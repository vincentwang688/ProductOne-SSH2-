package com.product.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.product.entity.User;
import com.product.service.UserService;

@Component("LoginAction")
@Scope("prototype")
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private UserService userService = null;
	private String message = null;

	private User user = null;

	private String action = null;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("user: " + user);
		if (null == user) {
			return "fail";
		}

		if ("".equals(user.getUsername()) || null == user.getUsername()) {
			this.addFieldError("user.username", "帐号不能为空,请重新输入!");
			return "fail";
		}

		if ("".equals(user.getPassword()) || null == user.getPassword()) {
			this.addFieldError("user.password", "密码不能为空,请重新输入!");
			return "fail";
		}

		boolean isExistUserName = this.userService.checkUserExits(user);
		if (isExistUserName) {
			boolean isExistUserNameAndPwd = this.userService
					.checkUserNameAndPassword(user);
			if (isExistUserNameAndPwd) {
				message = "用户: " + user.getUsername() + "登录成功";
				System.out.println(message);
				getSession().put("sessionUser", user);
				return "success";
			} else {
				this.addFieldError("user.username", "密码不正确,请重新输入密码!");
				return "fail";
			}
		} else {
			this.addFieldError("user.username", "该帐号不存在，请返回注册页面!");
			return "fail";
		}
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
