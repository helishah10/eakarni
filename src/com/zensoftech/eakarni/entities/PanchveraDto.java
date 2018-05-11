package com.zensoftech.eakarni.entities;

import java.time.LocalDate;

public class PanchveraDto {
	
	private int year;
	private int month;
	private int villageId;
	private LocalDate entryDate;
	private int taxtype;
	private double seekingPreviousAmountLeft=0.0;
	private double seekingCurrentAmount=0.0;
	private double seekingTotalAmount=0.0;
	private double recoveryTillPreviousMonthCurrent=0.0;
	private double recoveryTillPreviousMonthPrevious=0.0;
	private double recoveryTillPreviousMonthTotal=0.0;
	private double recoveryTillCurrentMonthCurrent=0.0;
	private double recoveryTillCurrentMonthPrevious=0.0;
	private double recoveryTillCurrentMonthTotal=0.0;
	private double totalRecoveryPrevious=0.0;
	private double totalRecoveryCurrent=0.0;
	private double totalRecoveryTotal=0.0;
	private double recoveryLeftAtTheEndMonthPrevious=0.0;
	private double recoveryLeftAtTheEndMonthCurrent=0.0;
	private double recoveryLeftAtTheEndMonthTotal=0.0;
	private double percentage=0.00;
	
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
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
	public int getTaxtype() {
		return taxtype;
	}
	public void setTaxtype(int taxtype) {
		this.taxtype = taxtype;
	}
	public double getSeekingPreviousAmountLeft() {
		return seekingPreviousAmountLeft;
	}
	public void setSeekingPreviousAmountLeft(double seekingPreviousAmountLeft) {
		this.seekingPreviousAmountLeft = seekingPreviousAmountLeft;
	}
	public double getSeekingCurrentAmount() {
		return seekingCurrentAmount;
	}
	public void setSeekingCurrentAmount(double seekingCurrentAmount) {
		this.seekingCurrentAmount = seekingCurrentAmount;
	}
	public double getSeekingTotalAmount() {
		return seekingTotalAmount;
	}
	public void setSeekingTotalAmount(double seekingTotalAmount) {
		this.seekingTotalAmount = seekingTotalAmount;
	}
	public double getRecoveryTillPreviousMonthCurrent() {
		return recoveryTillPreviousMonthCurrent;
	}
	public void setRecoveryTillPreviousMonthCurrent(double recoveryTillPreviousMonthCurrent) {
		this.recoveryTillPreviousMonthCurrent = recoveryTillPreviousMonthCurrent;
	}
	public double getRecoveryTillPreviousMonthPrevious() {
		return recoveryTillPreviousMonthPrevious;
	}
	public void setRecoveryTillPreviousMonthPrevious(double recoveryTillPreviousMonthPrevious) {
		this.recoveryTillPreviousMonthPrevious = recoveryTillPreviousMonthPrevious;
	}
	public double getRecoveryTillPreviousMonthTotal() {
		return recoveryTillPreviousMonthTotal;
	}
	public void setRecoveryTillPreviousMonthTotal(double recoveryTillPreviousMonthTotal) {
		this.recoveryTillPreviousMonthTotal = recoveryTillPreviousMonthTotal;
	}
	public double getRecoveryTillCurrentMonthCurrent() {
		return recoveryTillCurrentMonthCurrent;
	}
	public void setRecoveryTillCurrentMonthCurrent(double recoveryTillCurrentMonthCurrent) {
		this.recoveryTillCurrentMonthCurrent = recoveryTillCurrentMonthCurrent;
	}
	public double getRecoveryTillCurrentMonthPrevious() {
		return recoveryTillCurrentMonthPrevious;
	}
	public void setRecoveryTillCurrentMonthPrevious(double recoveryTillCurrentMonthPrevious) {
		this.recoveryTillCurrentMonthPrevious = recoveryTillCurrentMonthPrevious;
	}
	public double getRecoveryTillCurrentMonthTotal() {
		return recoveryTillCurrentMonthTotal;
	}
	public void setRecoveryTillCurrentMonthTotal(double recoveryTillCurrentMonthTotal) {
		this.recoveryTillCurrentMonthTotal = recoveryTillCurrentMonthTotal;
	}
	public double getTotalRecoveryPrevious() {
		return totalRecoveryPrevious;
	}
	public void setTotalRecoveryPrevious(double totalRecoveryPrevious) {
		this.totalRecoveryPrevious = totalRecoveryPrevious;
	}
	public double getTotalRecoveryCurrent() {
		return totalRecoveryCurrent;
	}
	public void setTotalRecoveryCurrent(double totalRecoveryCurrent) {
		this.totalRecoveryCurrent = totalRecoveryCurrent;
	}
	public double getTotalRecoveryTotal() {
		return totalRecoveryTotal;
	}
	public void setTotalRecoveryTotal(double totalRecoveryTotal) {
		this.totalRecoveryTotal = totalRecoveryTotal;
	}
	public double getRecoveryLeftAtTheEndMonthPrevious() {
		return recoveryLeftAtTheEndMonthPrevious;
	}
	public void setRecoveryLeftAtTheEndMonthPrevious(double recoveryLeftAtTheEndMonthPrevious) {
		this.recoveryLeftAtTheEndMonthPrevious = recoveryLeftAtTheEndMonthPrevious;
	}
	public double getRecoveryLeftAtTheEndMonthCurrent() {
		return recoveryLeftAtTheEndMonthCurrent;
	}
	public void setRecoveryLeftAtTheEndMonthCurrent(double recoveryLeftAtTheEndMonthCurrent) {
		this.recoveryLeftAtTheEndMonthCurrent = recoveryLeftAtTheEndMonthCurrent;
	}
	public double getRecoveryLeftAtTheEndMonthTotal() {
		return recoveryLeftAtTheEndMonthTotal;
	}
	public void setRecoveryLeftAtTheEndMonthTotal(double recoveryLeftAtTheEndMonthTotal) {
		this.recoveryLeftAtTheEndMonthTotal = recoveryLeftAtTheEndMonthTotal;
	}

}
