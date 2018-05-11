package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.PropertyMaster;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.service.PropertyDetailsManagerImpl;
import com.zensoftech.eakarni.service.TalatiCdpManagerImpl;

public class DemoCdp {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
		String user="eakarni";
		String password="eakarni";
		
		CdpDao cdpdao=new CdpDaoImpl(driver,url,user,password);
		
		PropertyDao propertydao=new PropertyDaoImpl(driver,url,user,password);
		PropertyMaster property=new PropertyMaster();
		
		PropertyDetailsManagerImpl manager=new PropertyDetailsManagerImpl(propertydao);
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the property id:");
		String propertyId=br1.readLine();
		property=manager.getProperty(propertyId);
		System.out.println(property);
		
		
		
		/*TalatiCdpManagerImpl cdpmanager=new TalatiCdpManagerImpl(cdpdao);
		Cdp cdp=new Cdp();
		
		System.out.println("enter the month");
		int month=Integer.parseInt(br.readLine());
				
		System.out.println("enter the year");
		int year=Integer.parseInt(br.readLine());
	
		System.out.println("enter the villageId:");
		int villageId=Integer.parseInt(br.readLine());
		cdp=cdpdao.getDetails(month, year, villageId);
		
		
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
	
		System.out.println("enter the date(dd-MM-yyyy):");
		String date=br.readLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate = LocalDate.parse(date, formatter);
		
		
		cdp.setGrantAllocated(grantAllocated);
		cdp.setCostsDuringPreviousYear( costsDuringPreviousYear);
		cdp.setCostsDuringThisMonth(costsDuringThisMonth);
		cdp.setOngoingCostsDuringCurrentYear(onGoingCostsDuringCurrentYear);
		cdp.setAchievementOfPreviousMonthOfCurrentYear(achievementOfPreviousMonthOfCurrentYear);
		cdp.setAchievementsDuirngThisMonth(achievementsDuirngThisMonth);
		cdp.setTotalAchievementsOfCurrentYear(totalAchievementsOfCurrentYear);
		cdp.setEntryDate(entryDate);
		boolean value=cdpmanager.updateCdp(cdp, villageId, month, year);
		System.out.println("value:"+value);*/
		
	
		/*System.out.println("enter the taluka id:");
		int districtId=Integer.parseInt(br.readLine());
		
		int total=cdpdao.getTotalCountByDistictId(districtId);
		System.out.println("total:"+total);
		Map<Integer, Cdp> cdpMap=new HashMap<Integer,Cdp>();
		cdpMap=cdpdao.getAllDetailsByDistrictId(districtId);
		
		System.out.println("cdp:"+cdpMap);*/
		
		
		/*int total=cdpdao.getTotalCountByTalukaId(talukaId,villageId);
		System.out.println("successful"+total);*/
		/*Map<Integer, Cdp> cdpMap=new HashMap<Integer,Cdp>();
		System.out.println("all details by taluka:");
		System.out.println("enter the taluka id:");
		int talukaId=Integer.parseInt(br.readLine());
		cdpMap=cdpdao.getAllDetailsByTalukaId(talukaId);
		for(Map.Entry<Integer,Cdp> cdpEntry: cdpMap.entrySet())
		{
		       System.out.print(cdpEntry.getKey()+" ---- ");
		       System.out.println(cdpEntry.getValue());
		}*/
		
	/*	Map<Integer, Cdp> cdpMap=new HashMap<Integer,Cdp>();
		System.out.println("get all details by village:");
		System.out.println("enter the village id:");
		int villageId=Integer.parseInt(br.readLine());
		cdpMap=cdpdao.getAllDetailsByVillageId(villageId);
		for(Map.Entry<Integer,Cdp> cdpEntry: cdpMap.entrySet())
		{
		       System.out.print(cdpEntry.getKey()+" ---- ");
		       System.out.println(cdpEntry.getValue());
		}
		*/
	
		/*CdpDao dao2=new CdpDaoImpl(driver,url,user,password);
		System.out.println("get all details by district:");
		System.out.println("enter the district id:");
		 Map<Integer, Cdp> cdpMap=new HashMap<Integer,Cdp>();
		int districtId1=Integer.parseInt(br.readLine());
		 cdpMap = dao2.getAllDetailsByDistrictId(districtId1);
		for(Map.Entry<Integer,Cdp> cdpEntry: cdpMap.entrySet())
		{
		       System.out.print(cdpEntry.getKey()+" ---- ");
		       System.out.println(cdpEntry.getValue());
		}*/
	
		
	/*	
		System.out.println("enterin cdp details:");
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
		cdp.setEntryDate(java.time.LocalDate.now());
		cdp.setGrantAllocated(grantAllocated);
		cdp.setCostsDuringPreviousYear( costsDuringPreviousYear);
		cdp.setCostsDuringThisMonth(costsDuringThisMonth);
		cdp.setOngoingCostsDuringCurrentYear(onGoingCostsDuringCurrentYear);
		cdp.setAchievementOfPreviousMonthOfCurrentYear(achievementOfPreviousMonthOfCurrentYear);
		cdp.setAchievementsDuirngThisMonth(achievementsDuirngThisMonth);
		cdp.setTotalAchievementsOfCurrentYear(totalAchievementsOfCurrentYear);
		cdp=cdpdao.insert(villageid, cdp);
		System.out.println(cdp);
		*/
		
		/*CdpDao dao5=new CdpDaoImpl(driver, url, user, password);
		System.out.println("enter the month");
		int month=Integer.parseInt(br.readLine());
				
		System.out.println("enter the year");
		int year=Integer.parseInt(br.readLine());
	
		System.out.println("enter the villageId:");
		int villageId=Integer.parseInt(br.readLine());
		
		Cdp cdp=new Cdp();
		
		cdp=dao5.getDetails(month, year, villageId);
		System.out.println(cdp);

		CdpDao dao4=new CdpDaoImpl();*/
		
		
		/*Cdp cdp=new Cdp();
		CdpDao dao4=new CdpDaoImpl(driver,url,user,password);
		System.out.println("enter the month");
		int month=Integer.parseInt(br.readLine());
		System.out.println("enter the year");
		int year=Integer.parseInt(br.readLine());
		System.out.println("enter the village id");
		int villageId=Integer.parseInt(br.readLine());
		cdp=dao4.getDetails(month, year, villageId);
		System.out.println("updating cdp details:");
		
		
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
	
		System.out.println("enter the date(dd-MM-yyyy):");
		String date=br.readLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate = LocalDate.parse(date, formatter);
		
		cdp.setGrantAllocated(grantAllocated);
		cdp.setCostsDuringPreviousYear( costsDuringPreviousYear);
		cdp.setCostsDuringThisMonth(costsDuringThisMonth);
		cdp.setOngoingCostsDuringCurrentYear(onGoingCostsDuringCurrentYear);
		cdp.setAchievementOfPreviousMonthOfCurrentYear(achievementOfPreviousMonthOfCurrentYear);
		cdp.setAchievementsDuirngThisMonth(achievementsDuirngThisMonth);
		cdp.setTotalAchievementsOfCurrentYear(totalAchievementsOfCurrentYear);
		cdp.setEntryDate(entryDate);
		
		boolean cdpdata=cdpdao.update(cdp,villageId);
		System.out.println("after update:"+cdpdata);
		*/
	
	
		
	}
	
	
}
