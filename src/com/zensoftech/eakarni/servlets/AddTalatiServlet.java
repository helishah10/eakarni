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
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AddTalatiManagerImpl;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.StateManagerImpl;
import com.zensoftech.eakarni.service.UserManagerImpl;

@WebServlet("/AddTalatiServlet")
public class AddTalatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in servlet:");
		if(request.getParameter("submit")!=null)
		{
			UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
			String loginId=userdetails.getUser().getLoginId();
			UserManagerImpl usermanager=(UserManagerImpl)getServletContext().getAttribute("usermanager");
			AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
			AddTalatiManagerImpl addTalatiManager=(AddTalatiManagerImpl)getServletContext().getAttribute("addTalatiManager");
			StateManagerImpl statemanager=(StateManagerImpl)getServletContext().getAttribute("statemanager");
			/*UserManagerImpl usermanager=(UserManagerImpl)getServl
		*/
			
			String villageName=request.getParameter("villageName");
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
			int villageId=Integer.parseInt(request.getParameter("villageId"));
			System.out.println("village id:"+villageId);
			Village village=new Village();
			
			AppointmentTalati talati=new AppointmentTalati();
			
			User user=new User();
			user=usermanager.getUser(userId);
			System.out.println("user in service:"+user);
			int id=user.getId();
			System.out.println("user id to be passed in method:"+id);
			
			village=statemanager.getVillage(villageId);
			System.out.println("village in servelt:"+village);
			if(appointmentType.equalsIgnoreCase("Permanent"))
			{
				type=true;
				talati.setAppointmentType(type);
			}
			else if(appointmentType.equalsIgnoreCase(" Not Permanent"))
			{
				type=false;
				talati.setAppointmentType(type);
			}
			talati.setUser(user);
			talati.setVillage(village);
			talati.setStartDate(date);
			
			talati.setAppointmentLetterNo(appointmentLetterNo);
			talati=addTalatiManager.insertTalati(villageId, id, talati);
			
			System.out.println(talati);
			
			RequestDispatcher rd=request.getRequestDispatcher("/ViewAllTalatis");
			rd.forward(request, response);
			
	
		}
	}

}
