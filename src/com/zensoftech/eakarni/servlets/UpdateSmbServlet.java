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
import com.zensoftech.eakarni.entities.SMB;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiGramSmbManagerImpl;


@WebServlet("/UpdateSmbServlet")
public class UpdateSmbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("in servlet:");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiGramSmbManagerImpl talatismbmanager=(TalatiGramSmbManagerImpl)getServletContext().getAttribute("talatismbmanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		SMB smb=new SMB();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			smb=talatismbmanager.getSMBDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println("in servlet:"+smb);
			
			request.getSession(false).setAttribute("smbvillage", smb);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageSMB.jsp");
	
			rd.forward(request, response);
		}
		
		/*System.out.println(cdp);*/
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			SMB smb1=(SMB)request.getSession(false).getAttribute("smbvillage");
			System.out.println("before method call from session:"+smb1);
			
			System.out.println(" in else if");
			int totalFamilies=Integer.parseInt(request.getParameter("totalFamilies"));
			int familiesHavingLavatories=Integer.parseInt(request.getParameter("familiesHavingLavatories"));
			int familiesNotHavingLavatories=totalFamilies-familiesHavingLavatories;
			int lavatoriesMadeDuringWeek=Integer.parseInt(request.getParameter("lavatoriesMadeDuringWeek"));
			
			 YearMonth yearmonth=smb1.getYearmonth();
		
				smb1.setTotalFamilies(totalFamilies);
				smb1.setFamiliesHavingLavatories(familiesHavingLavatories);
				smb1.setFamiliesNotHavingLavatories(familiesNotHavingLavatories);
				smb1.setLavatoriesMadeDuringWeek(lavatoriesMadeDuringWeek);
				
			smb=talatismbmanager.updateSMB(smb1, autovid,yearmonth);
			System.out.println("after mehtod call:"+smb);
			request.setAttribute("smbvillage",smb);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageSMB.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
		
	}

}
