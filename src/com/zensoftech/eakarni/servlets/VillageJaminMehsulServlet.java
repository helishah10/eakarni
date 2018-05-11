package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.time.YearMonth;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.ViewCdpDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewJaminMehsulDetailsManager;
import com.zensoftech.eakarni.service.ViewJaminMehsulDetailsManagerImpl;

@WebServlet("/VillageJaminMehsulServlet")
public class VillageJaminMehsulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
	

		if(request.getParameter("submit")!=null)
		{
			AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
			int villageId=appointmentTalati.getVillage().getvId();
			System.out.println("village id:"+villageId);
		
			
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			
			ViewJaminMehsulDetailsManagerImpl jaminmanager=(ViewJaminMehsulDetailsManagerImpl)getServletContext().getAttribute("jaminmanager");
			Map<Integer,JaminMehsulVeraVasulat> jaminMap;
			jaminMap=jaminmanager.getAllDetailsByVillageId(villageId,YearMonth.of(year, month));
			System.out.println("jamin map:"+jaminMap);
			request.setAttribute("jaminVillageMap", jaminMap);
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageJaminMehsulVeraVasulat.jsp");

			rd.forward(request, response);
		}
		
	}

}
