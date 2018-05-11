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

import com.zensoftech.eakarni.DAO.CdpReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class CdpReportManager {
	
	private CdpReportDaoImpl cdpreportdao;
	private StateDao statedao;
	
	public CdpReportManager(CdpReportDaoImpl cdpreportdao,StateDao statedao) {
		this.cdpreportdao=cdpreportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaCdpReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<CdpDto> cdpDtoList = new ArrayList<CdpDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			cdpDtoList.addAll(getCdpData(villageId, yearmonth));
		}
	
		cdpreportdao.generateCdpReport(cdpDtoList,"E:/report/talukaCdpReport.xls");//talukareport is filename
		
		
	}
	
	public List<CdpDto> getCdpData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
		Connection con = CdpReportDaoImpl.getConnection();
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
		
		String GET_ALL="select * from cdp_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List<CdpDto> cdpList = new ArrayList<CdpDto>();
		while(rs.next()){
			CdpDto cdp = new CdpDto();
			cdp.setVillageId(villagecensusId);
			cdp.setMonth(rs.getInt(3));
			cdp.setYear(rs.getInt(4));
			cdp.setGrantAllocated(rs.getDouble(5));
			cdp.setCostsDuringPreviousYear(rs.getDouble(6));
			cdp.setCostsDuringThisMonth(rs.getDouble(7));
			cdp.setOngoingCostsDuringCurrentYear(rs.getDouble(8));
			cdp.setAchievementOfPreviousMonthOfCurrentYear(rs.getDouble(9));
			cdp.setAchievementsDuirngThisMonth(rs.getDouble(10));
			cdp.setTotalAchievementsOfCurrentYear(rs.getDouble(11));
			cdp.setEntryDate(rs.getDate(12).toLocalDate());
			cdpList.add(cdp);
		}
		return cdpList;
}
	
	
	public  void generateDistrictCdpReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		 List<CdpDto> cdpDtoList = new ArrayList<CdpDto>();
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
					cdpDtoList.addAll(getCdpData(villageId, yearmonth));
				}
				
		}
		cdpreportdao.generateCdpReport(cdpDtoList,"E:/report/districtCdpReport.xls");//talukareport is filename
		
	}
}


