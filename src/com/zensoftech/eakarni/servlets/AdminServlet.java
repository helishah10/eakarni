package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.UserManagerImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		UserManagerImpl usermanager=(UserManagerImpl)getServletContext().getAttribute("usermanager");
		
		response.setContentType("application/json");
	
		String userData= request.getParameter("userData");
		System.out.println("user data:"+userData);
		
		PrintWriter out = response.getWriter();		
		
		Gson gson = new Gson();
		UserDetails jsonUserDetails=gson.fromJson(userData,UserDetails.class); 
		String firstName=jsonUserDetails.getFirstName();
		String middleName=jsonUserDetails.getMiddleName();
		String lastName=jsonUserDetails.getLastName();
		String address=jsonUserDetails.getAddress();
		String emailId=jsonUserDetails.getEmailId();
		int contactNo=jsonUserDetails.getContactNo();
		int postalCode=jsonUserDetails.getContactNo();
		int aadharcard=jsonUserDetails.getAadharcard();
		
		userdetails.setFirstName(firstName);
		userdetails.setMiddleName(middleName);
		userdetails.setLastName(lastName);
		userdetails.setAddress(address);
		userdetails.setEmailId(emailId);
		userdetails.setContactNo(contactNo);
		userdetails.setPostalCode(postalCode);
		userdetails.setAadharcard(aadharcard);
		request.setAttribute("userdetails", userdetails);
		System.out.println("done!");
		
		String jsonStr = "{\"status\": \"true\"}";
		
	boolean value=usermanager.updateUserDetails(loginId, userdetails);
		if(value== true)
		{
			//String jsonStr = "{\"status\": \"true\"}";

			Gson gson1 = new Gson();
			JsonElement element = gson1.fromJson (jsonStr, JsonElement.class);
			JsonObject jsonObj = element.getAsJsonObject();
			out.print(jsonObj);
			out.flush();
			
		}
		else
		{
			
		}
		
		
	}


}
