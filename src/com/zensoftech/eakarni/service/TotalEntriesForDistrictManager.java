package com.zensoftech.eakarni.service;

public interface TotalEntriesForDistrictManager {
	
	public int getCdpTotalCount(int districtId);
	public int getEgramTotalCount(int districtId);
	public int getFinanceTotalCount(int districtId);
	public int getGpperaTotalCount(int districtId);
	public int getGramswagatTotalCount(int districtId);
	public int getHsgTotalCount(int districtId);
	public int getIayTotalCount(int districtId);
	public int getJaminMehsulTotalCount(int districtId);
	public int getSmbTotalCount(int districtId);
	public int getPanchveraTotalCount(int districtId);

}
