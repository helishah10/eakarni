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
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiJaminMehsulManagerImpl;


@WebServlet("/TalatiJaminMehsulServlet")
public class TalatiJaminMehsulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("in servlet:");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiJaminMehsulManagerImpl talatijaminmanager=(TalatiJaminMehsulManagerImpl)getServletContext().getAttribute("talatijaminmanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		 JaminMehsulVeraVasulat jamin=new JaminMehsulVeraVasulat();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			jamin=talatijaminmanager.getJaminMehsulVeraVasulatDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(jamin);
			request.getSession(false).setAttribute("jaminvillage", jamin);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageLandRevenue.jsp");
	
			rd.forward(request, response);
		}
		
		/*System.out.println(cdp);*/
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			JaminMehsulVeraVasulat jamin1=(JaminMehsulVeraVasulat)request.getSession(false).getAttribute("jaminvillage");
			System.out.println("before method call from session:"+jamin1);
			
			System.out.println(" in else if");
			 double landRevenue=Double.parseDouble(request.getParameter("landRevenue"));
				double totalAmountSeeking=Double.parseDouble(request.getParameter("totalAmountSeeking"));
				double amountCollectedDuringMonth=Double.parseDouble(request.getParameter("amountCollectedDuringMonth"));
				double amountLeft=Double.parseDouble(request.getParameter("amountLeft"));
				double percentage=amountCollectedDuringMonth/100*totalAmountSeeking;
			
			
			 YearMonth yearmonth=jamin1.getYearmonth();
		
			 jamin1.setLandRevenue(landRevenue);
				jamin1.setTotalAmountSeeking(totalAmountSeeking);
				jamin1.setAmountCollectedDuringMonth(amountCollectedDuringMonth);
				jamin1.setAmountLeft(amountLeft);
				jamin1.setPercentage(percentage);
			System.out.println(jamin1);
			jamin=talatijaminmanager.updateJaminMehsulVeraVasulat(jamin1, autovid,yearmonth);
			System.out.println("after mehtod call:"+jamin);
			request.setAttribute("cdpvillage",jamin);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageLandRevenue.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
	}

}
