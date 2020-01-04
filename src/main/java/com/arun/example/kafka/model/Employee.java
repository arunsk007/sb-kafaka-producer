package com.arun.example.kafka.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="Employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8854020892254463690L;
	@JacksonXmlProperty(localName = "Name")
	private String name;
	@JacksonXmlProperty(localName = "Dept")
	private String dept;
	@JacksonXmlProperty(localName = "Salary")
	private Double salary;	
	
	public Employee(){
		
	}
	
	public Employee(String name, String dept, Double salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append(", dept=");
		builder.append(dept);
		builder.append(", salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}
	
	

}
