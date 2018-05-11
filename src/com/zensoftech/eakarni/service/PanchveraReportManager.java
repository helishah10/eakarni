package com.zensoftech.eakarni.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zensoftech.eakarni.DAO.CdpReportDaoImpl;
import com.zensoftech.eakarni.DAO.PanchveraReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.PanchveraDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;


@WebServlet("/PanchveraReportManager")
public class PanchveraReportManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PanchveraReportDaoImpl panchverareportdao;
	private StateDao statedao;
	
	public PanchveraReportManager(PanchveraReportDaoImpl panchverareportdao,StateDao statedao) {
		this.panchverareportdao=panchverareportdao;
		this.statedao=statedao;
	}
   
public  void generateTalukaPanchveraReport(int talukaId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
		
		List<Village> villageList= new ArrayList<>();
		villageList=statedao.getAllVillagesByTaluka(talukaId);//auto talukaId
		System.out.println("village list in manager:"+villageList);
	

		List<PanchveraDto> panchveraDtoList = new ArrayList<PanchveraDto>();
		for(Village village:villageList)
		{
			int villageId=village.getId();
			System.out.println(villageId);

			panchveraDtoList.addAll(getPanchveraData(villageId, yearmonth));
		}
		panchverareportdao.generatePanchveraReport(panchveraDtoList,"E:/report/talukaPanchveraReport.xls");//talukareport is filename
		
		
	}
public List<PanchveraDto> getPanchveraData(int villageId,YearMonth yearmonth) throws ClassNotFoundException, SQLException {
	
	Connection con = PanchveraReportDaoImpl.getConnection();
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
	
	
	
	
	String GET_ALL="select * from panch_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
	ps=con.prepareStatement(GET_ALL);
	ps.setInt(1,villageId);
	ps.setInt(2,yearmonth.getMonthValue());
	ps.setInt(3,yearmonth.getYear());
	rs=ps.executeQuery();

	
	
	List<PanchveraDto> panchveraList = new ArrayList<PanchveraDto>();
	while(rs.next()){
		PanchveraDto panchvera = new PanchveraDto();
		panchvera.setVillageId(villagecensusId);
		panchvera.setMonth(rs.getInt(3));
		panchvera.setYear(rs.getInt(4));
		panchvera.setSeekingPreviousAmountLeft(rs.getDouble("seeking_previous_amount_left"));
		 panchvera.setSeekingCurrentAmount(rs.getDouble("seeking_current_amount"));
		 panchvera.setSeekingTotalAmount(rs.getDouble("seeking_total_amount"));
		 panchvera.setRecoveryTillPreviousMonthCurrent(rs.getDouble("recovery_till_previous_month_current"));
		 panchvera.setRecoveryTillPreviousMonthPrevious(rs.getDouble("recovery_till_previous_month_previous"));
		 panchvera.setRecoveryTillPreviousMonthTotal(rs.getDouble("recovery_till_previous_month_total"));
		 panchvera.setRecoveryTillCurrentMonthCurrent(rs.getDouble("recovery_till_current_month_current"));
		 panchvera.setRecoveryTillCurrentMonthPrevious(rs.getDouble("recovery_till_current_month_previous"));
		 panchvera.setRecoveryTillCurrentMonthTotal(rs.getDouble("recovery_till_current_month_total"));
		 panchvera.setTotalRecoveryPrevious(rs.getDouble("total_recovery_previous"));
		 panchvera.setTotalRecoveryCurrent(rs.getDouble("total_recovery_current"));
		 panchvera.setTotalRecoveryTotal(rs.getDouble("total_recovery_total"));
		 panchvera.setRecoveryLeftAtTheEndMonthPrevious(rs.getDouble("recovery_left_at_the_end_month_previous"));
		 panchvera.setRecoveryLeftAtTheEndMonthCurrent(rs.getDouble("recovery_left_at_the_end_month_current"));
		 panchvera.setRecoveryLeftAtTheEndMonthTotal(rs.getDouble("recoevry_left_at_the_end_month_total"));
		 panchvera.setPercentage(rs.getDouble("percentage"));
		 panchvera.setEntryDate(rs.getDate("entry_date").toLocalDate());  
		panchveraList.add(panchvera);
	}
	return panchveraList;
}

public  void generateDistrictPanchveraReport(int districtId,YearMonth yearmonth) throws ClassNotFoundException, SQLException, IOException{
	
	List<Taluka> talukaList= new ArrayList<>();
	talukaList=statedao.getTalukasByDistrict(districtId);//auto 
	System.out.println("taluka list in manager:"+talukaList);
	 List<PanchveraDto> panchveraDtoList = new ArrayList<PanchveraDto>();
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
				panchveraDtoList.addAll(getPanchveraData(villageId, yearmonth));
			}
			
	}
	panchverareportdao.generatePanchveraReport(panchveraDtoList,"E:/report/districtPanchveraReport.xls");//talukareport is filename
	
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
