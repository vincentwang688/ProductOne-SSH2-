package com.product.dao;

import java.util.List;

import com.product.entity.User;

public interface UserDAO {

	/**
	 * 检查帐号是否存在
	 */
	public boolean getUserByUserNameExits(User user);

	/**
	 * 检查帐号与密码是否匹配
	 */
	public boolean getUserExits(User user);

	/**
	 * 保存用户信息
	 */
	public void saveUser(User user);

	/**
	 * 更新用户信息
	 */
	public void updateUser(User user);

	/**
	 * 获取用户信息
	 */
	public User getUser(User user);

	/**
	 * 删除用户信息
	 */
	public void delUser(User user);

	/**
	 * 获取所有用户信息
	 */
	public List<User> finUserAll();

}
