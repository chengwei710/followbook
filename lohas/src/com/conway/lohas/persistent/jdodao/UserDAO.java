package com.conway.lohas.persistent.jdodao;

import com.conway.lohas.persistent.jdo.User;

public interface UserDAO {
	
	public User getUserByUserNameAndPwd(String userName, String password);

}
