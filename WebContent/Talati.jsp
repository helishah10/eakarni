<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

<fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.Talati" prefix="">
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title><fmt:message key="page.nav1"></fmt:message></title>

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
					<fmt:message key="page.name"/>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="active">
	                    <a href="Talati.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p><fmt:message key="page.nav1"/></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="userTALATI.jsp">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="page.nav2"/></p>
	                    </a>
	                </li>
	                <li>
	                    <!-- <a href="schemes/village(index).html"> -->
							<a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'T1')">
									<i class="material-icons">content_paste</i>
									<p class="tab"><fmt:message key="page.nav3"/></p>
							</a>
					</li>
							
					<li id="T1" class="tabcontent" style="float:right;display:none" style="hovere:blue">
								<a href="InsertVillage(index).jsp" class="tablinks"  >
								<p><fmt:message key="nav3.menu1"/></p>
								</a>
								<a href="ViewVillageIndex.jsp" class="tablinks">
								<p><fmt:message key="nav3.menu2"/></p>
								</a>
								<a href="UpdateVillageIndex.jsp" class="tablinks" >
								<p><fmt:message key="nav3.menu3"></fmt:message></p>
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
								<a href="Talati.jsp"> 
								<i class="material-icons">dashboard</i>
									<p class="hidden-lg hidden-md">Dashboard</p>
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
							<!--  <li>
							 <a href="LogoutServlet"> 
								<i class="material-icons">power_settings_new</i>
									<p class="hidden-lg hidden-md">power_settings_new</p>
									<label> logout </label>
								</a>
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
							</li>
							 -->
	
							
						</ul>
					</div>
				</div>
			</nav>

			<div class="content" style="margin:30px">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="blue">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><b><fmt:message key="14th_FINANCE"/></b></p>
									<h3 class="title">1<small></small></h3>
								</div>
								
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats ">
								<div class="card-header" data-background-color="orange">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><b><fmt:message key="CDP_14"/></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="EGRAM"></fmt:message></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="GRAM_SBM"></fmt:message></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="GRAM_SVAGAT"/></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="HSG_1_14_15"/></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="HSG_1_15_16"/></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="IAY"/></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="LAND_REVENUE"/></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="GRAM_AUDIT_PARA"/></b></p>
									<h3 class="title">1<small></small></h3>
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
									<p class="category"><b><fmt:message key="TAX_COLLECTION"></fmt:message></b></p>
									<h3 class="title">1<small></small></h3>
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
	<</div>
	</fmt:bundle> 
</body>

	

</html>
