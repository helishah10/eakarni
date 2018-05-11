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
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiGramswagatManagerImpl;


@WebServlet("/InsertGramSvagatServlet")
public class InsertGramSvagatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiGramswagatManagerImpl talatigramswagatmanager=(TalatiGramswagatManagerImpl)getServletContext().getAttribute("talatigramswagatmanager");
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
		Gramswagat gram=new Gramswagat();
		
		int month=Integer.parseInt(request.getParameter("month"));
		int year=Integer.parseInt(request.getParameter("year"));
		
		YearMonth currentyearmonth=java.time.YearMonth.now();
		System.out.println(currentyearmonth);
		int currentmonth=currentyearmonth.getMonthValue();
		System.out.println(currentmonth);
		int currentyear=currentyearmonth.getYear();
		System.out.println(currentyear);
		
		String descriptionOfQuestionsRaised=request.getParameter("descriptionOfQuestionsRaised");
		int disposal=Integer.parseInt(request.getParameter("disposal"));
		int pending=Integer.parseInt(request.getParameter("pending"));
		
		month=Integer.parseInt(request.getParameter("month"));
		year=Integer.parseInt(request.getParameter("year"));
		
		
		if(currentmonth-1==month && year==currentyear){
			
			gram.setVillage(village);
			gram.setDescriptionOfQuestionsRaised(descriptionOfQuestionsRaised);
			gram.setDisposal(disposal);
			gram.setPending(pending);
			gram.setEntryDate(java.time.LocalDate.now());
			gram.setYearmonth(YearMonth.of(year, month));
			gram.setEntryDate(java.time.LocalDate.now());
			month=Integer.parseInt(request.getParameter("month"));
			year=Integer.parseInt(request.getParameter("year"));
			
			
			gram=talatigramswagatmanager.addEntry(gram, villageId);
			request.setAttribute("gramswagatentry", gram);
			
			RequestDispatcher rd=request.getRequestDispatcher("GramSvagattbl.jsp");
			rd.forward(request, response);
			
		}
		
		else if(currentmonth==1 && month==12 && year==currentyear){
			gram.setVillage(village);
			gram.setDescriptionOfQuestionsRaised(descriptionOfQuestionsRaised);
			gram.setDisposal(disposal);
			gram.setPending(pending);
			gram.setEntryDate(java.time.LocalDate.now());
			gram.setYearmonth(YearMonth.of(year, month));
			gram.setEntryDate(java.time.LocalDate.now());
			month=Integer.parseInt(request.getParameter("month"));
			year=Integer.parseInt(request.getParameter("year"));
			
			
			gram=talatigramswagatmanager.addEntry(gram, villageId);
			request.setAttribute("gramswagatentry", gram);
			
			RequestDispatcher rd=request.getRequestDispatcher("GramSvagattbl.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageGramswagat.jsp");
			rd.forward(request, response);
		}
	
		
		
	}

}
