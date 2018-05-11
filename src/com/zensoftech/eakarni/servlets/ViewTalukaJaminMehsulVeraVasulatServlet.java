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
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.JaminMehsulReportManager;
import com.zensoftech.eakarni.service.ViewCdpDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewJaminMehsulDetailsManagerImpl;


@WebServlet("/ViewTalukaJaminMehsulVeraVasulatServlet")
public class ViewTalukaJaminMehsulVeraVasulatServlet extends HttpServlet {
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
			
			ViewJaminMehsulDetailsManagerImpl jaminmanager=(ViewJaminMehsulDetailsManagerImpl)getServletContext().getAttribute("jaminmanager");
			Map<Integer,JaminMehsulVeraVasulat> jaminMap;
			jaminMap=jaminmanager.getAllDetailsByTalukaId(talukaId,YearMonth.of(year, month));
			System.out.println("servlet:"+jaminMap);
		
			request.setAttribute("jaminTalukaMap", jaminMap);
			
			YearMonth yearmonth=YearMonth.of(year, month);
			
			JaminMehsulReportManager jaminreportmanager=(JaminMehsulReportManager)request.getServletContext().getAttribute("jaminreportmanager");
			try {
				 /*FileOutputStream file =cdpreportmanager.generateTalukaCdpReport(talukaautoId, yearmonth);*/
				jaminreportmanager.generateTalukaJaminMehsulReport(talukaautoId, yearmonth);
				 
				System.out.println("in try servlet:");
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewTalukaJaminMehsulVeraVasulat.jsp");

			rd.forward(request, response);
			
			
			
		}
		
		
	}

}
