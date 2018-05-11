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
import com.zensoftech.eakarni.entities.GramswagatDto;

public class GramswagatReportDaoImpl {
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
   
    
    public GramswagatReportDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	GramswagatReportDaoImpl.driverName = driverName;
    	GramswagatReportDaoImpl.databaseUrl = databaseUrl;
    	GramswagatReportDaoImpl.databaseUsername = databaseUsername;
    	GramswagatReportDaoImpl.databasePassword = databasePassword;
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
	
	public  FileOutputStream  generateGramswagatReport(List<GramswagatDto> gramswagatDtoList,String fileName) throws IOException, ClassNotFoundException, SQLException {

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
	    	      cell.setCellValue("description of questions raised");
	    	      cell=row.createCell(5);
	    	      cell.setCellValue("disposal");
	    	      cell=row.createCell(6);
	    	      cell.setCellValue("pending");
	    	      
	    	     
	    	      int i=2;
	    	      for(GramswagatDto gramswagatDto:gramswagatDtoList)
//	    	      while(resultSet.next())
	    	      {
	    	         row=spreadsheet.createRow(i);
	    	        /* row1=spreadsheet.createRow(i+1);*/
	    	         cell=row.createCell(1);
	    	         cell.setCellValue(gramswagatDto.getVillageid());
	    	         cell=row.createCell(2);
	    	         cell.setCellValue(gramswagatDto.getMonth());
	    	         cell=row.createCell(3);
	    	         cell.setCellValue(gramswagatDto.getYear());
//	    	       /*  spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 4, 4));*/
	    	         cell=row.createCell(4);
	    	         cell.setCellValue(gramswagatDto.getDescriptionOfQuestionsRaised());
	    	         cell=row.createCell(5);
	    	         cell.setCellValue(gramswagatDto.getDisposal());
	    	         cell=row.createCell(6);
	    	         cell.setCellValue(gramswagatDto.getPending());
	    	         
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
