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
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiIayMangerImpl;


@WebServlet("/UpdateIayServlet")
public class UpdateIayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiIayMangerImpl talatiaymanager=(TalatiIayMangerImpl)getServletContext().getAttribute("talatiiaymanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		Iay iay=new Iay();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			iay=talatiaymanager.getIayDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(iay);
			request.getSession(false).setAttribute("iayvillage", iay);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageIay.jsp");
	
			rd.forward(request, response);
		}
		
		/*System.out.println(cdp);*/
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			Iay iay1=(Iay)request.getSession(false).getAttribute("iayvillage");
			System.out.println("before method call from session:"+iay1);
			
			System.out.println(" in else if");
			
			double firstInstallment=Double.parseDouble(request.getParameter("firstInstallment"));
			double secondInstallment=Double.parseDouble(request.getParameter("secondInstallment"));
			double thirdInstallment=Double.parseDouble(request.getParameter("thirdInstallment"));
			double target=firstInstallment+secondInstallment+thirdInstallment;
			
			
			 YearMonth yearmonth=iay1.getYearmonth();
		
			 iay1.setFirstInstallment(firstInstallment);
			 iay1.setSecondInstallment(secondInstallment);
			 iay1.setThirdInstallment(thirdInstallment);
			 iay1.setTarget((int) target);
			System.out.println(iay1);
			iay=talatiaymanager.updateIay(iay1, autovid,yearmonth);
			System.out.println("after mehtod call:"+iay);
			request.setAttribute("iayvillage",iay);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageIay.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
		
		
	}

}
