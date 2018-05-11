package com.zensoftech.eakarni.listener;

import java.util.Locale;



import javax.servlet.ServletContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.zensoftech.eakarni.DAO.AppointmentDao;
import com.zensoftech.eakarni.DAO.AppointmentDaoImpl;
import com.zensoftech.eakarni.DAO.CdpDao;
import com.zensoftech.eakarni.DAO.CdpDaoImpl;
import com.zensoftech.eakarni.DAO.CdpReportDaoImpl;
import com.zensoftech.eakarni.DAO.EgramDao;
import com.zensoftech.eakarni.DAO.EgramDaoImpl;
import com.zensoftech.eakarni.DAO.EgramReportDaoImpl;
import com.zensoftech.eakarni.DAO.Finance14Dao;
import com.zensoftech.eakarni.DAO.Finance14DaoImpl;
import com.zensoftech.eakarni.DAO.FinanceReportDaoImpl;
import com.zensoftech.eakarni.DAO.GPauditperaReportDaoImpl;
import com.zensoftech.eakarni.DAO.GpperaDao;
import com.zensoftech.eakarni.DAO.GpperaDaoImpl;
import com.zensoftech.eakarni.DAO.GramswagatDao;
import com.zensoftech.eakarni.DAO.GramswagatDaoImpl;
import com.zensoftech.eakarni.DAO.GramswagatReportDaoImpl;
import com.zensoftech.eakarni.DAO.HsgDao;
import com.zensoftech.eakarni.DAO.HsgDaoImpl;
import com.zensoftech.eakarni.DAO.HsgReportDaoImpl;
import com.zensoftech.eakarni.DAO.IayDao;
import com.zensoftech.eakarni.DAO.IayDaoImpl;
import com.zensoftech.eakarni.DAO.IayReportDaoImpl;
import com.zensoftech.eakarni.DAO.JaminMehsulDao;
import com.zensoftech.eakarni.DAO.JaminMehsulDaoImpl;
import com.zensoftech.eakarni.DAO.JaminMehsulReportDaoImpl;
import com.zensoftech.eakarni.DAO.OccupantDaoImpl;
import com.zensoftech.eakarni.DAO.OwnerDaoImpl;
import com.zensoftech.eakarni.DAO.PanchVeraDao;
import com.zensoftech.eakarni.DAO.PanchVeraDaoImpl;
import com.zensoftech.eakarni.DAO.PanchveraReportDaoImpl;
import com.zensoftech.eakarni.DAO.PropertyDaoImpl;
import com.zensoftech.eakarni.DAO.PropertyDetailsDaoImpl;
import com.zensoftech.eakarni.DAO.PropertyTransferDaoImpl;
import com.zensoftech.eakarni.DAO.SmbDao;
import com.zensoftech.eakarni.DAO.SmbDaoImpl;
import com.zensoftech.eakarni.DAO.SmbReportDaoImpl;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.DAO.StateDaoImpl;
import com.zensoftech.eakarni.DAO.TaxDaoImpl;
import com.zensoftech.eakarni.DAO.UserDao;
import com.zensoftech.eakarni.DAO.UserDaoImpl;
import com.zensoftech.eakarni.service.AddDdoManagerImpl;
import com.zensoftech.eakarni.service.AddTalatiManager;
import com.zensoftech.eakarni.service.AddTalatiManagerImpl;
import com.zensoftech.eakarni.service.AddTdoManagerImpl;
import com.zensoftech.eakarni.service.AppointmentManager;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.CdpReportManager;
import com.zensoftech.eakarni.service.DdoManagerImpl;
import com.zensoftech.eakarni.service.EgramReportManager;
import com.zensoftech.eakarni.service.FinanceReportManager;
import com.zensoftech.eakarni.service.GpauditperaReportManager;
import com.zensoftech.eakarni.service.GramswagatReportManager;
import com.zensoftech.eakarni.service.HsgReportManager;
import com.zensoftech.eakarni.service.IayReportManager;
import com.zensoftech.eakarni.service.JaminMehsulReportManager;
import com.zensoftech.eakarni.service.ListAllDdoManagerImpl;
import com.zensoftech.eakarni.service.ViewCdpDetailsManager;
import com.zensoftech.eakarni.service.ViewCdpDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewEgramDetailsManager;
import com.zensoftech.eakarni.service.ViewEgramDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewFinanceDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewGpperaDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewGramswagatDetailsManager;
import com.zensoftech.eakarni.service.ViewGramswagatDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewHsgDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewIayDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewJaminMehsulDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewPanchVeraVasulatDetailsManagerImpl;
import com.zensoftech.eakarni.service.ViewSmbDetailsManagerImpl;
import com.zensoftech.eakarni.service.ListAllTalatisManagerImpl;
import com.zensoftech.eakarni.service.ListAllTdoManagerImpl;
import com.zensoftech.eakarni.service.PanchveraReportManager;
import com.zensoftech.eakarni.service.PropertyDetailsManagerImpl;
import com.zensoftech.eakarni.service.SmbReportManager;
import com.zensoftech.eakarni.service.StateManager;
import com.zensoftech.eakarni.service.StateManagerImpl;
import com.zensoftech.eakarni.service.TalatiCdpManagerImpl;
import com.zensoftech.eakarni.service.TalatiEgramManagerImpl;
import com.zensoftech.eakarni.service.TalatiFinanceMangerImpl;
import com.zensoftech.eakarni.service.TalatiGramAuditManagerImpl;
import com.zensoftech.eakarni.service.TalatiGramSmbManagerImpl;
import com.zensoftech.eakarni.service.TalatiIayManager;
import com.zensoftech.eakarni.service.TalatiIayMangerImpl;
import com.zensoftech.eakarni.service.TalatiJaminMehsulManager;
import com.zensoftech.eakarni.service.TalatiJaminMehsulManagerImpl;
import com.zensoftech.eakarni.service.TalatiMilkatRegisterManagerImpl;
import com.zensoftech.eakarni.service.TalatiPanchVeraManager;
import com.zensoftech.eakarni.service.TalatiPanchVeraManagerImpl;
import com.zensoftech.eakarni.service.TdoManagerImpl;
import com.zensoftech.eakarni.service.TotalEnteriesForDistrictManagerImpl;
import com.zensoftech.eakarni.service.TotalEnteriesForTalukaManagerImpl;
import com.zensoftech.eakarni.service.UserManager;
import com.zensoftech.eakarni.service.UserManagerImpl;
import com.zensoftech.eakarni.service.TalatiGramswagatManagerImpl;
/*import com.zensoftech.eakarni.service.TalatiHsgManager;
import com.zensoftech.eakarni.service.TalatiHsgManagerImpl;*/
import com.zensoftech.eakarni.service.TalatiHsgManager;
import com.zensoftech.eakarni.service.TalatiHsgManagerImpl;


@WebListener
public class LoginListener implements ServletContextListener {
	

    public LoginListener() {
        
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
        
    }

	
    public void contextInitialized(ServletContextEvent event)  {
    	
    	ServletContext context=event.getServletContext();
    	String driverName=context.getInitParameter("driverName");
    	String databaseUrl=context.getInitParameter("databaseUrl");
    	String databaseUser=context.getInitParameter("databaseUser");
    	String databasePassword=context.getInitParameter("databasePassword");
    	
    	context.setAttribute("deflocale",new Locale(context.getInitParameter("default.lang")));
    	
    	/*System.out.println("LISTENR> "+context.getInitParameter("driverName"));
    	System.out.println("LISTENER > "+context.getInitParameter("databaseUrl"));
    	System.out.println("LISTENER >"+context.getInitParameter("databaseUser"));
    	System.out.println("LISTENER >"+context.getInitParameter("databasePassword"));*/
    	  
    	UserDao userdao = new UserDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	 UserManager usermanager=new UserManagerImpl(userdao);
    	 context.setAttribute("usermanager", usermanager);
    	 
    	 AppointmentDao appointmentdao=new AppointmentDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	 AppointmentManager appointmentmanager =new AppointmentManagerImpl(appointmentdao);
    	 context.setAttribute("appointmentmanager", appointmentmanager);
    	 
    	 AddTalatiManagerImpl addtalatimanager=new AddTalatiManagerImpl(appointmentdao);
    	 context.setAttribute("addtalatimanager", addtalatimanager);
    	 
    	 AddDdoManagerImpl addDdoManager=new AddDdoManagerImpl(appointmentdao);
    	 context.setAttribute("addDdoManager", addDdoManager);
    	 
    	 
    	StateDao statedao = new StateDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	StateManager statemanager=new StateManagerImpl(statedao);
    	context.setAttribute("statemanager", statemanager);
    	
    	TdoManagerImpl tdomanager=new TdoManagerImpl(statedao);
    	context.setAttribute("tdomanager",tdomanager);
    	
    	DdoManagerImpl ddomanager=new DdoManagerImpl(statedao);
    	context.setAttribute("ddomanager",ddomanager);
    	
    	CdpDao cdpdao = new CdpDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewCdpDetailsManager cdpmanager =new ViewCdpDetailsManagerImpl(cdpdao);
    	context.setAttribute("cdpmanager", cdpmanager);
    	
    	EgramDao egramdao =new EgramDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewEgramDetailsManager egrammanager=new ViewEgramDetailsManagerImpl(egramdao);
    	context.setAttribute("egrammanager", egrammanager);
    	
    	Finance14Dao financedao=new Finance14DaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewFinanceDetailsManagerImpl financemanager=new ViewFinanceDetailsManagerImpl(financedao);
    	context.setAttribute("financemanager", financemanager);
    	
    	GpperaDao peradao=new GpperaDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewGpperaDetailsManagerImpl peramanager=new ViewGpperaDetailsManagerImpl(peradao);
    	context.setAttribute("peramanager", peramanager);
    	
    	GramswagatDao gramswagatdao=new GramswagatDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewGramswagatDetailsManagerImpl gramswagatmanager=new ViewGramswagatDetailsManagerImpl(gramswagatdao);
    	context.setAttribute("gramswagatmanager", gramswagatmanager);
    	
    	IayDao iaydao=new IayDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewIayDetailsManagerImpl iaymanager=new ViewIayDetailsManagerImpl(iaydao);
    	context.setAttribute("iaymanager", iaymanager);
    	
    	HsgDao hsgdao=new HsgDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewHsgDetailsManagerImpl hsgmanager=new ViewHsgDetailsManagerImpl(hsgdao);
    	context.setAttribute("hsgmanager", hsgmanager);
    	
    	JaminMehsulDao jamindao=new JaminMehsulDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewJaminMehsulDetailsManagerImpl jaminmanager=new ViewJaminMehsulDetailsManagerImpl(jamindao);
    	context.setAttribute("jaminmanager", jaminmanager);
    	
    	SmbDao smbdao=new SmbDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewSmbDetailsManagerImpl smbmanager=new ViewSmbDetailsManagerImpl(smbdao);
    	context.setAttribute("smbmanager", smbmanager);
    	
    	PanchVeraDao panchveradao=new PanchVeraDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	ViewPanchVeraVasulatDetailsManagerImpl panchveramanager=new ViewPanchVeraVasulatDetailsManagerImpl(panchveradao);
    	context.setAttribute("panchveramanager", panchveramanager);
    	
    	ListAllTalatisManagerImpl talatilistmanager=new ListAllTalatisManagerImpl(appointmentdao,statedao);
    	context.setAttribute("talatilistmanager",talatilistmanager );
    	
    	ListAllDdoManagerImpl ddolistmanager=new ListAllDdoManagerImpl(appointmentdao,statedao);
    	context.setAttribute("ddolistmanager",ddolistmanager );
    	
    	
    	TotalEnteriesForTalukaManagerImpl talukaCdpcountmanager=new TotalEnteriesForTalukaManagerImpl(cdpdao);
    	context.setAttribute("talukaCdpcountmanager",talukaCdpcountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaEgramcountmanager=new TotalEnteriesForTalukaManagerImpl(egramdao);
    	context.setAttribute("talukaEgramcountmanager",talukaEgramcountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaGramperacountmanager=new TotalEnteriesForTalukaManagerImpl(peradao);
    	context.setAttribute("talukaGramperacountmanager",talukaGramperacountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaFinancecountmanager=new TotalEnteriesForTalukaManagerImpl(financedao);
    	context.setAttribute("talukaFinancecountmanager",talukaFinancecountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaSmbcountmanager=new TotalEnteriesForTalukaManagerImpl(smbdao);
    	context.setAttribute("talukaSmbcountmanager",talukaSmbcountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaGramswagatcountmanager=new TotalEnteriesForTalukaManagerImpl(gramswagatdao);
    	context.setAttribute("talukaGramswagatcountmanager",talukaGramswagatcountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaIaycountmanager=new TotalEnteriesForTalukaManagerImpl(iaydao);
    	context.setAttribute("talukaIaycountmanager",talukaIaycountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaJaminMehsulcountmanager=new TotalEnteriesForTalukaManagerImpl(jamindao);
    	context.setAttribute("talukaJaminMehsulcountmanager",talukaJaminMehsulcountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaHsgcountmanager=new TotalEnteriesForTalukaManagerImpl(hsgdao);
    	context.setAttribute("talukaHsgcountmanager",talukaHsgcountmanager);
    	
    	TotalEnteriesForTalukaManagerImpl talukaPanchVeracountmanager=new TotalEnteriesForTalukaManagerImpl(panchveradao);
    	context.setAttribute("talukaPanchVeracountmanager",talukaPanchVeracountmanager);
    	
    	
    	
    	TalatiCdpManagerImpl talaticdpmanager=new TalatiCdpManagerImpl(cdpdao);
    	context.setAttribute("talaticdpmanager", talaticdpmanager);
    	
    	TalatiEgramManagerImpl talatiegrammanager=new TalatiEgramManagerImpl(egramdao);
    	context.setAttribute("talatiegrammanager", talatiegrammanager);
    	
    	TalatiFinanceMangerImpl talatifinancemanager=new TalatiFinanceMangerImpl(financedao);
    	context.setAttribute("talatifinancemanager", talatifinancemanager);
    	
    	TalatiIayManager talatiiaymanager=new TalatiIayMangerImpl(iaydao);
    	context.setAttribute("talatiiaymanager", talatiiaymanager);
    	
    	TalatiHsgManager talatihsgmanager=new TalatiHsgManagerImpl(hsgdao);
    	context.setAttribute("talatihsgmanager", talatihsgmanager);
    	
    	TalatiGramswagatManagerImpl talatigramswagatmanager=new TalatiGramswagatManagerImpl(gramswagatdao);
    	context.setAttribute("talatigramswagatmanager", talatigramswagatmanager);
    	
    	TalatiGramAuditManagerImpl talatiperamanager=new TalatiGramAuditManagerImpl(peradao);
    	context.setAttribute("talatiperamanager", talatiperamanager);
    	
    	TalatiGramSmbManagerImpl talatismbmanager=new TalatiGramSmbManagerImpl(smbdao);
    	context.setAttribute("talatismbmanager", talatismbmanager);
    	
    	TalatiJaminMehsulManager talatijaminmanager=new TalatiJaminMehsulManagerImpl(jamindao);
    	context.setAttribute("talatijaminmanager", talatijaminmanager);
    	
    	 TalatiPanchVeraManager talatipanchveramanager= new TalatiPanchVeraManagerImpl(panchveradao);
    	 context.setAttribute("talatipanchveramanager", talatipanchveramanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtCdpcountmanager=new TotalEnteriesForDistrictManagerImpl(cdpdao);
    	context.setAttribute("districtCdpcountmanager",districtCdpcountmanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtFinancecountmanager=new TotalEnteriesForDistrictManagerImpl(financedao);
    	context.setAttribute("districtFinancecountmanager",districtFinancecountmanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtEgramcountmanager=new TotalEnteriesForDistrictManagerImpl(egramdao);
    	context.setAttribute("districtEgramcountmanager",districtEgramcountmanager);
    	 
    	TotalEnteriesForDistrictManagerImpl districtGramperacountmanager=new TotalEnteriesForDistrictManagerImpl(peradao);
    	context.setAttribute("districtGramperacountmanager",districtGramperacountmanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtSmbcountmanager=new TotalEnteriesForDistrictManagerImpl(smbdao);
    	context.setAttribute("districtSmbcountmanager",districtSmbcountmanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtGramswagatcountmanager=new TotalEnteriesForDistrictManagerImpl(gramswagatdao);
    	context.setAttribute("districtGramswagatcountmanager",districtGramswagatcountmanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtIaycountmanager=new TotalEnteriesForDistrictManagerImpl(iaydao);
    	context.setAttribute("districtIaycountmanager",districtIaycountmanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtJaminMehsulcountmanager=new TotalEnteriesForDistrictManagerImpl(jamindao);
    	context.setAttribute("districtJaminMehsulcountmanager",districtJaminMehsulcountmanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtPanchVeracountmanager=new TotalEnteriesForDistrictManagerImpl(panchveradao);
    	context.setAttribute("districtPanchVeracountmanager",districtPanchVeracountmanager);
    	
    	TotalEnteriesForDistrictManagerImpl districtHsgcountmanager=new TotalEnteriesForDistrictManagerImpl(hsgdao);
    	context.setAttribute("districtHsgcountmanager",districtHsgcountmanager);
    	
    	PropertyDetailsDaoImpl propertydetailsdao=new PropertyDetailsDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	PropertyDetailsManagerImpl propertydetailsmanager=new PropertyDetailsManagerImpl(propertydetailsdao);
    	context.setAttribute("propertydetailsmanager", propertydetailsmanager);
    	
    	PropertyDaoImpl propertydao=new PropertyDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	PropertyDetailsManagerImpl propertymanager=new PropertyDetailsManagerImpl(propertydao);
    	context.setAttribute("propertymanager", propertymanager);
    	
    	
    	TotalEnteriesForTalukaManagerImpl talukaPropertycountmanager=new TotalEnteriesForTalukaManagerImpl(propertydao);
    	context.setAttribute("talukaPropertycountmanager",talukaPropertycountmanager);
    	
    	TaxDaoImpl taxdao=new TaxDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	PropertyDetailsManagerImpl taxmanager=new PropertyDetailsManagerImpl(taxdao);
    	context.setAttribute("taxmanager", taxmanager);
    	
    	OccupantDaoImpl occupantdao=new OccupantDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	PropertyDetailsManagerImpl occupantmanager=new PropertyDetailsManagerImpl(occupantdao);
    	context.setAttribute("occupantmanager", occupantmanager);
    	
    	OwnerDaoImpl ownerdao=new OwnerDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	PropertyDetailsManagerImpl ownermanager=new PropertyDetailsManagerImpl(ownerdao);
    	context.setAttribute("ownermanager", ownermanager);
    	
    	PropertyTransferDaoImpl propertytransferdao=new PropertyTransferDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	PropertyDetailsManagerImpl tranasfermanager=new PropertyDetailsManagerImpl(propertytransferdao);
    	context.setAttribute("tranasfermanager", tranasfermanager);
    	
    	AddTalatiManagerImpl addTalatiManager=new AddTalatiManagerImpl(appointmentdao);
    	context.setAttribute("addTalatiManager", addTalatiManager);
    	
    	ListAllTdoManagerImpl tdoListmanager=new ListAllTdoManagerImpl(appointmentdao,statedao);
    	context.setAttribute("tdoListmanager", tdoListmanager);
    	
    	AddTdoManagerImpl addtdomanager=new AddTdoManagerImpl(appointmentdao);
    	context.setAttribute("addtdomanager", addtdomanager);
    	
    	TalatiMilkatRegisterManagerImpl propertyOwner=new TalatiMilkatRegisterManagerImpl(ownerdao);
    	context.setAttribute("propertyOwner",propertyOwner );
    	
    	TalatiMilkatRegisterManagerImpl propertyOccupant=new TalatiMilkatRegisterManagerImpl(occupantdao);
    	context.setAttribute("propertyOccupant",propertyOccupant );
    	
    	TalatiMilkatRegisterManagerImpl propertyTax=new TalatiMilkatRegisterManagerImpl(taxdao);
    	context.setAttribute("propertyTax",propertyTax );
    	
    	TalatiMilkatRegisterManagerImpl propertyTransfer=new TalatiMilkatRegisterManagerImpl(propertytransferdao);
    	context.setAttribute("propertyTransfer",propertyTransfer );
    	
    	TalatiMilkatRegisterManagerImpl propertyMaster=new TalatiMilkatRegisterManagerImpl(propertydao);
    	context.setAttribute("propertyMaster",propertyMaster );
    	
		
		CdpReportDaoImpl cdpreportdao=new CdpReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	CdpReportManager cdpreportmanager=new CdpReportManager(cdpreportdao,statedao);
    	context.setAttribute("cdpreportmanager", cdpreportmanager);
    	
    	IayReportDaoImpl iayreportdao=new IayReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	IayReportManager iayreportmanager=new IayReportManager(iayreportdao,statedao);
    	context.setAttribute("iayreportmanager", iayreportmanager);
    	
    	FinanceReportDaoImpl financereportdao=new FinanceReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	FinanceReportManager financereportmanager=new FinanceReportManager(financereportdao,statedao);
    	context.setAttribute("financereportmanager", financereportmanager);
    	
    	GPauditperaReportDaoImpl gpperareportdao=new GPauditperaReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	GpauditperaReportManager gpperareportmanager=new GpauditperaReportManager(gpperareportdao,statedao);
    	context.setAttribute("gpperareportmanager", gpperareportmanager);
    	
    	EgramReportDaoImpl egramreportdao=new EgramReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	EgramReportManager egramreportmanager=new EgramReportManager(egramreportdao,statedao);
    	context.setAttribute("egramreportmanager", egramreportmanager);
    	
    	SmbReportDaoImpl smbreportdao=new SmbReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	SmbReportManager smbreportmanager=new SmbReportManager(smbreportdao,statedao);
    	context.setAttribute("smbreportmanager", smbreportmanager);
    	
    	GramswagatReportDaoImpl gramswagatreportdao=new GramswagatReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	GramswagatReportManager gramswagatreportmanager=new GramswagatReportManager(gramswagatreportdao,statedao);
    	context.setAttribute("gramswagatreportmanager", gramswagatreportmanager);
    	
    	JaminMehsulReportDaoImpl jaminmehsulreportdao=new JaminMehsulReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	JaminMehsulReportManager jaminreportmanager=new JaminMehsulReportManager(jaminmehsulreportdao,statedao);
    	context.setAttribute("jaminreportmanager", jaminreportmanager);
    	
    	PanchveraReportDaoImpl panchverareportdao=new PanchveraReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	PanchveraReportManager panchverareportmanager=new PanchveraReportManager(panchverareportdao,statedao);
    	context.setAttribute("panchverareportmanager", panchverareportmanager);
    	
    	HsgReportDaoImpl hsgreportdao=new HsgReportDaoImpl(driverName,databaseUrl,databaseUser,databasePassword);
    	HsgReportManager hsgreportmanager=new HsgReportManager(hsgreportdao,statedao);
    	context.setAttribute("hsgreportmanager", hsgreportmanager);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	 
    	 
    }

	
}
