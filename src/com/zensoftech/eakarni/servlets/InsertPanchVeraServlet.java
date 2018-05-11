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
import com.zensoftech.eakarni.entities.PanchVeraVasulat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiPanchVeraManagerImpl;


@WebServlet("/InsertPanchVeraServlet")
public class InsertPanchVeraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//talatipanchveramanager
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in servlet");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiPanchVeraManagerImpl talatipanchveramanager=(TalatiPanchVeraManagerImpl)getServletContext().getAttribute("talatipanchveramanager");
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
		
	
		PanchVeraVasulat panchvera=new PanchVeraVasulat();
		
		String taxname=request.getParameter("taxname");
		System.out.println("taxname in servlet"+taxname);
		
		double seekingPreviousAmountLeft=Double.parseDouble(request.getParameter("seekingPreviousAmountLeft"));
		double seekingCurrentAmount=Double.parseDouble(request.getParameter("seekingCurrentAmount"));
		double seekingTotalAmount=seekingPreviousAmountLeft+seekingCurrentAmount;
		
		double recoveryTillPreviousMonthPrevious=Double.parseDouble(request.getParameter("recoveryTillPreviousMonthPrevious"));
		double recoveryTillPreviousMonthCurrent=Double.parseDouble(request.getParameter("recoveryTillPreviousMonthCurrent"));
		double recoveryTillPreviousMonthTotal=recoveryTillPreviousMonthCurrent+recoveryTillPreviousMonthPrevious;
		
		
		double recoveryTillCurrentMonthPrevious=Double.parseDouble(request.getParameter("recoveryTillCurrentMonthPrevious"));
		double recoveryTillCurrentMonthCurrent=Double.parseDouble(request.getParameter("recoveryTillCurrentMonthCurrent"));
		double recoveryTillCurrentMonthTotal=recoveryTillCurrentMonthCurrent+recoveryTillCurrentMonthPrevious;
		
		double totalRecoveryPrevious=Double.parseDouble(request.getParameter("totalRecoveryPrevious"));
		double totalRecoveryCurrent=Double.parseDouble(request.getParameter("totalRecoveryCurrent"));
		double totalRecoveryTotal=totalRecoveryPrevious+totalRecoveryCurrent;
		
		double recoveryLeftAtTheEndMonthPrevious=Double.parseDouble(request.getParameter("recoveryLeftAtTheEndMonthPrevious"));
		double recoveryLeftAtTheEndMonthCurrent=Double.parseDouble(request.getParameter("recoveryLeftAtTheEndMonthCurrent"));
		double recoveryLeftAtTheEndMonthTotal=recoveryLeftAtTheEndMonthCurrent-recoveryLeftAtTheEndMonthPrevious;
		
		System.out.println( recoveryLeftAtTheEndMonthTotal);
		
		double percentage=recoveryLeftAtTheEndMonthTotal*100/seekingTotalAmount;
		System.out.println( percentage);
		
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
			panchvera.setVillage(village);
		    
			
			panchvera.setSeekingPreviousAmountLeft(seekingPreviousAmountLeft);
			panchvera.setSeekingCurrentAmount(seekingCurrentAmount);
			panchvera.setSeekingTotalAmount(seekingTotalAmount);
			
			panchvera.setRecoveryTillPreviousMonthCurrent(recoveryTillPreviousMonthCurrent);
			panchvera.setRecoveryTillPreviousMonthPrevious(recoveryTillPreviousMonthPrevious);
			panchvera.setRecoveryTillPreviousMonthTotal(recoveryTillPreviousMonthTotal);
			
			panchvera.setRecoveryTillCurrentMonthCurrent(recoveryTillCurrentMonthCurrent);
			panchvera.setRecoveryTillCurrentMonthPrevious(recoveryTillCurrentMonthPrevious);
			panchvera.setRecoveryTillCurrentMonthTotal(recoveryTillCurrentMonthTotal);
			
			panchvera.setTotalRecoveryCurrent(totalRecoveryCurrent);
			panchvera.setTotalRecoveryPrevious(totalRecoveryPrevious);
			panchvera.setTotalRecoveryTotal(totalRecoveryTotal);
			
			panchvera.setRecoveryLeftAtTheEndMonthCurrent(recoveryLeftAtTheEndMonthCurrent);
			panchvera.setRecoveryLeftAtTheEndMonthPrevious(recoveryLeftAtTheEndMonthPrevious);
			panchvera.setRecoveryLeftAtTheEndMonthTotal(recoveryLeftAtTheEndMonthTotal);
			
			panchvera.setPercentage(percentage);
			
			panchvera.setEntryDate(java.time.LocalDate.now());
			panchvera.setYearmonth(YearMonth.of(year, month));
			
			
			panchvera=talatipanchveramanager.addEntry(panchvera, villageId,taxname);
			System.out.println(panchvera);
			request.setAttribute("panchveraentry", panchvera);
			
			RequestDispatcher rd=request.getRequestDispatcher("PanchVeraVasulatTbl.jsp");
			rd.forward(request, response);
			
		}
		
		else if(currentmonth==1 && month==12 && year==currentyear){
			
			panchvera.setVillage(village);
		    
			
			panchvera.setSeekingPreviousAmountLeft(seekingPreviousAmountLeft);
			panchvera.setSeekingCurrentAmount(seekingCurrentAmount);
			panchvera.setSeekingTotalAmount(seekingTotalAmount);
			
			panchvera.setRecoveryTillPreviousMonthCurrent(recoveryTillPreviousMonthCurrent);
			panchvera.setRecoveryTillPreviousMonthPrevious(recoveryTillPreviousMonthPrevious);
			panchvera.setRecoveryTillPreviousMonthTotal(recoveryTillPreviousMonthTotal);
			
			panchvera.setRecoveryTillCurrentMonthCurrent(recoveryTillCurrentMonthCurrent);
			panchvera.setRecoveryTillCurrentMonthPrevious(recoveryTillCurrentMonthPrevious);
			panchvera.setRecoveryTillCurrentMonthTotal(recoveryTillCurrentMonthTotal);
			
			panchvera.setTotalRecoveryCurrent(totalRecoveryCurrent);
			panchvera.setTotalRecoveryPrevious(totalRecoveryPrevious);
			panchvera.setTotalRecoveryTotal(totalRecoveryTotal);
			
			panchvera.setRecoveryLeftAtTheEndMonthCurrent(recoveryLeftAtTheEndMonthCurrent);
			panchvera.setRecoveryLeftAtTheEndMonthPrevious(recoveryLeftAtTheEndMonthPrevious);
			panchvera.setRecoveryLeftAtTheEndMonthTotal(recoveryLeftAtTheEndMonthTotal);
			
			panchvera.setPercentage(percentage);
			
			panchvera.setEntryDate(java.time.LocalDate.now());
			panchvera.setYearmonth(YearMonth.of(year, month));
			
			
			panchvera=talatipanchveramanager.addEntry(panchvera, villageId,taxname);
			System.out.println(panchvera);
			request.setAttribute("panchveraentry", panchvera);
			
			RequestDispatcher rd=request.getRequestDispatcher("PanchVeraVasulatTbl.jsp");
			rd.forward(request, response);
			
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillagePanchVeraVasulat.jsp");
			rd.forward(request, response);
		}


		
		
	
		
		
	}

}
