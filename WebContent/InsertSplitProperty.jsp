<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%@ page import="com.zensoftech.eakarni.properties.*" %> --%>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>
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
					CDP14
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">dashboard</i>
	                        <p>14th_Finance</p>
	                    </a>
	                </li>
	                <li class="active">
	                    <a href="View_CDP_14.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p>CDP_14</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>egram</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>Gram Audit Para</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>Gram SMB</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>Gram Svagat</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>HSG_1_14_15</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>HSG_1_15_16</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>IAY</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>Land Revenue</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
	                        <i class="material-icons">person</i>
	                        <p>Milkat Register</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="">
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
	                            <div class="card-header" data-background-color="blue">
	                                <h4 class="title" style="text-align:center;font-weight:bold;">Split Property</h4>
	                                
	                            </div>
	                            <div class="card-content table-responsive">
	                                <form class="well form-horizontal" action="" method="post"  id="contact_form">
								<fieldset>
								
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Property Number:</label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="Property_number" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Name of occupant:</label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="Property_number" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Owner id</label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="Property_number" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Area name</label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="area_name" placeholder="" class="form-control"  type="text" >
								    </div>
								  </div>
								</div>
								
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;" >Description</label> 
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="description" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								<!-- Text input-->
								       <div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Owner Name</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="Owner_name" placeholder="" class="form-control"  type="text" disabled>
								    </div>
								  </div>
								</div>
								
								
								
								<!-- Text input-->
								       <div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Parent Property</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="Owner_name" placeholder="" class="form-control"  type="text" disabled>
								    </div>
								  </div>
								</div>
								
								
								<!-- Text input-->
								       
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Annual Rent</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="annual_rent" placeholder="" class="form-control" type="text">
								    </div>
								  </div>
								</div>
								
								<!-- Text input-->
								      
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">tax-estimated</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="tax_estimated" placeholder="" class="form-control" type="text">
								    </div>
								  </div>
								</div>
								
								<!-- Text input-->
								 
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">previously mentioned surplus and deficit amount</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="" placeholder="" class="form-control"  type="text" disabled>
								    </div>
								  </div>
								</div>
								
								 <div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">registered Page No:</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <input style="width:120px;height:20px" name="reg_pg_no" placeholder="" class=""  type="date">
								    </div>
								  </div>
								</div> 
								
								 <div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">tax and annual estimated</label>  
								  <div class="col-md-4 inputGroupContainer">
								  <div class="input-group">
								  <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="Property_number" placeholder="" class="form-control"  type="text">
								    </div>
								  </div>
								</div>
								
								
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">month</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <select id="month" name="month" style="width:120px;height:20px"  class="">
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
							<option></option></select>
								    </div>
								  </div>
								</div>
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">year</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="year" placeholder="" class="form-control" type="text">
								    </div>
								  </div>
								</div>
								
								
								
								<!-- <li><label class="">DATE</label></li> -->
						
							
					
							
								<button type="submit" data-background-color="blue" class="btn btn-large btn-primary"  >Submit</button>
								
							
								</fieldset>
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
<script>
   
</script>
</body>

	<!--   Core JS Files   -->
	<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/material.min.js" type="text/javascript"></script>

	

	
	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	
	

</html>
