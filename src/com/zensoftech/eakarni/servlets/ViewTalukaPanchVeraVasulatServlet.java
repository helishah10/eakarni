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

import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.PanchVeraVasulat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.JaminMehsulReportManager;
import com.zensoftech.eakarni.service.PanchveraReportManager;
import com.zensoftech.eakarni.service.ViewCdpDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewPanchVeraVasulatDetailsManagerImpl;

@WebServlet("/ViewTalukaPanchVeraVasulatServlet")
public class ViewTalukaPanchVeraVasulatServlet extends HttpServlet {
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
			AppointmentTdo appointmentTdo=appointmentmanager.getTaluka(loginId);
			int talukaId=appointmentTdo.getTaluka().gettId();
			
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			int talukaautoId=appointmentTdo.getTaluka().getId();
			
			
			
			ViewPanchVeraVasulatDetailsManagerImpl panchveramanager=(ViewPanchVeraVasulatDetailsManagerImpl)getServletContext().getAttribute("panchveramanager");
			Map<Integer,PanchVeraVasulat> panchveraMap;
			panchveraMap=panchveramanager.getAllDetailsByTalukaId(talukaId,YearMonth.of(year, month));
		
			request.setAttribute("panchveraTalukaMap", panchveraMap);
			
			YearMonth yearmonth=YearMonth.of(year, month);
			
			PanchveraReportManager panchverareportmanager=(PanchveraReportManager)request.getServletContext().getAttribute("panchverareportmanager");
			
		
			try {
				
				
				panchverareportmanager.generateTalukaPanchveraReport(talukaautoId, yearmonth);
				 
				System.out.println("in try servlet:");
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewTalukaPanchveraVasulat.jsp");

			rd.forward(request, response);
		}
		
	}

}
