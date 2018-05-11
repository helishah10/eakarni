package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Month;
import java.time.YearMonth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiCdpManagerImpl;


@WebServlet("/UpdateCdpServlet")
public class UpdateCdpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in servlet:");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiCdpManagerImpl talaticdpmanager=(TalatiCdpManagerImpl)getServletContext().getAttribute("talaticdpmanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		Cdp cdp=new Cdp();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			cdp=talaticdpmanager.getCdpDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(cdp);
			request.getSession(false).setAttribute("cdpvillage", cdp);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageCdp.jsp");
	
			rd.forward(request, response);
		}
		
		/*System.out.println(cdp);*/
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			Cdp cdp1=(Cdp)request.getSession(false).getAttribute("cdpvillage");
			System.out.println("before method call from session:"+cdp1);
			
			System.out.println(" in else if");
			double grantAllocated=Double.parseDouble(request.getParameter("grantAllocated"));
			System.out.println("grant:"+grantAllocated);
			double costsDuringPreviousYear=Double.parseDouble(request.getParameter("costsDuringPreviousYear"));
			double costsDuringThisMonth=Double.parseDouble(request.getParameter("costsDuringThisMonth"));
			double ongoingCostsDuringCurrentYear=costsDuringPreviousYear+costsDuringThisMonth;
			double achievementOfPreviousMonthOfCurrentYear=Double.parseDouble(request.getParameter("achievementOfPreviousMonthOfCurrentYear"));
			double achievementsDuirngThisMonth=Double.parseDouble(request.getParameter("achievementsDuirngThisMonth"));
			double totalAchievementsOfCurrentYear=achievementOfPreviousMonthOfCurrentYear+achievementsDuirngThisMonth;
			
			
			 YearMonth yearmonth=cdp1.getYearmonth();
		
			cdp1.setGrantAllocated(grantAllocated);
			cdp1.setCostsDuringPreviousYear(costsDuringPreviousYear);
			cdp1.setCostsDuringThisMonth(costsDuringThisMonth);
			cdp1.setOngoingCostsDuringCurrentYear(ongoingCostsDuringCurrentYear);
			cdp1.setAchievementOfPreviousMonthOfCurrentYear(achievementOfPreviousMonthOfCurrentYear);
			cdp1.setAchievementsDuirngThisMonth(achievementsDuirngThisMonth);
			cdp1.setTotalAchievementsOfCurrentYear(totalAchievementsOfCurrentYear);
			System.out.println(cdp1);
			cdp=talaticdpmanager.updateCdp(cdp1, autovid,yearmonth);
			System.out.println("after mehtod call:"+cdp);
			request.setAttribute("cdpvillage",cdp);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageCdp.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
		
				
			
		
		
	}

}
