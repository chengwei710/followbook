package com.conway.lohas.services;

import com.conway.lohas.services.impl.UserServiceImpl;

public class ServicesFactory {
	
	public static UserService getUserService(){
		UserService userSvs = new UserServiceImpl();
		return userSvs;
	}

}
