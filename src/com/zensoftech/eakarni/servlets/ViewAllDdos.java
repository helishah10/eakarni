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

import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.ListAllDdoManagerImpl;
import com.zensoftech.eakarni.service.ListAllTalatisManagerImpl;


@WebServlet("/ViewAllDdos")
public class ViewAllDdos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in servelt");
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		/*User user=userdetails.getUser();*/
		
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		ListAllDdoManagerImpl ddolistmanager=(ListAllDdoManagerImpl)getServletContext().getAttribute("ddolistmanager");
		
		
		String loginId=userdetails.getUser().getLoginId();
		System.out.println("loginId:"+loginId);
		/*AppointmentDdo ddo=new AppointmentDdo();
		ddo=appointmentmanager.getDistrict(loginId);
		int districtId=ddo.getDistrict().getId();
		System.out.println("district id:"+districtId);*/
		List<AppointmentDdo> ddos= new ArrayList<AppointmentDdo>();
		
		ddos=ddolistmanager.getAllDdo(1);
	
		System.out.println("ddos"+ddos);
		request.setAttribute("Allddos", ddos);
		
		 RequestDispatcher rd=request.getRequestDispatcher("ListDdo.jsp");
		 System.out.println("in jsp:");
		rd.forward(request, response);
	}

}
