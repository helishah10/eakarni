package com.zensoftech.eakarni.DAO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zensoftech.eakarni.entities.CdpDto;
import com.zensoftech.eakarni.entities.EgramDto;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class EgramReportDaoImpl {
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
   
    
    public EgramReportDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	EgramReportDaoImpl.driverName = driverName;
    	EgramReportDaoImpl.databaseUrl = databaseUrl;
    	EgramReportDaoImpl.databaseUsername = databaseUsername;
    	EgramReportDaoImpl.databasePassword = databasePassword;
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
	
	public  FileOutputStream  generateEgramReport(List<EgramDto> egramDtoList,String fileName) throws IOException, ClassNotFoundException, SQLException {

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
	    	      cell.setCellValue("birth certificate copy");
	    	      cell=row.createCell(5);
	    	      cell.setCellValue("birth certiifcate income");
	    	      cell=row.createCell(6);
	    	      cell.setCellValue("death certificate copy");
	    	      cell=row.createCell(7);
	    	      cell.setCellValue("death certificate income");
	    	      cell=row.createCell(8);
	    	      cell.setCellValue("character certificate copy");
	    	      cell=row.createCell(9);
	    	      cell.setCellValue("character certificate income");
	    	      cell=row.createCell(10);
	    	      cell.setCellValue("caste certificate copy");
	    	      cell=row.createCell(11);
	    	      cell.setCellValue("caste certificate income");
	    	      cell=row.createCell(12);
	    	      cell.setCellValue("income certificate copy");
	    	      cell=row.createCell(13);
	    	      cell.setCellValue("income certificate income");
	    	      cell=row.createCell(14);
	    	      cell.setCellValue("7 12 8acopy");
	    	      cell=row.createCell(15);
	    	      cell.setCellValue("7 12 8a income");
	    	      cell=row.createCell(16);
	    	      cell.setCellValue("mgvcl bill");
	    	      cell=row.createCell(17);
	    	      cell.setCellValue("mgvcl income");
	    	      cell=row.createCell(18);
	    	      cell.setCellValue("badea entry");
	    	      cell=row.createCell(19);
	    	      cell.setCellValue("badea income");
	    	      cell=row.createCell(20);
	    	      cell.setCellValue("farmer application");
	    	      cell=row.createCell(21);
	    	      cell.setCellValue("farmer income");
	    	      cell=row.createCell(22);
	    	      cell.setCellValue("gspc bill");
	    	      cell=row.createCell(23);
	    	      cell.setCellValue("gspc income");
	    	      cell=row.createCell(24);
	    	      cell.setCellValue("csc service");
	    	      cell=row.createCell(25);
	    	      cell.setCellValue("csc income");
	    	      cell=row.createCell(26);
	    	      cell.setCellValue("other service");
	    	      cell=row.createCell(15);
	    	      cell.setCellValue("other income");
	    	      
	    	     /* cell=row.createCell(11);
	    	      cell.setCellValue("entry date");*/
	    	     
	    	      int i=2;
	    	      for(EgramDto egramDto:egramDtoList)
//	    	      while(resultSet.next())
	    	      {
	    	         row=spreadsheet.createRow(i);
	    	        /* row1=spreadsheet.createRow(i+1);*/
	    	         cell=row.createCell(1);
	    	         cell.setCellValue(egramDto.getVillageId());
	    	         cell=row.createCell(2);
	    	         cell.setCellValue(egramDto.getMonth());
	    	         cell=row.createCell(3);
	    	         cell.setCellValue(egramDto.getYear());
//	    	       /*  spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 4, 4));*/
	    	         cell=row.createCell(4);
	    	         cell.setCellValue(egramDto.getBirthCertificateCopy());
	    	         cell=row.createCell(5);
	    	         cell.setCellValue(egramDto.getBirthCertificateIncome());
	    	         cell=row.createCell(6);
	    	         cell.setCellValue(egramDto.getDeathCertificateCopy());
	    	         cell=row.createCell(7);
	    	         cell.setCellValue(egramDto.getDeathCertificateIncome());
	    	         cell=row.createCell(8);
	    	         cell.setCellValue(egramDto.getCharacterCertificateCopy());
	    	         cell=row.createCell(9);
	    	         cell.setCellValue(egramDto.getCharacterCertificateIncome());
	    	         cell=row.createCell(10);
	    	         cell.setCellValue(egramDto.getCasteCertificateCopy());
	    	         cell=row.createCell(11);
	    	         cell.setCellValue(egramDto.getCasteCertificateIncome());
	    	         cell=row.createCell(12);
	    	         cell.setCellValue(egramDto.getIncomeCertificateCopy());
	    	         cell=row.createCell(13);
	    	         cell.setCellValue(egramDto.getIncomeCertificateIncome());
	    	         cell=row.createCell(14);
	    	         cell.setCellValue(egramDto.getCopyOf7128A());
	    	         cell=row.createCell(15);
	    	         cell.setCellValue(egramDto.getIncomeOf7128A());
	    	         cell=row.createCell(16);
	    	         cell.setCellValue(egramDto.getMGVCLbill());
	    	         cell=row.createCell(17);
	    	         cell.setCellValue(egramDto.getMGVCLIncome());
	    	         cell=row.createCell(18);
	    	         cell.setCellValue(egramDto.getBADEAEntry());
	    	         cell=row.createCell(19);
	    	         cell.setCellValue(egramDto.getBADEAIncome());
	    	         cell=row.createCell(20);
	    	         cell.setCellValue(egramDto.getFarmerApplication());
	    	         cell=row.createCell(21);
	    	         cell.setCellValue(egramDto.getFarmerIncome());
	    	         cell=row.createCell(22);
	    	         cell.setCellValue(egramDto.getGSPCBill());
	    	         cell=row.createCell(23);
	    	         cell.setCellValue(egramDto.getGSPCIncome());
	    	         cell=row.createCell(24);
	    	         cell.setCellValue(egramDto.getCSCService());
	    	         cell=row.createCell(25);
	    	         cell.setCellValue(egramDto.getCSCIncome());
	    	         cell=row.createCell(26);
	    	         cell.setCellValue(egramDto.getOtherService());
	    	         cell=row.createCell(27);
	    	         cell.setCellValue(egramDto.getOtherIncome());
	    	         
	    	         
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
