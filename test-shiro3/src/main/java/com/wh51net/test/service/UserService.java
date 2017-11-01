package com.wh51net.test.service;

import java.util.List;

import com.wh51net.test.entity.User;

public interface UserService {
	
	User queryByUsername(String username);
	
	User save(User user);
	
	List<String> allPremissons(String username);
}
