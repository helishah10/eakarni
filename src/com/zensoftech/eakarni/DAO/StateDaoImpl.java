package com.zensoftech.eakarni.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.State;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class StateDaoImpl implements StateDao {
	

    private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public StateDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

        StateDaoImpl.driverName = driverName;
        StateDaoImpl.databaseUrl = databaseUrl;
        StateDaoImpl.databaseUsername = databaseUsername;
        StateDaoImpl.databasePassword = databasePassword;
     /*  System.out.println(" DAO>drivername:"+StateDaoImpl.driverName);
    	System.out.println("DAO > url:"+StateDaoImpl.databaseUrl);
        System.out.println("DAO >name:"+databaseUsername);
        System.out.println("DAO > password"+databasePassword);*/
    }
    
    
    
    	public static Connection getConnection() throws SQLException, ClassNotFoundException{
    		Class.forName("com.mysql.jdbc.Driver");
    	/*System.out.println("CONNECTION >drivername:"+driverName);
    	System.out.println("CONNECTION >url:"+databaseUrl);
        System.out.println("CONNECTION >name:"+databaseUsername);
       System.out.println("CONNECTION >password"+databasePassword);*/
  
       return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
       }

	private static Map<Integer,State> stateMap;
	
	public Map<Integer,State> getAllStates() throws ClassNotFoundException, SQLException 
	{
		Connection con=getConnection();
		return StateDaoImpl.getAllStates(con);
		
	}
	
	public static Map<Integer,State> getAllStates(Connection con) throws SQLException,ClassNotFoundException{
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		if(StateDaoImpl.stateMap == null)
		{
			Map<Integer,State> MapStates=new TreeMap<Integer,State>();
			//con=getConnection();
			String selectState="Select * from state_tbl";
 			ps=con.prepareStatement(selectState);
 			rs=ps.executeQuery();
 			while(rs.next())
 			{
 				State state=new State();
				state.setId(rs.getInt("id"));
				state.setStateId(rs.getInt("stateid"));
				state.setName(rs.getString("name"));
				state.setLanguageCode(rs.getString("languagecode"));
				state.setScriptCode(rs.getString("scriptcode"));
				MapStates.put(state.getId(), state);
			}
		
		StateDaoImpl.stateMap=MapStates;
		}
		
		return Collections.unmodifiableMap(StateDaoImpl.stateMap);
	}
	
private static Map<Integer,District> districtMap;
	
	public Map<Integer, District> getAllDistricts() throws ClassNotFoundException, SQLException {
		Connection con=StateDaoImpl.getConnection();
		return StateDaoImpl.getAllDistricts(con);
	}
	public static Map<Integer,District> getAllDistricts(Connection con) throws SQLException, ClassNotFoundException
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		if(StateDaoImpl.districtMap != null)
		{
		
			return districtMap;
		}
		
		else
		{
			Map<Integer,District> MapDistrict=new TreeMap<Integer,District>();
			//con=StateDaoImpl.getConnection();
			String selectDistrict="Select * from district_tbl";
 			ps=con.prepareStatement(selectDistrict);
 			rs=ps.executeQuery();
 			while(rs.next())
 			{
 				District district=new District();
				district.setState(StateDaoImpl.getAllStates(con).get(rs.getInt("stateid")));
		

				district.setId(rs.getInt("id"));
				district.setDId(rs.getInt("did"));
				district.setName(rs.getString("name"));
				MapDistrict.put(district.getId(), district);
				}
 			StateDaoImpl.districtMap=MapDistrict;
		}
		return Collections.unmodifiableMap(StateDaoImpl.districtMap);
	
	}
	
	private static Map<Integer,Taluka> talukaMap;

	public Map<Integer, Taluka> getAllTalukas() throws ClassNotFoundException, SQLException {
		Connection con=StateDaoImpl.getConnection();
		return StateDaoImpl.getAllTalukas(con);
		
	}
	public static Map<Integer,Taluka> getAllTalukas(Connection con) throws SQLException, ClassNotFoundException
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		if(StateDaoImpl.talukaMap == null)
		{
			Map<Integer,Taluka> MapTaluka=new TreeMap<Integer,Taluka>();
			//con=StateDaoImpl.getConnection();
			String selectTaluka="Select * from taluka_tbl";
 			ps=con.prepareStatement(selectTaluka);
 			rs=ps.executeQuery();
 			while(rs.next())
 			{
 				Taluka taluka=new Taluka();
				taluka.setDistrict(StateDaoImpl.getAllDistricts(con).get(rs.getInt("did")));
				//taluka.getDistrict().setDId((rs.getInt("did")));
				
				taluka.setId(rs.getInt("id"));
				taluka.settId(rs.getInt("tid"));
				taluka.setName(rs.getString("name"));
				MapTaluka.put(taluka.getId(), taluka);
			}
		
		StateDaoImpl.talukaMap=MapTaluka;
		}
		
		return Collections.unmodifiableMap(StateDaoImpl.talukaMap);
	}
	

	private static Map<Integer,Village> villageMap;
	public Map<Integer,Village> getAllVillage() throws ClassNotFoundException, SQLException {
		Connection con=StateDaoImpl.getConnection();
		return StateDaoImpl.getAllVillage(con);
		
	}
	public static Map<Integer,Village> getAllVillage(Connection con) throws SQLException, ClassNotFoundException
	{
		PreparedStatement ps=null;
		ResultSet rs=null;

		if(villageMap== null){
		
			Map<Integer,Village> MapVillage=new TreeMap<Integer,Village>();
			Map<Integer,Integer> gramMap=new TreeMap<>();
			//con=StateDaoImpl.getConnection();
			String selectVillage="Select * from village_tbl";
 			ps=con.prepareStatement(selectVillage);
 			rs=ps.executeQuery();
 
 			while(rs.next())
 			{
 			
 	 			Village village=new Village();
 	 			village.setTaluka(StateDaoImpl.getAllTalukas(con).get(rs.getInt("tid")));
				village.setId(rs.getInt("id"));
				//village.getTaluka().settId(taluka2.gettId());
				village.setvId(rs.getInt("vid"));
				village.setName(rs.getString("name"));
				
				village.setGramVillage(village);
		
				int gramvillage=rs.getInt("gramvillage");
				MapVillage.put(village.getId(),village);
				gramMap.put(village.getId(), gramvillage);
				
				
				/* Map<Integer,Village> villageMap = StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));*/
				    gramMap.forEach( (id, gramVillage) -> {
				                    Village v = MapVillage.get(id);
				                    Village gv = MapVillage.get(gramVillage);
				                    v.setGramVillage(gv);
				    });
					
			}
 			
		StateDaoImpl.villageMap=MapVillage;
		}

		return Collections.unmodifiableMap(StateDaoImpl.villageMap);
	}
	
		
	
	public State getStateByName(String name) throws SQLException
	{
		Connection con=null;
		ResultSet rs=null;
		State state=null;
		PreparedStatement ps;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByName="Select * from state_tbl where name=?";	
			ps=con.prepareStatement(FindByName);
			ps.setString(1,name);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				state=new State();
				state.setId(rs.getInt("id"));
				state.setStateId(rs.getInt("stateid"));
				state.setName(rs.getString("name"));
				state.setLanguageCode(rs.getString("languagecode"));
				state.setScriptCode(rs.getString("scriptcode"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		con.close();
		return state;
}
	
	public State getStateByStateId(int stateId) throws SQLException
	{
		Connection con=null;
		ResultSet rs=null;
		State state=null;
		PreparedStatement ps=null;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByStateId="Select * from state_tbl where stateid=?";			
		    ps=con.prepareStatement(FindByStateId);
			ps.setInt(1,stateId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				state=new State();
				state.setId(rs.getInt("id"));
				state.setStateId(rs.getInt("stateid"));
				state.setName(rs.getString("name"));
				state.setLanguageCode(rs.getString("languagecode"));
				state.setScriptCode(rs.getString("scriptcode"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		rs.close();
		con.close();
		
		return state;
	}
	
	public void update(State state) throws SQLException
	{
		Connection con=null;
		PreparedStatement ps;
		try
		{
			con=StateDaoImpl.getConnection();
			String update="Update state_tbl set stateid=?, name=?, languagecode=?, scriptcode=? where id=?";
			ps= con.prepareStatement(update);
			
			ps.setInt(1, state.getStateId());
			ps.setString(2, state.getName());
			ps.setString(3, state.getLanguageCode());
			ps.setString(4, state.getScriptCode());
			ps.setInt(5, state.getId());
			ps.executeUpdate();
			
			System.out.println("successfully updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		con.close();
	}
	
	
	
	public Map<Integer,District> getDistrictsByState(State state)
	{
		Map<Integer,District> districtMap= new HashMap<Integer,District>();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();				
			int Id=state.getId();
			String FindByState="Select * from district_tbl where stateid=?"	;
			ps=con.prepareStatement(FindByState);
			ps.setInt(1, Id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				District district=new District();
				district.setId(rs.getInt("id"));
				district.setState(state);
				district.setDId(rs.getInt("did"));
				district.setName(rs.getString("name"));
				districtMap.put(district.getId(), district);
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return districtMap;
	}
	
	public District getDistrictByName(String name)
	{
		District district=new District();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByName="Select * from district_tbl where name=?";
			 ps=con.prepareStatement(FindByName);
			 ps.setString(1,name);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				
				district.setId(rs.getInt("id"));
				district.setDId(rs.getInt("did"));
				district.setName(rs.getString("name"));
			}	
			}catch(Exception e)
			{
				System.out.println(e);
			}
		return district;
		}

	public District getDistrictByDistrictId(int dId)
	{
		District district=new District();
		PreparedStatement ps;
		Connection con;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByDistrictId="Select * from district_tbl where did=?";
			ps=con.prepareStatement(FindByDistrictId);
			ps.setInt(1,dId);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				district.setId(rs.getInt("id"));
				//d.getState().setStateId(rs.getInt("stateid"));
				district.setDId(rs.getInt("did"));
				district.setName(rs.getString("name"));
			}	
			}catch(Exception e)
			{
				System.out.println(e);
			}
		return district;
	}
	
	public void update(District district)
	{	
		Connection con;
		PreparedStatement ps;
		try
		{
			con=StateDaoImpl.getConnection();
			String update="Update district_tbl set stateid=?, did=?, name=? where id=?";			
			State state=new State();
			district.setState(state);
			
			ps= con.prepareStatement(update);
			
			ps.setInt(1, district.getState().getId());
			ps.setInt(2, district.getDId());
			ps.setString(3, district.getName());
			ps.setInt(4, district.getId());
			
			ps.executeUpdate();
			System.out.println("succuessfully updated");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	public List<Taluka> getTalukasByDistrict(int  districtId)//auto id
	{
		List<Taluka> talukaList = new ArrayList<>();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		{
			try
			{
				con=StateDaoImpl.getConnection();
				String FindByDistrict="Select * from taluka_tbl where did=?";
				ps=con.prepareStatement(FindByDistrict);
				/*int Id=district.getId();*/
				ps.setInt(1, districtId);
				rs=ps.executeQuery();
				while(rs.next())
				{
					Taluka taluka=new Taluka();
					/*taluka.setId(rs.getInt("id"));
					taluka.setDistrict(StateDaoImpl.getAllDistricts(con).get(rs.getInt("did")));
					taluka.settId(rs.getInt("tid"));
					taluka.setName(rs.getString("name"));*/
					taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
					talukaList.add(taluka);
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		return talukaList;
	}
	
	/*public Taluka getTalukaByName(String talukaName)
	{
		Taluka taluka=new Taluka();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByName="Select * from taluka_tbl where name=?";
			ps=con.prepareStatement(FindByName);
			ps.setString(1, talukaName);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				taluka.setId(rs.getInt("id"));
				taluka.settId(rs.getInt("tid"));
				taluka.setName(rs.getString("name"));
			}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		return taluka;
	}*/
/*	
	public Taluka getTalukaByTalukaId(int talukaId)
	{
		Taluka taluka=new Taluka();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByTalukaId="Select * from taluka_tbl where tid=?";		
			ps=con.prepareStatement(FindByTalukaId);
			ps.setInt(1, talukaId);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				taluka.setId(rs.getInt("id"));
				taluka.settId(rs.getInt("tid"));
				taluka.setName(rs.getString("name"));
			}
			}catch(Exception e) 
			{
				System.out.println(e);
			}
		return taluka;
	}*/
	
	public void update(Taluka taluka)
	{	
		Connection con;
		PreparedStatement ps;
		try
		{
			con=StateDaoImpl.getConnection();
			String update="update taluka_tbl set tid=?, name=? where id=?";		
			ps=con.prepareStatement(update);
			//pst.setInt(1, t.district.getId());
			ps.setInt(1, taluka.gettId());
			ps.setString(2,taluka.getName());
			ps.setInt(3, taluka.getId());
			
			System.out.println("succuessfully updated");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public  List<Village> getAllVillagesByTaluka(int talukaId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		List<Village> villageList=new ArrayList<Village>();
		try
		{
			con=StateDaoImpl.getConnection();
			String getVillagesByTaluka="select id from village_tbl where tid=?";
			ps=con.prepareStatement(getVillagesByTaluka);
			ps.setInt(1, talukaId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Village village;
				village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				villageList.add(village);
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return villageList;
		
		
	}
	public int getTotalVillagesByTalukaId(int talukaId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int total=0;
		try
		{
			con=StateDaoImpl.getConnection();
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
			String getNoOfVillages="select count(*) from village_tbl where tid=?";
			ps=con.prepareStatement(getNoOfVillages);
			ps.setInt(1,tid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				total=rs.getInt(1);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	public Village getVillage(int villageId)//census id
	{
		Village village=new Village();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByVillageId="Select * from village_tbl where vid=?";		
			ps=con.prepareStatement(FindByVillageId);
			ps.setInt(1, villageId);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				
			}
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
		return village;
	}
	
	public Taluka getTaluka(int talukaId)
	{
		Taluka taluka=new Taluka();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByVillageId="Select * from taluka_tbl where tid=?";		
			ps=con.prepareStatement(FindByVillageId);
			ps.setInt(1, talukaId);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				
			}
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
		return taluka;
		
	}

	public List<District> getAllDistrictByStateId(int stateId)
	{
		List<District> districtList=new ArrayList<>();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();
			String getDistrictByStateId="select * from district_tbl where stateid=?";
			ps=con.prepareStatement(getDistrictByStateId);
			ps.setInt(1,stateId);
			rs=ps.executeQuery();
			District district=new District();
			int did=0;
			while(rs.next())
			{
				district=StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				did=district.getId();
				System.out.println("district id:"+did);
				districtList.add(district);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return districtList;
	}



	public District getDistrict(int districtId) {
		District district=new District();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=StateDaoImpl.getConnection();
			String FindByDistrictId="Select * from district_tbl where did=?";		
			ps=con.prepareStatement(FindByDistrictId);
			ps.setInt(1, districtId);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				district=StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				
			}
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
		return district;
		
	}



	
	public int getTotalTalukasByDistrictId(int districtId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int total=0;
		try
		{
			con=StateDaoImpl.getConnection();
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
			String getNoOfTalukas="select count(*) from taluka_tbl where did=?";
			ps=con.prepareStatement(getNoOfTalukas);
			ps.setInt(1,did);
			rs=ps.executeQuery();
			while(rs.next())
			{
				total=rs.getInt(1);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
		
	}

	


	



	
	
	
	
	}

