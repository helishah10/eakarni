package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class Egram 
{
	private int id=0;
	private YearMonth yearmonth;
	private int birthCertificateCopy=0;
	private double birthCertificateIncome=0;
	private int deathCertificateCopy=0;
	private double deathCertificateIncome=0;
	private int incomeCertificateCopy=0;
	private double incomeCertificateIncome=0;
	private int copyOf7128A=0;
	private double incomeOf7128A=0;;
	private int MGVCLbill=0;
	private double MGVCLIncome=0.0;
	private int BADEAEntry=0;
	private double BADEAIncome=0.0;
	private int farmerApplication=0;
	private double farmerIncome=0.0;
	private int GSPCBill=0;
	private double GSPCIncome=0.0;
	private double CSCIncome=0.0;
	private int CSCService=0;
	private int otherService=0;
	private double otherIncome=0.0;
	private LocalDate entryDate;
	private int casteCertificateCopy=0;
	private double casteCertificateIncome=0.0;
	private int characterCertificateCopy=0;
	private double characterCertificateIncome=0.0;
	
	public YearMonth getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(YearMonth yearmonth) {
		this.yearmonth = yearmonth;
	}

	public int getMGVCLbill() {
		return MGVCLbill;
	}
	public void setMGVCLbill(int mGVCLbill) {
		MGVCLbill = mGVCLbill;
	}
	public double getMGVCLIncome() {
		return MGVCLIncome;
	}
	public void setMGVCLIncome(double mGVCLIncome) {
		MGVCLIncome = mGVCLIncome;
	}
	public int getCasteCertificateCopy() {
		return casteCertificateCopy;
	}
	public void setCasteCertificateCopy(int casteCertificateCopy) {
		this.casteCertificateCopy = casteCertificateCopy;
	}
	public double getCasteCertificateIncome() {
		return casteCertificateIncome;
	}
	public void setCasteCertificateIncome(double casteCertificateIncome) {
		this.casteCertificateIncome = casteCertificateIncome;
	}
	public int getCharacterCertificateCopy() {
		return characterCertificateCopy;
	}
	public void setCharacterCertificateCopy(int characterCertificateCopy) {
		this.characterCertificateCopy = characterCertificateCopy;
	}
	public double getCharacterCertificateIncome() {
		return characterCertificateIncome;
	}
	public void setCharacterCertificateIncome(double characterCertificateIncome) {
		this.characterCertificateIncome = characterCertificateIncome;
	}

	Village village;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBirthCertificateCopy() {
		return birthCertificateCopy;
	}
	public void setBirthCertificateCopy(int birthCertificateCopy) {
		this.birthCertificateCopy = birthCertificateCopy;
	}
	public double getBirthCertificateIncome() {
		return birthCertificateIncome;
	}
	public void setBirthCertificateIncome(double birthCertificateIncome) {
		this.birthCertificateIncome = birthCertificateIncome;
	}
	public int getDeathCertificateCopy() {
		return deathCertificateCopy;
	}
	public void setDeathCertificateCopy(int deathCertificateCopy) {
		this.deathCertificateCopy = deathCertificateCopy;
	}
	public double getDeathCertificateIncome() {
		return deathCertificateIncome;
	}
	public void setDeathCertificateIncome(double deathCertificateIncome) {
		this.deathCertificateIncome = deathCertificateIncome;
	}
	public int getIncomeCertifiacteCopy() {
		return incomeCertificateCopy;
	}
	public void setIncomeCertifiacteCopy(int incomeCertifiacteCopy) {
		this.incomeCertificateCopy = incomeCertifiacteCopy;
	}
	public double getIncomeCertificateIncome() {
		return incomeCertificateIncome;
	}
	public void setIncomeCertificateIncome(double incomeCertificateIncome) {
		this.incomeCertificateIncome = incomeCertificateIncome;
	}
	public int getCopyOf7128A() {
		return copyOf7128A;
	}
	public void setCopyOf7128A(int copyOf7128A) {
		this.copyOf7128A = copyOf7128A;
	}
	public double getIncomeOf7128A() {
		return incomeOf7128A;
	}
	public void setIncomeOf7128A(double incomeOf7128A) {
		this.incomeOf7128A = incomeOf7128A;
	}
	
	public int getBADEAEntry() {
		return BADEAEntry;
	}
	public void setBADEAEntry(int bADEAEntry) {
		BADEAEntry = bADEAEntry;
	}
	public double getBADEAIncome() {
		return BADEAIncome;
	}
	public void setBADEAIncome(double bADEAIncome) {
		BADEAIncome = bADEAIncome;
	}
	public int getFarmerApplication() {
		return farmerApplication;
	}
	public void setFarmerApplication(int farmerApplication) {
		this.farmerApplication = farmerApplication;
	}
	public double getFarmerIncome() {
		return farmerIncome;
	}
	public void setFarmerIncome(double farmerIncome) {
		this.farmerIncome = farmerIncome;
	}
	public int getGSPCBill() {
		return GSPCBill;
	}
	public void setGSPCBill(int gSPCBill) {
		GSPCBill = gSPCBill;
	}
	public double getGSPCIncome() {
		return GSPCIncome;
	}
	public void setGSPCIncome(double gSPCIncome) {
		GSPCIncome = gSPCIncome;
	}
	public double getCSCIncome() {
		return CSCIncome;
	}
	public void setCSCIncome(double cSCIncome) {
		CSCIncome = cSCIncome;
	}
	public int getCSCService() {
		return CSCService;
	}
	public void setCSCService(int cSCService) {
		CSCService = cSCService;
	}
	public int getOtherService() {
		return otherService;
	}
	public void setOtherService(int otherService) {
		this.otherService = otherService;
	}
	public double getOtherIncome() {
		return otherIncome;
	}
	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
	}
	public int getIncomeCertificateCopy() {
		return incomeCertificateCopy;
	}
	public void setIncomeCertificateCopy(int incomeCertificateCopy) {
		this.incomeCertificateCopy = incomeCertificateCopy;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	
	public String toString()
	{
		return "village id:"+this.getVillage().getvId()+"\tyearmonth:"+this.getYearmonth()+"birth certiificate copy:"+this.getBirthCertificateCopy()+
				"birth certificate income:"+this.getBirthCertificateIncome()+"death certiifcat copy:"+this.getDeathCertificateCopy()+
			"death certificate income:"+this.getDeathCertificateIncome()+"income certi income:"+this.getIncomeCertificateIncome()+
			"income certificate copy:"+this.getIncomeCertifiacteCopy()+"copy of 7_12:"+this.getCopyOf7128A()+"income of 7_12"+this.getIncomeOf7128A()+
			"hgvcl bill"+this.getMGVCLbill()+"hgvcl income"+this.getMGVCLIncome()+"badea entry:"+this.getBADEAEntry()+"badea income:"+
			this.getBADEAIncome()+"farmer apll:"+this.getFarmerApplication()+"farmer income:"+this.getFarmerIncome()+"gspc bill:"+
			this.getGSPCBill()+"gspc income:"+this.getGSPCIncome()+"csc service:"+this.getCSCService()+"csc income:"+this.getCSCIncome()
			+"other income:"+this.getOtherIncome()+"other service:"+this.getOtherService()+"entry date:"+this.getEntryDate();
				
	}
	
}
