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
import com.zensoftech.eakarni.DAO.IayReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.IayDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class IayReportManager {
	
	private IayReportDaoImpl iayreportdao;
	private StateDao statedao;
	
	public IayReportManager(IayReportDaoImpl iayreportdao,StateDao statedao) {
		this.iayreportdao=iayreportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaIayReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<IayDto> iayDtoList = new ArrayList<IayDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			iayDtoList.addAll(getIayData(villageId, yearmonth));
		}
		iayreportdao.generateIayReport(iayDtoList,"E:/report/talukaIayReport.xls");//talukareport is filename
		
		
	}
	
	public List<IayDto> getIayData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
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
		String GET_ALL="select * from iay_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List<IayDto> iayList = new ArrayList<IayDto>();
		while(rs.next()){
			IayDto iay = new IayDto();
			iay.setVillageId(villagecensusId);
			iay.setMonth(rs.getInt(3));
			iay.setYear(rs.getInt(4));
			iay.setTarget(rs.getInt(5));
			iay.setFirstInstallment(rs.getDouble(6));
			iay.setSecondInstallment(rs.getDouble(7));
			iay.setThirdInstallment(rs.getDouble(8));
			iayList.add(iay);
		}
		return iayList;
}
	
	
	public  void generateDistrictIayReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		 List<IayDto> iayDtoList = new ArrayList<IayDto>();
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
					iayDtoList.addAll(getIayData(villageId, yearmonth));
				}
				
		}
		iayreportdao.generateIayReport(iayDtoList,"E:/report/districtIayReport.xls");//talukareport is filename
		
	}

}
