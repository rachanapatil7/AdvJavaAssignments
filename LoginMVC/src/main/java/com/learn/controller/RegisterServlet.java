package com.learn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.learn.bean.UserBean;
import com.learn.service.UserService;
import com.learn.util.UserUtil;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService=new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error=UserUtil.validateUserDetails(request);
		System.out.println("Error: "+error);
		HttpSession session=request.getSession();
		if(error==null) {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(firstname+lastname+username+password);
		UserBean userBean=new UserBean();
		userBean.setFirstName(firstname);
		userBean.setLastName(lastname);
		userBean.setUsername(username);
		userBean.setPassword(password);
		error=userService.checkUserPersists(userBean);
		if(error==null) {
			
			String userError=userService.createUser(userBean);
			if(userError==null) {
			session.setAttribute("firstName", userBean.getFirstName());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
			}
		}
		}
		if(error!=null) {
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
	}

}
