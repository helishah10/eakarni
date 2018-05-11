package com.zensoftech.eakarni.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zensoftech.eakarni.DAO.FinanceReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.Finance14Dto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class FinanceReportManager {
	
	private FinanceReportDaoImpl finance14reportdao;
	private StateDao statedao;
	
	public FinanceReportManager(FinanceReportDaoImpl finance14reportdao,StateDao statedao) {
		this.finance14reportdao=finance14reportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaFinance14Report(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<Finance14Dto> Finance14DtoList = new ArrayList<Finance14Dto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			Finance14DtoList.addAll(getFinance14Data(villageId, yearmonth));
		}
		finance14reportdao.generateFinance14Report(Finance14DtoList,"E:/report/talukaFinanceReport.xls");//talukareport is filename
		
		
	}
	
	public List<Finance14Dto> getFinance14Data(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
		Connection con = FinanceReportDaoImpl.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String Getvid="select vid from village_tbl where id=?";
		ps=con.prepareStatement(Getvid);
		ps.setInt(1,villageId);
		rs=ps.executeQuery();
		int villagecensusId=0;
		while(rs.next())
		{
			villagecensusId=rs.getInt("vid");
		}
		String GET_ALL="select * from 14finance_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List<Finance14Dto> finance14List = new ArrayList<Finance14Dto>();
		while(rs.next()){
			Finance14Dto finance = new Finance14Dto();
			finance.setVillageId(villagecensusId);
			finance.setMonth(rs.getInt(3));
			finance.setYear(rs.getInt(4));
			finance.setTotalWork(rs.getInt(5));
			finance.setWorksApproved(rs.getInt(6));
			finance.setProjectNotStarted(rs.getInt(7));
			finance.setProgress(rs.getInt(8));
			finance.setCompleted(rs.getInt(9));
			finance.setGrantAllocated(rs.getDouble(10));
			finance.setAmountSpent(rs.getDouble(11));
			finance.setEntryDate(rs.getDate(12).toLocalDate());
			finance14List.add(finance);
		}
		return finance14List;
}
	
	
	public  void generateDistrictFinance14Report(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		 List<Finance14Dto> finance14DtoList = new ArrayList<Finance14Dto>();
		for(Taluka taluka:talukaList)
		{
			int talukaId=taluka.getId();
			
			List<Village> villageList= new ArrayList<>();
			villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
			System.out.println("village list in anager:"+villageList);
		
			
			
			 for(Village village:villageList)
				{
					int villageId=village.getId();
					System.out.println(villageId);
					finance14DtoList.addAll(getFinance14Data(villageId, yearmonth));
				}
				
		}
		finance14reportdao.generateFinance14Report(finance14DtoList,"E:/report/districtFinanceReport.xls");//talukareport is filename
		
	}
}


