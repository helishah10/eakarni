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
import com.zensoftech.eakarni.entities.Egram;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.EgramReportManager;
import com.zensoftech.eakarni.service.ViewCdpDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewEgramDetailsManagerImpl;


@WebServlet("/ViewTalukaEgramServlet")
public class ViewTalukaEgramServlet extends HttpServlet {
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
			
			ViewEgramDetailsManagerImpl egrammanager=(ViewEgramDetailsManagerImpl)getServletContext().getAttribute("egrammanager");
			Map<Integer,Egram> egramMap;
			egramMap=egrammanager.getAllDetailsByTalukaId(talukaId,YearMonth.of(year, month));
			System.out.println(egramMap);
		
			request.setAttribute("talukaEgramMap", egramMap);
			YearMonth yearmonth=YearMonth.of(year, month);
			
			EgramReportManager egramreportmanager=(EgramReportManager)request.getServletContext().getAttribute("egramreportmanager");
			try {
				 
				egramreportmanager.generateTalukaEgramReport(talukaautoId, yearmonth);
				 
				System.out.println("in try servlet:");
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewTalukaEgram.jsp");

			rd.forward(request, response);
			
			
		
		}
		
		
		
	
	}

}
