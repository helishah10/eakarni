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
import com.zensoftech.eakarni.entities.Egram;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiEgramManagerImpl;


@WebServlet("/UpdateEgramServlet")
public class UpdateEgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("in servlet:");
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiEgramManagerImpl talatiegrammanager=(TalatiEgramManagerImpl)getServletContext().getAttribute("talatiegrammanager");
		
		AppointmentTalati talati=new AppointmentTalati();
		talati=appointmentmanager.getVillage(loginId);
		int villageId=talati.getVillage().getvId();
		int autovid=talati.getVillage().getId();
		
		Egram egram=new Egram();
		
		if(request.getParameter("submit")!=null)
		
		{
			int month=Integer.parseInt(request.getParameter("month"));
			int year=Integer.parseInt(request.getParameter("year"));
			
			System.out.println(month);
			System.out.println(year);
			
		
			/*yearmonth.of(year, month);
			cdp.setYearmonth(yearmonth);*/
			System.out.println(YearMonth.of(year, month));
		
			egram=talatiegrammanager.getEgramDetailsByMonth(villageId,YearMonth.of(year, month));
			System.out.println(egram);
			request.getSession(false).setAttribute("egramvillage", egram);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageEgram.jsp");
	
			rd.forward(request, response);
		}
		
		/*System.out.println(cdp);*/
		
		else if(request.getParameter("update")!=null)
		{
			System.out.println(" in else if");
			Egram egram1=(Egram)request.getSession(false).getAttribute("egramvillage");
			System.out.println("before method call from session:"+egram1);
			
			System.out.println(" in else if");
			
			int birthCertificateCopy=Integer.parseInt(request.getParameter("birthCertificateCopy"));
			 double birthCertificateIncome=birthCertificateCopy*10;
			 int deathCertificateCopy=Integer.parseInt(request.getParameter("deathCertificateCopy"));
			 double deathCertificateIncome=deathCertificateCopy*10;
			 int characterCertificateCopy=Integer.parseInt(request.getParameter("characterCertificateCopy"));
			 double characterCertificateIncome=characterCertificateCopy*10;
			 int casteCertificateCopy=Integer.parseInt(request.getParameter("casteCertificateCopy"));
			 double casteCertificateIncome=casteCertificateCopy*10;
		     int incomeCertificateCopy=Integer.parseInt(request.getParameter("incomeCertificateCopy"));
			 double incomeCertificateIncome=incomeCertificateCopy*10;
			 int copyOf7128A=Integer.parseInt(request.getParameter("copyOf7128A"));
			 double incomeOf7128A=copyOf7128A*5;
			 int HGVCLbill=Integer.parseInt(request.getParameter("MGVCLbill"));
			 double HGVCLIncome=HGVCLbill*7;
			 int BADEAEntry=Integer.parseInt(request.getParameter("BADEAEntry"));
			 double BADEAIncome=BADEAEntry*10;
			 int farmerApplication=Integer.parseInt(request.getParameter("farmerApplication"));
			 double farmerIncome=farmerApplication*10;
			 int GSPCBill=Integer.parseInt(request.getParameter("GSPCBill"));
			 double GSPCIncome=GSPCBill*7;
			 int CSCService=Integer.parseInt(request.getParameter("CSCService"));
			 double CSCIncome=CSCService*10;
			 int otherService=Integer.parseInt(request.getParameter("otherService"));
			 double otherIncome=otherService*10;
		
			
			
			 YearMonth yearmonth=egram1.getYearmonth();
		
			
				egram1.setBirthCertificateCopy(birthCertificateCopy);
				egram1.setBirthCertificateIncome(birthCertificateIncome);
				egram1.setDeathCertificateCopy(deathCertificateCopy);
				egram1.setDeathCertificateIncome(deathCertificateIncome);
				egram1.setCharacterCertificateCopy(characterCertificateCopy);
				egram1.setCharacterCertificateIncome(characterCertificateIncome);
				egram1.setCasteCertificateCopy(casteCertificateCopy);
				egram1.setCasteCertificateIncome(casteCertificateIncome);
				egram1.setIncomeCertificateCopy(incomeCertificateCopy);
				egram1.setIncomeCertificateIncome(incomeCertificateIncome);
				egram1.setCopyOf7128A(copyOf7128A);
				egram1.setIncomeOf7128A(incomeOf7128A);
				egram1.setMGVCLbill(HGVCLbill);
				egram1.setMGVCLIncome(HGVCLIncome);
				egram1.setBADEAEntry(BADEAEntry);
				egram1.setBADEAIncome(BADEAIncome);
				egram1.setFarmerApplication(farmerApplication);
				egram1.setFarmerIncome(farmerIncome);
				egram1.setGSPCBill(GSPCBill);
				egram1.setGSPCIncome(GSPCIncome);
				egram1.setCSCService(CSCService);
				egram1.setCSCIncome(CSCIncome);
				egram1.setOtherService(otherService);
				egram1.setOtherIncome(otherIncome);
				egram1.setEntryDate(java.time.LocalDate.now());
			
			System.out.println(egram1);
			egram=talatiegrammanager.updateEgram(egram1, autovid,yearmonth);
			System.out.println("after mehtod call:"+egram);
			request.setAttribute("egramvillage",egram);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateVillageEgram.jsp");
			
			rd.forward(request, response);
		
			
			
		}
		
		else
		{
			System.out.println("none");
		}
	}

}
