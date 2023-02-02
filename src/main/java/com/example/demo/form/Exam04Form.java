package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;

public class Exam04Form {
	@NotBlank(message = "名前は必須です")
	private String name;
	@NotBlank(message = "年齢は必須です")
	private String age;
	@NotBlank(message = "コメントは必須です")
	private String comment;

	public Integer getIntAge() {
		return Integer.parseInt(age);
	}

	@Override
	public String toString() {
		return "Exam04Form [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
