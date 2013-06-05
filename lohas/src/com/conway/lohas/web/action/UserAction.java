package com.conway.lohas.web.action;

import java.util.Date;

import org.apache.commons.lang.xwork.StringUtils;

import com.conway.lohas.common.md5.MD5Util;
import com.conway.lohas.persistent.jdo.User;
import com.conway.lohas.services.ServicesFactory;
import com.conway.lohas.services.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	
	private String userName;
	private String password;
	private String rePassword;
	private String email;
	private int gender;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	public String execute() {
		try {
			UserService userService = ServicesFactory.getUserService();
			boolean isExists = userService.existsUserName(userName);
			if(!isExists){
				this.addActionError("Exists user name");
				return INPUT;
			}
			User user = createUserEntiry();
			userService.createUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	private User createUserEntiry() {
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(MD5Util.getMD5String(password));
		user.setEmail(email);
		user.setGender(gender);
		//user.setAge(age);
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		return user;
	}
	
	public void validate(){
		if(StringUtils.isBlank(userName)){
			this.addFieldError("UserName", "User name required");
		}
		if(StringUtils.isBlank(password)){
			this.addFieldError("Password", "Password required");
		}
		
		if(StringUtils.isBlank(rePassword) || !rePassword.equals(password)){
			this.addFieldError("rePassword", "It is inconsistent with previous one.");
		}
	}
}
