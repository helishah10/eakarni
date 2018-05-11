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
import com.zensoftech.eakarni.DAO.JaminMehsulReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulatDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class JaminMehsulReportManager {
	
	private JaminMehsulReportDaoImpl jaminmehsulreportdao;
	private StateDao statedao;
	
	public JaminMehsulReportManager(JaminMehsulReportDaoImpl jaminmehsulreportdao,StateDao statedao) {
		this.jaminmehsulreportdao=jaminmehsulreportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaJaminMehsulReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<JaminMehsulVeraVasulatDto> jaminmehsulDtoList = new ArrayList<JaminMehsulVeraVasulatDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			jaminmehsulDtoList.addAll(getJaminMehsulData(villageId, yearmonth));
		}
		jaminmehsulreportdao.generateJaminMehsulReport(jaminmehsulDtoList,"E:/report/talukaJaminMehsulVeraVasulatReport.xls");//talukareport is filename
		
		
	}
	
	public List<JaminMehsulVeraVasulatDto> getJaminMehsulData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
		Connection con = JaminMehsulReportDaoImpl.getConnection();
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
		
		String GET_ALL="select * from jamin_mehsul_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List<JaminMehsulVeraVasulatDto> jaminmehsulDtoList = new ArrayList<JaminMehsulVeraVasulatDto>();
		while(rs.next()){
			JaminMehsulVeraVasulatDto jamin = new JaminMehsulVeraVasulatDto();
			jamin.setVillageId(villagecensusId);
			jamin.setMonth(rs.getInt(3));
			jamin.setYear(rs.getInt(4));
			jamin.setLandRevenue(rs.getDouble(5));
			jamin.setTotalAmountSeeking(rs.getDouble(6));
			jamin.setAmountCollectedDuringMonth(rs.getDouble(7));
			jamin.setAmountLeft(rs.getDouble(8));
			jamin.setPercentage(rs.getDouble(9));
			
			jaminmehsulDtoList.add(jamin);
		}
		return jaminmehsulDtoList;
}
	
	
	public  void generateDistrictJaminMehsulReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		 List<JaminMehsulVeraVasulatDto> jaminmehsulDtoList = new ArrayList<JaminMehsulVeraVasulatDto>();
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
					jaminmehsulDtoList.addAll(getJaminMehsulData(villageId, yearmonth));
				}
				
		}
		jaminmehsulreportdao.generateJaminMehsulReport(jaminmehsulDtoList,"E:/report/districtJaminMehsulVeraVasulatReport.xls");//talukareport is filename
		
	}

}
