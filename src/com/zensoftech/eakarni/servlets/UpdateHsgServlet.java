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
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiCdpManagerImpl;
import com.zensoftech.eakarni.service.TalatiHsgManagerImpl;


@WebServlet("/UpdateHsgServlet")
public class UpdateHsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in servlet:");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiHsgManagerImpl talatihsgmanager=(TalatiHsgManagerImpl)getServletContext().getAttribute("talatihsgmanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
			Hsg hsg=new Hsg();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			hsg=talatihsgmanager.getHsgDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(hsg);
			request.getSession(false).setAttribute("hsgvillage", hsg);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageHsg1.jsp");
	
			rd.forward(request, response);
		}
		
		/*System.out.println(cdp);*/
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			Hsg hsg1=(Hsg)request.getSession(false).getAttribute("hsgvillage");
			System.out.println("before method call from session:"+hsg1);
			
			System.out.println(" in else if");

			int notStartedHouses=Integer.parseInt(request.getParameter("notStartedHouses"));
			int plinthLevel=Integer.parseInt(request.getParameter("plinthLevel"));
			int lintalLevel=Integer.parseInt(request.getParameter("lintalLevel"));
	        int slabLevel=Integer.parseInt(request.getParameter("slabLevel"));
			int completedHouses=Integer.parseInt(request.getParameter("completedHouses"));
			int target=notStartedHouses+plinthLevel+lintalLevel+slabLevel+completedHouses;
			
			
			 YearMonth yearmonth=hsg1.getYearmonth();
		
	
				hsg1.setTarget(target);
				hsg1.setNotStartedHouses(notStartedHouses);
		
				hsg1.setPlinthLevel(plinthLevel);
				hsg1.setLintalLevel(lintalLevel);
				hsg1.setSlabLevel(slabLevel);
				hsg1.setCompletedHouses(completedHouses);

		
			System.out.println(hsg1);
			hsg=talatihsgmanager.updateHsg(hsg1, autovid,yearmonth);
			System.out.println("after mehtod call:"+hsg1);
			request.setAttribute("hsgvillage",hsg);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageHsg1.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
		
				
			
		
		
	}
		
		
	}

