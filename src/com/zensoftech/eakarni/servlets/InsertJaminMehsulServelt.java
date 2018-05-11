package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.time.YearMonth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiJaminMehsulManager;
import com.zensoftech.eakarni.service.TalatiJaminMehsulManagerImpl;



@WebServlet("/InsertJaminMehsulServelt")
public class InsertJaminMehsulServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiJaminMehsulManager talatijaminmanager=(TalatiJaminMehsulManagerImpl)getServletContext().getAttribute("talatijaminmanager");
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
		JaminMehsulVeraVasulat jamin=new JaminMehsulVeraVasulat();
		
	    double landRevenue=Integer.parseInt(request.getParameter("landRevenue"));
		double totalAmountSeeking=Integer.parseInt(request.getParameter("totalAmountSeeking"));
		double amountCollectedDuringMonth=Integer.parseInt(request.getParameter("amountCollectedDuringMonth"));
		double amountLeft=Integer.parseInt(request.getParameter("amountLeft"));
		double percentage=amountCollectedDuringMonth/100*totalAmountSeeking;
		int month=Integer.parseInt(request.getParameter("month"));
		int year=Integer.parseInt(request.getParameter("year"));
		
	
		
		YearMonth currentyearmonth=java.time.YearMonth.now();
		System.out.println(currentyearmonth);
		int currentmonth=currentyearmonth.getMonthValue();
		System.out.println(currentmonth);
		int currentyear=currentyearmonth.getYear();
		System.out.println(currentyear);
		
		if(currentmonth-1==month && year==currentyear)
		{
			jamin.setVillage(village);
			jamin.setLandRevenue(landRevenue);
			jamin.setTotalAmountSeeking(totalAmountSeeking);
			jamin.setAmountCollectedDuringMonth(amountCollectedDuringMonth);
			jamin.setAmountLeft(amountLeft);
			jamin.setPercentage(percentage);
			jamin.setEntryDate(java.time.LocalDate.now());
			jamin.setYearmonth(YearMonth.of(year, month));
			
			jamin=talatijaminmanager.addEntry(jamin, villageId);
			request.setAttribute("jaminentry", jamin);
			
			RequestDispatcher rd=request.getRequestDispatcher("JaminMehsulTbl.jsp");
			rd.forward(request, response);
			
		}
		
		else if(currentmonth==1 && month==12 && year==currentyear){
			jamin.setVillage(village);
			jamin.setLandRevenue(landRevenue);
			jamin.setTotalAmountSeeking(totalAmountSeeking);
			jamin.setAmountCollectedDuringMonth(amountCollectedDuringMonth);
			jamin.setAmountLeft(amountLeft);
			jamin.setPercentage(percentage);
			jamin.setEntryDate(java.time.LocalDate.now());
			jamin.setYearmonth(YearMonth.of(year, month));
			
			jamin=talatijaminmanager.addEntry(jamin, villageId);
			request.setAttribute("jaminentry", jamin);
			
			RequestDispatcher rd=request.getRequestDispatcher("JaminMehsulTbl.jsp");
			rd.forward(request, response);
			
		}


			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ViewVillageJaminMehsulVeraVasulat.jsp");
				rd.forward(request, response);
			}
		
		
	}

}
