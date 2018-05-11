package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.DdoManagerImpl;
import com.zensoftech.eakarni.service.TotalEnteriesForDistrictManagerImpl;


@WebServlet("/DdoDashboardServlet")
public class DdoDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		DdoManagerImpl ddomanager=(DdoManagerImpl)getServletContext().getAttribute("ddomanager");

		TotalEnteriesForDistrictManagerImpl districtCdpcountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtCdpcountmanager");
		TotalEnteriesForDistrictManagerImpl districtFinancecountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtFinancecountmanager");
		TotalEnteriesForDistrictManagerImpl districtEgramcountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtEgramcountmanager");
		TotalEnteriesForDistrictManagerImpl districtGramperacountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtGramperacountmanager");
		TotalEnteriesForDistrictManagerImpl districtSmbcountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtSmbcountmanager");
		TotalEnteriesForDistrictManagerImpl districtGramswagatcountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtGramswagatcountmanager");
		TotalEnteriesForDistrictManagerImpl districtIaycountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtIaycountmanager");
		TotalEnteriesForDistrictManagerImpl districtJaminMehsulcountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtJaminMehsulcountmanager");
		TotalEnteriesForDistrictManagerImpl districtPanchVeracountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtPanchVeracountmanager");
		TotalEnteriesForDistrictManagerImpl districtHsgcountmanager=(TotalEnteriesForDistrictManagerImpl)getServletContext().getAttribute("districtHsgcountmanager");
		
		
		AppointmentDdo ddo=new AppointmentDdo();
		ddo=appointmentmanager.getDistrict(loginId);
		
		int districtId=ddo.getDistrict().getDId();
		
		int totalNoTalukas=ddomanager.getTotalTalukasByDistrictId(districtId);
		request.setAttribute("talukaCount", totalNoTalukas);
		
		
		
		int totalCdpCount=districtCdpcountmanager.getCdpTotalCount(districtId);
		request.setAttribute("districtCdpCount", totalCdpCount);
		int totalFinanceCount=districtFinancecountmanager.getFinanceTotalCount(districtId);
		request.setAttribute("districtFinanceCount", totalFinanceCount);
		int totalEgramCount=districtEgramcountmanager.getEgramTotalCount(districtId);
		request.setAttribute("districtEgramCount", totalEgramCount);
		int totalGramperaCount=districtGramperacountmanager.getGpperaTotalCount(districtId);
		request.setAttribute("districtGramperaCount", totalGramperaCount);
		int totalSmbCount=districtSmbcountmanager.getSmbTotalCount(districtId);
		request.setAttribute("districtSmbCount", totalSmbCount);
		int totalGramswagatCount=districtGramswagatcountmanager.getGramswagatTotalCount(districtId);
		request.setAttribute("districtGramswagatCount", totalGramswagatCount);
		int totalIayCount=districtIaycountmanager.getIayTotalCount(districtId);
		request.setAttribute("districtIayCount", totalIayCount);
		int totalJaminMehsulCount=districtJaminMehsulcountmanager.getJaminMehsulTotalCount(districtId);
		request.setAttribute("districtJaminMehsulCount", totalJaminMehsulCount);
		int totalPanchVeraCount=districtPanchVeracountmanager.getPanchveraTotalCount(districtId);
		request.setAttribute("districtPanchVeraCount", totalPanchVeraCount);
		int totalHsgCount=districtHsgcountmanager.getHsgTotalCount(districtId);
		request.setAttribute("districtHsgCount", totalHsgCount);
	
		
		
		RequestDispatcher rd=request.getRequestDispatcher("DDO.jsp");
		rd.forward(request, response);
	
	
	
	}

}
