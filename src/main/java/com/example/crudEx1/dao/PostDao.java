package com.example.crudEx1.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crudEx1.bean.Posts;
@Service
public class PostDao {
private static List<Posts> post=new ArrayList<>();
static {
	post.add(new Posts(1,"hgdsggy", "gygfufg"));
	post.add(new Posts(2,"kjjhhhh","bgdxdhbk"));
}
public List<Posts>getAllPosts(){
	return post;
}
public Posts getbyId(int id) {
	for(Posts postt:post) {
		if(postt.getPostId()==id) {
			return postt;
		}
	}
	return null;
}
public Posts create(Posts postt) {
	post.add(postt);
	return postt;
}
public Posts delete(int id) {
	Iterator<Posts> iter=post.iterator();
	while(iter.hasNext()) {
		Posts post=iter.next();
		if(post.getPostId()==id) {
			iter.remove();
			return post;
		}
	}
	return null;
}
}
