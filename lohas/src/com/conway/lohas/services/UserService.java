package com.conway.lohas.services;

import com.conway.lohas.persistent.jdo.User;

public interface UserService {

	public User getUserByNameAndPassword(String userName, String password)
			throws Exception;
	
	public boolean existsUserName(String userName) throws Exception;
	
	public void createUser(User user) throws Exception;
	
	public void updateUser(User user) throws Exception;

	public User getUserByName(String userName) throws Exception;
	
}