package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class GPAuditPeraDto
{
	private int id=0;
	private int month; 
	private int year;
	private int yearOfRegisteration=0;
	private int totalPera=0;
	private int totalPeraAnsweredThisWeek=0;
	private int peraNotanswered=0;
	private LocalDate entryDate;
	private int villageId;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	public int getVillageId() {
		return villageId;
	}
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}

	
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


}
