<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

    <fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.panchveraTbl" prefix="">
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="assets/img/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Dashboard</title>

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
					<fmt:message key="Schemes"/>
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
	                    <a href="InsertGramSMB.jsp">
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
	                    <a href="InsertJaminMehsul.jsp">
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
	                    <a href="InsertPanchVeraVasulat.jsp">
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
							</li> -->
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
	                                <table class="table table-hover">
	                                    <thead class="text-warning" style="color:purple;font-weight:900px;">
	                                        <tr>
									
								<th class="" style="" rowspan="2"><fmt:message key="srno"/></th>
									
									<th class="" style="text-align: CENTER;" rowspan="3"><fmt:message key="taxname"/> </th>
									<th></th>
									<th class="" style="text-align: CENTER;" colspan="3"><fmt:message key="Seeking"/></th>
									<th></th>
									<th class="" style="text-align: CENTER;" colspan="3"><fmt:message key="Previous_months"/> </th>
									<th class="" style="text-align: CENTER;" colspan="3"><fmt:message key="this_month"/></th>
									<th class="" style="text-align: CENTER;" colspan="3"><fmt:message key="total"/> </th>
									<th class="" style="text-align: CENTER;" colspan="3"><fmt:message key="recovery_at_the_end_of_the_month"/> </th>
									<th class="" style="text-align: CENTER;" rowspan="3"><fmt:message key="percentage"/></th>
								</tr>
								<tr>
									<th> </th>
									<th> </th>
									<th class="" style=""><fmt:message key="previousleft"/> </th>
									<th class="" style=""><fmt:message key="current"/></th>
									<th class="" style=""><fmt:message key="total"/></th>
									
									<th class="" style=""><fmt:message key="previousleft"/> </th>
									<th class="" style=""><fmt:message key="current"/></th>
									<th class="" style=""><fmt:message key="total"/></th>
									
									<th class="" style=""><fmt:message key="previousleft"/> </th>
									<th class="" style=""><fmt:message key="current"/></th>
									<th class="" style=""><fmt:message key="total"/></th>
									
									<th class="" style=""><fmt:message key="previousleft"/> </th>
									<th class="" style=""><fmt:message key="current"/></th>
									<th class="" style=""><fmt:message key="total"/></th>
									
									<th class="" style=""><fmt:message key="previousleft"/> </th>
									<th class="" style=""><fmt:message key="current"/></th>
									<th class="" style=""><fmt:message key="total"/></th>
									
									
								</tr>                                                 	
	                                    </thead>
	                                    <tbody>
	                                       <c:forEach var="panchvera" items="${panchveraVillageMap}"> 
	          					 			 <tr>
	                              			 	<td>${panchvera.key}</td>
	                               				<td>${panchvera.value.taxId}</td>
	                              			    <td>${panchvera.value. seekingPreviousAmountLeft}</td>
	                               				<td>${panchvera.value. seekingCurrentAmount}</td>
	                             			    <td>${panchvera.value.seekingTotalAmount}</td>
	                                            <td>${panchvera.value.recoveryTillPreviousMonthCurrent}</td>
	                                            <td>${panchvera.value.recoveryTillPreviousMonthPrevious}</td>
	                                            <td>${panchvera.value.recoveryTillPreviousMonthTotal}</td>
	                                            <td>${panchvera.value.recoveryTillCurrentMonthCurrent}</td>
	                                            <td>${panchvera.value.recoveryTillCurrentMonthPrevious}</td>
	                                            <td>${panchvera.value.recoveryTillCurrentMonthTotal}</td>
	                                            <td>${panchvera.value.totalRecoveryPrevious}</td>
	                                            <td>${panchvera.value.totalRecoveryCurrent}</td>
	                                             <td>${panchvera.value.totalRecoveryTotal}</td>
	                                             <td>${panchvera.value.recoveryLeftAtTheEndMonthPrevious}</td>
	                                             <td>${panchvera.value.recoveryLeftAtTheEndMonthCurrent}</td>
	                                             <td>${panchvera.value.recoveryLeftAtTheEndMonthTotal}</td>
	                                             <td>${panchvera.value.percentage}</td>
	                                             <td>${panchvera.value.entryDate}</td>
	                                                    
	                                               	 
	            				 </tr> 
								</c:forEach>
	                                    </tbody>
	                                </table>
	                               
	                                
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
