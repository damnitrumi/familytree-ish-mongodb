package com.guilhermesoares.familytree.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.guilhermesoares.familytree.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Integer age;
	
	private List<FamilyDTO> family = new ArrayList<>();
	
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
		this.family = new ArrayList<>(obj.getFamily());
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
	
	public List<FamilyDTO> getFamily() {
		return family;
	}

	public void setFamily(List<FamilyDTO> family) {
		this.family = family;
	}
}
