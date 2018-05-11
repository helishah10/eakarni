package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class Finance14Dto
{
	/*private int id=0;*/
	private int month; 
	private int year;
	private int totalWork=0;
	private int worksApproved=0;
	private int projectNotStarted=0;
	private int progress=0;
	private int completed=0;;
	private double grantAllocated=0.0;
	private double amountSpent=0.0;
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

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public int getTotalWork() {
		return totalWork;
	}

	public void setTotalWork(int totalWork) {
		this.totalWork = totalWork;
	}

	
	
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	

	public double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}

	public int getWorksApproved() {
		return worksApproved;
	}

	public void setWorksApproved(int worksApproved) {
		this.worksApproved = worksApproved;
	}

	public int getProjectNotStarted() {
		return projectNotStarted;
	}

	public void setProjectNotStarted(int projectNotStarted) {
		this.projectNotStarted = projectNotStarted;
	}

	public double getGrantAllocated() {
		return grantAllocated;
	}

	public void setGrantAllocated(double grantAllocated) {
		this.grantAllocated = grantAllocated;
	}


	public int getVillageId() {
		return villageId;
	}
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}
	

}
