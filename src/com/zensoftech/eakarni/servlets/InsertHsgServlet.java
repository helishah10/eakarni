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
import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiHsgManager;
import com.zensoftech.eakarni.service.TalatiHsgManagerImpl;



@WebServlet("/InsertHsgServlet")
public class InsertHsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiHsgManagerImpl talatihsgmanager=(TalatiHsgManagerImpl)getServletContext().getAttribute("talatihsgmanager");
		
		
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
		Hsg hsg=new Hsg();
		
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
			int financeYear=Integer.parseInt(request.getParameter("financeYear"));
			int notStartedHouses=Integer.parseInt(request.getParameter("notStartedHouses"));
			int plinthLevel=Integer.parseInt(request.getParameter("plinthLevel"));
			int lintalLevel=Integer.parseInt(request.getParameter("lintalLevel"));
	        int slabLevel=Integer.parseInt(request.getParameter("slabLevel"));
			int completedHouses=Integer.parseInt(request.getParameter("completedHouses"));
			 int target=notStartedHouses+plinthLevel+lintalLevel+slabLevel+completedHouses;
			 month=Integer.parseInt(request.getParameter("month"));
			 year=Integer.parseInt(request.getParameter("year"));
			
			if(financeYear==2014)
			{
				
				
				hsg.setVillage(village);
				hsg.setTarget(target);
				hsg.setNotStartedHouses(notStartedHouses);
				hsg.setPlinthLevel(plinthLevel);
				hsg.setLintalLevel(lintalLevel);
				hsg.setSlabLevel(slabLevel);
				hsg.setCompletedHouses(completedHouses);
				hsg.setFinanceYear(financeYear);
				hsg.setEntryDate(java.time.LocalDate.now());
				hsg.setYearmonth(YearMonth.of(year, month));
				
				
				hsg=talatihsgmanager.addEntry(hsg, villageId,YearMonth.of(year, month));
				request.setAttribute("hsg1415", hsg);
				
				RequestDispatcher rd=request.getRequestDispatcher("HSG_1_14_15_tbl.jsp");
				rd.forward(request, response);
			}
			
			else if(financeYear==2015){
				hsg.setVillage(village);
				hsg.setTarget(target);
				hsg.setNotStartedHouses(notStartedHouses);
				hsg.setPlinthLevel(plinthLevel);
				hsg.setLintalLevel(lintalLevel);
				hsg.setSlabLevel(slabLevel);
				hsg.setCompletedHouses(completedHouses);
				hsg.setFinanceYear(financeYear);
				hsg.setEntryDate(java.time.LocalDate.now());
				hsg.setYearmonth(YearMonth.of(year, month));
				
				
				hsg=talatihsgmanager.addEntry(hsg, villageId,YearMonth.of(year, month));
				request.setAttribute("hsg1516", hsg);
				
				RequestDispatcher rd=request.getRequestDispatcher("HSG_15_16_tbl.jsp");
				rd.forward(request, response);
			
			}
			
			
		
			
		}
		
		else if(currentmonth==1 && month==12 && year==currentyear)
		{
			int financeYear=Integer.parseInt(request.getParameter("financeYear"));
			int notStartedHouses=Integer.parseInt(request.getParameter("notStartedHouses"));
			int plinthLevel=Integer.parseInt(request.getParameter("plinthLevel"));
			int lintalLevel=Integer.parseInt(request.getParameter("lintalLevel"));
	        int slabLevel=Integer.parseInt(request.getParameter("slabLevel"));
			int completedHouses=Integer.parseInt(request.getParameter("completedHouses"));
			 int target=notStartedHouses+plinthLevel+lintalLevel+slabLevel+completedHouses;
			 month=Integer.parseInt(request.getParameter("month"));
			year=Integer.parseInt(request.getParameter("year"));
			
			if(financeYear==2014)
			{
				
				
				hsg.setVillage(village);
				hsg.setTarget(target);
				hsg.setNotStartedHouses(notStartedHouses);
				hsg.setPlinthLevel(plinthLevel);
				hsg.setLintalLevel(lintalLevel);
				hsg.setSlabLevel(slabLevel);
				hsg.setCompletedHouses(completedHouses);
				hsg.setFinanceYear(financeYear);
				hsg.setEntryDate(java.time.LocalDate.now());
				hsg.setYearmonth(YearMonth.of(year, month));
				
				
				hsg=talatihsgmanager.addEntry(hsg, villageId,YearMonth.of(year, month));
				request.setAttribute("hsg1415", hsg);
				
				RequestDispatcher rd=request.getRequestDispatcher("HSG_1_14_15_tbl.jsp");
				rd.forward(request, response);
			}
			
			else if(financeYear==2015){
				hsg.setVillage(village);
				hsg.setTarget(target);
				hsg.setNotStartedHouses(notStartedHouses);
				hsg.setPlinthLevel(plinthLevel);
				hsg.setLintalLevel(lintalLevel);
				hsg.setSlabLevel(slabLevel);
				hsg.setCompletedHouses(completedHouses);
				hsg.setFinanceYear(financeYear);
				hsg.setEntryDate(java.time.LocalDate.now());
				hsg.setYearmonth(YearMonth.of(year, month));
				
				
				hsg=talatihsgmanager.addEntry(hsg, villageId,YearMonth.of(year, month));
				request.setAttribute("hsg1516", hsg);
				
				RequestDispatcher rd=request.getRequestDispatcher("HSG_15_16_tbl.jsp");
				rd.forward(request, response);
		}
	}
			
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ViewVillageHsg1415.jsp");
				rd.forward(request, response);
			}
		
	}
}



