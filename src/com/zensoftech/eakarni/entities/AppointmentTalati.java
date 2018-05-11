package com.zensoftech.eakarni.entities;

import java.time.LocalDate;

public class AppointmentTalati {

	private int id=0;
	private int appointmentLetterNo=0;
	private boolean appointmentType;
	private LocalDate startDate;
	private LocalDate endDate;
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	Village village;
	User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAppointmentLetterNo() {
		return appointmentLetterNo;
	}
	public void setAppointmentLetterNo(int appointmentLetterNo) {
		this.appointmentLetterNo = appointmentLetterNo;
	}
	
	
	
	public String toString(){
		return "\nuser id:"+this.getUser()+ 
				"\n user details:"+this.getUser().getLoginId()+
				"\nvillage id:"+this.getVillage().getvId() +
				"village name:"+this.getVillage().getName() +"join date:"+this.getStartDate() +"leave date:"
				+this.getEndDate() + "type:"+this.isAppointmentType() + "letter no:"+this.getAppointmentLetterNo();
	}
	public boolean isAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(boolean appointmentType) {
		this.appointmentType = appointmentType;
	}
	
}
