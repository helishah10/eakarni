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

import com.zensoftech.eakarni.entities.Finance14;
import com.zensoftech.eakarni.entities.Finance14Dto;

public class FinanceReportDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
   
    
    public FinanceReportDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	FinanceReportDaoImpl.driverName = driverName;
    	FinanceReportDaoImpl.databaseUrl = databaseUrl;
    	FinanceReportDaoImpl.databaseUsername = databaseUsername;
    	FinanceReportDaoImpl.databasePassword = databasePassword;
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
	
	public  FileOutputStream  generateFinance14Report(List<Finance14Dto> Finance14DtoList,String fileName) throws IOException, ClassNotFoundException, SQLException {

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
	    	      cell.setCellValue("Total work");
	    	      cell=row.createCell(5);
	    	      cell.setCellValue("Works approved");
	    	      cell=row.createCell(6);
	    	      cell.setCellValue("Project not started");
	    	      cell=row.createCell(7);
	    	      cell.setCellValue("Progress");
	    	      cell=row.createCell(8);
	    	      cell.setCellValue("Completed");
	    	      cell=row.createCell(9);
	    	      cell.setCellValue("Grant allocated");
	    	      cell=row.createCell(10);
	    	      cell.setCellValue("Amount spent");
	    	     /* cell=row.createCell(11);
	    	      cell.setCellValue("entry date");*/
	    	     
	    	      int i=2;
	    	      for(Finance14Dto finance14Dto:Finance14DtoList)
//	    	      while(resultSet.next())
	    	      {
	    	         row=spreadsheet.createRow(i);
	    	        /* row1=spreadsheet.createRow(i+1);*/
	    	         cell=row.createCell(1);
	    	         cell.setCellValue(finance14Dto.getVillageId());
	    	         cell=row.createCell(2);
	    	         cell.setCellValue(finance14Dto.getMonth());
	    	         cell=row.createCell(3);
	    	         cell.setCellValue(finance14Dto.getYear());
//	    	       /*  spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 4, 4));*/
	    	         cell=row.createCell(4);
	    	         cell.setCellValue(finance14Dto.getTotalWork());
	    	         cell=row.createCell(5);
	    	         cell.setCellValue(finance14Dto.getWorksApproved());
	    	         cell=row.createCell(6);
	    	         cell.setCellValue(finance14Dto.getProjectNotStarted());
	    	         cell=row.createCell(7);
	    	         cell.setCellValue(finance14Dto.getProgress());
	    	         cell=row.createCell(8);
	    	         cell.setCellValue(finance14Dto.getCompleted());
	    	         cell=row.createCell(9);
	    	         cell.setCellValue(finance14Dto.getGrantAllocated());
	    	         cell=row.createCell(10);
	    	         cell.setCellValue(finance14Dto.getAmountSpent());
	    	         /*cell=row.createCell(11);
	    	         cell.setCellValue(finance14Dto.getEntryDate());*/
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
