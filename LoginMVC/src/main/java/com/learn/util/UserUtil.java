package com.learn.util;

import jakarta.servlet.http.HttpServletRequest;

public class UserUtil {
	public static String validateRequest(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String error = null;
		if(username.isEmpty()||password.isEmpty()) {
			error = "Username or password is empty";
		}
		return error;
	}

	public static String validateUserDetails(HttpServletRequest request) {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String error = null;
		if(firstname.isEmpty()||lastname.isEmpty()||username.isEmpty()||password.isEmpty()) {
			error = "No fields should be empty";
		}
		return error;
	}
}
