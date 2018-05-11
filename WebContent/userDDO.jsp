<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

<fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.UserDDO" prefix="">
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
					<fmt:message key="page.name"/>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
	                    <a href="DDO.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p><b><fmt:message key="page.nav1"/></b></p>
	                    </a>
	                </li>
	                <li class="active">
	                    <a href="userDDO.jsp">
	                        <i class="material-icons">person</i>
	                        <p><b><fmt:message key="page.nav2"/></b></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="ViewAllTdosServlet">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="page.nav3"/></p>
	                    </a>
	                </li>
	                <li>
	                   
							<a href="View_VillageIndex.jsp" class="tablinks"  >
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
								<a href="TDO.jsp" ><!-- class="dropdown-toggle" data-toggle="dropdown" -->
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
							<!-- <li>
								<a href="userDDO.jsp"> class="dropdown-toggle" data-toggle="dropdown"
	 							   <i class="material-icons">person</i>
	 							   <p class="hidden-lg hidden-md">Profile</p>
	 						   </a>
							</li> -->
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
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title"><fmt:message key="Profile"/></h4>
									<p class="category"><fmt:message key="Complete_Profile"/></p>
	                            </div>
	                            <div class="card-content">

	                                    <div class="row">
	                                        <div class="col-md-5">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="district"/></label>
													<input type="text" value="${appointmentDdo.district.name}"class="form-control" disabled>
												</div>
	                                        </div>
	                                        <div class="col-md-3">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="LoginId"/></label>
													<input type="text" value="${userdetails.user.loginId}" class="form-control" disabled >
												</div>
	                                        </div>
	                                        <div class="col-md-4">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Email"/></label>
													<input type="email" value="${userdetails.emailId}" id="emailId" class="form-control" >
												</div>
	                                        </div>
	                                    </div>

	                                    <div class="row">
	                                        <div class="col-md-5">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="First_name"/></label>
													<input type="text" value="${userdetails.firstName}" id="firstName" class="form-control" >
												</div>
	                                        </div>
	                                        <div class="col-md-3">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Middle_name"/></label>
													<input type="text" value="${userdetails.middleName}" id="middleName" class="form-control" >
												</div>
	                                        </div>
	                                        <div class="col-md-4">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Last_name"/></label>
													<input type="text" value="${userdetails.lastName}" id="lastName" class="form-control" >
												</div>
	                                        </div>
	                                    </div>

	                                    <div class="row">
	                                        <div class="col-md-12">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Address"/></label>
													<input type="text" value="${userdetails.address}" id="address" class="form-control" >
												</div>
	                                        </div>
	                                    </div>

	                                    <div class="row">
	                                        <div class="col-md-4">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Contact"/></label>
													<input type="number" value="${userdetails.contactNo}" id="contactNo" class="form-control" >
												</div>
	                                        </div>
	                                        <div class="col-md-4">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Postal_Code"/></label>
													<input type="number" value="${userdetails.postalCode}" id="postalCode" class="form-control" >
												</div>
	                                        </div>
	                                        <div class="col-md-4">
												<div class="form-group label-floating">
													<label class="control-label"><fmt:message key="Aadhar"/></label>
													<input type="number" value="${userdetails.aadharcard}" id="aadharcard" class="form-control" >
												</div>
	                                        </div>
	                                    </div>


	                                    <button type="submit" value="update" id="update" class="btn btn-primary pull-right"><fmt:message key="Update_Profile"/></button>
	                                    <div class="clearfix"></div>


	                            		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	                            <script>
	                           		 $(document).ready(function() {
	                              	  		$("#update").click(function()  {
	                           					var firstName = $("#firstName").val();
	                           					var middleName =  $("#middleName").val();
	                           					var lastName = $("#lastName").val();
	                           					var emailId = $("#emailId").val();
	                           					var address =  $("#address").val();
	                           					var contactNo = $("#contactNo").val();
	                           					var postalCode = $("#postalCode").val();
	                           					var aadharcard = $("#aadharcard").val();

	                           				 var userData;
	                           				 	userData={

	                     									"firstName":firstName,
	                     									"middleName":middleName,
	                     									"lastName":lastName,
	                     									"emailId":emailId,
	                     									"address":address,
	                     									"contactNo":contactNo,
	                     									"postalCode":postalCode,
	                     									"aadharcard":aadharcard

	                     						};


	                 

	                              	   	$.ajax({
	                              	      	
	                              	      	url:'TdoServlet',
	                              	      	type: 'GET',
	                              	      	contentType:'application/json',
	                              	      	dataType: 'json',
	                              	      	//data : userData,
	                              	     	data:{userData:JSON.stringify(userData)},

	                              	    	 success: function() {
	                              	    		 
	                              	    	 alert("data saved");
	                              	    	 },

	                              	   		error: function(jqXHR, textStatus, errorThrown) {
	                              	   			console.log(userdata);
	                              	   			console.log(jqXHR+", "+textStatus+","+ errorThrown);
	                              	     	  alert("Something went wrong");
	                              	   }

	                               })
	                              


	                              });

	                           });

	                            </script>

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
