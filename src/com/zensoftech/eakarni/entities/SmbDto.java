package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class SmbDto {
	private int id=0;
	private int year=0;
	private int month=0;
	private int totalFamilies=0;
	private int familiesHavingLavatories=0;
	private int familiesNotHavingLavatories=0;
	private int lavatoriesMadeDuringWeek=0;
	private LocalDate entryDate;
	private int villageId=0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getTotalFamilies() {
		return totalFamilies;
	}
	public void setTotalFamilies(int totalFamilies) {
		this.totalFamilies = totalFamilies;
	}
	public int getFamiliesHavingLavatories() {
		return familiesHavingLavatories;
	}
	public void setFamiliesHavingLavatories(int familiesHavingLavatories) {
		this.familiesHavingLavatories = familiesHavingLavatories;
	}
	public int getFamiliesNotHavingLavatories() {
		return familiesNotHavingLavatories;
	}
	public void setFamiliesNotHavingLavatories(int familiesNotHavingLavatories) {
		this.familiesNotHavingLavatories = familiesNotHavingLavatories;
	}
	public int getLavatoriesMadeDuringWeek() {
		return lavatoriesMadeDuringWeek;
	}
	public void setLavatoriesMadeDuringWeek(int lavatoriesMadeDuringWeek) {
		this.lavatoriesMadeDuringWeek = lavatoriesMadeDuringWeek;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	public int getVillageId() {
		return villageId;
	}
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}
	
	
	

}
