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
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiGramAuditManagerImpl;


@WebServlet("/UpdateGpAuditServlet")
public class UpdateGpAuditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("in servlet:");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiGramAuditManagerImpl talatiperamanager=(TalatiGramAuditManagerImpl)getServletContext().getAttribute("talatiperamanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		GPauditpera pera=new GPauditpera();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			pera=talatiperamanager.getGPauditperaDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(pera);
			request.getSession(false).setAttribute("peravillage", pera);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateGPAudit.jsp");
	
			rd.forward(request, response);
		}
	
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			GPauditpera pera1=(GPauditpera)request.getSession(false).getAttribute("peravillage");
			System.out.println("before method call from session:"+pera1);
			
			System.out.println(" in else if");
			int yearOfRegisteration=Integer.parseInt(request.getParameter("yearOfRegisteration"));
			int totalPera=Integer.parseInt(request.getParameter("totalPera"));
			int totalPeraAnsweredThisWeek=Integer.parseInt(request.getParameter("totalPeraAnsweredThisWeek"));
			int peraNotanswered=totalPera-totalPeraAnsweredThisWeek;
			
			
			 YearMonth yearmonth=pera1.getYearmonth();
			 System.out.println(yearmonth);
		
			 pera1.setYearOfRegisteration(yearOfRegisteration);
			 pera1.setTotalPera(totalPera);
			pera1.setTotalPeraAnsweredThisWeek(totalPeraAnsweredThisWeek);
			pera1.setPeraNotanswered(peraNotanswered);
				
				
			System.out.println(pera1);
			pera=talatiperamanager.updateGPauditpera(pera1, autovid,yearmonth);
			System.out.println("after mehtod call:"+pera);
			request.setAttribute("peravillage",pera);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateGPAudit.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
		
				
	}

}
