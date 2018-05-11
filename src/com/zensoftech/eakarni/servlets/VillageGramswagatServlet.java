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
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.GPauditpera;
import com.zensoftech.eakarni.entities.Gramswagat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.ViewGpperaDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewGramswagatDetailsManagerImpl;

@WebServlet("/VillageGramswagatServlet")
public class VillageGramswagatServlet extends HttpServlet {
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
			
			
			
			ViewGramswagatDetailsManagerImpl gramswagatmanager=(ViewGramswagatDetailsManagerImpl)getServletContext().getAttribute("gramswagatmanager");
			Map<Integer, Gramswagat> gramswagatMap;
			gramswagatMap=gramswagatmanager.getAllDetailsByVillageId(villageId,YearMonth.of(year, month));
		
			request.setAttribute("gramswagatMap",gramswagatMap);
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageGramswagat.jsp");

			rd.forward(request, response);
		}
		
	}

}
