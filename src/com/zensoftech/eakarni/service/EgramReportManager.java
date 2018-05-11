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
import com.zensoftech.eakarni.DAO.EgramReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.EgramDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class EgramReportManager {
	private EgramReportDaoImpl egramreportdao;
	private StateDao statedao;
	
	public EgramReportManager( EgramReportDaoImpl egramreportdao,StateDao statedao) {
		this.egramreportdao=egramreportdao;
		this.statedao=statedao;
	}
	
	public  void generateTalukaEgramReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List< EgramDto > egramDtoList = new ArrayList<EgramDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			egramDtoList.addAll(getEgramData(villageId, yearmonth));
		}
	
		egramreportdao.generateEgramReport(egramDtoList,"E:/report/talukaEgramReport.xls");//talukareport is filename
		
		
	}
	
	public List<EgramDto> getEgramData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
		
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
		
		String GET_ALL="select * from egram_tbl where vid=? AND mth=? AND yr=?";
		ps=con.prepareStatement(GET_ALL);
		ps.setInt(1,villageId);
		ps.setInt(2,yearmonth.getMonthValue());
		ps.setInt(3,yearmonth.getYear());
		rs=ps.executeQuery();
		List< EgramDto > egramDtoList = new ArrayList<EgramDto>();
		while(rs.next()){
			EgramDto egram = new EgramDto();
			egram.setVillageId(villagecensusId);
			egram.setMonth(rs.getInt(3));
			egram.setYear(rs.getInt(4));
			egram.setBirthCertificateCopy(rs.getInt(5));
			egram.setBirthCertificateIncome(rs.getDouble(6));
			egram.setDeathCertificateCopy(rs.getInt(7));
			egram.setDeathCertificateIncome(rs.getDouble(8));
			egram.setCharacterCertificateCopy(rs.getInt(9));
			egram.setCharacterCertificateIncome(rs.getDouble(10));
			egram.setCasteCertificateCopy(rs.getInt(11));
			egram.setCasteCertificateIncome(rs.getDouble(12));
			egram.setIncomeCertificateCopy(rs.getInt(13));
			egram.setIncomeCertificateIncome(rs.getDouble(14));
			egram.setCopyOf7128A(rs.getInt(15));
			egram.setIncomeOf7128A(rs.getDouble(16));
			egram.setMGVCLbill(rs.getInt(17));
			egram.setMGVCLIncome(rs.getDouble(18));
			egram.setBADEAEntry(rs.getInt(19));
			egram.setBADEAIncome(rs.getDouble(20));
			egram.setFarmerApplication(rs.getInt(21));
			egram.setFarmerIncome(rs.getDouble(22));
			egram.setGSPCBill(rs.getInt(23));
			egram.setGSPCIncome(rs.getDouble(24));
			egram.setCSCService(rs.getInt(25));
			egram.setCSCIncome(rs.getDouble(26));
			egram.setOtherService(rs.getInt(27));
			egram.setOtherIncome(rs.getDouble(28));
			egramDtoList.add(egram);
			
		}
		return egramDtoList;
}
	
	
	public  void generateDistrictEgramReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Taluka> talukaList= new ArrayList<>();
		talukaList=statedao.getTalukasByDistrict(districtId);//auto 
		System.out.println("taluka list in manager:"+talukaList);
		List< EgramDto > egramDtoList = new ArrayList<EgramDto>();
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
					egramDtoList.addAll(getEgramData(villageId, yearmonth));
				}
				
		}
		egramreportdao.generateEgramReport(egramDtoList,"E:/report/districtEgramReport.xls");//talukareport is filename
		
	}

}
