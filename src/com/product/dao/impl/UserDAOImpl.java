package com.product.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.product.dao.UserDAO;
import com.product.entity.User;

@Component("userDao")
public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public boolean getUserByUserNameExits(User user) {
		List<User> users = hibernateTemplate
				.find("from User u where u.username = '" + user.getUsername() + "'");

		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean getUserExits(User user) {
		List<User> users = hibernateTemplate
				.find("from User u where u.username = '" + user.getUsername()
						+ "' and u.password='" + user.getPassword() + "'");

		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void saveUser(User user) {
		this.hibernateTemplate.save(user);
	}

	@Override
	public void delUser(User user) {
		User delUser = getUser(user);
		this.hibernateTemplate.delete(delUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> finUserAll() {
		return this.hibernateTemplate.find("from User");
	}

	@Override
	public User getUser(User user) {
		return this.hibernateTemplate.load(User.class, user.getId());
	}

	@Override
	public void updateUser(User user) {
		this.hibernateTemplate.update(user);
	}
}
