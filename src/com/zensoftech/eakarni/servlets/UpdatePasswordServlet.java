package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.service.UserManagerImpl;


@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManagerImpl usermanager=(UserManagerImpl)getServletContext().getAttribute("usermanager");
		
		String login=request.getParameter("loginId");
		String password=request.getParameter("oldPassword");
		
		String newpwd=request.getParameter("newPassword");
		
		User user=new User();
		user=usermanager.getUser(login);
		String loginId=user.getLoginId();
		
		usermanager.updatePassword(loginId, newpwd);
		
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

}
