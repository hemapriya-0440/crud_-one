package com.example.crudEx1.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class user {
	
private Integer id;
@Size(min=2,message = "should have atleast 2 characters")
private String name;
@Past
private Date DOB;
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
public Date getDOB() {
	return DOB;
}
public void setDOB(Date dOB) {
	DOB = dOB;
}
public user() {
	super();
	// TODO Auto-generated constructor stub
}
public user(Integer id, String name, Date dOB) {
	super();
	this.id = id;
	this.name = name;
	DOB = dOB;
}
@Override
public String toString() {
	return "user [id=" + id + ", name=" + name + ", DOB=" + DOB + "]";
}

}
