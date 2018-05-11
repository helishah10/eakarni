<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

    <fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.ListTalati" prefix="">
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
					<b><fmt:message key="page.name"/>
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
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
	                <li class="active">
	                    <a href="listTalati.jsp">
	                        <i class="material-icons">person</i>
	                        <p><fmt:message key="page.nav3"/></p>
	                    </a>
	                </li>
	                <li>
	                   
							<a href="ViewTalukaVillageIndex.jsp" class="tablinks"  >
									<i class="material-icons">content_paste</i>
									<p class="tab"><fmt:message key="nav3.menu1"/></p>
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
        							<!-- <a href="/eakarni/LogoutServlet" class="btn btn-info "> -->
        							 <a href="LogoutServlet"> 
								<i class="material-icons">power_settings_new</i>
									<p class="hidden-lg hidden-md">power_settings_new</p>
									<label> logout </label>
								</a>
      						</li>
							<!-- <li>
        							<a href="#" class="btn btn-info ">
         							<span class="glyphicon glyphicon-log-out"></span> Log out
        							</a>
      						</li> -->
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
	                            <div class="card-header" data-background-color="orange">
	                                <h4 class="title" style="text-align:center;font-weight: bold;"><fmt:message key="Taluka_dev_officers"/></h4>
	                                
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table table-hover">
	                                    <thead class="text-warning">
	                                        <th><b><fmt:message key="Login_Id"/></b></th>
	                                        <th><fmt:message key="Village_Id"/></th>
	                                    	<th><fmt:message key="Start_date"/></th>
	                                    	<%-- <th><fmt:message key="End_date"/></th> --%>
	                                    	<th><fmt:message key="appointmentLetterNo"/></b></th>
	                                    	
	                                    </thead>
	                                    <tbody>
	                                     <c:forEach var="talati" items="${AllTalatis}">
	                                        <tr>
	                                        	 <td>${talati.user.loginId}</td>
	                                        	<td>${talati.village.vId}</td>
	                                        	<td>${talati.startDate}</td>
	                                        	<%-- <td>${talati.endDate}</td> --%>
	                                        	<td>${talati.appointmentLetterNo}</td>  
	                                        	 
	                                        	
	                                        </tr>
	                                        
	                                       </c:forEach>
	                                    </tbody>
	                                </table>
	                               
	                                <input type="button" onclick="location.href='AddTalati.jsp';" class="btn btn-white btn-round btn-just-icon" value="<fmt:message key="Add_New_Talati"/>" style="color:white;background:orange;">
									<i class="material-icons"></i><div class="ripple-container"></div>
	                            </div>
	                        </div>
						</div>
					</div>
				</div>
			</div> 

<!-- 			
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
