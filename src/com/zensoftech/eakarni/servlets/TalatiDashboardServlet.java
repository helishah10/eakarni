package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TotalEnteriesForTalukaManagerImpl;


@WebServlet("/TalatiDashboardServlet")
public class TalatiDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaCdpcountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaCdpcountmanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		
		int villageId=talati.getVillage().getvId();
		
		int totalCdpCount=talukaCdpcountmanager.getCdpTotalCount(villageId);
		System.out.println("in servlet:"+totalCdpCount);
		request.setAttribute("villageCdpCount", totalCdpCount);
		
		RequestDispatcher rd=request.getRequestDispatcher("Talati.jsp");
		rd.forward(request, response);

	}
	

}
