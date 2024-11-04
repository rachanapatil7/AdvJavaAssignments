package com.learn.service;

import com.learn.bean.UserBean;
import com.learn.dao.UserDAO;

public class UserService {
	UserDAO userDAO=new UserDAO();

	public String authenticateAndPopulateUser(UserBean userBean) {
		String error=null;
		userBean= userDAO.getUserBean(userBean);
		
		if(userBean.getFirstName()==null) {
			error="invalid user creds";
		}
		
		return error;
	}

	public String checkUserPersists(UserBean userBean) {
		String error=null;
		int usrs;
		//userBean= userDAO.getUserBean(userBean);
		usrs= userDAO.getUserDetails(userBean);
		
		if(usrs!=0) {
			error="Username exists";
		}
		System.out.println("Error at Userservice"+error);
		return error;
	}

	public String createUser(UserBean userBean) {
		String error=userDAO.createUserBean(userBean);
		return error;
		
	}
}
