package com.example.crudEx1.bean;

public class Posts {
private Integer postId;
private String message;
private String comments;
public Posts() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getPostId() {
	return postId;
}
public void setPostId(Integer postId) {
	this.postId = postId;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public Posts(Integer postId, String message, String comments) {
	super();
	this.postId = postId;
	this.message = message;
	this.comments = comments;
}
@Override
public String toString() {
	return "Posts [postId=" + postId + ", message=" + message + ", comments=" + comments + "]";
}
}
