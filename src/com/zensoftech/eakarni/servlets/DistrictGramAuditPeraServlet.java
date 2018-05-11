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
import com.zensoftech.eakarni.entities.GPauditpera;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.GpauditperaReportManager;
import com.zensoftech.eakarni.service.ViewCdpDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewGpperaDetailsManagerImpl;


@WebServlet("/DistrictGramAuditPeraServlet")
public class DistrictGramAuditPeraServlet extends HttpServlet {
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
			AppointmentDdo appointmentDdo=appointmentmanager.getDistrict(loginId);
			int districtId=appointmentDdo.getDistrict().getDId();
			int districtAutoId=appointmentDdo.getDistrict().getId();
			
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			ViewGpperaDetailsManagerImpl peramanager=(ViewGpperaDetailsManagerImpl)getServletContext().getAttribute("peramanager");
			Map<Integer,GPauditpera> peraMap;
			peraMap=peramanager.getAllDetailsByDistrictId(districtId,YearMonth.of(year, month));
		
			request.setAttribute("peraDistrictMap", peraMap);
			
			YearMonth yearmonth=YearMonth.of(year, month);
			
			GpauditperaReportManager gpperareportmanager=(GpauditperaReportManager)request.getServletContext().getAttribute("gpperareportmanager");
			try {
				 /*FileOutputStream file =cdpreportmanager.generateTalukaCdpReport(talukaautoId, yearmonth);*/
				gpperareportmanager.generateDistrictGpAuditReport(districtAutoId, yearmonth);
				 
				System.out.println("in try servlet:");
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewDistrictGramAuditPera.jsp");

			rd.forward(request, response);
			
			
			
			
		}
		
	}

}
