package com.zensoftech.eakarni.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import com.zensoftech.eakarni.DAO.CdpReportDaoImpl;
import com.zensoftech.eakarni.DAO.SmbReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.SmbDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class SmbReportManager {
	
	private SmbReportDaoImpl smbreportdao;
	private StateDao statedao;
	
	public SmbReportManager(SmbReportDaoImpl smbreportdao,StateDao statedao) {
		this.smbreportdao=smbreportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaSmbReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<SmbDto> smbDtoList = new ArrayList<SmbDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			smbDtoList.addAll(getSmbData(villageId, yearmonth));
		}
		smbreportdao.generateSmbReport(smbDtoList,"E:/report/talukaSmbReport.xls");//talukareport is filename
		
		
	}
	
	public List<SmbDto> getSmbData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
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
		
		String GET_ALL="select * from smb_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List<SmbDto> smbList = new ArrayList<SmbDto>();
		while(rs.next()){
			SmbDto smb = new SmbDto();
			smb.setVillageId(villagecensusId);
			smb.setMonth(rs.getInt(3));
			smb.setYear(rs.getInt(4));
			smb.setTotalFamilies(rs.getInt(5));
			smb.setFamiliesHavingLavatories(rs.getInt(6));
			smb.setFamiliesNotHavingLavatories(rs.getInt(7));
			smb.setLavatoriesMadeDuringWeek(rs.getInt(8));
			smbList.add(smb);
		}
		return smbList;
}
	
	
	public  void generateDistrictSmbReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		 List<SmbDto> smbDtoList = new ArrayList<SmbDto>();
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
					smbDtoList.addAll(getSmbData(villageId, yearmonth));
				}
				
		}
		smbreportdao.generateSmbReport(smbDtoList,"E:/report/districtSmbReport.xls");//talukareport is filename
		
	}

}
