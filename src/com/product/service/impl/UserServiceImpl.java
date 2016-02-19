package com.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.product.dao.UserDAO;
import com.product.entity.User;
import com.product.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	private UserDAO userDao = null;

	public UserDAO getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public boolean checkUserExits(User user) throws Exception {
		return this.userDao.getUserByUserNameExits(user);
	}

	public boolean checkUserNameAndPassword(User user) throws Exception {
		return this.userDao.getUserExits(user);
	}
	
	@Override
	public void delUser(User user) {
		this.userDao.delUser(user);
	}

	@Override
	public User getUserById(User user) {
		return this.userDao.getUser(user);
	}

	@Override
	public List<User> getUserList() {
		return this.userDao.finUserAll();
	}

	@Override
	public void addUser(User user) {
		System.out.println("添加: " + user);
		this.userDao.saveUser(user);
	}

	@Override
	public void editUser(User user) {
		this.userDao.updateUser(user);
	}
}
