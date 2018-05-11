package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.ListAllTalatisManagerImpl;



@WebServlet("/ViewAllTalatis")
public class ViewAllTalatisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in servelt");
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		User user=userdetails.getUser();
		
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		ListAllTalatisManagerImpl talatilistmanager=(ListAllTalatisManagerImpl)getServletContext().getAttribute("talatilistmanager");
		
		
		String loginId=userdetails.getUser().getLoginId();
		System.out.println("loginId:"+loginId);
		AppointmentTdo tdo=new AppointmentTdo();
		tdo=appointmentmanager.getTaluka(loginId);  
		int talukaId=tdo.getTaluka().getId();
		System.out.println("taluka id:"+talukaId);
		List<AppointmentTalati> talatis= new ArrayList<AppointmentTalati>();
		
		talatis=talatilistmanager.getAllTalatis(talukaId);
	
		System.out.println("talatis"+talatis);
		request.setAttribute("AllTalatis", talatis);
		
		 RequestDispatcher rd=request.getRequestDispatcher("listTalati.jsp");
		 System.out.println("in jsp:");
		rd.forward(request, response);
	}

}
