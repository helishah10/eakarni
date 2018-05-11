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
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiFinanceMangerImpl;


@WebServlet("/InsertFinanceServlet")
public class InsertFinanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiFinanceMangerImpl talatifinancemanager=(TalatiFinanceMangerImpl)getServletContext().getAttribute("talatifinancemanager");
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);

		
		Finance14 finance=new Finance14();
		
		int totalWork=Integer.parseInt(request.getParameter("totalWork"));
		int progress=Integer.parseInt(request.getParameter("progress"));
		int completed=Integer.parseInt(request.getParameter("completed"));
		double  GrantAllocated=Double.parseDouble(request.getParameter("GrantAllocated"));
		double amountSpent=Double.parseDouble(request.getParameter("amountSpent"));
		int projectNotStarted=Integer.parseInt(request.getParameter("projectNotStarted"));
		int worksApproved=projectNotStarted+progress+completed;
		
		int month=Integer.parseInt(request.getParameter("month"));
		int year=Integer.parseInt(request.getParameter("year"));
		
		YearMonth currentyearmonth=java.time.YearMonth.now();
		System.out.println(currentyearmonth);
		int currentmonth=currentyearmonth.getMonthValue();
		System.out.println(currentmonth);
		int currentyear=currentyearmonth.getYear();
		System.out.println(currentyear);
	
		if(currentmonth-1==month && year==currentyear){
		finance.setVillage(village);
		finance.setTotalWork(totalWork);
		finance.setWorksApproved(worksApproved);
		finance.setProjectNotStarted(projectNotStarted);
		finance.setProgress(progress);
		finance.setCompleted(completed);
		finance.setGrantAllocated(GrantAllocated);
		finance.setAmountSpent(amountSpent);
		finance.setEntryDate(java.time.LocalDate.now());
		finance.setYearmonth(YearMonth.of(year, month));
		
		finance=talatifinancemanager.addEntry(finance, villageId);
		System.out.println("finance ins servlet:"+finance);
		request.setAttribute("financeentry", finance);
		
		RequestDispatcher rd=request.getRequestDispatcher("FinanceTbl.jsp");
		rd.forward(request, response);
		
		}
		
		else if(currentmonth==1 && month==12 && year==currentyear)
		{
			
			finance.setVillage(village);
			finance.setTotalWork(totalWork);
			finance.setWorksApproved(worksApproved);
			finance.setProjectNotStarted(projectNotStarted);
			finance.setProgress(progress);
			finance.setCompleted(completed);
			finance.setGrantAllocated(GrantAllocated);
			finance.setAmountSpent(amountSpent);
			finance.setEntryDate(java.time.LocalDate.now());
			finance.setYearmonth(YearMonth.of(year, month));
			
			finance=talatifinancemanager.addEntry(finance, villageId);
			System.out.println("finance ins servlet:"+finance);
			request.setAttribute("financeentry", finance);
			
			RequestDispatcher rd=request.getRequestDispatcher("FinanceTbl.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageFinance.jsp");
			rd.forward(request, response);
		}
	}

}
