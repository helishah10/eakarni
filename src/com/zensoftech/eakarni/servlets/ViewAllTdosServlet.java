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
import com.zensoftech.eakarni.service.ListAllTalatisManagerImpl;
import com.zensoftech.eakarni.service.ListAllTdoManagerImpl;


@WebServlet("/ViewAllTdosServlet")
public class ViewAllTdosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in servlet");
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		User user=userdetails.getUser();
		
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		ListAllTdoManagerImpl tdoListmanager=(ListAllTdoManagerImpl)getServletContext().getAttribute("tdoListmanager");
		
		
		String loginId=userdetails.getUser().getLoginId();
		System.out.println("loginId:"+loginId);
		AppointmentDdo ddo=new AppointmentDdo();
		ddo=appointmentmanager.getDistrict(loginId);
		int districtId=ddo.getDistrict().getId();
		System.out.println("district id:"+districtId);
		List<AppointmentTdo> tdos= new ArrayList<AppointmentTdo>();
		
		tdos=tdoListmanager.getAllTdo(districtId);
	
		System.out.println("tdos:"+tdos);
		request.setAttribute("AllTdo", tdos);
		
		 RequestDispatcher rd=request.getRequestDispatcher("listTDO.jsp");
		 rd.forward(request, response);
	}

}
