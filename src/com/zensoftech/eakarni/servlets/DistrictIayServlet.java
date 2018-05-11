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
import com.zensoftech.eakarni.entities.Iay;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.IayReportManager;
import com.zensoftech.eakarni.service.ViewIayDetailsManagerImpl;


@WebServlet("/DistrictIayServlet")
public class DistrictIayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		/*AppointmentDdo appointmentDdo=appointmentmanager.getDistrict(loginId);
		int districtId=appointmentDdo.getDistrict().getDId();*/
		
		if(request.getParameter("submit")!=null)
		{
			AppointmentDdo appointmentDdo=appointmentmanager.getDistrict(loginId);
			int districtId=appointmentDdo.getDistrict().getDId();
			int districtAutoId=appointmentDdo.getDistrict().getId();
			
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			ViewIayDetailsManagerImpl iaymanager=(ViewIayDetailsManagerImpl)getServletContext().getAttribute("iaymanager");
			Map<Integer,Iay> iayMap;
			iayMap=iaymanager.getAllDetailsByDistrictId(districtId,YearMonth.of(year, month));

			request.setAttribute("iayDistrictMap", iayMap);
			
			YearMonth yearmonth=YearMonth.of(year, month);
			
			IayReportManager iayreportmanager=(IayReportManager)request.getServletContext().getAttribute("iayreportmanager");
			try {
				 
				iayreportmanager.generateDistrictIayReport(districtAutoId, yearmonth);
				 
				System.out.println("in try servlet:");
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			

			request.setAttribute("iayDistrictMap", iayMap);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewDistrictIAY.jsp");

			rd.forward(request, response);
			
			
		}
		
	}

}
