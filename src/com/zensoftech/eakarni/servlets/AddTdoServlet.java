package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AddTalatiManagerImpl;
import com.zensoftech.eakarni.service.AddTdoManagerImpl;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.StateManagerImpl;
import com.zensoftech.eakarni.service.UserManagerImpl;


@WebServlet("/AddTdoServlet")
public class AddTdoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in servlet:");
		if(request.getParameter("submit")!=null)
		{
			UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
			String loginId=userdetails.getUser().getLoginId();
			UserManagerImpl usermanager=(UserManagerImpl)getServletContext().getAttribute("usermanager");
			AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
			AddTdoManagerImpl addTdoManager=(AddTdoManagerImpl)getServletContext().getAttribute("addtdomanager");
			StateManagerImpl statemanager=(StateManagerImpl)getServletContext().getAttribute("statemanager");
		
			
			String talukaName=request.getParameter("talukaName");
			String userId=request.getParameter("userId");
			int appointmentLetterNo=Integer.parseInt(request.getParameter("appointmentLetterNo"));
			String appointmentType=request.getParameter("appointmentType");
			boolean type = false;
			/*if(appointmentType.equalsIgnoreCase("Permanent"))
			{
				type=true;
				talati.setAppointmentType(type);
			}
			else if(appointmentType.equalsIgnoreCase(" Not Permanent"))
			{
				type=false;
				talati.setAppointmentType(type);
			}*/
			String joinDate=request.getParameter("joindate");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(joinDate, formatter);
			int talukaId=Integer.parseInt(request.getParameter("talukaId"));
			System.out.println("taluka id:"+talukaId);
			
			Taluka taluka=new Taluka();
			
			AppointmentTdo tdo=new AppointmentTdo();
			
			User user=new User();
			user=usermanager.getUser(userId);
			System.out.println("user in service:"+user);
			int id=user.getId();
			System.out.println("user id to be passed in method:"+id);
			
			taluka=statemanager.getTaluka(talukaId);
			/*boolean appointmentType=Boolean.parseBoolean(request.getParameter("appointmentType"));
			System.out.println("appointment type:"+appointmentType);
			tdo.setAppointmentType(appointmentType);*/
			
			System.out.println("taluka in servelt:"+taluka);
			if(appointmentType.equalsIgnoreCase("Permanent"))
			{
				type=true;
				tdo.setAppointmentType(type);
			}
			else if(appointmentType.equalsIgnoreCase(" Not Permanent"))
			{
				type=false;
				tdo.setAppointmentType(type);
			}
			tdo.setUser(user);
			tdo.setTaluka(taluka);
			tdo.setStartDate(date);
			
			tdo.setAppointmentLetterNo(appointmentLetterNo);
			tdo=addTdoManager.insertTdo(talukaId, id, tdo);
			
			System.out.println(tdo);
			
			RequestDispatcher rd=request.getRequestDispatcher("/ViewAllTdosServlet");
			rd.forward(request, response);
			
	
		}
	}

}
