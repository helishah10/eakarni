package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.User.Usertype;
import com.zensoftech.eakarni.entities.Village;


public class DemoAppointment {
	public static void main(String args[]) throws NumberFormatException, IOException 
	{
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
		String user="eakarni";
		String password="eakarni";
		
		/*AppointmentDao dao=new AppointmentDaoImpl(driver,url,user,password);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the taluka id");
		int talukaId=Integer.parseInt(br.readLine());
		*/
		StateDao sdao=new StateDaoImpl(driver,url,user,password);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the village id");
		int villageId=Integer.parseInt(br.readLine());
		Village village=sdao.getVillage(villageId);
		System.out.println(village);
		
		//dao.get
		/*AppointmentTalati talati=new AppointmentTalati();
		talati=dao.getVillage(loginId);
		System.out.println(talati);*/
		
		//br=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("enter the loginId");
		//loginId=br.readLine();
		/*AppointmentTdo tdo=new AppointmentTdo();
		tdo=dao.getTaluka(loginId);
		System.out.println(tdo);
		*/
		//br=new BufferedReader(new InputStreamReader(System.in));
		///System.out.println("enter the loginId");
		//loginId=br.readLine();
		/*AppointmentDdo ddo=new AppointmentDdo();
		ddo=dao.getDistrict(loginId);
		System.out.println(ddo);*/
		
		//Taluka taluka=new Taluka();
		//Village village=new Village();
		//String village=appointmentDao.getVillageName(loginId);
		//System.out.println("village name:"+village);
		/*System.out.println("enter the district id:");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int districtId=Integer.parseInt(br.readLine());
		appointmentDao.getAllddo(districtId);
		
		for(AppointmentDdo ddo:appointmentDao.getAllddo(districtId) )
		{
			System.out.println("distict:"+ddo.getDistrict().getId());
			System.out.println("join date:"+ddo.getJoinDate()+"\t leave date:"+ddo.getLeaveDate()+"\t appointment type:"+ddo.getAppointmentType()+"\t letter no:"+ddo.getAppointmentLetterNo());

		}
		
		System.out.println("enter the taluka id:");
		BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
		int talukaId=Integer.parseInt(br2.readLine());
		appointmentDao.getAllTdo(talukaId);
		
		for(AppointmentTdo taluka:appointmentDao.getAllTdo(talukaId))
		{
			System.out.println("taluka:"+taluka.getTaluka().getId());
			System.out.println("join date:"+taluka.getJoinDate()+"\t leave date:"+taluka.getLeaveDate()+"\t appointment type:"+taluka.getAppointmentType()+"\t letter no:"+taluka.getAppointmentLetterNo());
		}
		
		System.out.println("enter the village id:");
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		int villageId=Integer.parseInt(br1.readLine());
		appointmentDao.getAllTalati(villageId);
		
		for(AppointmentTalati village:appointmentDao.getAllTalati(villageId))
		{
			System.out.println("village:"+village.getVillage().getId());

			System.out.println("join date:"+village.getJoinDate()+"\tleave date:"+village.getLeaveDate()+"\tappointment type:"+village.getAppointmentType()+"\t letter no:"+village.getAppointmentLetterNo());
		}*/
		
		/*System.out.println("entering a tdo:");
		AppointmentTdo tdo=new AppointmentTdo();
		BufferedReader br12=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the talukaId to add the tdo to:");
		int talukaId=Integer.parseInt(br12.readLine());
		
		System.out.println("enter the user id :");
		String userId=br12.readLine();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		System.out.println("enter join date(dd-mm-yyyy): ");
		LocalDate joinDate=LocalDate.parse(br12.readLine(), dtf);
		System.out.println("enter leave date(dd-mm-yyyy): ");
		LocalDate leaveDate=LocalDate.parse(br12.readLine(), dtf);
		System.out.println("enter type of appointment:");
		int appointmentType=Integer.parseInt(br12.readLine());
		System.out.println("enter appointment letter number:");
		int appointmentLetterNo=Integer.parseInt(br12.readLine());
		
		tdo.setJoinDate(joinDate);
		tdo.setLeaveDate(leaveDate);
		tdo.setAppointmentType(appointmentType);
		tdo.setAppointmentLetterNo(appointmentLetterNo);
		appointmentDao.insertTdo(talukaId,userId,tdo);*/
		
		/*System.out.println("updating tdo details:");
		AppointmentTdo tdo1=new AppointmentTdo();
		BufferedReader br13=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the taluka id to update the details to:");
		int talukaId=Integer.parseInt(br13.readLine());
		
		System.out.println("enter the user id:");
		String userId=br13.readLine();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("enter join date(dd-mm-yyyy): ");
		LocalDate joinDate=LocalDate.parse(br13.readLine(), dtf);
		System.out.println("enter leave date(dd-mm-yyyy): ");
		LocalDate leaveDate=LocalDate.parse(br13.readLine(), dtf);
		System.out.println("enter type of appointment:");
		int appointmentType=Integer.parseInt(br13.readLine());
		System.out.println("enter appointment letter number:");
		int appointmentLetterNo=Integer.parseInt(br13.readLine());
		
		tdo1.setJoinDate(joinDate);
		tdo1.setLeaveDate(leaveDate);
		tdo1.setAppointmentType(appointmentType);
		tdo1.setAppointmentLetterNo(appointmentLetterNo);
		appointmentDao.updateTdoDetails(talukaId, userId, tdo1);*/
		
		/*System.out.println("entering a ddo:");
		AppointmentDdo ddo=new AppointmentDdo();
		BufferedReader br12=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the district Id to add the ddo to:");
		int districtId=Integer.parseInt(br12.readLine());
		
		System.out.println("enter the user id :");
		String userId=br12.readLine();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		System.out.println("enter join date(dd-mm-yyyy): ");
		LocalDate joinDate=LocalDate.parse(br12.readLine(), dtf);
		System.out.println("enter leave date(dd-mm-yyyy): ");
		LocalDate leaveDate=LocalDate.parse(br12.readLine(), dtf);
		System.out.println("enter type of appointment:");
		int appointmentType=Integer.parseInt(br12.readLine());
		System.out.println("enter appointment letter number:");
		int appointmentLetterNo=Integer.parseInt(br12.readLine());
		
		ddo.setJoinDate(joinDate);
		ddo.setLeaveDate(leaveDate);
		ddo.setAppointmentType(appointmentType);
		ddo.setAppointmentLetterNo(appointmentLetterNo);
		appointmentDao.insertDdo(districtId,userId,ddo);
		
		System.out.println("entering a TALATI:");
		AppointmentTalati talati=new AppointmentTalati();
		BufferedReader br31=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the village Id to add the talati to:");
		int villageId=Integer.parseInt(br12.readLine());
		
		System.out.println("enter the user id :");
		String userid=br31.readLine();
		
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		System.out.println("enter join date(dd-mm-yyyy): ");
		 joinDate=LocalDate.parse(br12.readLine(), dtf);
		System.out.println("enter leave date(dd-mm-yyyy): ");
		leaveDate=LocalDate.parse(br12.readLine(), dtf);
		System.out.println("enter type of appointment:");
		appointmentType=Integer.parseInt(br12.readLine());
		System.out.println("enter appointment letter number:");
		appointmentLetterNo=Integer.parseInt(br12.readLine());
		
		talati.setJoinDate(joinDate);
		talati.setLeaveDate(leaveDate);
		talati.setAppointmentType(appointmentType);
		talati.setAppointmentLetterNo(appointmentLetterNo);
		appointmentDao.insertTalati(villageId,userId,talati);
		
		System.out.println("updating ddo details:");
		AppointmentDdo ddo1=new AppointmentDdo();
		BufferedReader br13=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the distrcit id to update the details to:");
		int distrcitId=Integer.parseInt(br13.readLine());
		
		System.out.println("enter the user id:");
		userId=br13.readLine();
		
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("enter join date(dd-mm-yyyy): ");
		joinDate=LocalDate.parse(br13.readLine(), dtf);
		System.out.println("enter leave date(dd-mm-yyyy): ");
		 leaveDate=LocalDate.parse(br13.readLine(), dtf);
		System.out.println("enter type of appointment:");
		appointmentType=Integer.parseInt(br13.readLine());
		System.out.println("enter appointment letter number:");
		appointmentLetterNo=Integer.parseInt(br13.readLine());
		
		ddo1.setJoinDate(joinDate);
		ddo1.setLeaveDate(leaveDate);
		ddo1.setAppointmentType(appointmentType);
		ddo1.setAppointmentLetterNo(appointmentLetterNo);
		appointmentDao.updateDdoDetails(districtId, userId, ddo1);
		
		/*System.out.println("updating talati details:");
		AppointmentTalati talati=new AppointmentTalati();
		BufferedReader br13=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the village id to update the details to:");
		int villageId=Integer.parseInt(br13.readLine());
		
		System.out.println("enter the user id:");
		String userId=br13.readLine();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("enter join date(dd-mm-yyyy): ");
		LocalDate joinDate=LocalDate.parse(br13.readLine(), dtf);
		System.out.println("enter leave date(dd-mm-yyyy): ");
		LocalDate leaveDate=LocalDate.parse(br13.readLine(), dtf);
		System.out.println("enter type of appointment:");
		int appointmentType=Integer.parseInt(br13.readLine());
		System.out.println("enter appointment letter number:");
		int appointmentLetterNo=Integer.parseInt(br13.readLine());
		
		talati.setJoinDate(joinDate);
		talati.setLeaveDate(leaveDate);
		talati.setAppointmentType(appointmentType);
		talati.setAppointmentLetterNo(appointmentLetterNo);
		appointmentDao.updateTalatiDetails(villageId, userId, talati);*/


	}

}
