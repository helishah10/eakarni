<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				Milkat Register
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
	                    <a href="14th_finance.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p>14th_Finance</p>
	                    </a>
	                </li>
	                <li>
	                    <a href="CDP_14.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p>CDP_14</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="egram.jsp">
	                        <i class="material-icons">person</i>
	                        <p>egram</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="Gram_Audit_Para.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Gram Audit Para</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="Gram_SBM.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Gram SBM</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="Gram_Svagat.jsp">
	                        <i class="material-icons">person</i>
	                        <p>egram</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="HSG_1_14_15.jsp"/>
	                        <i class="material-icons">person</i>
	                        <p>HSG_1_14_15</p>
	             
	                    </a>
	                </li>s
	                <li class="">   
	                    <a href="HSG_1_15_16.jsp">
	                        <i class="material-icons">person</i>
	                        <p>HSG_1_15_16</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="IAY.jsp">
	                        <i class="material-icons">person</i>
	                        <p>IAY</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="Land_Revenue.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Land Revenue</p>
	                    </a>
	                </li>
	                <li class="active">
	                    <a href="milkat_register.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Milkat Register</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="TaxCollection.jsp">
	                        <i class="material-icons">person</i>
	                        <p>TaxCollection</p>
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
	                                <h4 class="title" style="text-align:center;font-weight:bold;">Milkat Register</h4>
	                                
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table table-hover">
	                                    <thead class="text-warning" style="color:purple;font-weight:900px;">
	                                        <tr>
					<th colspan="9" style="text-align:center"> મિલકત વિગતો</th>
				</tr>
					<tr>
					<!-- <th>Cost</th><th>Profit</th><th>Fun</th></tr></thead> -->
					<th colspan="" class="" style="text-align:center">મિલકત નંબર</th>
									<th colspan="" class="" style="text-align:center">માલિક નું  નામ </th>
									<th colspan="" class="" style="text-align:center">રહેનાર નું  નામ </th>
									<th colspan="" class="" style="text-align:center">વિસ્તાર નામ </th>
									<th colspan="" class="" style="text-align:center">મિલકત વર્ણન</th>
									
									<th colspan="" class="" style="text-align:center">વાર્ષિક ભાડું:</th>
									<th colspan="" class="" style="text-align:center">કર ની આકારેલી રકમ :</th>
									<th colspan="" class="" style="text-align:center">પછલા વધારેલા અને ગટાળા ની બાબત  :</th>
									<th colspan="" class="" style="text-align:center">રજીસ્ટર પાનાં ક્રમાંક:</th>
					</tr>
	                                    	
	                                    </thead>
	                                    <tbody>
	                                       <!--  <tr>
	                                        	<td ></td>
	                                        	<td ></td>
	                                        	<td ></td>
	                                        	<td ></td>
	                                        	<td ></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	
	                                        </tr>
	                                        <tr>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td> </td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        </tr>
	                                        <tr>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td> </td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        </tr>
	                                        <tr>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td> </td>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
	                                        </tr> -->
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

</body>

	<!--   Core JS Files   -->
	<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/material.min.js" type="text/javascript"></script>

	

	
	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	
	

</html>
