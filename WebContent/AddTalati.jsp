<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

    <fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.AddTalati" prefix="">
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
	<script src="assets/js/tab.js"></script>
	<link href="assets/css/dd.css" rel="stylesheet">
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
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
					<fmt:message key="Page.name"/>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
				<ul class="nav">
	                <li>
	                    <a href="/eakarni/TdoDashboardServlet">
	                        <i class="material-icons">dashboard</i>
	                        <p><fmt:message key="page.nav1"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="userDDO.jsp">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="page.nav2"/></p>
	                    </a>
	                </li>
	                <li class="active">
	                    <a href="listTalati.jsp">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="page.nav3"/></p>
	                    </a>
	                </li>
	                <li>
	                    <!-- <a href="schemes/village(index).html"> -->
							<a href="ViewTalukaVillageIndex.jsp" class="tablinks"  >
									<i class="material-icons">content_paste</i>
									<p class="tab"><fmt:message key="page.nav4"/></p>
							</a>
					</li>
							
					
					     <!-- <li>
	                    <a href="maps.html">
	                        <i class="material-icons">location_on</i>
	                        <p>Maps</p>
	                    </a>
	                </li>
	                <li>
	                    <a href="notifications.html">
	                        <i class="material-icons text-gray">notifications</i>
	                        <p>Notifications</p>
	                    </a>
	                </li>
					<li class="active-pro">
                        <a href="upgrade.html">
	                        <i class="material-icons">unarchive</i>
	                        <p>Upgrade to PRO</p>
	                    </a>
                    </li> -->
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
								<a href="TDO.jsp" ><!-- class="dropdown-toggle" data-toggle="dropdown" -->
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
							</li>
							<li>
								<a href="userTDO.jsp"> class="dropdown-toggle" data-toggle="dropdown"
	 							   <i class="material-icons">person</i>
	 							   <p class="hidden-lg hidden-md">Profile</p>
	 						   </a>
							</li> -->
							<!-- <li>
        							<a href="#" class="btn btn-info ">
         							<span class="glyphicon glyphicon-log-out"></span> Log out
        							</a>
      						</li> -->
						</ul>

						<!-- <form class="navbar-form navbar-right" role="search">
							<div class="form-group  is-empty">
	                        	<input type="text" class="form-control" placeholder="Search">
	                        	<span class="material-input"></span>
							</div>
							<button type="submit" class="btn btn-white btn-round btn-just-icon">
								<i class="material-icons">search</i><div class="ripple-container"></div>
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
	                                <h4 class="title"><fmt:message key="Add_Profile"></fmt:message></h4>
									<p class="category"><fmt:message key="Add_Talati_Details"/></p>
	                            </div>
	                            <div class="card-content">
	                                <form action="AddTalatiServlet" method="post">
	                                    <div class="row">
	                                        <div class="col-md-5">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Village_Name"/></label>
													<input type="text"name="villageName" class="form-control" >
												</div>
	                                        </div>
	                                      </div>
	                                      
	                                      <div class="row">  
	                                        <div class="col-md-3">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="User_Id"/></label>
													<input type="text" name="userId" class="form-control" >
												</div>
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="appointment_letter_no"/></label>
													<input type="number" name="appointmentLetterNo" class="form-control" >
												</div>
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="appointment_type"/></label>
													<input type="text" name="appointmentType" class="form-control" >
												</div> 
												 <%-- <label class=""><fmt:message key="appointment_type"/></label>
	                                        <div class="row"> 
	                                        
	                                       
	                                       
	                                        <div class="col-md-4">
												<div class="form-group">
													
													 <label class="">permanent<input type="radio" name="appointmentType" class="form-control" ></label><br/>
													 <label class="">temporary<input type="radio" name="appointmentType" class="form-control" ></label>
													
													
												</div>
	                                        </div>
	                                       </div>  --%>
												<div class="form-group ">
													<label class="control-label"><fmt:message key="join_date"/></label>
													<input type="date"  name="joindate" class="form-control" >
												</div>
	                                        </div>
	                                       </div> 
	                                       <div class="row">
	                                        <div class="col-md-4">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Village_Id"/></label>
													<input type="number" name="villageId" class="form-control" >
												</div>
	                                        </div>
	                                    </div>

	                                 <!--    onclick="location.href='listTDO.jsp;'" -->
	                                    <button type="submit" name="submit" class="btn btn-primary pull-right"><fmt:message key="page.submit"/></button>
	                                    <div class="clearfix"></div>
	                                </form>
	                            </div>
	                        </div>
	                    </div>
						<div class="col-md-4">
    						<div class="card card-profile">
    							<!-- <div class="card-avatar">
    								<a href="#pablo">
    									<img class="img" src="../assets/img/faces/marc.jpg" />
    								</a>
    							</div>
 -->
    							<!-- <div class="content">
    								<h6 class="category text-gray">CEO / Co-Founder</h6>
    								<h4 class="card-title">Alec Thompson</h4>
    								<p class="card-content">
    									Don't be scared of the truth because we need to restart the human foundation in truth And I love you like Kanye loves Kanye I love Rick Owens’ bed design but the back is...
    								</p>
    								<a href="#pablo" class="btn btn-primary btn-round">Follow</a>
    							</div> -->
    						</div>
		    			</div>
	                </div>
	            </div>
	        </div>

	       s
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
