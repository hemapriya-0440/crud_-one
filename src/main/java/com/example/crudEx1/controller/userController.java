package com.example.crudEx1.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.crudEx1.Exception.usernotfoundException;
import com.example.crudEx1.bean.user;
import com.example.crudEx1.dao.userDao;

@RestController

public class userController {
	@Autowired
	userDao dao;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<user> getallusers(user usr) {
		return dao.findall();
	}

	@RequestMapping(value = "/users/{id}")
	public user finone(@PathVariable int id) {
		user user = dao.findone(id);
		if (user == null)
			throw new usernotfoundException("id" + id);
		return user;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Object> save(@Valid @RequestBody user usr) {
		user saved = dao.save(usr);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
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
	
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public  ResponseEntity<Object> delete(@PathVariable int id) {
		user usr=dao.delte(id);
		if(usr==null)
			throw new usernotfoundException("id"+id);
		return ResponseEntity.noContent().build();
		/*
		 * URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
		 * (deleted.getId()) .toUri();
		 */
	}

}
