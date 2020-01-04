package com.arun.example.kafka.model;

public class User {
	
	private String name;
	private String dept;
	private long salary;
	
	public User() {
	}	

	public User(String name, String dept, long salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [name=");
		builder.append(name);
		builder.append(", dept=");
		builder.append(dept);
		builder.append(", salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	
}
