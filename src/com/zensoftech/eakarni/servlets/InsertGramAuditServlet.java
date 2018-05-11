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
import com.zensoftech.eakarni.entities.GPauditpera;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiGramAuditManagerImpl;


@WebServlet("/InsertGramAuditServlet")
public class InsertGramAuditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiGramAuditManagerImpl talatiperamanager=(TalatiGramAuditManagerImpl)getServletContext().getAttribute("talatiperamanager");
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
	
		
		GPauditpera gpAudit=new GPauditpera();
		
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
			int yearOfRegisteration=Integer.parseInt(request.getParameter("yearOfRegisteration"));
			int totalPera=Integer.parseInt(request.getParameter("totalPera"));
			int totalPeraAnsweredThisWeek=Integer.parseInt(request.getParameter("totalPeraAnsweredThisWeek"));
			int peraNotanswered=totalPera-totalPeraAnsweredThisWeek;
			/*int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));*/
			
			

			gpAudit.setYearOfRegisteration(yearOfRegisteration);
			gpAudit.setTotalPera(totalPera);
			gpAudit.setTotalPeraAnsweredThisWeek(totalPeraAnsweredThisWeek);
			gpAudit.setPeraNotanswered(peraNotanswered);
			
			gpAudit.setYearmonth(YearMonth.of(year, month));
			
			gpAudit=talatiperamanager.addEntry( gpAudit,villageId);
			System.out.println("pera in servlet:"+gpAudit);
			request.setAttribute("GpAuditentry", gpAudit);
			
			RequestDispatcher rd=request.getRequestDispatcher("GramAuditTbl.jsp");
			rd.forward(request, response);
		}
		
		else if(currentmonth==1 && month==12 && year==currentyear){
			
			int yearOfRegisteration=Integer.parseInt(request.getParameter("yearOfRegisteration"));
			int totalPera=Integer.parseInt(request.getParameter("totalPera"));
			int totalPeraAnsweredThisWeek=Integer.parseInt(request.getParameter("totalPeraAnsweredThisWeek"));
			int peraNotanswered=totalPera-totalPeraAnsweredThisWeek;
			/*int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));*/
			
			

			gpAudit.setYearOfRegisteration(yearOfRegisteration);
			gpAudit.setTotalPera(totalPera);
			gpAudit.setTotalPeraAnsweredThisWeek(totalPeraAnsweredThisWeek);
			gpAudit.setPeraNotanswered(peraNotanswered);
			
			gpAudit.setYearmonth(YearMonth.of(year, month));
			
			gpAudit=talatiperamanager.addEntry( gpAudit,villageId);
			System.out.println("pera in servlet:"+gpAudit);
			request.setAttribute("GpAuditentry", gpAudit);
			
			RequestDispatcher rd=request.getRequestDispatcher("GramAuditTbl.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageGramAuditpera.jsp");
			rd.forward(request, response);
		}
		
	}

}
