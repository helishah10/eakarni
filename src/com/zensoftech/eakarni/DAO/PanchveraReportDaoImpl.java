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

import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.PanchVeraVasulat;
import com.zensoftech.eakarni.entities.PanchveraDto;

public class PanchveraReportDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public PanchveraReportDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	PanchveraReportDaoImpl.driverName = driverName;
    	PanchveraReportDaoImpl.databaseUrl = databaseUrl;
    	PanchveraReportDaoImpl.databaseUsername = databaseUsername;
    	PanchveraReportDaoImpl.databasePassword = databasePassword;
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
	
    public  FileOutputStream  generatePanchveraReport(List<PanchveraDto> panchveraDtoList,String fileName) throws IOException, ClassNotFoundException, SQLException {

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
	    	     
	    	      cell.setCellValue("tax_id");
	    	      cell=row.createCell(5);
	    	      cell.setCellValue("seeking_previous_amount_left");
	    	      cell=row.createCell(6);
	    	      cell.setCellValue("seeking_current_amount");
	    	      cell=row.createCell(7);
	    	      cell.setCellValue("seeking_total_amount");
	    	      cell=row.createCell(8);
	    	      cell.setCellValue("recovery_till_previous_month_current");
	    	      cell=row.createCell(9);
	    	      cell.setCellValue("recovery_till_previous_month_previous");
	    	      cell=row.createCell(10);
	    	      cell.setCellValue("recovery_till_previous_month_total");
	    	      cell=row.createCell(11);
	    	      cell.setCellValue("recovery_till_current_month_current");
	    	      cell=row.createCell(12);
	    	      cell.setCellValue("recovery_till_current_month_previous");
	    	      cell=row.createCell(13);
	    	      cell.setCellValue("recovery_till_current_month_total");
	    	      cell=row.createCell(14);
	    	      cell.setCellValue("total_recovery_previous");
	    	      cell=row.createCell(15);
	    	      cell.setCellValue("total_recovery_current");
	    	      cell=row.createCell(16);
	    	      cell.setCellValue("total_recovery_total");
	    	      cell=row.createCell(17);
	    	      cell.setCellValue("recovery_left_at_the_end_month_previous");
	    	      cell=row.createCell(18);
	    	      cell.setCellValue("recovery_left_at_the_end_month_current");
	    	      cell=row.createCell(19);
	    	      cell.setCellValue("recoevry_left_at_the_end_month_total");
	    	      cell=row.createCell(20);
	    	     
	    	      cell.setCellValue("percentage");
	    	      cell=row.createCell(21);
	    	      
	    	     /* cell=row.createCell(11);
	    	      cell.setCellValue("entry date");*/
	    	     
	    	      int i=2;
	    	      for(PanchveraDto panchveraDto:panchveraDtoList)
//	    	      while(resultSet.next())
	    	      {
	    	         row=spreadsheet.createRow(i);
	    	        /* row1=spreadsheet.createRow(i+1);*/
	    	         cell=row.createCell(1);
	    	         cell.setCellValue(panchveraDto.getVillageId());
	    	         cell=row.createCell(2);
	    	         cell.setCellValue(panchveraDto.getMonth());
	    	         cell=row.createCell(3);
	    	         cell.setCellValue(panchveraDto.getYear());
	    	         
//	    	       /*  spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 4, 4));*/
	    	         cell=row.createCell(4);
	    	         cell.setCellValue(panchveraDto.getTaxtype());
	    	         cell=row.createCell(5);
	    	         cell.setCellValue(panchveraDto.getSeekingPreviousAmountLeft());
	    	         cell=row.createCell(6);
	    	         cell.setCellValue(panchveraDto.getSeekingCurrentAmount());
	    	         
	    	        cell=row.createCell(7);
	    	         cell.setCellValue(panchveraDto.getSeekingTotalAmount());
	    	         cell=row.createCell(8);
	    	         cell.setCellValue(panchveraDto.getRecoveryLeftAtTheEndMonthPrevious());
	    	         cell=row.createCell(9);
	    	         cell.setCellValue(panchveraDto.getRecoveryLeftAtTheEndMonthCurrent());
	    	         cell=row.createCell(10);
	    	         cell.setCellValue(panchveraDto.getRecoveryLeftAtTheEndMonthTotal());
	    	         cell=row.createCell(11);
	    	         cell.setCellValue(panchveraDto.getRecoveryTillCurrentMonthPrevious());
	    	         cell=row.createCell(12);
	    	         cell.setCellValue(panchveraDto.getRecoveryTillCurrentMonthCurrent());
	    	         cell=row.createCell(13);
	    	         cell.setCellValue(panchveraDto.getRecoveryLeftAtTheEndMonthTotal());
	    	         cell=row.createCell(14);
	    	         cell.setCellValue(panchveraDto.getTotalRecoveryPrevious());
	    	         cell=row.createCell(15);
	    	         cell.setCellValue(panchveraDto.getTotalRecoveryCurrent());
	    	         cell=row.createCell(16);
	    	         cell.setCellValue(panchveraDto.getTotalRecoveryTotal());
	    	         cell=row.createCell(17);
	    	         cell.setCellValue(panchveraDto.getRecoveryTillCurrentMonthPrevious());
	    	         cell=row.createCell(18);
	    	         cell.setCellValue(panchveraDto.getRecoveryTillCurrentMonthCurrent());
	    	         cell=row.createCell(19);
	    	         cell.setCellValue(panchveraDto.getRecoveryTillCurrentMonthTotal());
	    	         cell=row.createCell(20);
	    	         cell.setCellValue(panchveraDto.getPercentage());
	    	         cell=row.createCell(21);
	    	         

	    	         
	    	         
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
