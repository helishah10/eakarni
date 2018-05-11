package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TdoManagerImpl;
import com.zensoftech.eakarni.service.TotalEnteriesForTalukaManagerImpl;
import com.zensoftech.eakarni.service.UserManagerImpl;

@WebServlet("/TdoDashboardServlet")
public class TdoDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doPost(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TdoManagerImpl tdomanager=(TdoManagerImpl)getServletContext().getAttribute("tdomanager");
		
		TotalEnteriesForTalukaManagerImpl talukaCdpcountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaCdpcountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaGramperacountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaGramperacountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaEgramcountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaEgramcountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaFinancecountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaFinancecountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaSmbcountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaSmbcountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaGramswagatcountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaGramswagatcountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaIaycountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaIaycountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaJaminMehsulcountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaJaminMehsulcountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaPanchVeracountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaPanchVeracountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaHsgcountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaHsgcountmanager");
		
		TotalEnteriesForTalukaManagerImpl talukaPropertycountmanager=(TotalEnteriesForTalukaManagerImpl)getServletContext().getAttribute("talukaPropertycountmanager");
		

		
		
		AppointmentTdo tdo=new AppointmentTdo();
		tdo=appointmentmanager.getTaluka(loginId);
		
		int talukaId=tdo.getTaluka().gettId();
		
		int totalNoVillages=tdomanager.getTotalVillagesByTalukaId(talukaId);
		request.setAttribute("villageCount", totalNoVillages);
		
		int totalCdpCount=talukaCdpcountmanager.getCdpTotalCount(talukaId);
		request.setAttribute("talukaCdpCount", totalCdpCount);
		
		int totalEgramCount=talukaEgramcountmanager.getEgramTotalCount(talukaId);
		request.setAttribute("talukaEgramCount", totalEgramCount);
		
		int totalGramperaCount=talukaGramperacountmanager.getGpperaTotalCount(talukaId);
		request.setAttribute("talukaGramperaCount", totalGramperaCount);
		
		int totalFinanceCount=talukaFinancecountmanager.getFinanceTotalCount(talukaId);
		request.setAttribute("talukaFinanceCount", totalFinanceCount);
		
		int totalSmbCount=talukaSmbcountmanager.getSmbTotalCount(talukaId);
		request.setAttribute("talukaSmbCount", totalSmbCount);
		
		int totalGramswagatCount=talukaGramswagatcountmanager.getGramswagatTotalCount(talukaId);
		request.setAttribute("talukaGramswagatCount", totalGramswagatCount);
		
		int totalIayCount=talukaIaycountmanager.getIayTotalCount(talukaId);
		request.setAttribute("talukaIayCount", totalIayCount);
		
		int totalJaminMehsulCount=talukaJaminMehsulcountmanager.getJaminMehsulTotalCount(talukaId);
		request.setAttribute("talukaJaminMehsulCount", totalJaminMehsulCount);
		
		int totalPanchVeraCount=talukaPanchVeracountmanager.getPanchveraTotalCount(talukaId);
		request.setAttribute("talukaPanchVeraCount", totalPanchVeraCount);
		
		int totalHsgCount=talukaHsgcountmanager.getHsgTotalCount(talukaId);
		request.setAttribute("totalHsgCount", totalHsgCount);
		
		int totalPropertyCount=talukaPropertycountmanager.getPropertyTotal(talukaId);
		request.setAttribute("totalPropertyCount", totalPropertyCount);
		
		
	
		RequestDispatcher rd=request.getRequestDispatcher("TDO.jsp");
		rd.forward(request, response);
		
		
		
	}

}
