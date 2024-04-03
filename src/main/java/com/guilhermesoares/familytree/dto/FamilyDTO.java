package com.guilhermesoares.familytree.dto;

import java.io.Serializable;

public class FamilyDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;
	
	public FamilyDTO() {
	}
	
	public FamilyDTO(UserDTO obj) {
		this.name = obj.getName();
		this.age = obj.getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
