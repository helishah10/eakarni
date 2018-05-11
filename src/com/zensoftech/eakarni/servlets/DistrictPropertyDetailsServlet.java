package com.zensoftech.eakarni.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensoftech.eakarni.entities.PropertyDetails;
import com.zensoftech.eakarni.entities.PropertyMaster;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.AppointmentManagerImpl;
import com.zensoftech.eakarni.service.PropertyDetailsManagerImpl;


@WebServlet("/DistrictPropertyDetailsServlet")
public class DistrictPropertyDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails userdetails=(UserDetails)request.getSession(false).getAttribute("userdetails");
		String loginId=userdetails.getUser().getLoginId();
		AppointmentManagerImpl appointmentmanager=(AppointmentManagerImpl)getServletContext().getAttribute("appointmentmanager");
	
		System.out.println("in servlet:");
		
		if(request.getParameter("submit")!=null)
		{
			String propertyId=request.getParameter("propertyId");
			PropertyMaster property=new PropertyMaster();
		
			System.out.println("in if:");
			PropertyDetailsManagerImpl propertymanager=(PropertyDetailsManagerImpl)getServletContext().getAttribute("propertymanager");
			property=propertymanager.getProperty(propertyId);
			System.out.println("property obj:"+property);
			
			int id=property.getId();
			PropertyDetailsManagerImpl propertydetailsmanager=(PropertyDetailsManagerImpl)getServletContext().getAttribute("propertydetailsmanager");
			Map<Integer,PropertyDetails> propertyMap;
			try {
				propertyMap=propertydetailsmanager.getAllPropertyDetails(id);
				/*System.out.println(propertyMap);*/
				request.setAttribute("districtPropertyDetails", propertyMap);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewDistrictMilkatRegister.jsp");
			rd.forward(request, response);
			
		}
		
	}
}


