package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import java.io.PrintWriter;

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
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.UserManagerImpl;

@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession(false).getAttribute("user");
		User user=(User)request.getSession(false).getAttribute("user");
		String loginId=user.getLoginId();
		
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String emailId=request.getParameter("emailId");
		int contactNo=Integer.parseInt(request.getParameter("contactNo"));
		String address=request.getParameter("address");
		int postalCode=Integer.parseInt(request.getParameter("postalCode"));
		int aadharcard=Integer.parseInt(request.getParameter("aadharcardNo"));
		
		UserDetails userdetails=new UserDetails();
		userdetails.setFirstName(firstName);
		userdetails.setMiddleName(middleName);
		userdetails.setLastName(lastName);
		userdetails.setEmailId(emailId);
		userdetails.setContactNo(contactNo);
		userdetails.setAddress(address);
		userdetails.setPostalCode(postalCode);
		userdetails.setAadharcard(aadharcard);
	
		UserManagerImpl usermanager=(UserManagerImpl)getServletContext().getAttribute("usermanager");
		usermanager.addUserDetails(loginId, userdetails);
		userdetails.setUser(user);
		request.setAttribute("userdetails", userdetails);
		
		
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		AppointmentTalati talati=new AppointmentTalati();
		AppointmentTdo tdo=new AppointmentTdo();
		AppointmentDdo ddo=new AppointmentDdo();
		String login=user.getLoginId();
		userdetails=usermanager.getUserDetails(login);
		request.setAttribute("userdetails", userdetails);
		userdetails.setUser(user);
		request.getSession(false).setAttribute("userdetails", userdetails);
		
		String usertype=user.getType().name();
		 if(usertype == "Tdo")
		 {
			 tdo.setUser(user);
			 tdo=appointmentmanager.getTaluka(login);
			 request.getSession(false).setAttribute("appointmentTdo", tdo);
			 RequestDispatcher rd=request.getRequestDispatcher("TDO.jsp");
			 rd.forward(request, response);
		 }
		 else if(usertype == "Ddo")
		 {
			 ddo.setUser(user);
			 ddo=appointmentmanager.getDistrict(login);
			 request.getSession(false).setAttribute("appointmentDdo", ddo);
			 RequestDispatcher rd=request.getRequestDispatcher("DDO.jsp");
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
		 else
		 {
			 RequestDispatcher rd=request.getRequestDispatcher("Failure1.jsp");
				rd.forward(request, response);
		 }
		 
	}

}
