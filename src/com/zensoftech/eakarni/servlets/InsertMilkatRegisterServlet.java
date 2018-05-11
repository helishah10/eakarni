package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.Person;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.TalatiMilkatRegisterManagerImpl;
import com.zensoftech.eakarni.service.TalatiPanchVeraManagerImpl;


@WebServlet("/InsertMilkatRegisterServlet")
public class InsertMilkatRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
		
		TalatiMilkatRegisterManagerImpl propertyOwner=(TalatiMilkatRegisterManagerImpl)getServletContext().getAttribute("propertyOwner");
		TalatiMilkatRegisterManagerImpl propertyOccupant=(TalatiMilkatRegisterManagerImpl)getServletContext().getAttribute("propertyOccupant");
		TalatiMilkatRegisterManagerImpl propertyTax=(TalatiMilkatRegisterManagerImpl)getServletContext().getAttribute("propertyTax");
		TalatiMilkatRegisterManagerImpl propertyTransfer=(TalatiMilkatRegisterManagerImpl)getServletContext().getAttribute("propertyTransfer");
		TalatiMilkatRegisterManagerImpl propertyMaster=(TalatiMilkatRegisterManagerImpl)getServletContext().getAttribute("propertyMaster");
		
		
		AppointmentTalati appointmentTalati=appointmentmanager.getVillage(loginId);
		int villageId=appointmentTalati.getVillage().getId();//autoincrement village id
		Village village=new Village();
		village.setId(villageId);
		
		/*String propertyNo=request.getParameter("propertyNo");*/
		String ownerName=request.getParameter("owner");
		int ownerAadharcard =Integer.parseInt(request.getParameter("owneraadhar"));
		String addButton=request.getParameter("add");
		System.out.println("add:"+addButton);
		/*String removeButton=request.getParameter("remove");
		int total=addbu*/
		/*boolean split=Boolean.parseBoolean(request.getParameter("split"));
		*/
		/*String occupantName=request.getParameter("occupantName");
		int occupantAadharcard=Integer.parseInt(request.getParameter("occupantAadharcard"));
		String areaName=request.getParameter("areaName");
		String areaDescription=request.getParameter("areaDescription");
		double estimatedTaxAmount=Double.parseDouble(request.getParameter("estimatedTaxAmount"));
		double assessmentOfAnnualRent=Double.parseDouble(request.getParameter("assessmentOfAnnualRent"));
		double previouslyMentionedSurplusAndDeficitAmount=Double.parseDouble(request.getParameter("previouslyMentionedSurplusAndDeficitAmount"));
		int registerPageNo=Integer.parseInt(request.getParameter("registerPageNo"));
		String parent=request.getParameter("parent");
		boolean split=Boolean.parseBoolean("split");*/
		
		System.out.println(ownerAadharcard);
		System.out.println(ownerName);
		
		
		
		
       /* List<Person> personInfo = new ArrayList<>();
        Person person=new Person();
        person.setName(ownerName);
        person.setAadharcard(ownerAadharcard);
        personInfo.add(person)	;	


      System.out.println(personInfo);*/
		
	}

}
