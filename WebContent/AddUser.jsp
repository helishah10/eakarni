<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

    <fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.Admin" prefix="">
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
					<b><fmt:message key="Admin"/></b>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
	                    <a href="ViewAllDdos">
	                        <i class="material-icons">dashboard</i>
	                        <p><b><fmt:message key="ViewDdos"></fmt:message></b></p>
	                    </a>
	                </li>
	                 <li class="">
	                    <a href="AdminUser.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p><b><fmt:message key="User_Profile"/></b></p>
	                    </a>
	                </li>
	                 <li class="">
	                    <a href="AddDdo.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p><b><fmt:message key="Add_Ddo"/></b></p>
	                    </a>
	                </li>
	                 <li class="active">
	                    <a href="AddUser.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p><b><fmt:message key="Add_user"/></b></p>
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
								<a href="Admin.jsp"> 
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
								<a href="AdminUser.jsp"> <!-- class="dropdown-toggle" data-toggle="dropdown" -->
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

			   <div class="content">
	            <div class="container-fluid">
	                <div class="row">
	                 <div class="col-md-8">
	                        <div class="card">
	                            <div class="card-header" data-background-color="blue">
	                                <h4 class="title"><fmt:message key="Add_DDO_Details"/></h4>
									<p class="category"></p>
	                            </div>
	                            <div class="card-content">
	                                <form action="AddUserServlet" method="post">
	                                    <div class="row">
	                                        <div class="col-md-5">
												<div class="form-group label-floating">
													<label class=""><fmt:message key="User_Id"/></label>
													<input type="text" name="loginid" class="form-control" >
												</div>
	                                        </div>
	                                     </div>
	                                     <div class="row">
	                                        <div class="col-md-5">
												<div class="form-group label-floating">
													<label class=""><fmt:message key="Password"/></label>
													<input type="text" name="password" class="form-control" >
												</div>
	                                        </div>
	                                     </div>
	                                     <label class="">User Type</label>
	                                     <div class="row">
	                                        <div class="col-md-5">
												<div class="form-group label-floating">
													<label class="">Ddo
													<input type="radio" name="userType" value="Ddo" class="form-control" >
													<label class="">Tdo
													<input type="radio" name="userType" value="Tdo" class="form-control" >
													<label class="">Talati
													<input type="radio" name="userType" value="Talati" class="form-control" >
												</div>
	                                        </div>
	                                     </div>
	                                     
	                                      <button type="submit" name="submit" class="btn btn-primary pull-right" onclick="f1();"><fmt:message key="page.submit"/></button>
						</form>
						
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

	<

	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>

	 

</html>
