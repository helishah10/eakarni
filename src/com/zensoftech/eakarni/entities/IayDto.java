package com.zensoftech.eakarni.entities;

import java.time.LocalDate;


public class IayDto {
	private int id=0;
	private int year;
	private int month;
	private int target=0;
	private double firstInstallment=0.00;
	private double secondInstallment=0.00;
	private double thirdInstallment=0.00;
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
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public double getFirstInstallment() {
		return firstInstallment;
	}
	public void setFirstInstallment(double firstInstallment) {
		this.firstInstallment = firstInstallment;
	}
	public double getSecondInstallment() {
		return secondInstallment;
	}
	public void setSecondInstallment(double secondInstallment) {
		this.secondInstallment = secondInstallment;
	}
	public double getThirdInstallment() {
		return thirdInstallment;
	}
	public void setThirdInstallment(double thirdInstallment) {
		this.thirdInstallment = thirdInstallment;
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
