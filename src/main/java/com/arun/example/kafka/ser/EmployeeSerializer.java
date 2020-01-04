package com.arun.example.kafka.ser;

import org.apache.kafka.common.serialization.Serializer;

import com.arun.example.kafka.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class EmployeeSerializer implements Serializer<Employee> {

	@Override
	public byte[] serialize(String topic, Employee data) {
		byte[] valueInBytes = null;
		ObjectMapper objectMapper  = new XmlMapper();
		try {
			valueInBytes = objectMapper.writeValueAsBytes(data);
			System.out.println("================================================");
			System.out.println("in Bytes :  {}"+valueInBytes);
			System.out.println("================================================");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valueInBytes;
	}

}
