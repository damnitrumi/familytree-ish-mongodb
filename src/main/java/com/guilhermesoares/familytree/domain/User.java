package com.guilhermesoares.familytree.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.guilhermesoares.familytree.dto.FamilyDTO;

@Document
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private Integer age;
	
	private List<FamilyDTO> family = new ArrayList<>();
	
	public User() {
	}

	public User(String id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
