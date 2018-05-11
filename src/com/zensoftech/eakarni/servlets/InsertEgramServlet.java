package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.time.LocalDate;
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
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiEgramManagerImpl;

@WebServlet("/InsertEgramServlet")
public class InsertEgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		TalatiEgramManagerImpl talatiegrammanager=(TalatiEgramManagerImpl)getServletContext().getAttribute("talatiegrammanager");
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
		Egram egram=new Egram();
		
		
		 int birthCertificateCopy=Integer.parseInt(request.getParameter("birthCertificateCopy"));
		 double birthCertificateIncome=birthCertificateCopy*10;
		 int deathCertificateCopy=Integer.parseInt(request.getParameter("deathCertificateCopy"));
		 double deathCertificateIncome=deathCertificateCopy*10;
		 int casteCertificateCopy=Integer.parseInt(request.getParameter("casteCertificateCopy"));
		 double casteCertificateIncome=casteCertificateCopy*10;
		 int characterCertificateCopy=Integer.parseInt(request.getParameter("characterCertificateCopy"));
		 double characterCertificateIncome=characterCertificateCopy*10;
	     int incomeCertificateCopy=Integer.parseInt(request.getParameter("incomeCertificateCopy"));
		 double incomeCertificateIncome=incomeCertificateCopy*10;
		 int copyOf7128A=Integer.parseInt(request.getParameter("copyOf7128A"));
		 double incomeOf7128A=copyOf7128A*5;
		 int MGVCLbill=Integer.parseInt(request.getParameter("MGVCLbill"));
		 double MGVCLIncome=MGVCLbill*7;
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
		 
				egram.setVillage(village);
				egram.setBirthCertificateCopy(birthCertificateCopy);
				egram.setBirthCertificateIncome(birthCertificateIncome);
				egram.setDeathCertificateCopy(deathCertificateCopy);
				egram.setDeathCertificateIncome(deathCertificateIncome);
				egram.setCasteCertificateCopy(casteCertificateCopy);
				egram.setCasteCertificateIncome(casteCertificateIncome);
				egram.setCharacterCertificateCopy(characterCertificateCopy);
				egram.setCharacterCertificateIncome(characterCertificateIncome);
				egram.setIncomeCertificateCopy(incomeCertificateCopy);
				egram.setIncomeCertificateIncome(incomeCertificateIncome);
				egram.setCopyOf7128A(copyOf7128A);
				egram.setIncomeOf7128A(incomeOf7128A);
				egram.setMGVCLbill(MGVCLbill);
				egram.setMGVCLIncome(MGVCLIncome);
				egram.setBADEAEntry(BADEAEntry);
				egram.setBADEAIncome(BADEAIncome);
				egram.setFarmerApplication(farmerApplication);
				egram.setFarmerIncome(farmerIncome);
				egram.setGSPCBill(GSPCBill);
				egram.setGSPCIncome(GSPCIncome);
				egram.setCSCService(CSCService);
				egram.setCSCIncome(CSCIncome);
				egram.setOtherService(otherService);
				egram.setOtherIncome(otherIncome);
				egram.setEntryDate(java.time.LocalDate.now());
				egram.setYearmonth(YearMonth.of(year, month));
			 
			 egram=talatiegrammanager.addEntry(egram, villageId);
			 System.out.println("egram in servlet:"+egram);
				request.setAttribute("egramentry", egram);
				
				RequestDispatcher rd=request.getRequestDispatcher("VillageEgram.jsp");
				rd.forward(request, response);
			}
			else if(currentmonth==1 && month==12 && year==currentyear)
			{
				
				egram.setVillage(village);
				egram.setBirthCertificateCopy(birthCertificateCopy);
				egram.setBirthCertificateIncome(birthCertificateIncome);
				egram.setDeathCertificateCopy(deathCertificateCopy);
				egram.setDeathCertificateIncome(deathCertificateIncome);
				egram.setCasteCertificateCopy(casteCertificateCopy);
				egram.setCasteCertificateIncome(casteCertificateIncome);
				egram.setCharacterCertificateCopy(characterCertificateCopy);
				egram.setCharacterCertificateIncome(characterCertificateIncome);
				egram.setIncomeCertificateCopy(incomeCertificateCopy);
				egram.setIncomeCertificateIncome(incomeCertificateIncome);
				egram.setCopyOf7128A(copyOf7128A);
				egram.setIncomeOf7128A(incomeOf7128A);
				egram.setMGVCLbill(MGVCLbill);
				egram.setMGVCLIncome(MGVCLIncome);
				egram.setBADEAEntry(BADEAEntry);
				egram.setBADEAIncome(BADEAIncome);
				egram.setFarmerApplication(farmerApplication);
				egram.setFarmerIncome(farmerIncome);
				egram.setGSPCBill(GSPCBill);
				egram.setGSPCIncome(GSPCIncome);
				egram.setCSCService(CSCService);
				egram.setCSCIncome(CSCIncome);
				egram.setOtherService(otherService);
				egram.setOtherIncome(otherIncome);
				egram.setEntryDate(java.time.LocalDate.now());
				egram.setYearmonth(YearMonth.of(year, month));
				egram=talatiegrammanager.addEntry(egram, villageId);
				request.setAttribute("egramentry", egram);
				
				RequestDispatcher rd=request.getRequestDispatcher("VillageEgram.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ViewVillageEgram.jsp");
				rd.forward(request, response);
			}
			}
		 
		 
	}

