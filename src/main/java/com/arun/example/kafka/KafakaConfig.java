package com.arun.example.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.arun.example.kafka.model.Employee;
import com.arun.example.kafka.model.User;
import com.arun.example.kafka.ser.EmployeeSerializer;

@Configuration
public class KafakaConfig {
	
	@Bean
	public ProducerFactory<String, User> jsonProducerFactory(){
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, User>(producerConfig);
	}
	
	@Bean("userKafkaTemplate")
	public KafkaTemplate<String, User> userKafkaTemplate() {
		return new KafkaTemplate<String, User>(jsonProducerFactory());
	}
	
	@Bean
	public ProducerFactory<String, Employee> xmlProducerFactory(){
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EmployeeSerializer.class);
		//producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
		
		return new DefaultKafkaProducerFactory<String, Employee>(producerConfig);
	}
	
	@Bean("xmlKafkaTemplate")
	public KafkaTemplate<String, Employee> xmlKafkaTemplate() {
		return new KafkaTemplate<String, Employee>(xmlProducerFactory());
	}

}
