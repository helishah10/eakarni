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

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.GPauditpera;
import com.zensoftech.eakarni.entities.PanchVeraVasulat;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.ViewCdpDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewGpperaDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewPanchVeraVasulatDetailsManagerImpl;


@WebServlet("/GPAuditvillageServlet")
public class VillageGPAuditServlet extends HttpServlet {
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
			AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
			int villageId=appointmentTalati.getVillage().getvId();
			System.out.println("village id:"+villageId);
		
			
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			System.out.println("year:"+year);
			
			
			ViewGpperaDetailsManagerImpl peramanager=(ViewGpperaDetailsManagerImpl)getServletContext().getAttribute("peramanager");
			Map<Integer,GPauditpera> gpauditMap;
			gpauditMap=peramanager.getAllDetailsByVillageId(villageId,YearMonth.of(year, month));
		
			request.setAttribute("GpAuditVillageMap",gpauditMap);
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewVillageGramAuditpera.jsp");

			rd.forward(request, response);
		}
		
	}

}
