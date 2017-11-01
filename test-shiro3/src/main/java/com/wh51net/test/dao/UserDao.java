package com.wh51net.test.dao;

import java.util.List;

import com.wh51net.test.entity.User;

public interface UserDao {
	User queryByUsername(String username);
	
	User saveUser(User user);
	
	List<String> queryAllPremissions(String username);
}
