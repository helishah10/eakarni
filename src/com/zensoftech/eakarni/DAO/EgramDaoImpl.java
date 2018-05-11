package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.*;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.Egram;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class EgramDaoImpl implements EgramDao 
{
	private static String driverName="";
	private static String databaseUrl="";
	private static String databaseUsername="";
	private static String databasePassword;
	
	public EgramDaoImpl(String driverName,String databaseUrl,String databaseUsername,String databasePassword)
	{
		EgramDaoImpl.driverName=driverName;
		EgramDaoImpl.databaseUrl=databaseUrl;
		EgramDaoImpl.databaseUsername=databaseUsername;
		EgramDaoImpl.databasePassword=databasePassword;
	}
	
	public static Connection getConnection()throws SQLException,ClassNotFoundException
	{
		System.out.println("in Connection method:");
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection(databaseUrl,databaseUsername,databasePassword);
		
	}
	
	public   Map<Integer,Egram> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth){
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		 Map<Integer,Egram> egramMap=new HashMap<Integer,Egram>();
		try
		{
			con=EgramDaoImpl.getConnection();
			String getDid="select id from district_tbl where did=?";
			ps=con.prepareStatement(getDid);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			int did=0;
			while(rs.next())
			{
				District district =StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				did=district.getId();
				
			}
	
			String getTid="select id from taluka_tbl where did=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,did);
			rs=ps.executeQuery();
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Integer> talukaList=new ArrayList();
			int tid=0;
			while(rs.next())
			{
				Taluka taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				tid=taluka.getId();
				talukaList.add(tid);
			}
			@SuppressWarnings({ "unchecked", "rawtypes" })
			
			List<Integer> villageList=new ArrayList();
			for(int talukaid:talukaList)
			{
				String getvid="select id from village_tbl where tid=?";
				ps=con.prepareStatement(getvid);
				ps.setInt(1,talukaid);
				rs=ps.executeQuery();
				
				int villageId=0;
			
				while(rs.next())
				{
					Village village =StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
					villageId=village.getId();
					villageList.add(villageId);
				}
				
			}
			for(int vid:villageList)
			{
				String GET_ALL="select * from egram_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
				
			
			while(rs.next())
			{
				 Egram e1=new Egram();
				 e1.setId(rs.getInt("id"));
				 e1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 int year=rs.getInt("yr");
				 int month=rs.getInt("mth");
				 e1.setYearmonth(YearMonth.of(year, month));
				 e1.setBirthCertificateCopy(rs.getInt("birth_certificate_copy"));
				 e1.setBirthCertificateIncome(rs.getDouble("birth_certificate_income"));
				 e1.setDeathCertificateCopy(rs.getInt("death_certificate_copy"));
				 e1.setDeathCertificateIncome(rs.getDouble("death_certificate_income"));
				 e1.setIncomeCertificateCopy(rs.getInt("income_certificate_copy"));
				 e1.setIncomeCertificateIncome(rs.getDouble("income_certificate_income"));
				 e1.setCopyOf7128A(rs.getInt("copy_of_7_12_8A"));
				 e1.setIncomeOf7128A(rs.getDouble("income_7_12_8A"));
				 e1.setMGVCLbill(rs.getInt("MGVCL_bill"));
				 e1.setMGVCLIncome(rs.getDouble("MGVCL_income"));
				 e1.setBADEAEntry(rs.getInt("BADEA_entry"));
				 e1.setBADEAIncome(rs.getDouble("BADEA_income"));
				 e1.setFarmerApplication(rs.getInt("farmer_application"));
				 e1.setFarmerIncome(rs.getDouble("farmer_income"));
				 e1.setGSPCBill(rs.getInt("GSPC_bill"));
				 e1.setGSPCIncome(rs.getDouble("GSPC_income"));
				 e1.setCSCService(rs.getInt("CSC_service"));
				 e1.setCSCIncome(rs.getDouble("CSC_income"));
				 e1.setOtherService(rs.getInt("other_service"));
				 e1.setOtherIncome(rs.getDouble("other_income"));
				 e1.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 e1.setCharacterCertificateCopy(rs.getInt("character_certificate_copy"));
				 e1.setCharacterCertificateIncome(rs.getDouble("character_certificate_income"));
				 e1.setCasteCertificateCopy(rs.getInt("caste_certificate_copy"));
				 e1.setCasteCertificateIncome(rs.getDouble("caste_certificate_income"));
				 
				 egramMap.put(e1.getId(),e1); 
			}
		}
			rs.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return egramMap;
	}
	
	public   Map<Integer,Egram> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, Egram> egramMap=new HashMap<Integer,Egram>();
		try
		{
			con=EgramDaoImpl.getConnection();
			
			
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,talukaId);
			rs=ps.executeQuery();
			int tid=0;
			while(rs.next())
			{
				Taluka taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				tid=taluka.getId();
			}
			
			String getvid="select id from village_tbl where tid=?";
			ps=con.prepareStatement(getvid);
			ps.setInt(1,tid);
			int id=0;
			rs=ps.executeQuery();
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<Integer> villagelist=new ArrayList();
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				id=village.getId();
				villagelist.add(id);
				
			}
			
			for(int vid:villagelist)
			{
				String GET_ALL="select * from egram_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,vid);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
				
			    while(rs.next())
				{
			    	 Egram e1=new Egram();
					 e1.setId(rs.getInt("id"));
					 e1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 int year=rs.getInt("yr");
					 int month=rs.getInt("mth");
					 e1.setYearmonth(YearMonth.of(year, month));
					 e1.setBirthCertificateCopy(rs.getInt("birth_certificate_copy"));
					 e1.setBirthCertificateIncome(rs.getDouble("birth_certificate_income"));
					 e1.setDeathCertificateCopy(rs.getInt("death_certificate_copy"));
					 e1.setDeathCertificateIncome(rs.getDouble("death_certificate_income"));
					 e1.setIncomeCertificateCopy(rs.getInt("income_certificate_copy"));
					 e1.setIncomeCertificateIncome(rs.getDouble("income_certificate_income"));
					 e1.setCopyOf7128A(rs.getInt("copy_of_7_12_8A"));
					 e1.setIncomeOf7128A(rs.getDouble("income_7_12_8A"));
					 e1.setMGVCLbill(rs.getInt("MGVCL_bill"));
					 e1.setMGVCLIncome(rs.getDouble("MGVCL_income"));
					 e1.setBADEAEntry(rs.getInt("BADEA_entry"));
					 e1.setBADEAIncome(rs.getDouble("BADEA_income"));
					 e1.setFarmerApplication(rs.getInt("farmer_application"));
					 e1.setFarmerIncome(rs.getDouble("farmer_income"));
					 e1.setGSPCBill(rs.getInt("GSPC_bill"));
					 e1.setGSPCIncome(rs.getDouble("GSPC_income"));
					 e1.setCSCService(rs.getInt("CSC_service"));
					 e1.setCSCIncome(rs.getDouble("CSC_income"));
					 e1.setOtherService(rs.getInt("other_service"));
					 e1.setOtherIncome(rs.getDouble("other_income"));
					 e1.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 e1.setCharacterCertificateCopy(rs.getInt("character_certificate_copy"));
					 e1.setCharacterCertificateIncome(rs.getDouble("character_certificate_income"));
					 e1.setCasteCertificateCopy(rs.getInt("caste_certificate_copy"));
					 e1.setCasteCertificateIncome(rs.getDouble("caste_certificate_income"));
					 
					 egramMap.put(e1.getId(),e1); 
				}

	
			}	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return egramMap;
	}

	public Egram insert(int villageId,Egram egram)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			con=EgramDaoImpl.getConnection();
			
		/*
			String select_village="select id from village_tbl where vid=?";
			ps=con.prepareStatement(select_village);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			int id=0;
			Village village = null;
			while(rs.next())
			{
				village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			}*/
			
			Village village=null;
			village=StateDaoImpl.getAllVillage(con).get(villageId);
			System.out.println(village);
			egram.setVillage(village);
			int vid=village.getId();
			
			
			String INSERT="insert into egram_tbl(vid,mth,yr,birth_certificate_copy,birth_certificate_income,death_certificate_copy,"
					+ "death_certificate_income,character_certificate_copy,character_certificate_income,caste_certificate_copy,"
					+ "caste_certificate_income,income_certificate_income,income_certificate_copy,copy_of_7_12_8A,income_7_12_8A,"
					+ "MGVCL_bill,MGVCL_income,BADEA_entry,BADEA_income,farmer_application,farmer_income,GSPC_bill,GSPC_income,"
					+ "CSC_service,CSC_income,other_income,other_service,entry_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
			ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,villageId);
			ps.setInt(2,egram.getYearmonth().getMonthValue());
			ps.setInt(3, egram.getYearmonth().getYear());
			ps.setInt(4,egram.getBirthCertificateCopy());
			ps.setDouble(5,egram.getBirthCertificateIncome());
			ps.setInt(6,egram.getDeathCertificateCopy());
			ps.setDouble(7,egram.getDeathCertificateIncome());
			ps.setInt(8, egram.getCharacterCertificateCopy());
			ps.setDouble(9,egram.getCharacterCertificateIncome());
			ps.setInt(10,egram.getCasteCertificateCopy());
			ps.setDouble(11,egram.getCasteCertificateIncome());
			ps.setInt(12,egram.getIncomeCertificateCopy());
			ps.setDouble(13,egram.getIncomeCertificateIncome());
			ps.setInt(14,egram.getCopyOf7128A());
			ps.setDouble(15,egram.getIncomeOf7128A());
			ps.setInt(16,egram.getMGVCLbill());
			ps.setDouble(17,egram.getMGVCLIncome());
			ps.setInt(18,egram.getBADEAEntry());
			ps.setDouble(19,egram.getBADEAIncome());
			ps.setInt(20,egram.getFarmerApplication());
			ps.setDouble(21,egram.getFarmerIncome());
			ps.setInt(22,egram.getGSPCBill());
			ps.setDouble(23,egram.getGSPCIncome());
			ps.setDouble(24,egram.getCSCService());
			ps.setDouble(25,egram.getCSCIncome());
			ps.setInt(26,egram.getOtherService());
			ps.setDouble(27, egram.getOtherIncome());
			ps.setDate(28,Date.valueOf(java.time.LocalDate.now()));
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return egram;
	}
	public   Map<Integer,Egram> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer,Egram> egramMap=new HashMap<Integer,Egram>();
		try
		{
			con=EgramDaoImpl.getConnection();
			
			
			String getVid="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getVid);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			int vid=0;
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get((rs.getInt("id")));
				vid=village.getId();
			
			}
	
			String GET_ALL="select * from egram_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
			
		    while(rs.next())
			{
		    	 Egram e1=new Egram();
				 e1.setId(rs.getInt("id"));
				 e1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 int year=rs.getInt("yr");
				 int month=rs.getInt("mth");
				 e1.setYearmonth(YearMonth.of(year, month));
				 e1.setBirthCertificateCopy(rs.getInt("birth_certificate_copy"));
				 e1.setBirthCertificateIncome(rs.getDouble("birth_certificate_income"));
				 e1.setDeathCertificateCopy(rs.getInt("death_certificate_copy"));
				 e1.setDeathCertificateIncome(rs.getDouble("death_certificate_income"));
				 e1.setCharacterCertificateCopy(rs.getInt("character_certificate_copy"));
				 e1.setCharacterCertificateIncome(rs.getInt("character_certificate_income"));
				 e1.setCasteCertificateCopy(rs.getInt("caste_certificate_copy"));
				 e1.setCasteCertificateIncome(rs.getInt("caste_certificate_income"));
				 e1.setIncomeCertificateIncome(rs.getInt("income_certificate_copy"));
				 e1.setIncomeCertificateIncome(rs.getDouble("income_certificate_income"));
				 e1.setCopyOf7128A(rs.getInt("copy_of_7_12_8A"));
				 e1.setIncomeOf7128A(rs.getDouble("income_7_12_8A"));
				 e1.setMGVCLbill(rs.getInt("MGVCL_bill"));
				 e1.setMGVCLIncome(rs.getDouble("MGVCL_income"));
				 e1.setBADEAEntry(rs.getInt("BADEA_entry"));
				 e1.setBADEAIncome(rs.getDouble("BADEA_income"));
				 e1.setFarmerApplication(rs.getInt("farmer_application"));
				 e1.setFarmerIncome(rs.getDouble("farmer_income"));
				 e1.setGSPCBill(rs.getInt("GSPC_bill"));
				 e1.setGSPCIncome(rs.getDouble("GSPC_income"));
				 e1.setCSCService(rs.getInt("CSC_service"));
				 e1.setCSCIncome(rs.getDouble("CSC_income"));
				 e1.setOtherIncome(rs.getInt("other_income"));
				 e1.setOtherIncome(rs.getDouble("other_income"));
				 e1.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 egramMap.put(e1.getId(),e1); 
				 
				 
				
			}
		    
		    rs.close();
		    con.close();
		    
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return egramMap;
	}
	
	public Egram getDetails(YearMonth yearmonth,int villageId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Egram egram=new Egram();
		try
		{
			con=EgramDaoImpl.getConnection();
			
			

			String getId="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			rs.next();
			Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			int vid=village.getId();
			egram.setVillage(village);
			egram.setYearmonth(yearmonth);
			
			
			String GET_ALL="select * from egram_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
			
		    while(rs.next())
			{
		    	 
		    	egram.setId(rs.getInt("id"));
		    	egram.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 int year=rs.getInt("yr");
				 int month=rs.getInt("mth");
				 egram.setYearmonth(YearMonth.of(year, month));
				 egram.setBirthCertificateCopy(rs.getInt("birth_certificate_copy"));
				 egram.setBirthCertificateIncome(rs.getDouble("birth_certificate_income"));
				 egram.setDeathCertificateCopy(rs.getInt("death_certificate_copy"));
				 egram.setDeathCertificateIncome(rs.getDouble("death_certificate_income"));
				 egram.setCharacterCertificateCopy(rs.getInt("character_certificate_copy"));
				 egram.setCharacterCertificateIncome(rs.getInt("character_certificate_income"));
				 egram.setCasteCertificateCopy(rs.getInt("caste_certificate_copy"));
				 egram.setCasteCertificateIncome(rs.getInt("caste_certificate_income"));
				 egram.setIncomeCertificateIncome(rs.getInt("income_certificate_copy"));
				 egram.setIncomeCertificateIncome(rs.getDouble("income_certificate_income"));
				 egram.setCopyOf7128A(rs.getInt("copy_of_7_12_8A"));
				 egram.setIncomeOf7128A(rs.getDouble("income_7_12_8A"));
				 egram.setMGVCLbill(rs.getInt("MGVCL_bill"));
				 egram.setMGVCLIncome(rs.getDouble("MGVCL_income"));
				 egram.setBADEAEntry(rs.getInt("BADEA_entry"));
				 egram.setBADEAIncome(rs.getDouble("BADEA_income"));
				 egram.setFarmerApplication(rs.getInt("farmer_application"));
				 egram.setFarmerIncome(rs.getDouble("farmer_income"));
				 egram.setGSPCBill(rs.getInt("GSPC_bill"));
				 egram.setGSPCIncome(rs.getDouble("GSPC_income"));
				 egram.setCSCService(rs.getInt("CSC_service"));
				 egram.setCSCIncome(rs.getDouble("CSC_income"));
				 egram.setOtherIncome(rs.getInt("other_income"));
				 egram.setOtherIncome(rs.getDouble("other_income"));
				 egram.setEntryDate(rs.getDate("entry_date").toLocalDate()); 
		 
			}	
			rs.close();
			con.close();
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return egram;
	}
	
	
	public Egram update(Egram egram,int villageId,YearMonth yearmonth)
	{
		Connection con=null;
		PreparedStatement ps=null;
		boolean egramdata;
		
		try
		{
			egramdata=true;
			con=EgramDaoImpl.getConnection();
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			System.out.println(village);
		
			egram.setVillage(village);
			
			
			String update="update egram_tbl set birth_certificate_copy=?,birth_certificate_income=?,death_certificate_copy=?,death_certificate"
					+ "_income=?,character_certificate_copy=?,character_certificate_income=?,caste_certificate_copy=?,"
					+ "caste_certificate_income=?,income_certificate_copy=?,income_certificate_income=?,copy_of_7_12_8A=?,income_7_12_8A=?,MGVCL_bill=?,"
					+ "MGVCL_income=?,BADEA_entry=?,BADEA_income=?,farmer_application=?,farmer_income=?,GSPC_bill=?,"
					+ "GSPC_income=?,CSC_income=?,CSC_service=?,other_income=?,other_service=?,entry_date=?where vid=? AND mth=? AND yr=?";
			
			ps=con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,egram.getBirthCertificateCopy());
			ps.setDouble(2,egram.getBirthCertificateIncome());
			ps.setInt(3,egram.getDeathCertificateCopy());
			ps.setDouble(4,egram.getDeathCertificateIncome());
			ps.setInt(5,egram.getCharacterCertificateCopy());
			ps.setDouble(6,egram.getCharacterCertificateIncome());
			ps.setInt(7,egram.getCasteCertificateCopy());
			ps.setDouble(8,egram.getCasteCertificateIncome());
			ps.setInt(9,egram.getIncomeCertificateCopy());
			ps.setDouble(10,egram.getIncomeCertificateIncome());
			ps.setInt(11,egram.getCopyOf7128A());
			ps.setDouble(12,egram.getIncomeOf7128A());
			ps.setInt(13,egram.getMGVCLbill());
			ps.setDouble(14,egram.getMGVCLIncome());
			ps.setInt(15,egram.getBADEAEntry());
			ps.setDouble(16,egram.getBADEAIncome());
			ps.setInt(17,egram.getFarmerApplication());
			ps.setDouble(18,egram.getFarmerIncome());
			ps.setInt(19,egram.getGSPCBill());
			ps.setDouble(20,egram.getGSPCIncome());
			ps.setDouble(21,egram.getCSCService());
			ps.setDouble(22,egram.getCSCIncome());
			ps.setInt(23,egram.getOtherService());
			ps.setDouble(24, egram.getOtherIncome());
			ps.setDate(25,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(26, villageId);
			ps.setInt(27, yearmonth.getMonthValue());
			ps.setInt(28,yearmonth.getYear());
			
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return egram;	
	}
	
	public int getTotalCountByTalukaId(int talukaId)  // taluka id=census taluka id
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int count=0;
		int total=0;
		try
		{
			con=EgramDaoImpl.getConnection();
		
			
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,talukaId);
			rs=ps.executeQuery();
			int tid=0;
			while(rs.next())
			{
				Taluka taluka =StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				tid=taluka.getId();
			}
			
			String getvid="select id from village_tbl where tid=?";
			ps=con.prepareStatement(getvid);
			ps.setInt(1,tid);
			int id=0;
			rs=ps.executeQuery();
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<Integer> villageList=new ArrayList();
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				int vid=village.getId();
				villageList.add(vid);
				
			}
			for(int vid:villageList)
			{
				
				String getCount="select count(*) from egram_tbl where vid=?";
				ps=con.prepareStatement(getCount);
				ps.setInt(1,vid);
				ps.setInt(2,YearMonth.now().getMonthValue()-1);
				ps.setInt(3,YearMonth.now().getYear());
				rs=ps.executeQuery();
				while(rs.next())
				{
					count=rs.getInt(1);
					System.out.println("in while loop:"+count);
					if(count != 0)
					{
						total=total+count;
						System.out.println("total:"+total);
					}
				}
				
				
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("total no of rows:"+total);
		return total;
	}
	
	
	public int getTotalCountByDistrictId(int districtId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int count=0;
		int total=0;
		try
		{
			con=CdpDaoImpl.getConnection();
	
			String getDid="select id from district_tbl where did=?";
			ps=con.prepareStatement(getDid);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			int did=0;
			while(rs.next())
			{
				District district=StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				did=district.getId();
			}
			
			String getTid="select id from taluka_tbl where did=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,did);
			int tid=0;
			rs=ps.executeQuery();
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<Integer> talukaList=new ArrayList();
			while(rs.next())
			{
				Taluka taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				talukaList.add(rs.getInt("id"));
				
			}
			System.out.println("taluka list:"+talukaList);
			for(int talukaId:talukaList)
			{
				String getvid="select id from village_tbl where tid=?";
				ps=con.prepareStatement(getvid);
				ps.setInt(1,talukaId);
				int id=0;
				rs=ps.executeQuery();
				@SuppressWarnings({ "rawtypes", "unchecked" })
				List<Integer> villageList=new ArrayList();
				while(rs.next())
				{
					Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
					int vid=village.getId();
					villageList.add(vid);
					
				}
				for(int vid:villageList)
				{
					
					String getCount="select count(*) from egram_tbl where vid=?";
					ps=con.prepareStatement(getCount);
					ps.setInt(1,vid);
					ps.setInt(2,YearMonth.now().getMonthValue()-1);
					ps.setInt(3,YearMonth.now().getYear());
					rs=ps.executeQuery();
					while(rs.next())
					{
						count=rs.getInt(1);
						System.out.println("in while loop:"+count);
						if(count != 0)
						{
							total=total+count;
							System.out.println("total:"+total);
						}
					}
					
					
				}
				
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("total no of rows:"+total);
		return total;
	}

	

	

	

	}


