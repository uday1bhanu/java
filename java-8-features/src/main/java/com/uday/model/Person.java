package com.uday.model;

public class Person {
	private String name;
	private int age;
	private String city;
	private String state;

	public Person(String name, int age, String city, String state) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.state = state;
	}
	public int getAge() {
		return age;
	}
	public String getCity() {
		return city;
	}
	public String getName() {
		return name;
	}
	public String getState() {
		return state;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
