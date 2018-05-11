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

import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.service.AddDdoManagerImpl;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.StateManagerImpl;
import com.zensoftech.eakarni.service.UserManagerImpl;


@WebServlet("/AddDdoServlet")
public class AddDdoServlet extends HttpServlet {
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
			
			StateManagerImpl statemanager=(StateManagerImpl)getServletContext().getAttribute("statemanager");
			/*UserManagerImpl usermanager=(UserManagerImpl)getServl
		*/
			
			String districtName=request.getParameter("districtName");
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
			int districtId=Integer.parseInt(request.getParameter("districtId"));
			System.out.println("district id:"+districtId);
			District district=new District();
			
			AppointmentDdo ddo=new AppointmentDdo();
			
			User user=new User();
			user=usermanager.getUser(userId);
			System.out.println("user in service:"+user);
			int id=user.getId();
			System.out.println("user id to be passed in method:"+id);
			
			district=statemanager.getDistrict(districtId);
			int districtautoId=district.getId();
			System.out.println("district in servelt:"+district);
			if(appointmentType.equalsIgnoreCase("Permanent"))
			{
				type=true;
				ddo.setAppointmentType(type);
			}
			else if(appointmentType.equalsIgnoreCase(" Not Permanent"))
			{
				type=false;
				ddo.setAppointmentType(type);
			}
			ddo.setUser(user);
			ddo.setDistrict(district);
			ddo.setStartDate(date);
			
			AddDdoManagerImpl addDdoManager=(AddDdoManagerImpl)getServletContext().getAttribute("addDdoManager");
			ddo.setAppointmentLetterNo(appointmentLetterNo);
			ddo=addDdoManager.insertDdo(districtId, userId, ddo);
			
			System.out.println(ddo);
			
			RequestDispatcher rd=request.getRequestDispatcher("/ViewAllDdos");
			rd.forward(request, response);
			
	
		}
	}

}
