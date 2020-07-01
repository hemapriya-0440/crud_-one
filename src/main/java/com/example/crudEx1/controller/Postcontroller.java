package com.example.crudEx1.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.crudEx1.Exception.usernotfoundException;
import com.example.crudEx1.bean.Posts;
import com.example.crudEx1.bean.user;
import com.example.crudEx1.dao.PostDao;

@RestController

public class Postcontroller {
	@Autowired
	PostDao dao;

	@RequestMapping(value = "/Posts", method = RequestMethod.GET)
	public List<Posts> getallposts(Posts post) {
		return dao.getAllPosts();
	}

	@RequestMapping(value = "/Posts/{id}")
	public Posts finone(@PathVariable int id) {
		Posts post = dao. getbyId(id);
		if (post == null)
			throw new usernotfoundException("id" + id);
		return post;
	}

	@RequestMapping(value = "/Posts", method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody Posts post) {
		Posts saved = dao.create(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getPostId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	/*
	 * @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE) public
	 * void delete(@PathVariable int id) { user usr=dao.delte(id); if(usr==null)
	 * throw new usernotfoundException("id"+id);
	 * 
	 * URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (deleted.getId()) .toUri();
	 * 
	 * }
	 */
	
	
	@RequestMapping(value = "/Posts/{id}", method = RequestMethod.DELETE)
	public  ResponseEntity<Object> delete(@PathVariable int id) {
		Posts post=dao.delete(id);
		if(post==null)
			throw new usernotfoundException("id"+id);
		return ResponseEntity.noContent().build();
		/*
		 * URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
		 * (deleted.getId()) .toUri();
		 */
	}

}
