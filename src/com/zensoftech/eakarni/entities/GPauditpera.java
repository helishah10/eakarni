package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class GPauditpera
{
	private int id=0;
	private YearMonth yearmonth;
	private int yearOfRegisteration=0;
	private int totalPera=0;
	private int totalPeraAnsweredThisWeek=0;
	private int peraNotanswered=0;
	private LocalDate entryDate;
	Village village;
	
	public YearMonth getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(YearMonth yearmonth) {
		this.yearmonth = yearmonth;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public GPauditpera()
	{}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getTotalPera() {
		return totalPera;
	}
	public void setTotalPera(int totalPera) {
		this.totalPera = totalPera;
	}
	public int getTotalPeraAnsweredThisWeek() {
		return totalPeraAnsweredThisWeek;
	}
	public void setTotalPeraAnsweredThisWeek(int totalPeraAnsweredThisWeek) {
		this.totalPeraAnsweredThisWeek = totalPeraAnsweredThisWeek;
	}
	public int getPeraNotanswered() {
		return peraNotanswered;
	}
	public void setPeraNotanswered(int peraNotanswered) {
		this.peraNotanswered = peraNotanswered;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	
	public int getYearOfRegisteration() {
		return yearOfRegisteration;
	}
	public void setYearOfRegisteration(int yearOfRegisteration) {
		this.yearOfRegisteration = yearOfRegisteration;
	}

	
	public String toString()
	{
		return "\tyearmonth:"+this.getYearmonth()+ "year of registration : " +this.getYearOfRegisteration() +
				"total pera : " +this.getTotalPera() + "total pera answered : " +this.getTotalPeraAnsweredThisWeek() + "pera not answered : "
				+this.getPeraNotanswered();
	}

}
