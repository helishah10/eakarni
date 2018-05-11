package com.zensoftech.eakarni.DAO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.GPAuditPeraDto;

public class GPauditperaReportDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
   
    
    public GPauditperaReportDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	GPauditperaReportDaoImpl.driverName = driverName;
    	GPauditperaReportDaoImpl.databaseUrl = databaseUrl;
    	GPauditperaReportDaoImpl.databaseUsername = databaseUsername;
    	GPauditperaReportDaoImpl.databasePassword = databasePassword;
        /*System.out.println(" DAO>drivername:"+UserDaoImpl.driverName);
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
	
	public  FileOutputStream  generateGpAuditPeraReport(List<GPAuditPeraDto> gpAuditperaDtoList,String fileName) throws IOException, ClassNotFoundException, SQLException {

		/*String excelFileName = "C:/Test.xls";*/// name of excel file
		File file=new File(fileName);

		String sheetName = "Sheet1";// name of sheet

//		ResultSet resultSet = getDatabase(villageId,yearmonth);
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
	    	      cell.setCellValue("year of registration");
	    	      cell=row.createCell(5);
	    	      cell.setCellValue("total pera");
	    	      cell=row.createCell(6);
	    	      cell.setCellValue("total pera answered this week");
	    	      cell=row.createCell(7);
	    	      cell.setCellValue("pera not answered");
	    	     /* cell=row.createCell(11);
	    	      cell.setCellValue("entry date");*/
	    	     
	    	      int i=2;
	    	      for(GPAuditPeraDto peraDto:gpAuditperaDtoList)
//	    	      while(resultSet.next())
	    	      {
	    	         row=spreadsheet.createRow(i);
	    	        /* row1=spreadsheet.createRow(i+1);*/
	    	         cell=row.createCell(1);
	    	         cell.setCellValue(peraDto.getVillageId());
	    	         cell=row.createCell(2);
	    	         cell.setCellValue(peraDto.getMonth());
	    	         cell=row.createCell(3);
	    	         cell.setCellValue(peraDto.getYear());
//	    	       /*  spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 4, 4));*/
	    	         cell=row.createCell(4);
	    	         cell.setCellValue(peraDto.getYearOfRegisteration());
	    	         cell=row.createCell(5);
	    	         cell.setCellValue(peraDto.getTotalPera());
	    	         cell=row.createCell(6);
	    	         cell.setCellValue(peraDto.getTotalPeraAnsweredThisWeek());
	    	         cell=row.createCell(7);
	    	         cell.setCellValue(peraDto.getPeraNotanswered());
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
