package com.example.demo.form;

public class Exam01Form {
	private String name;

	@Override
	public String toString() {
		return "Exam01Form [name=" + name + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
