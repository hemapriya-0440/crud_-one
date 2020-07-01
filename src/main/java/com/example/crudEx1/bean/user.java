package com.example.crudEx1.bean;

import java.util.Date;

public class user {
private Integer id;
private String name;
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
