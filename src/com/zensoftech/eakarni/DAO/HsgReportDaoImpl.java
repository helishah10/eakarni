package com.zensoftech.eakarni.DAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.CdpDto;

import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.HsgDto;

public class HsgReportDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public HsgReportDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	HsgReportDaoImpl.driverName = driverName;
    	HsgReportDaoImpl.databaseUrl = databaseUrl;
    	HsgReportDaoImpl.databaseUsername = databaseUsername;
    	HsgReportDaoImpl.databasePassword = databasePassword;
        /*System.out.println(" DAO>drivername:"+UserDaoImpl.d
         * iverName);
    	System.out.println("DAO > url:"+UserDaoImpl.databaseUrl);
        System.out.println("DAO >name:"+databaseUsername);
        System.out.println("DAO > password"+databasePassword);*/
    }
    	 public static Connection getConnection() throws SQLException, ClassNotFoundException{
    	    	
    	    	
    	   	 /*System.out.println(" connection>drivername:"+driverName);
    	   	
    	    	 System.out.println("connection > url:"+databaseUrl);
    	        System.out.println("connection >name:"+databaseUsername);
    	        System.out.println("connection> password"+databasePassword);*/
    	   	Class.forName("com.mysql.jdbc.Driver");
    	      return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
    	      }
    	 
    	 public  FileOutputStream  generateHsgReport(List<HsgDto> hsgDtoList,String fileName) throws IOException, ClassNotFoundException, SQLException {

    			/*String excelFileName = "C:/Test.xls";*/// name of excel file
    			File file=new File(fileName);

    			String sheetName = "Sheet1";// name of sheet

//    			ResultSet resultSet = getDatabase(villageId,yearmonth);
    			XSSFWorkbook workbook = new XSSFWorkbook(); 
    		      XSSFSheet spreadsheet = workbook
    		    	      .createSheet(sheetName);
    		    	      XSSFRow row=spreadsheet.createRow(1);
    		    	     /* XSSFRow row1 = spreadsheet.createRow(2);*/
    		    	    
    		    	      XSSFCell cell;
    		    	      cell=row.createCell(1);
    		    	      cell.setCellValue("vid");
    		    	      cell=row.createCell(2);
    		    	      cell.setCellValue("month");
    		    	      cell=row.createCell(3);
    		    	      cell.setCellValue("year");
    		    	      cell=row.createCell(4);
    		    	      cell.setCellValue("target");
    		    	      cell=row.createCell(5);
    		    	      cell.setCellValue("not_started_houses");
    		    	      cell=row.createCell(6);
    		    	      cell.setCellValue("plinth_level");
    		    	      cell=row.createCell(7);
    		    	      cell.setCellValue("lintal_level");
    		    	      cell=row.createCell(8);
    		    	      cell.setCellValue("slab_level");
    		    	      cell=row.createCell(9);
    		    	      cell.setCellValue("completed_houses");
    		    	      cell=row.createCell(10);
    		    	      cell.setCellValue("finance_year");
    		    	      

    		    	      int i=2;
    		    	      for(HsgDto hsgDto:hsgDtoList)
    		    	      {
    			    	         row=spreadsheet.createRow(i);
    			    	        /* row1=spreadsheet.createRow(i+1);*/
    			    	         cell=row.createCell(1);
    			    	         cell.setCellValue(hsgDto.getVillageId());
    			    	         cell=row.createCell(2);
    			    	         cell.setCellValue(hsgDto.getMonth());
    			    	         cell=row.createCell(3);
    			    	         cell.setCellValue(hsgDto.getYear());
//    			    	       /*  spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 4, 4));*/
    			    	         cell=row.createCell(4);
    			    	         cell.setCellValue(hsgDto.getTarget());
    			    	         cell=row.createCell(5);
    			    	         cell.setCellValue(hsgDto.getNotStartedHouses());
    			    	         cell=row.createCell(6);
    			    	         cell.setCellValue(hsgDto.getPlinthLevel());
    			    	         cell=row.createCell(7);
    			    	         cell.setCellValue(hsgDto.getLintalLevel());
    			    	         cell=row.createCell(8);
    			    	         cell.setCellValue(hsgDto.getSlabLevel());
    			    	         cell=row.createCell(9);
    			    	         cell.setCellValue(hsgDto.getCompletedHouses());
    			    	         cell=row.createCell(10);
    			    	         cell.setCellValue(hsgDto.getFinanceYear());
    			    	         /*cell=row.createCell(11);
    			    	         cell.setCellValue(cdpDto.getEntryDate());*/
    			    	         i++;
    			    	      }
    			    	      FileOutputStream out = new FileOutputStream(
    			    	      file);
    			    	      workbook.write(out);
    			    	      out.close();
    			    	      System.out.println(
    			    	      "exceldatabase.xlsx written successfully");
    			    	      
    			    	return out;
    	
    	
    	
    }
	
	

}
