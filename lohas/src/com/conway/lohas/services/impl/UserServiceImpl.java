package com.conway.lohas.services.impl;

import com.conway.lohas.common.md5.MD5Util;
import com.conway.lohas.persistent.jdo.User;
import com.conway.lohas.persistent.jdodao.UserDAO;
import com.conway.lohas.persistent.jdodao.impl.UserDaoImpl;
import com.conway.lohas.services.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO userDao = new UserDaoImpl();

	@Override
	public User getUserByNameAndPassword(String userName, String password)
			throws Exception {
		
		String pwdMd5 = MD5Util.getMD5String(password);
		User user = userDao.getUserByUserNameAndPwd(userName, pwdMd5);
				
		return user;
	}

	@Override
	public void createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
