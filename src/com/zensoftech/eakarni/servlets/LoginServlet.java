
package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.State;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.StateManagerImpl;
import com.zensoftech.eakarni.service.UserManagerImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		UserManagerImpl usermanager=(UserManagerImpl)getServletContext().getAttribute("usermanager");
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		User user=new User();
		user.setLoginId(login);
		user.setPwd(password);
		
		HttpSession session;
		
		UserDetails userdetails=new UserDetails();
		AppointmentTalati talati=new AppointmentTalati();
		AppointmentTdo tdo=new AppointmentTdo();
		AppointmentDdo ddo=new AppointmentDdo();
	
	
		boolean validate=usermanager.Login(login, password);
		if(validate== true)
		{
			 session=request.getSession();  
			 user=usermanager.getUser(login);
			 session.setAttribute("user", user);
			 userdetails=usermanager.getUserDetails(login);
			 userdetails.setUser(user);
	
			 
			 if(userdetails.isUserDetailsAvailable() == true)
			 {
							session.setAttribute("userdetails", userdetails);
							String usertype=user.getType().name();
							if(usertype == "Admin")
							 {
								 
								
								 RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
									rd.forward(request, response);
							 }
							else if(usertype == "Tdo")
							 {
								 tdo.setUser(user);
								 tdo=appointmentmanager.getTaluka(login);
								 request.getSession(false).setAttribute("appointmentTdo", tdo);
								 RequestDispatcher rd=request.getRequestDispatcher("/TdoDashboardServlet");
									rd.forward(request, response);
							 }
							 else if(usertype == "Ddo")
							 {
								 ddo.setUser(user);
								 ddo=appointmentmanager.getDistrict(login);
								 request.getSession(false).setAttribute("appointmentDdo", ddo);
								 RequestDispatcher rd=request.getRequestDispatcher("/DdoDashboardServlet");
									rd.forward(request, response);
							 }
							 else if(usertype == "Talati")
							 {
								 talati.setUser(user);
								 talati=appointmentmanager.getVillage(login);
								 request.getSession(false).setAttribute("appointmentTalati", talati);
								 RequestDispatcher rd=request.getRequestDispatcher("Talati.jsp");
									rd.forward(request, response);
							 }
			 		}
						
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("MyAccount.jsp");
					rd.forward(request, response);
			 }
			 
			 
		}
		else
		 {
			 RequestDispatcher rd=request.getRequestDispatcher("Failure1.jsp");
				rd.forward(request, response);
		 }
				
			
			  
		}
	}

