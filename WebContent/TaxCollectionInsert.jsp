<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

<fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.InsertPanchVera" prefix="">
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="assets/img/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title><fmt:message key="Dashboard"/></title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!--  Material Dashboard CSS    -->
    <link href="assets/css/material-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />
	<link href="assets/css/dd.css" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
	<script src="assets/js/tab.js"> </script>
</head>

<body>

	<div class="wrapper">

	    <div class="sidebar" data-color="blue" data-image="assets/img/sidebar-1.jpg">
			<!--
		        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

		        Tip 2: you can also add an image using data-image tag
		    -->

			<div class="logo">
				<a href="" class="simple-text">
				<i class="material-icons">view_list</i>
					<fmt:message key="Tax_Collection"/>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
	                    <a href="InsertFinance.jsp">
	                        <i class="material-icons">label</i>
	                        <p style=""><fmt:message key="14th_Finance"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertCdp.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="CDP14"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertEgram.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Egram"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertGramAudit.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Gram_Audit_Para"></fmt:message></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertGramSMB">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Gram_SMB"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertGramSvagat.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Gram_Svagat"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertHSG_1_14_15.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="HSG_1_14_15"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertHSG_1_15_16.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="HSG_1_15_16"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertIAY.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="IAY"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertLandRevenue.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Land_Revenue"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertMilkatRegister.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Milkat_Register"/></p>
	                    </a>
	                </li>
	                <li class="active">
	                    <a href="InsertTaxCollection.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Tax_Collection"/></p>
	                    </a>
	                </li>

	                
	            </ul>
	    	</div>
	    </div>

	    <div class="main-panel">
			<nav class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"></a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a href="TDO.jsp"> 
								<i class="material-icons">dashboard</i>
									<p class="hidden-lg hidden-md">Dashboard</p>
								</a>
							</li>
							<!-- <li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<i class="material-icons">notifications</i>
									<span class="notification">5</span>
									<p class="hidden-lg hidden-md">Notifications</p>
								</a>
								<ul class="dropdown-menu">
									<li><a href="#">Mike John responded to your email</a></li>
									<li><a href="#">You have 5 new tasks</a></li>
									<li><a href="#">You're now friend with Andrew</a></li>
									<li><a href="#">Another Notification</a></li>
									<li><a href="#">Another One</a></li>
								</ul>
							</li>-->
							<li> 
								<a href="userTDO.jsp"> <!-- class="dropdown-toggle" data-toggle="dropdown" -->
	 							   <i class="material-icons">person</i>
	 							   <p class="hidden-lg hidden-md">Profile</p>
		 						</a>
							</li>
							<li>
        							<!-- <a href="/eakarni/LogoutServlet" class="btn btn-info "> -->
        							 <a href="LogoutServlet"> 
								<i class="material-icons">power_settings_new</i>
									<p class="hidden-lg hidden-md">power_settings_new</p>
									<label> logout </label>
								</a>
      						</li>
						</ul>
					</div>
				</div>
			</nav>
				<div id="T1"  class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr> 
									<th class="" style="" rowspan="">ક્ર્મ</th>
									<th class="" style="" rowspan="">વેરાનો પ્રકાર </th>
									<th class="" style="">પાછલું બાકી </th>
									<th class="" style="">ચાલુ </th>
									<th class="" style="">કુલ </th>
								
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td style="text-align:CENTER;">વ્વસાય વેરો</td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">2</td>
									<td style="text-align: CENTER;">ઘર વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
							   </tr>
							   <tr>
									<td style="text-align: CENTER;">3</td>
									<td style="text-align: CENTER;">સ્ટ્રીટ લાઈટ વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">4</td>
									<td style="text-align: CENTER;">પાણી વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">5</td>
									<td style="text-align: CENTER;">સફાય વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								
								
							</tbody>
						</table>
			</div>
	</div>
	
	
	<div id="T2"  class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr> 
									<th class="" style="" rowspan="">ક્ર્મ</th>
									<th class="" style="" rowspan="">વેરાનો પ્રકાર </th>
									<th class="" style="">પાછલું બાકી </th>
									<th class="" style="">ચાલુ </th>
									<th class="" style="">કુલ </th>
								
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td style="text-align:CENTER;">વ્વસાય વેરો</td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">2</td>
									<td style="text-align: CENTER;">ઘર વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
							   </tr>
							   <tr>
									<td style="text-align: CENTER;">3</td>
									<td style="text-align: CENTER;">સ્ટ્રીટ લાઈટ વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">4</td>
									<td style="text-align: CENTER;">પાણી વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">5</td>
									<td style="text-align: CENTER;">સફાય વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								
								
							</tbody>
						</table>
			</div>
	</div>
	
	<div id="T3"  class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr> 
									<th class="" style="" rowspan="">ક્ર્મ</th>
									<th class="" style="" rowspan="">વેરાનો પ્રકાર </th>
									<th class="" style="">પાછલું બાકી </th>
									<th class="" style="">ચાલુ </th>
									<th class="" style="">કુલ </th>
								
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td style="text-align:CENTER;">વ્વસાય વેરો</td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">2</td>
									<td style="text-align: CENTER;">ઘર વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
							   </tr>
							   <tr>
									<td style="text-align: CENTER;">3</td>
									<td style="text-align: CENTER;">સ્ટ્રીટ લાઈટ વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">4</td>
									<td style="text-align: CENTER;">પાણી વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">5</td>
									<td style="text-align: CENTER;">સફાય વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								
								
							</tbody>
						</table>
			</div>
	</div>

	<div id="T4"  class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr> 
									<th class="" style="" rowspan="">ક્ર્મ</th>
									<th class="" style="" rowspan="">વેરાનો પ્રકાર </th>
									<th class="" style="">પાછલું બાકી </th>
									<th class="" style="">ચાલુ </th>
									<th class="" style="">કુલ </th>
								
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td style="text-align:CENTER;">વ્વસાય વેરો</td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">2</td>
									<td style="text-align: CENTER;">ઘર વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
							   </tr>
							   <tr>
									<td style="text-align: CENTER;">3</td>
									<td style="text-align: CENTER;">સ્ટ્રીટ લાઈટ વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">4</td>
									<td style="text-align: CENTER;">પાણી વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">5</td>
									<td style="text-align: CENTER;">સફાય વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								
								
							</tbody>
						</table>
			</div>
	</div>
	
	<div id="T5"  class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr> 
									<th class="" style="" rowspan="">ક્ર્મ</th>
									<th class="" style="" rowspan="">વેરાનો પ્રકાર </th>
									<th class="" style="">પાછલું બાકી </th>
									<th class="" style="">ચાલુ </th>
									<th class="" style="">કુલ </th>
								
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td style="text-align:CENTER;">વ્વસાય વેરો</td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">2</td>
									<td style="text-align: CENTER;">ઘર વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
							   </tr>
							   <tr>
									<td style="text-align: CENTER;">3</td>
									<td style="text-align: CENTER;">સ્ટ્રીટ લાઈટ વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">4</td>
									<td style="text-align: CENTER;">પાણી વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								<tr>
									<td style="text-align: CENTER;">5</td>
									<td style="text-align: CENTER;">સફાય વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
								</tr>
								
								
							</tbody>
						</table>
			</div>
	</div>

	
	<div id="T6"  class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr> 
									<th class="" style="" rowspan="">ક્ર્મ</th>
									<th class="" style="" rowspan="">વેરાનો પ્રકાર </th>
									<th class="" style="">ટકાવારી %</th>
									
								
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td style="text-align:CENTER;">વ્વસાય વેરો</td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									
								</tr>
								<tr>
									<td style="text-align: CENTER;">2</td>
									<td style="text-align: CENTER;">ઘર વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>

							   </tr>
							   <tr>
									<td style="text-align: CENTER;">3</td>
									<td style="text-align: CENTER;">સ્ટ્રીટ લાઈટ વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									
								</tr>
								<tr>
									<td style="text-align: CENTER;">4</td>
									<td style="text-align: CENTER;">પાણી વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
										</tr>
								<tr>
									<td style="text-align: CENTER;">5</td>
									<td style="text-align: CENTER;">સફાય વેરો </td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
										</tr>
								
								
							</tbody>
						</table>
			</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div id="A2" class="tabcontent">
<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
							
								<tr>
									<th colspan="3" class="" style="text-align:center">મરણ નું પ્રમાણ પત્ર </th>
								<tr>
								<tr>
									<th class="" style="">ક્ર્મ</th>
									<th class="" style="">નકલ</th>
									<th class="" style="">આવક </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<div class="box">
									<td><input id="" name="" class="box" type="text" value="" ></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</div>
									</tr>
							</tbody>
						</table>
					</div>
				</div>
	<div id="A3" class="tabcontent">
	<div class="table-responsive" style="overflow-x:scroll;">
							<table id="hsg3" border="1" class="table table-hover">
								<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">ચરિત્ર નું પ્રમાણ પત્ર </th>
								<tr>
									
									<tr>
										<th class="" style="">ક્ર્મ</th>
										<th class="" style="">નકલ</th>
										<th class="" style="">આવક </th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td style="text-align: CENTER;">1</td>
										<td><input id="" name="" class="box" type="text" value=""></td>
										<td><input id="" name="" class="box" type="text" value=""></td>
										</tr>
								</tbody>
							</table>
				</div>
		</div>
		<div id="A4" class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">જાતિ  નું પ્રમાણ પત્ર  </th>
								<tr>
								<tr>
									<th class="" style="">ક્ર્મ</th>
									<th class="" style="">નકલ</th>
									<th class="" style="">આવક </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</tr>
							</tbody>
						</table>
					</div>
	</div>
	<div id="A5" class="tabcontent">
			<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">આવક  નું પ્રમાણ પત્ર</th>
								<tr>
								<tr>
									<th class="" style="">ક્ર્મ</th>
									<th class="" style="">નકલ</th>
									<th class="" style="">આવક </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</tr>
							</tbody>
						</table>
					</div>
	</div>
		<div id="A6" class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">૭/૧૨ , ૮ અ , નં ૬ </th>
								<tr>
								<tr>
									<th class="" style="">ક્ર્મ</th>
									<th class="" style="">નકલ</th>
									<th class="" style="">આવક </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</tr>
							</tbody>
						</table>
					</div>
		</div>
				
		<div id="A7" class="tabcontent">
					<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">MGVCL BILL</th>
								<tr>
								<tr>
									<th class="" style="">ક્ર્મ</th>
									<th class="" style="">બીલ</th>
									<th class="" style="">આવક </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</tr>
							</tbody>
						</table>
					</div>
		</div>
		<div id="B1" class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">BADEA ENTRI </th>
								<tr>
								
								<tr>	
									<th class="" style="">ક્ર્મ</th>
									<th class="" style="">ENTRI</th>
									<th class="" style="">આવક </th>
									<!-- <th class="" style="">અરજી</th>
									<th class="" style="">આવક </th>
									<th class="" style="">બીલ</th>
									<th class="" style="">આવક</th>
									<th class="" style="">SERVICE</th>
									<th class="" style="">આવક</th>
									<th class="" style="">નકલ</th>
									<th class="" style="">આવક </th> -->
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<!--b2 <td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									b3<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
									<td><input id="" name="" class="span1" type="text" value=""></td>
							 -->		</tr>
							</tbody>
						</table>
					</div>
		</div>
		<div id="B2" class="tabcontent">
		<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">I ખેડૂત</th>
								<tr>
								<tr>
									<th class="" style="">ક્ર્મ</th>
									<th class="" style="">અરજી</th>
									<th class="" style="">આવક </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</tr>
							</tbody>
						</table>
					</div>
		</div>
		<div id="B3" class="tabcontent">
			<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">GSPC BILL</th>
								<tr>
								<tr>
									<th class="" style="">ક્ર્મ</th>
									<th class="" style="">બીલ</th>
									<th class="" style="">આવક</th>
								</tr>
									</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</tr>
							</tbody>
						</table>
					</div>
		</div>
		<div id="B4" class="tabcontent">
			<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">CSC</th>
								<tr>
								<tr>
									<th class="" style="">ક્ર્મ</th>
									
									<th class="" style="">SERVICE</th>
									<th class="" style="">આવક</th>
								</tr>
									</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</tr>
							</tbody>
						</table>
					</div>
		</div>
									
		<div id="B5" class="tabcontent">
			<div class="table-responsive" style="overflow-x:scroll;">
						<table id="hsg3" border="1" class="table table-hover">
							<thead>
								<tr>
									<th colspan="3" class="" style="text-align:center">અન્ય</th>
								<tr>
								<tr>
								<th class="" style="">ક્ર્મ</th>
									
								<th class="" style="">નકલ</th>
									<th class="" style="">આવક </th> 
																</tr>
									</thead>
							<tbody>
								<tr>
									<td style="text-align: CENTER;">1</td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									<td><input id="" name="" class="box" type="text" value=""></td>
									</tr>
							</tbody>
						</table>
				</div>
		</div>

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						
								 <div class="card-content">
									<div class="tab-content">
										<div class="tab-pane active" id="profile">
											
						<div class="col-lg-12 col-md-12">
							<div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title" style="text-align:center;font-weight:bold;"><fmt:message key="Tax_Collection"/></h4>
	                                
	                            </div>
	                            <div class="card-content table-responsive">
	                                <form class="well form-horizontal" action="InsertPanchVeraServlet" method="post"  id="contact_form">
								<fieldset>
								
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="taxname"/></label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="taxname" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								
								<div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title" style="text-align:center;font-weight:bold;">માંગણુ  </h4>
	                            </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="seekingPreviousAmountLeft"/> </label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="seekingPreviousAmountLeft" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="seekingCurrentAmount"/></label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="seekingCurrentAmount" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<!-- <div class="form-group">
								  <label class="col-md-4 control-label" >કુલ </label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="total" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div> -->
								
								<div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title" style="text-align:center;font-weight:bold;">ગત માસ સુધી કરેલ વસુલાત  </h4>
	                            </div>
								</div>
								
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="recoveryTillPreviousMonthPrevious"/></label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="recoveryTillPreviousMonthPrevious" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="recoveryTillPreviousMonthCurrent"/></label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="recoveryTillPreviousMonthCurrent" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<!-- <div class="form-group">
								  <label class="col-md-4 control-label" >કુલ </label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="total" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								 -->
								 <div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title" style="text-align:center;font-weight:bold;">ચાલુ માસ માં કરેલ વસુલાત  </h4>
	                            </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="recoveryTillCurrentMonthPrevious"/> </label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="recoveryTillCurrentMonthPrevious" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="recoveryTillCurrentMonthCurrent"/></label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="recoveryTillCurrentMonthCurrent" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<!-- <div class="form-group">
								  <label class="col-md-4 control-label" >કુલ </label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="total" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div> -->
								
								
								 <div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title" style="text-align:center;font-weight:bold;">કુલ વસુલાત  </h4>
	                            </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="totalRecoveryPrevious"/> </label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="totalRecoveryPrevious" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="totalRecoveryCurrent"/></label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="totalRecoveryCurrent" placeholder="" class="form-control"  type="number">
								    </div>
								  </div>
								</div>
								
								<!-- <div class="form-group">
								  <label class="col-md-4 control-label" >કુલ </label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="total" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div> -->
								
								 <div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title" style="text-align:center;font-weight:bold;">માસના અંતે બાકી વસુલાત</h4>
	                            </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="recoveryLeftAtTheEndMonthPrevious"/> </label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="recoveryLeftAtTheEndMonthPrevious" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label"><fmt:message key="recoveryLeftAtTheEndMonthCurrent"/></label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="recoveryLeftAtTheEndMonthCurrent" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<!-- <div class="form-group">
								  <label class="col-md-4 control-label" >કુલ </label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="total" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div> -->
							
								
								<!-- <div class="form-group">
								  <label class="col-md-4 control-label" >ટકાવારી %</label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="percent" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div> -->
								
								 <div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title" style="text-align:center;font-weight:bold;"></h4>
	                            </div>
								</div>
								<div class="form-group">
								  <label class="col-md-4 control-label" ><fmt:message key="month"/></label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="month" placeholder="" class="form-control"  type="number">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4 control-label" ><fmt:message key="year"/></label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="year" placeholder="" class="form-control"  type="number">
								    </div>
								  </div>
								</div>
								
								
								<button type="sumit" class="btn btn-large btn-primary" ><fmt:message key="Submit"/></button>
								
								</ul>
								</fieldset>
								</form>
								                          
	                              
	                            </div>
	                        </div>
						</div>
					</div>
				</div>
			</div> 

<!-- 			<footer class="footer">
				<div class="container-fluid">
					<nav class="pull-left">
						<ul>
							<li>
								<a href="#">
									Home
								</a>
							</li>
							<li>
								<a href="#">
									User
								</a>
							</li>
							<li>
								<a href="#">
									Portfolio
								</a>
							</li>
							<li>
								<a href="#">
								   Blog
								</a>
							</li>
						</ul>
					</nav>
					<p class="copyright pull-right">
						&copy; <script>document.write(new Date().getFullYear())</script> <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
					</p>
				</div>
			</footer>
 -->		</div>
	</div>
</div>
</div>
</div>
</fmt:bundle>
</body>

	<!--   Core JS Files   -->
	<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/material.min.js" type="text/javascript"></script>

	

	
	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	
	

</html>
