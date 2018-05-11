package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;

public interface TalatiJaminMehsulManager {

	public JaminMehsulVeraVasulat addEntry(JaminMehsulVeraVasulat jamin,int villageId);
	public JaminMehsulVeraVasulat getJaminMehsulVeraVasulatDetailsByMonth(int villageId,YearMonth yearmonth);
	public JaminMehsulVeraVasulat updateJaminMehsulVeraVasulat(JaminMehsulVeraVasulat jamin,int villageId,YearMonth yearmonth);
}
