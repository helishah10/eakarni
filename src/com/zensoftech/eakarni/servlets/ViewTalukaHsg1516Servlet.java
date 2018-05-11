package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.time.YearMonth;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.ViewHsgDetailsManagerImpl;


@WebServlet("/ViewTalukaHsg1516Servlet")
public class ViewTalukaHsg1516Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		
		if(request.getParameter("submit")!=null)
		{
			
			
			
			AppointmentTdo appointmentTdo=appointmentmanager.getTaluka(loginId);
			int talukaId=appointmentTdo.getTaluka().gettId();
			
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			int financeYear=Integer.parseInt(request.getParameter("financeYear"));
			if(financeYear==2014)
			{
				RequestDispatcher rd=request.getRequestDispatcher("ViewTalukaHSG14-15.jsp");

				rd.forward(request, response);
			}
			else
			{
				
			
			
				ViewHsgDetailsManagerImpl hsgmanager=(ViewHsgDetailsManagerImpl)getServletContext().getAttribute("hsgmanager");
				Map<Integer,Hsg> hsgMap;
				hsgMap=hsgmanager.getAllDetailsByTalukaId(talukaId,YearMonth.of(year, month));
			
				request.setAttribute("hsgTalukaMap", hsgMap);
				
				RequestDispatcher rd=request.getRequestDispatcher("ViewTalukaHSG15-16.jsp");

				rd.forward(request, response);
			}
			
		}
			
	}
	
}


