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
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiPanchVeraManagerImpl;


@WebServlet("/UpdatePanchVeraVasulatServlet")
public class UpdatePanchVeraVasulatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiPanchVeraManagerImpl talatipanchveramanager=(TalatiPanchVeraManagerImpl)getServletContext().getAttribute("talatipanchveramanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		PanchVeraVasulat panchvera=new PanchVeraVasulat();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			panchvera=talatipanchveramanager.getPanchVeraVasulatDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(panchvera);
			request.getSession(false).setAttribute("panchveravillage", panchvera);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillagePanchVeraVasulat.jsp");
	
			rd.forward(request, response);
		}
		
		/*System.out.println(cdp);*/
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			PanchVeraVasulat panchvera1=(PanchVeraVasulat)request.getSession(false).getAttribute("panchveravillage");
			System.out.println("before method call from session:"+panchvera1);
			
			System.out.println(" in else if");
			String taxname=request.getParameter("taxName");
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
			
			double percentage=(recoveryLeftAtTheEndMonthTotal*100)/seekingTotalAmount;
			
			
			 YearMonth yearmonth=panchvera1.getYearmonth();
			 	panchvera1.setSeekingPreviousAmountLeft(seekingPreviousAmountLeft);
				panchvera1.setSeekingCurrentAmount(seekingCurrentAmount);
				panchvera1.setSeekingTotalAmount(seekingTotalAmount);
				
				panchvera1.setRecoveryTillPreviousMonthCurrent(recoveryTillPreviousMonthCurrent);
				panchvera1.setRecoveryTillPreviousMonthPrevious(recoveryTillPreviousMonthPrevious);
				panchvera1.setRecoveryTillPreviousMonthTotal(recoveryTillPreviousMonthTotal);
				
				panchvera1.setRecoveryTillCurrentMonthCurrent(recoveryTillCurrentMonthCurrent);
				panchvera1.setRecoveryTillCurrentMonthPrevious(recoveryTillCurrentMonthPrevious);
				panchvera1.setRecoveryTillCurrentMonthTotal(recoveryTillCurrentMonthTotal);
				
				panchvera1.setTotalRecoveryCurrent(totalRecoveryCurrent);
				panchvera1.setTotalRecoveryPrevious(totalRecoveryPrevious);
				panchvera1.setTotalRecoveryTotal(totalRecoveryTotal);
				
				panchvera1.setRecoveryLeftAtTheEndMonthCurrent(recoveryLeftAtTheEndMonthCurrent);
				panchvera1.setRecoveryLeftAtTheEndMonthPrevious(recoveryLeftAtTheEndMonthPrevious);
				panchvera1.setRecoveryLeftAtTheEndMonthTotal(recoveryLeftAtTheEndMonthTotal);
				
				panchvera1.setPercentage(percentage);
				
			 	
			System.out.println(panchvera1);
			panchvera=talatipanchveramanager.updatePanchVeraVasulat(panchvera1, autovid,yearmonth,taxname);
			System.out.println("after mehtod call:"+panchvera);
			request.setAttribute("panchveravillage",panchvera);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillagePanchVeraVasulat.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
		
				
	}

}
