<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<script src="js/add.js"></script>
  <link rel="stylesheet" href="css/bootstrap.min.css1">
  <script src="js/radio.js"></script>
  <script>
  
  
$(document).ready(function () {
    $(".text").hide();
	
    $("#r1").click(function () {
        $(".text").show();
		$(".text1").hide();
    });
	$(".text1").hide();
    $("#r2").click(function () {
        
		 $(".text").hide();
		 $(".text1").show();
    });
});

</script>
<script>




$(document).ready(function () {
    $(".parent").hide();
    $("#p1").click(function () {
        $(".parent").show();
    });
	 $("#p2").click(function () {
        $(".parent").hide();
    });
	
	
   
});

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
					milkat register
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                <li class="">
	                    <a href="InsertFinance.jsp">
	                        <i class="material-icons">label</i>
	                        <p style="">14 finance</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertCdp.jsp">
	                        <i class="material-icons">label</i>
	                        <p>cdp</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertEgram.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Egram</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertGramAudit.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Gram_Audit_Para</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertGramSMB.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Gram_SMB</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertGramSvagat.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Gram_Svagat</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertHSG_1_14_15.jsp">
	                        <i class="material-icons">label</i>
	                        <p>HSG_1_14_15</p>
	                    </a>
	                </li>
	                
	                <li class="">
	                    <a href="InsertIAY.jsp">
	                        <i class="material-icons">label</i>
	                        <p>IAY</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertJaminMehsul.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Land_Revenue</p>
	                    </a>
	                </li>
	                <li class="active">
	                    <a href="InsertMilkatRegister.jsp">
	                        <i class="material-icons">label</i>
	                        <p>Milkat_Register</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="InsertPanchVeraVasulat.jsp">
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
					<div class="row">
						
								 <div class="card-content">
									<div class="tab-content">
										<div class="tab-pane active" id="profile">
											
						<div class="col-lg-12 col-md-12">
							<div class="card">
	                            <div class="card-header" data-background-color="blue">
	                                <h4 class="title" style="text-align:center;font-weight:bold;">milkat register</h4>
	                                
	                            </div>
	                            <div class="card-content table-responsive">
	                                <form class="well form-horizontal" action="/eakarni/InsertCdpServlet" method="post"  id="contact_form">
								<fieldset>
																<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;" >Owner</label> 
								  
								  <input style="width:120px;height:20px" type="text" name="occupant" class="form-control" placeholder="owner"><br/><br/>
								   <label class="col-md-4" style="font-weight:bold;color:black;" >Addhar number</label> 
								   <input style="width:120px;height:20px" type="text" name="aadhar" class="form-control" placeholder="aadhar">
								  <div class="col-md-4 inputGroupContainer">
								<div class="input-group control-group after-add-more">
								<span class="input-group-addon"><i class=""></i></span>
								
								  
								  <!-- <div class="input-group-btn"> 
									<button class="btn btn-success add-more" type="button"><i class="glyphicon glyphicon-plus"></i> Add</button>
								  </div> -->
								</div>
								</div>
								</div>
								
								 <div class="copy hide">
								<div class="form-group">
								<div class="abc">
								<label class="col-md-4" style="font-weight:bold;color:black;" >Owner</label> 
								  <input style="width:120px;height:20px" type="text" name="occupant" class="form-control" placeholder="owner"><br/><br/>
								   <label class="col-md-4" style="font-weight:bold;color:black;" >Addhar number</label> 
								   <input style="width:120px;height:20px" type="text" name="aadhar" class="form-control" placeholder="aadhar">
								 <div class="input-group-btn"> 
									  <button class="btn btn-danger remove" type="button"><i class="glyphicon glyphicon-remove"></i> Remove</button>
									</div>
								</div>
								</div>
								</div>
								  <!-- <label class="col-md-4" style="font-weight:bold;color:black;" ></label> 
								  <div class="col-md-4 inputGroupContainer">
								<div class="input-group control-group">
								<span class="input-group-addon"><i class=""></i></span>
									
									<input style="width:120px;height:20px" type="text" name="" class="form-control" placeholder="owner"><br/><br/>
									<input style="width:120px;height:20px" type="text" name="" class="form-control" placeholder="aadhar">
									<div class="input-group-btn"> 
									  <button class="btn btn-danger remove" type="button"><i class="glyphicon glyphicon-remove"></i> Remove</button>
									</div>
								  </div>
								</div>
								</div>
								</div> -->
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;" >Split</label> <br/> <br/>
								  <label class="col-md-4" style="font-weight:bold;color:black;" >yes</label> 
								  <input style="width:120px;height:20px" id="p1" type="radio" name="occupant" class="form-control"><br>
								  <label class="col-md-4" style="font-weight:bold;color:black;" >no</label> 
								  <input style="width:120px;height:20px" id="p2" type="radio" name="occupant" class="form-control" >
								  <div class="col-md-4 inputGroupContainer">
								<div class="input-group control-group">
								<span class="input-group-addon"><i class=""></i></span>
								  </div>
								  </div>
								  </div>
								  
								  <div class="parent">
								  <div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;" >Parent</label> 
								  <input style="width:120px;height:20px" type="text" name="parent" class="form-control" placeholder="parent"><br/><br/>
								  
								  <div class="col-md-4 inputGroupContainer">
								<div class="input-group control-group after-add-more1">
								<span class="input-group-addon"><i class=""></i></span>
								
								  
								 
								</div>
								</div>
								</div>
								  </div>
								  
								
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;" >self</label> 
								  <input style="width:120px;height:20px" id="r1" type="radio" name="occupant" class="form-control"><br/>
								   <label class="col-md-4" style="font-weight:bold;color:black;" >other</label> 
								  <input style="width:120px;height:20px" id="r2" type="radio" name="occupant" class="form-control" >
								  <div class="col-md-4 inputGroupContainer">
								<div class="input-group control-group">
								<span class="input-group-addon"><i class=""></i></span>
								  </div>
								  </div>
								  </div>
								  
								  <div class="text">
								  <div class="form-group">
								   <label class="col-md-4" style="font-weight:bold;color:black;" >મિલકત નંબર</label> 
								  <input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="મિલકત નંબર"><br/><br/>
								  <label class="col-md-4" style="font-weight:bold;color:black;" >વિસ્તાર નામ</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="વિસ્તાર નામ"><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >મિલકત વર્ણન</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="મિલકત વર્ણન"><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >વાર્ષિક ભાડું:</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="વાર્ષિક ભાડું:"><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >કર ની આકારેલી રકમ</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="કર ની આકારેલી રકમ "><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >પછલા વધારેલા અને ગટાળા ની બાબત </label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="પછલા વધારેલા અને ગટાળા ની બાબત :"><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >રજીસ્ટર પાનાં ક્રમાંક</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="રજીસ્ટર પાનાં ક્રમાંક:"><br/><br/>
							
								  
								  </div>
								  </div>
								  
								   <div class="text1">
								    <div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;" >Occupant</label> 
								  <input style="width:120px;height:20px" type="text" name="occupant" class="form-control" placeholder="occupant"><br/><br/>
								   <label class="col-md-4" style="font-weight:bold;color:black;" >Addhar number</label> 
								   <input style="width:120px;height:20px" type="text" name="aadhar" class="form-control" placeholder="aadhar">
								  <div class="col-md-4 inputGroupContainer">
								<div class="input-group control-group after-add-more1">
								<span class="input-group-addon"><i class=""></i></span>
								
								  
								  <!-- <div class="input-group-btn"> 
									<button class="btn btn-success add-more1" type="button"><i class="glyphicon glyphicon-plus"></i> Add</button>
								  </div> -->
								</div>
								</div>
								</div>
								<label class="col-md-4" style="font-weight:bold;color:black;" >મિલકત નંબર</label> 
								  <input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="મિલકત નંબર"><br/><br/>
								  <label class="col-md-4" style="font-weight:bold;color:black;" >વિસ્તાર નામ</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="વિસ્તાર નામ"><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >મિલકત વર્ણન</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="મિલકત વર્ણન"><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >વાર્ષિક ભાડું:</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="વાર્ષિક ભાડું:"><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >કર ની આકારેલી રકમ</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="કર ની આકારેલી રકમ "><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >પછલા વધારેલા અને ગટાળા ની બાબત </label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="પછલા વધારેલા અને ગટાળા ની બાબત :"><br/><br/>
								<label class="col-md-4" style="font-weight:bold;color:black;" >રજીસ્ટર પાનાં ક્રમાંક</label> 
								<input style="width:120px;height:20px" type="text" name="addmore[]" class="form-control" placeholder="રજીસ્ટર પાનાં ક્રમાંક:"><br/><br/>
							
								
								
								<div class="copy1 hide">
								<div class="form-group">
								<div class="abc1">
								<label class="col-md-4" style="font-weight:bold;color:black;" >Occupant</label> 
								  <input style="width:120px;height:20px" type="text" name="occupant" class="form-control" placeholder="owner"><br/><br/>
								   <label class="col-md-4" style="font-weight:bold;color:black;" >Addhar number</label> 
								   <input style="width:120px;height:20px" type="text" name="aadhar" class="form-control" placeholder="aadhar">
								 <div class="input-group-btn"> 
									  <button class="btn btn-danger remove" type="button"><i class="glyphicon glyphicon-remove"></i> Remove</button>
									</div>
								</div>
								</div>
								</div>
								   
								   
								   </div>
								   
								   
								  
								  <div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Month</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								 <select id="month" name="month">
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
						</select>
								    </div>
								  </div>
								</div>
								<div class="form-group">
								  <label class="col-md-4" style="font-weight:bold;color:black;">Year</label>  
								    <div class="col-md-4 inputGroupContainer">
								    <div class="input-group">
								        <span class="input-group-addon"><i class=""></i></span>
								  <input value="" style="width:120px;height:20px" name="year" placeholder="" class="form-control" type="text">
								    </div>
								  </div>
								</div>
								
								
								
								<!-- <li><label class="">DATE</label></li> -->
						
							
					
							
								<button type="submit" class="btn btn-large btn-primary" style="background-color:skyblue" >Submit</button>
								
							</div>
								</fieldset>
								</form>
								  
								

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
</div>
</div>
</div>
<script type="text/javascript">

    $(document).ready(function() {

      $(".add-more").click(function(){ 
          var html = $(".copy").html();
          $(".after-add-more").after(html);
		  
      });

      $("body").on("click",".remove",function(){ 
          $(this).parents(".abc").remove();
      });

    });
	
	 $(document).ready(function() {

      $(".add-more1").click(function(){ 
          var html = $(".copy1").html();
          $(".after-add-more1").after(html);
		  
      });

      $("body").on("click",".remove",function(){ 
          $(this).parents(".abc1").remove();
      });

    });

</script>

</body>

	<!--   Core JS Files   -->
	<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/material.min.js" type="text/javascript"></script>

	

	
	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	
	

</html>
