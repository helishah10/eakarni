<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

<fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.GramSwagatTbl" prefix="">
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
					<fmt:message key="Gram_Svagat"/>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
	                    <a href="UpdateVillageFinance.jsp" >
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="14th_Finance"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <!-- <a href="VillageView_cdp14.jsp">  -->
	                     <a href="UpdateVillageCdp.jsp" >
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="CDP14"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="UpdateVillageEgram.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Egram"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="UpdateGPAudit.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Gram_Audit_Para"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="UpdateVillageSMB.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Gram_SMB"/></p>
	                    </a>
	                </li>
	                <li class="active">
	                    <a href="UpdateVillageGramSwagat.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Gram_Svagat"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="UpdateVillageHsg1.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="HSG_1_14_15"/></p>
	                    </a>
	                </li>
	               <%--  <li class="">
	                    <a href="UpdateVillageHsg2.jsp">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="HSG_1_15_16"/></p>
	                    </a>
	                </li> --%>
	                <li class="">
	                    <a href="UpdateVillageIay.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="IAY"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="UpdateVillageLandRevenue.jsp">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Land_Revenue"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">label</i>
	                        <p><fmt:message key="Milkat_Register"/></p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="UpdateVillagePanchVeraVasulat.jsp">
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
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<i class="material-icons">notifications</i>
									<span class="notification">5</span>
									<p class="hidden-lg hidden-md">Notifications</p>
								</a>
								<!-- <ul class="dropdown-menu">
									<li><a href="#">Mike John responded to your email</a></li>
									<li><a href="#">You have 5 new tasks</a></li>
									<li><a href="#">You're now friend with Andrew</a></li>
									<li><a href="#">Another Notification</a></li>
									<li><a href="#">Another One</a></li>
								</ul> -->
							</li>
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
					<form action="UpdateGramSwagatServlet" method="post">
						<fmt:message key="month"/>: <select id="month" name="month">
							<option value="0">Month
							<option>
							<option value="1">January
							<option>
							<option value="2">February
							<option>
							<option value="3">March
							<option>
							<option value="4">April
							<option>
							<option value="5">May
							<option>
							<option value="6">June
							<option>
							<option value="7">July
							<option>
							<option value="8">August
							<option>
							<option value="9">September
							<option>
							<option value="10">October
							<option>
							<option value="11">November
							<option>
							<option value="12">December
							<option>
						</select> <fmt:message key="year"/>: <input type="number" id="year" name="year" required />
						<button type="submit" name="submit" value="submit" id="submit"
							class="btn btn-primary pull-mid"><fmt:message key="click"/></button>
					</form>

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						
								 <div class="card-content">
									<div class="tab-content">
										<div class="tab-pane active" id="profile">
											
						<div class="col-lg-12 col-md-12">
							<div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title" style="text-align:center;font-weight:bold;"><fmt:message key="Gram_Svagat"/></h4>
	                                
	                            </div>
	                            <div class="card-content table-responsive">
	                            <form action="UpdateGramSwagatServlet" method="post">
	                                <table class="table table-hover">
	                                    <thead class="text-warning" style="color:blue;font-weight:900px;">
	                                          <tr>
												<th class="" style=""><fmt:message key="srno"/></th>
												<th class="" style=""><fmt:message key="descriptionOfQuestionsRaised"/> </th>
												<th class="" style=""><fmt:message key="disposal"/> </th>
												<th class="" style=""><fmt:message key="pending"/> </th>
											</tr>
	                                    	
	                                    </thead>
	                                    <tbody>
	                                     <%
																	int i = 1;
																%>
																<tr>
																	<%--  <td>${cdpvillage.key}</td> --%>
																	<td><%=i%> <%
 																		i++;
																	 %></td>
												<td><input type="text" name="descriptionOfQuestionsRaised" id="descriptionOfQuestionsRaised" value="${gramvillage.descriptionOfQuestionsRaised}"></td>
												<td><input type="number" name="disposal" id="disposal" value="${gramvillage.disposal}"></td>
												<td><input type="number" name="pending" id="pending" value="${gramvillage.pending}"></td> 
	            				 		</tr> 
				
	                                    </tbody>
	                                </table>
	                               <input type="hidden" name="gramvillage" value="${gramvillage}" />			
						<button type="submit" value="update" name="update" id="update"
							class="btn btn-primary pull-right">Update Values</button>
						<div class="clearfix"></div>
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
