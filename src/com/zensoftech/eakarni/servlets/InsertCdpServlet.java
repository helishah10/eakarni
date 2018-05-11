package com.zensoftech.eakarni.servlets;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiCdpManagerImpl;

@WebServlet("/InsertCdpServlet")
public class InsertCdpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiCdpManagerImpl talaticdpmanager=(TalatiCdpManagerImpl)getServletContext().getAttribute("talaticdpmanager");
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
		Cdp cdp=new Cdp();
		
		double grantAllocated=Double.parseDouble(request.getParameter("grantAllocated"));
		double costsDuringPreviousYear=Double.parseDouble(request.getParameter("costsDuringPreviousYear"));
		double costsDuringThisMonth=Double.parseDouble(request.getParameter("costsDuringThisMonth"));
		double onGoingCostsDuringCurrentYear=costsDuringPreviousYear+costsDuringThisMonth;
		double achievementOfPreviousMonthOfCurrentYear=Double.parseDouble(request.getParameter("achievementOfPreviousMonthOfCurrentYear"));
		double achievementsDuirngThisMonth=Double.parseDouble(request.getParameter("achievementsDuirngThisMonth"));
		double totalAchievementsOfCurrentYear=achievementOfPreviousMonthOfCurrentYear+achievementsDuirngThisMonth;
		int month=Integer.parseInt(request.getParameter("month"));
		int year=Integer.parseInt(request.getParameter("year"));
		
		YearMonth currentyearmonth=java.time.YearMonth.now();
		System.out.println(currentyearmonth);
		int currentmonth=currentyearmonth.getMonthValue();
		System.out.println(currentmonth);
		int currentyear=currentyearmonth.getYear();
		System.out.println(currentyear);
		
		if(currentmonth-1==month && year==currentyear){
			cdp.setVillage(village);
			cdp.setGrantAllocated(grantAllocated);
			cdp.setCostsDuringPreviousYear(costsDuringPreviousYear);
			cdp.setCostsDuringThisMonth(costsDuringThisMonth);
			cdp.setOngoingCostsDuringCurrentYear(onGoingCostsDuringCurrentYear);
			cdp.setAchievementOfPreviousMonthOfCurrentYear(achievementOfPreviousMonthOfCurrentYear);
			cdp.setAchievementsDuirngThisMonth(achievementsDuirngThisMonth);
			cdp.setTotalAchievementsOfCurrentYear(totalAchievementsOfCurrentYear);
			cdp.setEntryDate(java.time.LocalDate.now());
			cdp.setYearmonth(YearMonth.of(year, month));
			
			
			cdp=talaticdpmanager.addEntry(cdp, villageId);
			request.setAttribute("cdpentry", cdp);
			
			RequestDispatcher rd=request.getRequestDispatcher("VillageCdp.jsp");
			rd.forward(request, response);
			
		}
		
		else if(currentmonth==1 && month==12 && year==currentyear)
		{
			cdp.setVillage(village);
			cdp.setGrantAllocated(grantAllocated);
			cdp.setCostsDuringPreviousYear(costsDuringPreviousYear);
			cdp.setCostsDuringThisMonth(costsDuringThisMonth);
			cdp.setOngoingCostsDuringCurrentYear(onGoingCostsDuringCurrentYear);
			cdp.setAchievementOfPreviousMonthOfCurrentYear(achievementOfPreviousMonthOfCurrentYear);
			cdp.setAchievementsDuirngThisMonth(achievementsDuirngThisMonth);
			cdp.setTotalAchievementsOfCurrentYear(totalAchievementsOfCurrentYear);
			cdp.setEntryDate(java.time.LocalDate.now());
			cdp.setYearmonth(YearMonth.of(year, month));
			
			
			cdp=talaticdpmanager.addEntry(cdp, villageId);
			request.setAttribute("cdpentry", cdp);
			
			RequestDispatcher rd=request.getRequestDispatcher("VillageCdp.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageCdp.jsp");
			rd.forward(request, response);
		}
	
		
		
	}

}
