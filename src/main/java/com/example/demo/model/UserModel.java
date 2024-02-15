package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table //is a corresponding table that matches that entity in the database
@Entity // for specifies class is an entity and is mapped to a database table. 

public class UserModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + "]";
	}
	
	

}
