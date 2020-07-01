package com.example.crudEx1.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.crudEx1.bean.user;

@Component
public class userDao {
private static List<user> usrs =  new ArrayList<>();
public static int count=3;
static {
	usrs.add(new user(1,"kdhkjsdh" , new Date()));
	usrs.add(new user(2,"jjhjjk" , new Date()));
	usrs.add(new user(3,"dcbbhdb" , new Date()));

}
public List<user> findall(){
	return usrs;
}
public user save(user usr) {
	if(usr.getId()==null) {
	
		usr.setId(++count);
	}
	usrs.add(usr);
	return usr;
}
public user findone(int Id) {
	for(user user:usrs) {
		if(user.getId()==Id) {
			return user;
	}
	}
return null;
}
public user delte(int id) {
	Iterator<user> iterator=usrs.iterator();
	while(iterator.hasNext()) {
		user usrs=iterator.next();
		if(usrs.getId()==id) {
			iterator.remove();
			return usrs;
		}
	}
	return null;
}
}
