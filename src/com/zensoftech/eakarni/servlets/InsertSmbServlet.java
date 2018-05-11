package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.SMB;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiGramSmbManagerImpl;

@WebServlet("/InsertSmbServlet")
public class InsertSmbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiGramSmbManagerImpl talatismbmanager=(TalatiGramSmbManagerImpl)getServletContext().getAttribute("talatismbmanager");
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement
		
		SMB smb=new SMB();
		int totalFamilies=Integer.parseInt(request.getParameter("totalFamilies"));
		int familiesHavingLavatories=Integer.parseInt(request.getParameter("FamiliesNotHavingLavatories"));
		int familiesNotHavingLavatories=totalFamilies-familiesHavingLavatories;
		int lavatoriesMadeDuringWeek=Integer.parseInt(request.getParameter("LavatoriesMadeDuringWeek"));
		
		int month=Integer.parseInt(request.getParameter("month"));
		int year=Integer.parseInt(request.getParameter("year"));
		YearMonth currentyearmonth=java.time.YearMonth.now();
		System.out.println(currentyearmonth);
		int currentmonth=currentyearmonth.getMonthValue();
		System.out.println(currentmonth);
		int currentyear=currentyearmonth.getYear();
		System.out.println(currentyear);
		/*String date=request.getParameter("entryDate");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate = LocalDate.parse(date);*/
		
		if(currentmonth-1==month && year==currentyear){
			smb.setTotalFamilies(totalFamilies);
			smb.setFamiliesHavingLavatories(familiesHavingLavatories);
			smb.setFamiliesNotHavingLavatories(familiesNotHavingLavatories);
			smb.setLavatoriesMadeDuringWeek(lavatoriesMadeDuringWeek);
			smb.setEntryDate(java.time.LocalDate.now());
			smb.setYearmonth(YearMonth.of(year, month));
			
			smb=talatismbmanager.addEntry(smb, villageId);
			request.setAttribute("smbentry",smb);
			
			RequestDispatcher rd=request.getRequestDispatcher("GramsmbTbl.jsp");
			rd.forward(request, response);
			
		}
		
		else if(currentmonth==1 && month==12 && year==currentyear){
			smb.setTotalFamilies(totalFamilies);
			smb.setFamiliesHavingLavatories(familiesHavingLavatories);
			smb.setFamiliesNotHavingLavatories(familiesNotHavingLavatories);
			smb.setLavatoriesMadeDuringWeek(lavatoriesMadeDuringWeek);
			smb.setEntryDate(java.time.LocalDate.now());
			smb.setYearmonth(YearMonth.of(year, month));
			
			smb=talatismbmanager.addEntry(smb, villageId);
			request.setAttribute("smbentry",smb);
			
			RequestDispatcher rd=request.getRequestDispatcher("GramsmbTbl.jsp");
			rd.forward(request, response);
			
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageSmb.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
