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

import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.CdpReportManager;
import com.zensoftech.eakarni.service.ViewCdpDetailsManagerImpl;


@WebServlet("/ViewTalukaCdpServlet")
public class ViewTalukaCdpServlet extends HttpServlet {
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
			int talukaautoId=appointmentTdo.getTaluka().getId();
			
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			
			ViewCdpDetailsManagerImpl cdpmanager=(ViewCdpDetailsManagerImpl)getServletContext().getAttribute("cdpmanager");
			Map<Integer,Cdp> cdpMap;
			cdpMap=cdpmanager.getAllDetailsByTalukaId(talukaId,YearMonth.of(year, month));
		
			request.setAttribute("cdpTalukaMap", cdpMap);
			
			YearMonth yearmonth=YearMonth.of(year, month);
			
			CdpReportManager cdpreportmanager=(CdpReportManager)request.getServletContext().getAttribute("cdpreportmanager");
			try {
				 /*FileOutputStream file =cdpreportmanager.generateTalukaCdpReport(talukaautoId, yearmonth);*/
				 cdpreportmanager.generateTalukaCdpReport(talukaautoId, yearmonth);
				 
				System.out.println("in try servlet:");
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewTalukaCdp.jsp");

			rd.forward(request, response);
			
			
		}
		
	
		
	}

}
