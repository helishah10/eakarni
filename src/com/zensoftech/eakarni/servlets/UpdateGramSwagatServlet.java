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
import com.zensoftech.eakarni.entities.Gramswagat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiGramswagatManagerImpl;


@WebServlet("/UpdateGramSwagatServlet")
public class UpdateGramSwagatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("in servlet:");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiGramswagatManagerImpl talatigramswagatmanager=(TalatiGramswagatManagerImpl)getServletContext().getAttribute("talatigramswagatmanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		Gramswagat gram=new Gramswagat();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			
			System.out.println(YearMonth.of(year, month));
		
			gram=talatigramswagatmanager.getGramswagatDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(gram);
			request.getSession(false).setAttribute("gramvillage", gram);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageGramSwagat.jsp");
	
			rd.forward(request, response);
		}
		
		/*System.out.println(cdp);*/
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			Gramswagat gram1=(Gramswagat)request.getSession(false).getAttribute("gramvillage");
			System.out.println("before method call from session:"+gram1);
			
			System.out.println(" in else if");
			 String descriptionOfQuestionsRaised=request.getParameter("descriptionOfQuestionsRaised");
			 int disposal=Integer.parseInt(request.getParameter("disposal"));
			 int pending=Integer.parseInt(request.getParameter("pending"));
			
	
			 YearMonth yearmonth=gram1.getYearmonth();
		
			 	gram1.setDescriptionOfQuestionsRaised(descriptionOfQuestionsRaised);
				gram1.setPending(pending);
				gram1.setDisposal(disposal);
				gram1.setEntryDate(java.time.LocalDate.now());
				
			System.out.println(gram1);
			gram=talatigramswagatmanager.updateGramswagat(gram1, autovid,yearmonth);
			System.out.println("after mehtod call:"+gram);
			request.setAttribute("gramvillage",gram);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageGramSwagat.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
		
				
			
		
	}

}
