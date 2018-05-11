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


import com.zensoftech.eakarni.DAO.HsgReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;

import com.zensoftech.eakarni.entities.HsgDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;


public class HsgReportManager {
	private HsgReportDaoImpl hsgreportdao;
	private StateDao statedao;
	
	public HsgReportManager(HsgReportDaoImpl hsgreportdao,StateDao statedao) {
		this.hsgreportdao=hsgreportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaHsgReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<HsgDto> hsgDtoList = new ArrayList<HsgDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);


			hsgDtoList.addAll(getHsgData(villageId,yearmonth));
		}
		hsgreportdao.generateHsgReport(hsgDtoList,"E:/talukaHsgReport.xls");//talukareport is filename
		
		
	}
	
	public List<HsgDto> getHsgData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
		Connection con = HsgReportDaoImpl.getConnection();
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
		
		String GET_ALL="select * from hsg_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List<HsgDto> hsgList = new ArrayList<HsgDto>();
		while(rs.next()){
			HsgDto hsg = new HsgDto();
			hsg.setVillageId(villagecensusId);
			hsg.setMonth(rs.getInt(3));
			hsg.setYear(rs.getInt(4));
			hsg.setNotStartedHouses(rs.getInt(5));
			hsg.setCompletedHouses(rs.getInt(6));
			hsg.setTarget(rs.getInt(7));
			hsg.setFinanceYear(rs.getInt(8));
			hsg.setLintalLevel((rs.getInt(9)));
			hsg.setSlabLevel(rs.getInt(10));
			hsg.setPlinthLevel(rs.getInt(11));
			/*hsg.setEntryDate(rs.getDate(12).toLocalDate());*/
			hsgList.add(hsg);
		}
		return hsgList;
}
	
	
	public  void generateDistrictHsgReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		 List<HsgDto> hsgDtoList = new ArrayList<HsgDto>();
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
					hsgDtoList.addAll(getHsgData(villageId, yearmonth));
				}
				
		}
		hsgreportdao.generateHsgReport(hsgDtoList,"E:/districtHsgReport.xls");//talukareport is filename
		
	}
	

}
