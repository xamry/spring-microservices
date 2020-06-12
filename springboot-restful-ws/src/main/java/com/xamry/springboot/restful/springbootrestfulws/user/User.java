package com.xamry.springboot.restful.springbootrestfulws.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The User entity")   //Swagger
@Entity  //JPA
public class User {

	@Id  //JPA
	@GeneratedValue	//JPA
	private Integer id;

	@Size(min = 2, message = "Name must have at least 2 characters, more is better.")
	@ApiModelProperty(notes = "Name should have a minimum of 2 characters")	//Swagger
	private String name;

	@Past
	@ApiModelProperty(notes = "Birthdate can't be in the past")	//Swagger
	private Date birthDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

	public User() {
		super();
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}	

}
