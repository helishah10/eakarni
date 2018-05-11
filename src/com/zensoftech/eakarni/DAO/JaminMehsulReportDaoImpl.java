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
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulatDto;

public class JaminMehsulReportDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
   
    
    public JaminMehsulReportDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	JaminMehsulReportDaoImpl.driverName = driverName;
    	JaminMehsulReportDaoImpl.databaseUrl = databaseUrl;
    	JaminMehsulReportDaoImpl.databaseUsername = databaseUsername;
    	JaminMehsulReportDaoImpl.databasePassword = databasePassword;
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
	
	public  FileOutputStream  generateJaminMehsulReport(List<JaminMehsulVeraVasulatDto> jaminmehsulDtoList,String fileName) throws IOException, ClassNotFoundException, SQLException {

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
	    	      cell.setCellValue("land reveneue");
	    	      cell=row.createCell(5);
	    	      cell.setCellValue("total amount seeking");
	    	      cell=row.createCell(6);
	    	      cell.setCellValue("amount collected during month");
	    	      cell=row.createCell(7);
	    	      cell.setCellValue("amount left");
	    	      cell=row.createCell(8);
	    	      cell.setCellValue("percentage");
	    	      
	    	     
	    	      int i=2;
	    	      for(JaminMehsulVeraVasulatDto jaminDto:jaminmehsulDtoList)
//	    	      while(resultSet.next())
	    	      {
	    	         row=spreadsheet.createRow(i);
	    	        /* row1=spreadsheet.createRow(i+1);*/
	    	         cell=row.createCell(1);
	    	         cell.setCellValue(jaminDto.getVillageId());
	    	         cell=row.createCell(2);
	    	         cell.setCellValue(jaminDto.getMonth());
	    	         cell=row.createCell(3);
	    	         cell.setCellValue(jaminDto.getYear());
	    	         cell=row.createCell(4);
	    	         cell.setCellValue(jaminDto.getLandRevenue());
	    	         cell=row.createCell(5);
	    	         cell.setCellValue(jaminDto.getTotalAmountSeeking());
	    	         cell=row.createCell(6);
	    	         cell.setCellValue(jaminDto.getAmountCollectedDuringMonth());
	    	         cell=row.createCell(7);
	    	         cell.setCellValue(jaminDto.getAmountLeft());
	    	         cell=row.createCell(8);
	    	         cell.setCellValue(jaminDto.getPercentage());
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
