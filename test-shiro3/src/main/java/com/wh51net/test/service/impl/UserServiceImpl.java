package com.wh51net.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wh51net.test.dao.UserDao;
import com.wh51net.test.entity.User;
import com.wh51net.test.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	public User queryByUsername(String username) {
		
		return userDao.queryByUsername(username);
	}

	public User save(User user) {
		return userDao.saveUser(user);
	}

	public List<String> allPremissons(String username) {
		
		return userDao.queryAllPremissions(username);
	}
	
}
