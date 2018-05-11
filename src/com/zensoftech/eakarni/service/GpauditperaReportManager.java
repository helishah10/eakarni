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
import com.zensoftech.eakarni.DAO.GPauditperaReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.GPAuditPeraDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class GpauditperaReportManager {
	
	private  GPauditperaReportDaoImpl gpauditreportdao;
	private StateDao statedao;
	
	public GpauditperaReportManager(GPauditperaReportDaoImpl gpauditreportdao,StateDao statedao) {
		this.gpauditreportdao=gpauditreportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaGpAuditperaReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<GPAuditPeraDto> gpauditDtoList = new ArrayList<GPAuditPeraDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			gpauditDtoList.addAll(getAuditPeraData(villageId, yearmonth));
		}
		gpauditreportdao.generateGpAuditPeraReport(gpauditDtoList,"E:/report/talukaAuditPeraReport.xls");//talukareport is filename
		
		
	}
	
	public List<GPAuditPeraDto> getAuditPeraData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
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
		
		String GET_ALL="select * from gp_audit_pera_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List<GPAuditPeraDto> peraList = new ArrayList<GPAuditPeraDto>();
		while(rs.next()){
			GPAuditPeraDto auditpera = new GPAuditPeraDto();
			auditpera.setVillageId(villagecensusId);
			auditpera.setMonth(rs.getInt(3));
			auditpera.setYear(rs.getInt(4));
			auditpera.setYearOfRegisteration(rs.getInt(5));
			auditpera.setTotalPera(rs.getInt(6));
			auditpera.setTotalPeraAnsweredThisWeek(rs.getInt(7));
			auditpera.setPeraNotanswered(rs.getInt(8));
			peraList.add(auditpera);
		}
		return peraList;
}
	
	
	public  void generateDistrictGpAuditReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		List<GPAuditPeraDto> peraList = new ArrayList<GPAuditPeraDto>();
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
					peraList.addAll(getAuditPeraData(villageId, yearmonth));
				}
				
		}
		gpauditreportdao.generateGpAuditPeraReport(peraList,"E:/report/districtAuditPeraReport.xls");//talukareport is filename
		
	}

}
