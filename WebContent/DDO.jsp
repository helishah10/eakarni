<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

    <fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.DDO" prefix="">
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

	    <div class="sidebar" data-color="purple" data-image="assets/img/sidebar-1.jpg">
			<!--
		        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

		        Tip 2: you can also add an image using data-image tag
		    -->

			<div class="logo">
				<a href="" class="simple-text">
					<b><fmt:message key="page.name"/></b>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="active">
	                    <a href="DDO.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p><b><fmt:message key="page.nav1"/></b></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="userDDO.jsp">
	                        <i class="material-icons">person</i>
	                        <p><b><fmt:message key="page.nav2"/></b></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="ViewAllTdosServlet">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="page.nav3"/></p>
	                    </a>
	                </li>
	                <li>
	                   
							<a href="ViewDistrictVillageIndex.jsp" class="tablinks"  >
									<i class="material-icons">content_paste</i>
									<p class="tab"><b><fmt:message key="page.nav4"/></b></p>
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
								<a href="DDO.jsp"> 
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
								<a href="userDDO.jsp"> <!-- class="dropdown-toggle" data-toggle="dropdown" -->
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

						<!-- <form class="navbar-form navbar-right" role="search">
							<div class="form-group  is-empty">
								<input type="text" class="form-control" placeholder="Search">
								<span class="material-input"></span>
							</div>
							<button type="submit" class="btn btn-white btn-round btn-just-icon">
								<i class="material-icons"></i><div class="ripple-container"></div>
							</button>
						</form> -->
					</div>
				</div>
			</nav>

			<div class="content" style="margin:30px">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="red">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><b><fmt:message key="Number_Of_Talukas"/></p>
									<h3 class="title"><small>${talukaCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="blue">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="CDP_14"/></p>
									<h3 class="title"><small>${districtCdpCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="green">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="EGRAM"/></p>
									<h3 class="title"><small>${districtEgramCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="orange">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="GRAM_AUDIT_PARA"/></p>
									<h3 class="title"><small>${districtGramperaCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="blue">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="GRAM_SBM"/></p>
									<h3 class="title"><small>${districtSmbCount }</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="green">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="GRAM_SVAGAT"/></p>
									<h3 class="title"><small>${ districtGramswagatCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="orange">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="HSG_1_14_15"/>HSG</p>
									<h3 class="title"><small>${ districtHsgCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
					</div>
					<%-- <div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="blue">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="HSG_1_15_16"/></p>
									<h3 class="title">49/50<small></small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div> --%>
						 <div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="green">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="IAY"/></p>
									<h3 class="title"><small>${districtIayCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="orange">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="LAND_REVENUE"/></p>
									<h3 class="title"><small>${districtJaminMehsulCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						
						
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="blue">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="TAX_COLLECTION"/></p>
									<h3 class="title"><small>${districtPanchVeraCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						</div>
						<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="green">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><fmt:message key="14th_FINANCE"></fmt:message></p>
									<h3 class="title"><small>${districtFinanceCount}</small></h3>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="green">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category">Milkat register</p>
									<h3 class="title"><small>2</small></h>
								</div>
								<!-- <div class="card-footer">
									<div class="stats">
										<i class="material-icons text-danger">warning</i> <a href="#pablo">Get More Space...</a>
									</div>
								</div> -->
							</div>
						</div>
						</div>
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

	<

	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>

	 

</html>
