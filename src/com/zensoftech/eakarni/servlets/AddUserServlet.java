package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.User.Usertype;
import com.zensoftech.eakarni.service.UserManagerImpl;


@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManagerImpl usermanager=(UserManagerImpl)getServletContext().getAttribute("usermanager");
		
		String loginid=request.getParameter("loginid");
		String password=request.getParameter("password");
		String userType=request.getParameter("userType");
		System.out.println("usertype"+userType);
		User user=new User();
		user.setLoginId(loginid);
		user.setPwd(password);
		Usertype utype=Usertype.valueOf(userType);
		
		user.setType(utype);
		user=usermanager.addUser(user);
		System.out.println("user:"+user);
		
		RequestDispatcher rd=request.getRequestDispatcher("UserAdded.jsp");

		rd.forward(request, response);
	}

}
