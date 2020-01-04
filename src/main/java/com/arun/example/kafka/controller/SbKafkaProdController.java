package com.arun.example.kafka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.example.kafka.model.Employee;
import com.arun.example.kafka.model.User;

@RestController
@RequestMapping("/kafka")
public class SbKafkaProdController {
	
	/*
	 * @Autowired KafkaTemplate<String, String> kafkaTemplate;
	 */
	
	@Autowired
	@Qualifier("userKafkaTemplate")
	KafkaTemplate<String, User> userKafkaTemplate;
	
	@Autowired
	@Qualifier("xmlKafkaTemplate")
	KafkaTemplate<String, Employee> xmlKafkaTemplate;
	
	private static final String TOPIC = "test";
	private static final String USER_TOPIC = "test-json";
	private static final String XML_TOPIC = "test-xml";
	
	/*
	 * @GetMapping("/publish/{message}") public String
	 * publishMessage(@PathVariable("message") final String message) {
	 * kafkaTemplate.send(TOPIC, message); return "Published Successfully"; }
	 */
	
	@GetMapping("/publish/user/{name}")
	public String publishUserMessage(@PathVariable() final String name) {
		
		User user = new User(name,"Technology",1200l);
		
		
		/*
		 * One Way to make it work.
		 * Message<User> message = MessageBuilder.withPayload(user)
		 * .setHeader(KafkaHeaders.TOPIC, USER_TOPIC) .build();
		 * userKafkaTemplate.send(message);
		 */
		
		userKafkaTemplate.send(USER_TOPIC, user);
		return "Published Successfully";
	}
	
	@PostMapping(value="/publish/empxml", consumes=MediaType.APPLICATION_XML_VALUE)
	public String publishUserXMLMessage(@RequestBody Employee employee) {
		
		System.out.println("Input :: "+employee.toString());
		xmlKafkaTemplate.send(XML_TOPIC, employee);
		return "Published Successfully"+employee.toString();
	}
	
	@GetMapping("/error")
	public String error() {
		
		return "Error";
	}

}
