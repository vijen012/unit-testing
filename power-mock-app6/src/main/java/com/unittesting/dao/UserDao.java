package com.unittesting.dao;

import com.unittesting.domain.User;
import com.unittesting.util.IDGenerator;

public class UserDao {
	
	public int createUser(User user) {
		int id = IDGenerator.generateID();
		//save the user object in db
		return id;
	}
}
