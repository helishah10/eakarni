package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.zensoftech.eakarni.entities.GPauditpera;
import com.zensoftech.eakarni.entities.PanchVeraVasulat;
import com.zensoftech.eakarni.entities.Taxtype;
import com.zensoftech.eakarni.service.ViewGpperaDetailsManagerImpl;

public class DemoPanchvera {
	public static void main(String args[]) throws IOException
	{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
		String user="eakarni";
		String password="eakarni";
		
		PanchVeraDao dao=new PanchVeraDaoImpl(driver,url,user,password);
		GpperaDao peradao=new GpperaDaoImpl(driver,url,user,password);
		
		/*System.out.println("get all details by village:");
		System.out.println("enter the village id:");
		int month=1;
		int year=2001;
		int villageId=Integer.parseInt(br.readLine());
		Map<Integer,GPauditpera> peramap;
		peramap=peradao.getAllDetailsByVillageId(villageId, YearMonth.of(year, month));
		
		System.out.println("pera map:"+peramap);
		
		ViewGpperaDetailsManagerImpl manager=new ViewGpperaDetailsManagerImpl(peradao);
		peramap=manager.getAllDetailsByVillageId(villageId, YearMonth.of(year, month));
		System.out.println("ins ervice:"+peramap);
		
		Map<Integer,PanchVeraVasulat> panchveraMap=new HashMap<Integer,PanchVeraVasulat>();
		int total;
		*/
		
		/*System.out.println("all details by taluka:");
		System.out.println("enter the taluka id:");
		int talukaId=Integer.parseInt(br.readLine());
		panchveraMap=dao.getAllDetailsByTalukaId(talukaId);
		 for(Map.Entry<Integer,PanchVeraVasulat> panchveraEntry: panchveraMap.entrySet())
			{
			       System.out.print(panchveraEntry.getKey()+" ---- ");
			       System.out.println(panchveraEntry.getValue());
			}
		*/
		/*System.out.println("get all details by village:");
		System.out.println("enter the village id:");
		int villageId=Integer.parseInt(br.readLine());
		panchveraMap=dao.getAllDetailsByTalukaId(talukaId);
		for(Map.Entry<Integer,PanchVeraVasulat> panchveraEntry: panchveraMap.entrySet())
		{
		       System.out.print(panchveraEntry.getKey()+" ---- ");
		       System.out.println(panchveraEntry.getValue());
		}
		*/
		/*System.out.println("get all details by district:");
		System.out.println("enter the district id:");
		int districtId=Integer.parseInt(br.readLine());
		total=dao.getTotalCountByDistrictId(districtId);
		System.out.println("total is: " +total);
		panchveraMap=dao.getAllDetailsByDistrictId(districtId);
		for(Map.Entry<Integer,PanchVeraVasulat> panchveraEntry: panchveraMap.entrySet())
		{
		       System.out.print(panchveraEntry.getKey()+" ---- ");
		       System.out.println(panchveraEntry.getValue());
		}*/
		/*System.out.println("enterin panch vera scheme details:");
		
		System.out.println("enter the village id to add the details to:");
		int villageid=Integer.parseInt(br.readLine());
		
		PanchVeraVasulat vera=new PanchVeraVasulat();
		System.out.println("enter the month:");
		int month=Integer.parseInt(br.readLine());
		
		System.out.println("enter the year:");
		int year= Integer.parseInt(br.readLine());
		
		System.out.println("enter the tax id:");
		int taxId=Integer.parseInt(br.readLine());

		System.out.println("enter the seeking previous amount left:");
		double seekingPreviousAmountLeft=Integer.parseInt(br.readLine());
		
		System.out.println("enter the seeking amount currently:");
		double seekingCurrentAmount=Double.parseDouble(br.readLine());

		System.out.println("enter the total amount seeking:");
		double seekingTotalAmount=Double.parseDouble(br.readLine());
		
		System.out.println("enter the amount recovered till the previous month of current year:");
		double recoveryTillPreviousMonthCurrent=Double.parseDouble(br.readLine());

		System.out.println("enter the recovered amount in previous month of previous year:");
		double recoveryTillPreviousMonthPrevious=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total amount recovered till previous month:");
		double recoveryTillPreviousMonthTotal=Double.parseDouble(br.readLine());
		
		System.out.println("enter the recovery done till current month of current year");
		double recoveryTillCurrentMonthCurrent=Double.parseDouble(br.readLine());
		
		System.out.println("enter the recovery done till current month of previous year:");
		double recoveryTillCurrentMonthPrevious=Double.parseDouble(br.readLine());
	
		System.out.println("enter the recoevry done till currrent month in total:");
		double recoveryTillCurrentMonthTotal=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total recovery done previously:");
	    double totalRecoveryPrevious=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total recovery done done currently:");
		double totalRecoveryCurrent=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total recovery done");
		double totalRecoveryTotal=Double.parseDouble(br.readLine());
		
		System.out.println("enter the amount left to be recovered till the end of previous month");
		double recoveryLeftAtTheEndMonthPrevious=Double.parseDouble(br.readLine());
		
		System.out.println("enter the recovery left at the end of month of current year");
		double recoveryLeftAtTheEndMonthCurrent=Double.parseDouble(br.readLine());
		
		System.out.println("enter the recovery left at the end of month in total");
		double recoveryLeftAtTheEndMonthTotal=Double.parseDouble(br.readLine());
		
		System.out.println("enter the date(dd-mm-yyyy):");
		String date=br.readLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate = LocalDate.parse(date, formatter);
		
		vera.setMth(month);
		vera.setYr(year);
		vera.setTaxId(taxId);
		vera.setSeekingPreviousAmountLeft(seekingPreviousAmountLeft);
		vera.setSeekingCurrentAmount(seekingCurrentAmount);
		vera.setSeekingTotalAmount(seekingTotalAmount);
		vera.setRecoveryTillPreviousMonthCurrent(recoveryTillPreviousMonthCurrent);
		vera.setRecoveryTillPreviousMonthPrevious(recoveryTillPreviousMonthPrevious);
		vera.setRecoveryTillPreviousMonthTotal(recoveryTillPreviousMonthTotal);
		vera.setRecoveryTillCurrentMonthCurrent(recoveryTillCurrentMonthCurrent);
		vera.setRecoveryTillCurrentMonthPrevious(recoveryTillCurrentMonthPrevious);
		vera.setRecoveryTillCurrentMonthTotal(recoveryTillCurrentMonthTotal);
		vera.setTotalRecoveryPrevious(totalRecoveryPrevious);
		vera.setTotalRecoveryCurrent(totalRecoveryCurrent);
		vera.setTotalRecoveryTotal(totalRecoveryTotal);
		vera.setRecoveryLeftAtTheEndMonthPrevious(recoveryLeftAtTheEndMonthPrevious);
		vera.setRecoveryLeftAtTheEndMonthCurrent(recoveryLeftAtTheEndMonthCurrent);
		vera.setRecoveryLeftAtTheEndMonthTotal(recoveryLeftAtTheEndMonthTotal);
		vera.setEntryDate(entryDate);
	
		dao.insert(villageid,vera);*/
		PanchVeraVasulat vera=new PanchVeraVasulat();
		
		System.out.println("updating the details:");
		
		System.out.println("enter the month");
		int month=Integer.parseInt(br.readLine());
		
		System.out.println("enter the year:");
		int year=Integer.parseInt(br.readLine());
		
		System.out.println("enter the villageId:");
		int villageId=Integer.parseInt(br.readLine());
		
		/*vera=dao.getDetails(YearMonth.of(year, month), villageId);
		System.out.println(vera);*/
		
		System.out.println("enter the tax name:");
		String taxName=br.readLine();
		
		

		System.out.println("enter the seeking previous amount left:");
		double seekingPreviousAmountLeft=Integer.parseInt(br.readLine());
		
		System.out.println("enter the seeking amount currently:");
		double seekingCurrentAmount=Double.parseDouble(br.readLine());

		System.out.println("enter the total amount seeking:");
		double seekingTotalAmount=Double.parseDouble(br.readLine());
		
		System.out.println("enter the amount recovered till the previous month of current year:");
		double recoveryTillPreviousMonthCurrent=Double.parseDouble(br.readLine());

		System.out.println("enter the recovered amount in previous month of previous year:");
		double recoveryTillPreviousMonthPrevious=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total amount recovered till previous month:");
		double recoveryTillPreviousMonthTotal=Double.parseDouble(br.readLine());
		
		System.out.println("enter the recovery done till current month of current year");
		double recoveryTillCurrentMonthCurrent=Double.parseDouble(br.readLine());
		
		System.out.println("enter the recovery done till current month of previous year:");
		double recoveryTillCurrentMonthPrevious=Double.parseDouble(br.readLine());
	
		System.out.println("enter the recoevry done till currrent month in total:");
		double recoveryTillCurrentMonthTotal=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total recovery done previously:");
	    double totalRecoveryPrevious=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total recovery done done currently:");
		double totalRecoveryCurrent=Double.parseDouble(br.readLine());
		
		System.out.println("enter the total recovery done");
		double totalRecoveryTotal=Double.parseDouble(br.readLine());
		
		System.out.println("enter the amount left to be recovered till the end of previous month");
		double recoveryLeftAtTheEndMonthPrevious=Double.parseDouble(br.readLine());
		
		System.out.println("enter the recovery left at the end of month of current year");
		double recoveryLeftAtTheEndMonthCurrent=Double.parseDouble(br.readLine());
		
		System.out.println("enter the recovery left at the end of month in total");
		double recoveryLeftAtTheEndMonthTotal=Double.parseDouble(br.readLine());
		
		/*System.out.println("enter the date(dd-mm-yyyy):");
		String date=br.readLine();
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		entryDate = LocalDate.parse(date, formatter);*/
		
		/*vera.setTaxtype(taxtype);*/
		vera.setSeekingPreviousAmountLeft(seekingPreviousAmountLeft);
		vera.setSeekingCurrentAmount(seekingCurrentAmount);
		vera.setSeekingTotalAmount(seekingTotalAmount);
		vera.setRecoveryTillPreviousMonthCurrent(recoveryTillPreviousMonthCurrent);
		vera.setRecoveryTillPreviousMonthPrevious(recoveryTillPreviousMonthPrevious);
		vera.setRecoveryTillPreviousMonthTotal(recoveryTillPreviousMonthTotal);
		vera.setRecoveryTillCurrentMonthCurrent(recoveryTillCurrentMonthCurrent);
		vera.setRecoveryTillCurrentMonthPrevious(recoveryTillCurrentMonthPrevious);
		vera.setRecoveryTillCurrentMonthTotal(recoveryTillCurrentMonthTotal);
		vera.setTotalRecoveryPrevious(totalRecoveryPrevious);
		vera.setTotalRecoveryCurrent(totalRecoveryCurrent);
		vera.setTotalRecoveryTotal(totalRecoveryTotal);
		vera.setRecoveryLeftAtTheEndMonthPrevious(recoveryLeftAtTheEndMonthPrevious);
		vera.setRecoveryLeftAtTheEndMonthCurrent(recoveryLeftAtTheEndMonthCurrent);
		vera.setRecoveryLeftAtTheEndMonthTotal(recoveryLeftAtTheEndMonthTotal);
		vera.setEntryDate(java.time.LocalDate.now());
		vera.setYearmonth(YearMonth.of(year, month));
		vera=dao.update(vera, villageId,YearMonth.of(year, month),taxName);
		System.out.println(vera);
	}

}
