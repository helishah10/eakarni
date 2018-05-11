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
import com.zensoftech.eakarni.entities.Iay;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiCdpManagerImpl;
import com.zensoftech.eakarni.service.TalatiIayMangerImpl;

@WebServlet("/InsertIayServlet")
public class InsertIayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiIayMangerImpl talatiiaymanager=(TalatiIayMangerImpl)getServletContext().getAttribute("talatiiaymanager");
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
		Iay iay=new Iay();
		
		
		double firstInstallment=Double.parseDouble(request.getParameter("firstInstallment"));
		double secondInstallment=Double.parseDouble(request.getParameter("secondInstallment"));
		double thirdInstallment=Double.parseDouble(request.getParameter("thirdInstallment"));
		int target=(int) (firstInstallment+secondInstallment+thirdInstallment);
		int month=Integer.parseInt(request.getParameter("month"));
		int year=Integer.parseInt(request.getParameter("year"));
		
				
		YearMonth currentyearmonth=java.time.YearMonth.now();
		System.out.println(currentyearmonth);
		int currentmonth=currentyearmonth.getMonthValue();
		System.out.println(currentmonth);
		int currentyear=currentyearmonth.getYear();
		System.out.println(currentyear);
		
		if(currentmonth-1==month && year==currentyear){
			
			iay.setVillage(village);
			iay.setTarget(target);
			iay.setFirstInstallment(firstInstallment);
			iay.setSecondInstallment(secondInstallment);
			iay.setThirdInstallment(thirdInstallment);
			iay.setEntryDate(java.time.LocalDate.now());
			iay.setYearmonth(YearMonth.of(year, month));
			
			iay=talatiiaymanager.addEntry(iay, villageId);
			request.setAttribute("iayentry", iay);
			
			RequestDispatcher rd=request.getRequestDispatcher("IAYtbl.jsp");
			rd.forward(request, response);
		}
			
		
		
		else if (currentmonth==1 && month==12 && year==currentyear){
			
			iay.setVillage(village);
			iay.setTarget(target);
			iay.setFirstInstallment(firstInstallment);
			iay.setSecondInstallment(secondInstallment);
			iay.setThirdInstallment(thirdInstallment);
			iay.setEntryDate(java.time.LocalDate.now());
			iay.setYearmonth(YearMonth.of(year, month));
			
			iay=talatiiaymanager.addEntry(iay, villageId);
			request.setAttribute("iayentry", iay);
			
			RequestDispatcher rd=request.getRequestDispatcher("IAYtbl.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageIay.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
