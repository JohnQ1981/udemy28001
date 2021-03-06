package com.udemy28001.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy28001.entity.Users;

@Component
public class UserDaoService {

	private static int usersCount = 4;
	private static List<Users> users = new ArrayList<>();

	static {
		users.add(new Users(1, "Adam", new Date()));
		users.add(new Users(2, "Eve", new Date()));
		users.add(new Users(3, "Jack", new Date()));
		users.add(new Users(4, "John", new Date()));
	}

	public List<Users> findAll() {
		return users;
	}

	public Users save(Users user) {
		if (user.getId() == null) {
			user.setId(++usersCount);

		}
		users.add(user);
		return user;
	}

	public Users findById(int id) {
		for (Users user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public Users deleteById(int id) {
		Iterator<Users> iterator =users.iterator();
				while(iterator.hasNext()) {
					Users user = iterator.next();
					if(user.getId()==id) {
						iterator.remove();
						return user;
					}
					
				}
			return null;
	}
}