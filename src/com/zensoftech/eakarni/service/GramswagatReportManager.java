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
import com.zensoftech.eakarni.DAO.GramswagatReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.GramswagatDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class GramswagatReportManager {
	
	private GramswagatReportDaoImpl gramswagatreportdao;
	private StateDao statedao;
	
	public GramswagatReportManager(GramswagatReportDaoImpl gramswagatreportdao,StateDao statedao) {
		this.gramswagatreportdao=gramswagatreportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaGramswagatReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<GramswagatDto> gramswagatDtoList = new ArrayList<GramswagatDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			gramswagatDtoList.addAll(getGramswagatData(villageId, yearmonth));
		}
		gramswagatreportdao.generateGramswagatReport(gramswagatDtoList,"E:/report/talukaGramswagatReport.xls");//talukareport is filename
		
		
	}
	
	public List<GramswagatDto> getGramswagatData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
		Connection con = GramswagatReportDaoImpl.getConnection();
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
		
		String GET_ALL="select * from gramswagat_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List<GramswagatDto> gramswagatList = new ArrayList<GramswagatDto>();
		while(rs.next()){
			GramswagatDto gramswagat = new GramswagatDto();
			gramswagat.setVillageid(villagecensusId);
			gramswagat.setMonth(rs.getInt(3));
			gramswagat.setYear(rs.getInt(4));
			gramswagat.setDescriptionOfQuestionsRaised(rs.getString(5));
			gramswagat.setDisposal(rs.getInt(6));
			gramswagat.setPending(rs.getInt(7));
			gramswagatList.add(gramswagat);
		}
		return gramswagatList;
}
	
	
	public  void generateDistrictGramswagatReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		 List<GramswagatDto> gramswagatDtoList = new ArrayList<GramswagatDto>();
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
					gramswagatDtoList.addAll(getGramswagatData(villageId, yearmonth));
				}
				
		}
		gramswagatreportdao.generateGramswagatReport(gramswagatDtoList,"E:/report/districtGramswagatReport.xls");//talukareport is filename
		
	}

}
