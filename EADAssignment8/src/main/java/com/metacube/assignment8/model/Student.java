package com.metacube.assignment8.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotBlank(message = "{Name should not be Empty")
	@Size(min = 2, max = 15, message = "{Length is not Appropriate}")
	private String firstName;

	@NotBlank(message = "{Name should not be Empty")
	@Size(min = 2, max = 15, message = "{Length is not Appropriate}")
	private String fatherName;

	@NotBlank(message = "{Name should not be Empty")
	@Size(min = 2, max = 15, message = "{Length is not Appropriate}")
	private String lastName;

	private int className;

	private int age;

	@NotBlank(message = "{emptyField}")
	@Email(message = "{badEmail}")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getClassName() {
		return className;
	}

	public void setClassName(int className) {
		this.className = className;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", fatherName=" + fatherName + ", lastName=" + lastName
				+ ", className=" + className + ", age=" + age + "]";
	}

}
