package com.zensoftech.eakarni.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.PanchVeraVasulat;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Taxtype;
import com.zensoftech.eakarni.entities.Village;

public class PanchVeraDaoImpl  implements PanchVeraDao
{
	 private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public PanchVeraDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	PanchVeraDaoImpl.driverName = driverName;
	    	PanchVeraDaoImpl.databaseUrl = databaseUrl;
	    	PanchVeraDaoImpl.databaseUsername = databaseUsername;
	    	PanchVeraDaoImpl.databasePassword = databasePassword;

	    }
	    
	    public static Connection getConnection() throws SQLException, ClassNotFoundException
	    {
	    	System.out.println("in connection method:");
	    	
	    	Class.forName("com.mysql.jdbc.Driver");
	       return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
	       }
	    
	public   Map<Integer,PanchVeraVasulat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	
	{
		Connection con;
		PreparedStatement ps;
		Map<Integer, PanchVeraVasulat> panchveraMap=new HashMap<Integer,PanchVeraVasulat>();
		ResultSet rs;
		try
		{
			con=PanchVeraDaoImpl.getConnection(); 
			
			String getDid="select id from district_tbl where did=?";
			ps=con.prepareStatement(getDid);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			int did=0;
			while(rs.next())
			{
				District district =StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				did=district.getId();
				//System.out.println("district id:"+did);
				
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
		//	System.out.println("taluka list:"+talukaList);

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
				//System.out.println("village list:"+villageList);
				
				
			}
			
			for(int vid:villageList)
			{
				String GET_ALL="select * from panch_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2, yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
				
				TaxtypeDao taxdao = new TaxtypeDaoImpl(driverName,databaseUrl, databaseUsername, databasePassword);
			while(rs.next())
			{
				 PanchVeraVasulat panchvera=new PanchVeraVasulat();
				 panchvera.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 panchvera.setYearmonth(YearMonth.of(year, month));
				 panchvera.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 panchvera.setTaxtype(taxdao.getAllDetails().get(rs.getInt("tax_id")));
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
				 
				 panchveraMap.put(panchvera.getId(),panchvera);
				
	         }
		
			}
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return panchveraMap;
}
		
		
		public   Map<Integer,PanchVeraVasulat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
		{
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs;		
			 Map<Integer,PanchVeraVasulat> panchveraMap=new HashMap<Integer,PanchVeraVasulat>();
			try
			{
				con=PanchVeraDaoImpl.getConnection();
				
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
				System.out.println("village list:"+villagelist);
				for(int vid:villagelist)
				{
					String GET_ALL="select * from panch_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
					ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1,vid);
					ps.setInt(2, yearmonth.getMonthValue());
					ps.setInt(3,yearmonth.getYear());
					rs=ps.executeQuery();
					TaxtypeDao taxdao = new TaxtypeDaoImpl(driverName,databaseUrl, databaseUsername, databasePassword);
				    while(rs.next())
					{
				    	 PanchVeraVasulat panchvera=new PanchVeraVasulat();
						 panchvera.setId(rs.getInt("id"));
						 int month=rs.getInt("mth");
						 int year=rs.getInt("yr");
						 panchvera.setYearmonth(YearMonth.of(year, month));
						 panchvera.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
						 panchvera.setTaxtype(taxdao.getAllDetails().get(rs.getInt("tax_id")));
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
						 
						 panchveraMap.put(panchvera.getId(),panchvera);
					}
				}	
			    rs.close();
			    con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return panchveraMap;
		}
		
		public   Map<Integer,PanchVeraVasulat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
		{
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs;		
			 Map<Integer, PanchVeraVasulat> panchveraMap=new HashMap<Integer,PanchVeraVasulat>();
			try
			{
				con=PanchVeraDaoImpl.getConnection();
				
				String getVid="select id from village_tbl where vid=?";
				ps=con.prepareStatement(getVid);
				ps.setInt(1,villageId);
				rs=ps.executeQuery();
				int id=0;
				while(rs.next())
				{
					Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
					id=village.getId();
				
					
				}
				String GET_ALL="select * from panch_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,id);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
				Village village=new Village();
				village.setId(id);
				TaxtypeDao taxdao = new TaxtypeDaoImpl(driverName,databaseUrl, databaseUsername, databasePassword);
			    while(rs.next())
				{
			    	 PanchVeraVasulat panchvera=new PanchVeraVasulat();
					 panchvera.setId(rs.getInt("id"));
					 int month=rs.getInt("mth");
					 int year=rs.getInt("yr");
					 panchvera.setYearmonth(YearMonth.of(year, month));
					 panchvera.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 panchvera.setTaxtype(taxdao.getAllDetails().get(rs.getInt("tax_id")));
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
					 
					 panchveraMap.put(panchvera.getId(),panchvera);
				}
		
			    rs.close();
			    con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return panchveraMap;
		}
		
	
	public PanchVeraVasulat insert(int villageId,PanchVeraVasulat panchvera,String taxname)
	{
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		try
		{
			con=PanchVeraDaoImpl.getConnection();
			
			Village village=null;
			village=StateDaoImpl.getAllVillage(con).get(villageId);
			panchvera.setVillage(village);
			int vid=village.getId();
			
			/*String getAll = "Select * from taxtype_tbl where tax_name=?";
			Taxtype taxtype=new Taxtype();
			ps = con.prepareStatement(getAll,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,taxname);
			rs=ps.executeQuery();
			while(rs.next()){
				
				taxtype.setTaxId(rs.getInt("tax_id"));
				taxtype.setTaxName(rs.getString("tax_name"));
				
			}
			System.out.println(taxtype);
			panchvera.setTaxtype(taxtype);
			*/
			
			
			String getAll = "Select * from taxtype_tbl where tax_name=?";
			Taxtype taxtype=new Taxtype();
			ps = con.prepareStatement(getAll,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,taxname);
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				taxtype.setTaxId(rs.getInt("tax_id"));
				taxtype.setTaxName(rs.getString("tax_name"));
				
			}
			
			System.out.println(taxtype);
			panchvera.setTaxtype(taxtype);
			
			
			
	
			String INSERT="insert into panch_vera_vasulat_tbl(vid,mth,yr,tax_id,seeking_previous_amount_left,seeking_current_amount,"
					+ "seeking_total_amount,recovery_till_previous_month_current,recovery_till_previous_month_previous,"
					+ "recovery_till_previous_month_total,recovery_till_current_month_current,recovery_till_current_month_previous,"
					+ "recovery_till_current_month_total,total_recovery_previous,total_recovery_current,"
					+ "total_recovery_total,recovery_left_at_the_end_month_previous,recovery_left_at_the_end_month_current,"
					+ "recoevry_left_at_the_end_month_total,percentage,entry_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(INSERT);
	
			ps.setInt(1,vid);
			ps.setInt(2,panchvera.getYearmonth().getMonthValue());
			ps.setInt(3,panchvera.getYearmonth().getYear());
	
			ps.setDouble(4,panchvera.getSeekingPreviousAmountLeft());
			ps.setDouble(5,panchvera.getSeekingCurrentAmount());
			ps.setDouble(6,panchvera.getSeekingTotalAmount());
			ps.setDouble(7,panchvera.getRecoveryTillPreviousMonthCurrent());
			ps.setDouble(8,panchvera.getRecoveryTillPreviousMonthPrevious());
			ps.setDouble(9,panchvera.getRecoveryTillPreviousMonthTotal());
			ps.setDouble(10,panchvera.getRecoveryTillCurrentMonthCurrent());
			ps.setDouble(11,panchvera.getRecoveryTillCurrentMonthPrevious());
			ps.setDouble(12,panchvera.getRecoveryTillCurrentMonthTotal());
			ps.setDouble(13,panchvera.getTotalRecoveryPrevious());
			ps.setDouble(14,panchvera.getTotalRecoveryCurrent());
			ps.setDouble(15,panchvera.getTotalRecoveryTotal());
			ps.setDouble(16,panchvera.getRecoveryLeftAtTheEndMonthPrevious());
			ps.setDouble(17,panchvera.getRecoveryLeftAtTheEndMonthCurrent());
			ps.setDouble(18,panchvera.getRecoveryLeftAtTheEndMonthTotal());
			ps.setDouble(19, panchvera.getPercentage());
			ps.setDate(20,Date.valueOf(java.time.LocalDate.now()));
			
			ps.executeUpdate();
			
			
	        System.out.println("success");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return panchvera;
	}
	
	public PanchVeraVasulat getDetails(YearMonth yearmonth,int villageId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		PanchVeraVasulat panchvera=new PanchVeraVasulat();
		try
		{
			con=PanchVeraDaoImpl.getConnection();
			
			String getId="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			rs.next();
			Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			int vid=village.getId();
			panchvera.setVillage(village);
			/*panchvera.setMth(month);
			panchvera.setYr(year);
			*/
			String GET_ALL="select * from panch_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2, yearmonth.getMonthValue());
			ps.setInt(3, yearmonth.getYear());
			rs=ps.executeQuery();

			TaxtypeDao taxdao = new TaxtypeDaoImpl(driverName,databaseUrl, databaseUsername, databasePassword);
		    while(rs.next())
			{
		    	 panchvera.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 panchvera.setYearmonth(YearMonth.of(year, month));
				 panchvera.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 panchvera.setTaxtype(taxdao.getAllDetails().get(rs.getInt("tax_id")));
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
		
			}
			
			rs.close();
			con.close();
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return panchvera;
	}
	
	
	public PanchVeraVasulat update(PanchVeraVasulat panchvera,int villageId,YearMonth yearmonth,String taxname)
	{
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		try
		{
			con=PanchVeraDaoImpl.getConnection();
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			System.out.println(village);
			panchvera.setVillage(village);
			
			String getAll = "Select * from taxtype_tbl where tax_name=?";
			Taxtype taxtype=new Taxtype();
			ps = con.prepareStatement(getAll,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,taxname);
			rs=ps.executeQuery();
			while(rs.next()){
				
				taxtype.setTaxId(rs.getInt("tax_id"));
				taxtype.setTaxName(rs.getString("tax_name"));
				
			}
			System.out.println(taxtype);
			panchvera.setTaxtype(taxtype);
		
			final String update = "UPDATE panch_vera_vasulat_tbl SET seeking_previous_amount_left=?,"
			 			+ "seeking_current_amount=?,seeking_total_amount=?,"
				 		+ "recovery_till_previous_month_current=?,recovery_till_previous_month_previous=?,"
				 		+ "recovery_till_previous_month_total=?,recovery_till_current_month_current=?,"
				 		+ "recovery_till_current_month_previous=?,recovery_till_current_month_total=?,"
				 		+ "total_recovery_previous=?,total_recovery_current=?,total_recovery_total=?,"
				 		+ "recovery_left_at_the_end_month_previous=?,recovery_left_at_the_end_month_previous=?,"
						+ "recoevry_left_at_the_end_month_total=?,percentage=?,entry_date=? where vid=? AND mth=? AND yr=?" ;
					
			ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
			
			ps.setDouble(1,panchvera.getSeekingPreviousAmountLeft());
			ps.setDouble(2, panchvera.getSeekingCurrentAmount());
			ps.setDouble(3, panchvera.getSeekingTotalAmount());
			ps.setDouble(4,panchvera.getRecoveryTillPreviousMonthCurrent());
			ps.setDouble(5,panchvera.getRecoveryTillPreviousMonthPrevious());
			ps.setDouble(6,panchvera.getRecoveryTillPreviousMonthTotal());
			ps.setDouble(7,panchvera.getRecoveryTillCurrentMonthPrevious());
			ps.setDouble(8,panchvera.getRecoveryTillCurrentMonthCurrent());
			ps.setDouble(9,panchvera.getRecoveryTillCurrentMonthTotal());
			ps.setDouble(10,panchvera.getTotalRecoveryPrevious());
			ps.setDouble(11,panchvera.getTotalRecoveryCurrent());
			ps.setDouble(12,panchvera.getTotalRecoveryTotal());
			ps.setDouble(13,panchvera.getRecoveryLeftAtTheEndMonthPrevious());
			ps.setDouble(14,panchvera.getRecoveryLeftAtTheEndMonthCurrent());
			ps.setDouble(15,panchvera.getRecoveryLeftAtTheEndMonthTotal());
			ps.setDouble(16,panchvera.getPercentage());
			ps.setDate(17,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(18, villageId);
			ps.setInt(19, yearmonth.getMonthValue());
			ps.setInt(20, yearmonth.getYear());
			ps.executeUpdate();
			System.out.println(panchvera);
			System.out.println("successsss");
			
		
		
			
			System.out.println("successfully updated");
	 
	     } 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return panchvera;
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
			con=CdpDaoImpl.getConnection();
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
				
				String getCount="select count(*) from panch_vera_vasulat_tbl where vid=?";
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
					
					String getCount="select count(*) from panch_vera_vasulat_tbl where vid=?";
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
