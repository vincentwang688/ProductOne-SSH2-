package com.product.service;

import java.util.List;

import com.product.entity.User;

public interface UserService {

	public boolean checkUserExits(User user) throws Exception;

	public boolean checkUserNameAndPassword(User user) throws Exception;

	public void addUser(User user);

	public void editUser(User user);

	public void delUser(User user);

	public List<User> getUserList();

	public User getUserById(User user);

}
