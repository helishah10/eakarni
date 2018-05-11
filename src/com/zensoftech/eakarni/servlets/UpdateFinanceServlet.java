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
import com.zensoftech.eakarni.entities.Finance14;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiFinanceMangerImpl;


@WebServlet("/UpdateFinanceServlet")
public class UpdateFinanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("in servlet:");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiFinanceMangerImpl talatifinancemanager=(TalatiFinanceMangerImpl)getServletContext().getAttribute("talatifinancemanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		Finance14 finance=new Finance14();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			finance=talatifinancemanager.getFinanceDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(finance);
			request.getSession(false).setAttribute("financevillage", finance);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageFinance.jsp");
	
			rd.forward(request, response);
		}
	
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			Finance14 finance1=(Finance14)request.getSession(false).getAttribute("financevillage");
			System.out.println("before method call from session:"+finance1);
			
			System.out.println(" in else if");
			int totalWork=Integer.parseInt(request.getParameter("totalWork"));
			int projectNotStarted=Integer.parseInt(request.getParameter("projectNotStarted"));
			int progress=Integer.parseInt(request.getParameter("progress"));
			int completed=Integer.parseInt(request.getParameter("completed"));
			int worksApproved=projectNotStarted+progress+completed;
			double  GrantAllocated=Double.parseDouble(request.getParameter("grantAllocated"));
			double amountSpent=Double.parseDouble(request.getParameter("amountSpent"));
			
			
			 YearMonth yearmonth=finance1.getYearmonth();
		
			finance1.setTotalWork(totalWork);
			finance1.setWorksApproved(worksApproved);
			finance1.setProjectNotStarted(projectNotStarted);
			finance1.setProgress(progress);
			finance1.setCompleted(completed);
			finance1.setGrantAllocated(GrantAllocated);
			finance1.setAmountSpent(amountSpent);
			finance1.setEntryDate(java.time.LocalDate.now());
			
			System.out.println(finance1);
			finance=talatifinancemanager.updateFinance(finance1, autovid,yearmonth);
			System.out.println("after mehtod call:"+finance);
			request.setAttribute("financevillage",finance);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageFinance.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
		
				
			
	}

}
