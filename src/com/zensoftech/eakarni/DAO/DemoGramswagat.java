package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.zensoftech.eakarni.entities.Gramswagat;

public class DemoGramswagat {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
		String user="eakarni";
		String password="eakarni";
		
		GramswagatDao dao=new GramswagatDaoImpl(driver,url,user,password);
		Gramswagat gramswagat=new Gramswagat();
		
System.out.println("updating the details:");
		
		System.out.println("enter the month");
		int month=Integer.parseInt(br.readLine());
		
		System.out.println("enter the year:");
		int year=Integer.parseInt(br.readLine());
		
		System.out.println("enter the villageId:");
		int villageId=Integer.parseInt(br.readLine());
		
		/*gramswagat=dao.getDetails(YearMonth.of(year, month), villageId);
		System.out.println(gramswagat);
		*/
		System.out.println("enter the desacription of questions raised:");
		String descriptionOfQuestionsRaised=br.readLine();

		System.out.println("enter the disposal of questions:");
		int disposal=Integer.parseInt(br.readLine());

		System.out.println("enter the pending questions:");
		int pending=Integer.parseInt(br.readLine());

		System.out.println("enter the date(dd-mm-yyyy):");
		String date=br.readLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate = LocalDate.parse(date, formatter);
		
		gramswagat.setDescriptionOfQuestionsRaised(descriptionOfQuestionsRaised);
		gramswagat.setDisposal(disposal);
		gramswagat.setPending(pending);
	    gramswagat.setEntryDate(entryDate);

	    gramswagat=dao.update(gramswagat,villageId,YearMonth.of(year, month));
		
		System.out.println(gramswagat);
		
		
		 Map<Integer,Gramswagat> gramMap=new HashMap<Integer,Gramswagat>();
		 /*
		System.out.println("all details by taluka:");
		System.out.println("enter the taluka id:");
		int talukaId=Integer.parseInt(br.readLine());
		gramMap=dao.getAllDetailsByTalukaId(talukaId);
		for(Map.Entry<Integer,Gramswagat> gramEntry: gramMap.entrySet())
		{
		       System.out.print(gramEntry.getKey()+" ---- ");
		       System.out.println(gramEntry.getValue());
		}
		
		System.out.println("get all details by village:");*/
		/*System.out.println("enter the village id:");
		int villageId=Integer.parseInt(br.readLine());
		
		gramMap=dao.getAllDetailsByVillageId(villageId);
	
		for(Map.Entry<Integer,Gramswagat> gramEntry: gramMap.entrySet())
		{
		       System.out.print(gramEntry.getKey()+" ---- ");
		       System.out.println(gramEntry.getValue());
		}
		*/
		/*System.out.println("get all details by district:");
		System.out.println("enter the district id:");
		int districtId=Integer.parseInt(br.readLine());
		gramMap=dao.getAllDetailsByDistrictId(districtId);
		for(Map.Entry<Integer,Gramswagat> gramEntry: gramMap.entrySet())
		{
		       System.out.print(gramEntry.getKey()+" ---- ");
		       System.out.println(gramEntry.getValue());
		       
		}*/
		/*
		 * System.out.println("enterin cdp details:");
		System.out.println("enter the village id to add the details to:");
		int villageid=Integer.parseInt(br.readLine());
		Cdp cdp=new Cdp();
		
		System.out.println("enter the month");
		int month=Integer.parseInt(br.readLine());
				
		System.out.println("enter the year");
		int year=Integer.parseInt(br.readLine());
	
		System.out.println("enter the grant allocated:");
		double grantAllocated=Double.parseDouble(br.readLine());

		System.out.println("enter the costs during previous year:");
		double costsDuringPreviousYear=Double.parseDouble(br.readLine());
		
		System.out.println("enter the cost during this month:");
		double costsDuringThisMonth=Double.parseDouble(br.readLine());

		System.out.println("enter the ongoing costs during the current year :");
		double onGoingCostsDuringCurrentYear=Double.parseDouble(br.readLine());
		
		System.out.println("enter the achievement of the previous month of the current yeaar:");
		double achievementOfPreviousMonthOfCurrentYear=Double.parseDouble(br.readLine());

		System.out.println("enter the achievements during this  month:");
		double achievementsDuirngThisMonth=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total achievements of the current year:");
		double totalAchievementsOfCurrentYear=Double.parseDouble(br.readLine());
		
		System.out.println("enter the date(dd-mm-yyyy):");
		String date=br.readLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate = LocalDate.parse(date, formatter);
		
		cdp.setMth(month);
		cdp.setYr(year);
		cdp.setEntryDate(entryDate);
		cdp.setGrantAllocated(grantAllocated);
		cdp.setCostsDuringPreviousYear( costsDuringPreviousYear);
		cdp.setCostsDuringThisMonth(costsDuringThisMonth);
		cdp.setOngoingCostsDuringCurrentYear(onGoingCostsDuringCurrentYear);
		cdp.setAchievementOfPreviousMonthOfCurrentYear(achievementOfPreviousMonthOfCurrentYear);
		cdp.setAchievementsDuirngThisMonth(achievementsDuirngThisMonth);
		cdp.setTotalAchievementsOfCurrentYear(totalAchievementsOfCurrentYear);
		cdpdao.insert(villageid, cdp);
		 */
		/*Gramswagat gramswagat=new Gramswagat();
		System.out.println("enter in gramswagat scheme details:");
		System.out.println("enter the village id to add the details to:");
		int villageid=Integer.parseInt(br.readLine());
		
		
		System.out.println("enter the month");
		int month=Integer.parseInt(br.readLine());
		
		System.out.println("enter the year");
		int year=Integer.parseInt(br.readLine());
	
		System.out.println("enter the desacription of questions raised:");
		String descriptionOfQuestionsRaised=br.readLine();

		System.out.println("enter the disposal of questions:");
		String disposal=br.readLine();
		
		System.out.println("enter the pending questions:");
		String pending=br.readLine();

		System.out.println("enter the date(dd-mm-yyyy):");
		String date=br.readLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate = LocalDate.parse(date, formatter);
		gramswagat.setMth(month);
		gramswagat.setYr(year);
		gramswagat.setEntryDate(entryDate);
		gramswagat.setDescriptionOfQuestionsRaised(descriptionOfQuestionsRaised);
		gramswagat.setDisposal(disposal);
		gramswagat.setPending(pending);
	   
		
		dao.insert(villageid,gramswagat);*/
	
	/*
		
		System.out.println("updating the details:");
		
		System.out.println("enter the month");
		month=Integer.parseInt(br.readLine());
		
		System.out.println("enter the year:");
		year=Integer.parseInt(br.readLine());
		
		System.out.println("enter the villageId:");
		villageId=Integer.parseInt(br.readLine());
		
		gramswagat=dao.getDetails(month, year, villageId);
		System.out.println(gramswagat);
		
		System.out.println("enter the desacription of questions raised:");
		descriptionOfQuestionsRaised=br.readLine();

		System.out.println("enter the disposal of questions:");
		disposal=br.readLine();
		
		System.out.println("enter the pending questions:");
		pending=br.readLine();

		System.out.println("enter the date(dd-mm-yyyy):");
		date=br.readLine();
		formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		entryDate = LocalDate.parse(date, formatter);
		
		gramswagat.setDescriptionOfQuestionsRaised(descriptionOfQuestionsRaised);
		gramswagat.setDisposal(disposal);
		gramswagat.setPending(pending);
	    gramswagat.setEntryDate(entryDate);

		dao.update(gramswagat);*/
		
	}

}

