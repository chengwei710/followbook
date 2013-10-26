package com.conway.lohas.web.action;

import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.conway.lohas.persistent.jdo.Role;
import com.conway.lohas.persistent.jdo.User;
import com.conway.lohas.services.ServicesFactory;
import com.conway.lohas.services.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private static final Logger log = Logger.getLogger(LoginAction.class.getName());

	private String userName;
	private String password;

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

	public String execute() {
		UserService userService = ServicesFactory.getUserService();
		try {
			User user = userService.getUserByNameAndPassword(userName, password);
			if(user == null){
				this.addActionError("user or password error!");
				user = userService.getUserByName(userName);
				int times = user.getErrorLoginTimes() + 1;
				if(times > 3){
					user.setDisabled("Y");
				}
				user.setErrorLoginTimes(times);
				updateLoginInfoToUser(user);
				return INPUT;
			}else{
				updateLoginInfoToUser(user);
			}
			if(!"N".equals(user.getDisabled())){
				this.addActionError("user is disabled!");
				return INPUT;
			}
			Role role = user.getRole();
			if(role != null){
				String roleName = role.getRoleName();
				if(!StringUtils.isBlank(roleName)){
					if(Role.ADMIN.equals(roleName)){
						return "ADMIN";
					}else if(Role.USER.equals(roleName)){
						return "USER";
					}
				}
			}
			this.addActionMessage("user has no authority");
			return INPUT;
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			log.warning(e.getMessage());
			e.printStackTrace();
		}
		
		return INPUT;
	}
	
	public void validate(){
		if(StringUtils.isBlank(userName)){
			this.addFieldError("userName", "User name required");
		}
		if(StringUtils.isBlank(password)){
			this.addFieldError("password", "Password required");
		}
	}
	
	private void updateLoginInfoToUser(User user) throws Exception{
		UserService userService = ServicesFactory.getUserService();
		
		String lastLoginIP = getLoginUserIP();
		user.setLastLoginIP(lastLoginIP);
		user.setLastLoginDate(new Date());
		
		userService.updateUser(user);
	}
	
	private String getLoginUserIP(){
		
		HttpServletRequest req=(HttpServletRequest)ServletActionContext.getRequest();
		String lastLoginIP = req.getHeader("x-forwarded-for"); 
		if(lastLoginIP == null || lastLoginIP.length() == 0 
				|| "unknown".equalsIgnoreCase(lastLoginIP)) { 
			lastLoginIP = req.getHeader("Proxy-Client-IP"); 
		} 
		if(lastLoginIP == null || lastLoginIP.length() == 0 
				|| "unknown".equalsIgnoreCase(lastLoginIP)) { 
			lastLoginIP = req.getHeader("WL-Proxy-Client-IP"); 
		} 
		if(lastLoginIP == null || lastLoginIP.length() == 0 
				|| "unknown".equalsIgnoreCase(lastLoginIP)) { 
			lastLoginIP = req.getRemoteAddr(); 
		}
		return lastLoginIP;
	}
}
