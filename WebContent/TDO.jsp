
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

    <fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.TDO" prefix="">
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="assets/img/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title><fmt:message key="page.nav1"/></title>

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
					<fmt:message key="page.name"></fmt:message>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="active">
	                    <a href="/eakarni/TdoDashboardServlet">
	                        <i class="material-icons">dashboard</i>
	                        <p><fmt:message key="page.nav1"/></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="userTDO.jsp">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="page.nav2"/></p>
	                    </a>
	                </li>
	                <li>
	                    <a href="ViewAllTalatis">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="page.nav3"></fmt:message></p>
	                    </a>
	                </li>
	                <li>
	                   
							<a href="ViewTalukaVillageIndex.jsp" class="tablinks"  >
									<i class="material-icons">content_paste</i>
									<p class="tab"><fmt:message key="page.nav4"></fmt:message></p>
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
								
							</li> -->
							<li>
								<a href="userTDO.jsp"> <!-- class="dropdown-toggle" data-toggle="dropdown" -->
	 							   <i class="material-icons">person</i>
	 							   <p class="hidden-lg hidden-md">Profile</p>
		 						</a>
							</li>
							<li>
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
								<div class="card-content" >
									<p class="category"><b><fmt:message key="Number_Of_Villages"/></b></p>
						
									<h3 class="title">${villageCount}</h3> 
									
								</div>
								
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
									<p class="category"><b><fmt:message key="CDP_14"></fmt:message></b></p>
									<h3 class="title"><small>${talukaCdpCount}</small></h3> 
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
									<p class="category"><b><fmt:message key="EGRAM"/></b></p>
									<h3 class="title"><small>${talukaEgramCount}</small></h3>
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
									<p class="category"><b><fmt:message key="GRAM_AUDIT_PARA"/></b></p>
									<h3 class="title"><small>${talukaGramperaCount}</small></h3>
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
									<p class="category"><b><fmt:message key="GRAM_SBM"/></b></p>
									<h3 class="title"><small>${talukaSmbCount}</small></h3>
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
									<p class="category"><b><fmt:message key="GRAM_SVAGAT"></fmt:message></b></p>
									<h3 class="title"> <small>${talukaGramswagatCount}</small></h3>
								</div>
								
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="orange">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><b><%-- <fmt:message key="HSG_1_14_15"></fmt:message> --%>HSG</b></p>
									<h3 class="title"><small>${totalHsgCount}</small></h3>
								</div>
								
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
									<p class="category"><b><fmt:message key="HSG_1_15_16"></fmt:message></b></p>
									<h3 class="title"><small></small></h3>
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
									<p class="category"><b><fmt:message key="IAY"/></b></p>
									<h3 class="title"><small>${talukaIayCount}</small></h3>
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
									<p class="category"><b><fmt:message key="LAND_REVENUE"/></b></p>
									<h3 class="title"><small>${talukaJaminMehsulCount}</small></h3> 
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
									<p class="category"><b><fmt:message key="TAX_COLLECTION"/></b></p>
									<h3 class="title"><small>${talukaPanchVeraCount}</small></h3>
								</div>
								
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
									<p class="category"><b><fmt:message key="14th_FINANCE"/></b></p>
									<h3 class="title"><small>${talukaFinanceCount}</small></h3>
								</div>
								
							</div>
						</div>
						
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header" data-background-color="green">
									<i class="material-icons">content_copy</i>
								</div>
								<div class="card-content">
									<p class="category"><b>Property Master</b></p>
									<h3 class="title"><small>${totalPropertyCount}</small></h3>
								</div>
								
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


	

	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	

	

</html>
