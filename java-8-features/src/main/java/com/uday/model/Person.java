package com.uday.model;

import java.time.LocalDate;

public class Person {
	private String name;
	private int age;
	private String city;
	private String state;
	private LocalDate birthDate;
	public Person(String name, int age, String city, String state, LocalDate birthDate) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.state = state;
		this.birthDate = birthDate;
	}
	public int getAge() {
		return age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
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
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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
		return "Person [name=" + name + ", age=" + age + ", city=" + city + ", state=" + state + ", birthDate="
				+ birthDate + "]";
	}
}
