package com.zensoftech.eakarni.entities;
import java.time.LocalDate;
import java.time.YearMonth;

public class SMB
{
	private int id=0;
	private YearMonth yearmonth;
	private int totalFamilies=0;
	private int familiesHavingLavatories=0;
	private int familiesNotHavingLavatories=0;
	private int lavatoriesMadeDuringWeek=0;
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

	public SMB()
	{}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String toString()
	{
		return "village :"+this.getVillage().getId()+"\tyearmonth:"+this.getYearmonth()+"families having lavatories:"+this.getFamiliesHavingLavatories()+
				"total families:"+this.getTotalFamilies()+"families not having lavatories:"+this.getFamiliesNotHavingLavatories()+
				"lavatories made during the week:"+this.getLavatoriesMadeDuringWeek();
	}
	
	

}
