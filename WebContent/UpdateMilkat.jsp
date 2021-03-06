<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<script>
function myFunction() {
    alert("report generated");
}
</script>
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
					Schemes
				</a>
			</div>

	    <div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
	                    <a href="ViewDistrictFinance.jsp" >
	                        <i class="material-icons">label</i>
	                        <p>14th_Finance</p>
	                    </a>
	                </li>
	                <li class="active">
	                    <a href="ViewDistrictCdp.jsp"> 
	                        <i class="material-icons">label</i>
	                        <p>CDP14</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="ViewDistrictEgram.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Egram</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="ViewDistrictGramAuditPera.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Gram_Audit_Para</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="ViewDistrictGramSMB.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Gram_SMB</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="ViewDistrictGramswagat.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Gram_Svagat</p>
	                    </a>
	                </li>
	                 <li class="">
	                    <a href="ViewDistrictGramswagat.jsp">
	                        <i class="material-icons">label</i>
	                        <p>hsg</p>
	                    </a>
	                </li>
	               <!--  <li class="">
	                    <a href="ViewDistrictHsg1516.jsp">
	                        <i class="material-icons">person</i>
	                        <p>HSG_1_15_16</p>
	                    </a>
	                </li> -->
	                <li class="">
	                    <a href="ViewDistrictIAY.jsp">
	                        <i class="material-icons">label</i>
	                        <p>IAY</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="ViewDistrictJaminMehsul.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Land_Revenue</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="ViewDistrictMilkatRegister.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Milkat_Register</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="ViewDistrictPanchVeraVasulat.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Tax_Collection</p>
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
					<form action="UpdateCdpServlet" method="post">
						month: <select id="month" name="month">
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
						</select> year: <input type="number" id="year" name="year" required />
						<button type="submit" name="submit" value="submit" id="submit"
							class="btn btn-primary pull-mid">click</button>
					</form>
			


					<br>
					<br>
					<div>
						<div class="row">

							<div class="card-content">
								<div class="tab-content">
									<div class="tab-pane active" id="profile">

										<div class="col-lg-12 col-md-12">
											<div class="card">
												<div class="card-header" data-background-color="purple">
													<h4 class="title"
														style="text-align: center; font-weight: bold;">Milkat Register</h4>

												</div>
												<div class="card-content table-responsive">
													<form action="UpdateCdpServlet" method="post">

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
	                                             <% int i = 1; %>  
	                             <c:forEach var="milkat" items="${districtPropertyDetails}"> 
	          					  <tr>
	          					 <td><%= i %> <% i++; %></td> 
	                                <%-- <td>${entry.key}</td>  --%>
	                               <td style="text-align:center">${milkat.value.property.propertyNo}</td>
	                               <td style="text-align:center">${milkat.value.owner.ownerName}</td>
	                               <td style="text-align:center">${milkat.value.occupant.occupantName}</td>
	                               <td style="text-align:center">${milkat.value.property.areaName}</td>
	                               <td style="text-align:center">${milkat.value.property.description}</td>
	                               <td style="text-align:center">${milkat.value.tax.assessmentOfAnnualRent}</td>
	                               <td style="text-align:center">${milkat.value.tax.estimatedTaxAmount}</td>
	                               <td style="text-align:center">${milkat.value.tax.previouslyMentionedSurplusAndDeficitAmount}</td>  
	                                <td style="text-align:center">${milkat.value.property.registerPageNo}</td>        	 
	            				 </tr> 
								</c:forEach>
	                                    </tbody>
	                                </table>
	                                <input type="hidden" name="" value="" />			
						<button type="submit" value="update" name="update" id="update"
							class="btn btn-primary pull-right" >Update</button>
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

</body>

	<!--   Core JS Files   -->
	<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/material.min.js" type="text/javascript"></script>

	

	
	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	
	

</html>
