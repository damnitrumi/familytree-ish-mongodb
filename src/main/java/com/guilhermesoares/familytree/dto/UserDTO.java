package com.guilhermesoares.familytree.dto;

import java.io.Serializable;

import com.guilhermesoares.familytree.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Integer age;
	
	public UserDTO() {
	}
	
	public UserDTO(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public UserDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.age = obj.getAge();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
