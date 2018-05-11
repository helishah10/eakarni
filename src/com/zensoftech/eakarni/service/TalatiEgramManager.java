package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.Egram;

public interface TalatiEgramManager {

	public Egram addEntry(Egram egram,int villageId);
	public Egram getEgramDetailsByMonth(int villageId,YearMonth yearmonth);
	public Egram updateEgram(Egram egram,int villageId,YearMonth yearmonth);
}
