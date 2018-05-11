package com.zensoftech.eakarni.entities;

import java.time.LocalDate;

public class AppointmentDdo 
{
	private  int id=0;
	private boolean appointmentType;
	private int appointmentLetterNo=0;
	private  LocalDate startDate;
	private LocalDate leaveDate;
	User user;
	District district;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(LocalDate leaveDate) {
		this.leaveDate = leaveDate;
	}
	public int getAppointmentLetterNo() {
		return appointmentLetterNo;
	}
	public void setAppointmentLetterNo(int appointmentLetterNo) {
		this.appointmentLetterNo = appointmentLetterNo;
	}
	
	public String toString(){
		return "\nuser id:"+this.getUser().getId() + "district id:"+this.getDistrict().getId() +"district name:"+
				this.getDistrict().getName() +"join date:"+this.getStartDate() +"leave date:"
				+this.getLeaveDate() + "type:"+this.isAppointmentType() + "letter no:"+this.getAppointmentLetterNo();
	}
	public boolean isAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(boolean appointmentType) {
		this.appointmentType = appointmentType;
	}
	

}
