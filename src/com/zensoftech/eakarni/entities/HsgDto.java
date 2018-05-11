package com.zensoftech.eakarni.entities;

import java.time.LocalDate;

public class HsgDto {
	
	private int month;
	private int target=0;
	private int notStartedHouses=0;
	private int plinthLevel=0;
	private int lintalLevel=0;
	private int slabLevel=0;
	private int financeYear=0;
	private int completedHouses=0;
	private int villageId;
	private LocalDate entryDate;
	private int year;
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
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getNotStartedHouses() {
		return notStartedHouses;
	}
	public void setNotStartedHouses(int notStartedHouses) {
		this.notStartedHouses = notStartedHouses;
	}
	public int getPlinthLevel() {
		return plinthLevel;
	}
	public void setPlinthLevel(int plinthLevel) {
		this.plinthLevel = plinthLevel;
	}
	public int getLintalLevel() {
		return lintalLevel;
	}
	public void setLintalLevel(int lintalLevel) {
		this.lintalLevel = lintalLevel;
	}
	public int getSlabLevel() {
		return slabLevel;
	}
	public void setSlabLevel(int slabLevel) {
		this.slabLevel = slabLevel;
	}
	public int getFinanceYear() {
		return financeYear;
	}
	public void setFinanceYear(int financeYear) {
		this.financeYear = financeYear;
	}
	public int getCompletedHouses() {
		return completedHouses;
	}
	public void setCompletedHouses(int completedHouses) {
		this.completedHouses = completedHouses;
	}
	public int getVillageId() {
		return villageId;
	}
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	

}
