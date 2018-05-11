
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
	
	<script type="text/javascript" src="assets/js/jquery-1.3.2.min.js"></script>
	<script src="js/milkat.js" type="text/javascript"></script>
<link href="css/milkat.css" rel="stylesheet" type="text/css">
	<!-- <script type="text/javascript">
	
	$(document).ready(function(){

    var counter = 2;

    $("#addButton").click(function () {

	if(counter>10){
            alert("Only 10 textboxes allow");
            return false;
	}

	var newTextBoxDiv = $(document.createElement('div'))
	     .attr("id", 'TextBoxDiv' + counter);

	newTextBoxDiv.after().html('<label>Owner name' + ' : </label>' +
	      '<input type="text" name="textbox' + counter +
	      '" id="textbox' + counter + '" value="" >'+""+'<label>Aadhar card' + ' : </label>' +
	      '<input type="text" name="textbox' + counter +
	      '" id="textbox1' + counter + '" value="" >');
	

	newTextBoxDiv.appendTo("#TextBoxesGroup");


	
	counter++;
     });

     $("#removeButton").click(function () {
	if(counter==1){
          alert("No more textbox to remove");
          return false;
       }

	counter--;

        $("#TextBoxDiv" + counter).remove();

     });

     $("#getButtonValue").click(function () {

	var msg = '';
	for(i=1; i<counter; i++){
   	  msg += "\n Textbox #" + i + " : " + $('#textbox' + i).val();
	}
    	  alert(msg);
     });
  });
</script> -->
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
	                    <a href="View_14thFinance.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p>14th_Finance</p>
	                    </a>
	                </li>
	                <li>
	                    <a href="View_CDP_14.jsp">
	                        <i class="material-icons">dashboard</i>
	                        <p>CDP_14</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="View_egram.jsp">
	                        <i class="material-icons">person</i>
	                        <p>egram</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="View_Gram_Audit_Para.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Gram Audit Para</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="View_Gram_SMB.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Gram SMB</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="View_Gram_Svagat.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Gram Svagat</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="View_HSG_1_14_15.jsp">
	                        <i class="material-icons">person</i>
	                        <p>HSG_1_14_15</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="View_HSG_1_15_16.jsp">
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
	                    <a href="View_Land_Revenue.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Land Revenue</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="View_milkat_register.jsp">
	                        <i class="material-icons">person</i>
	                        <p>Milkat Register</p>
	                    </a>
	                </li>
	                <li class="">
	                    <a href="View_TaxCollection.jsp">
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
										
										
										
									<div class="main">
									<div class="header">
									<h3>Milkat Register</h3>
									</div>
									
									<div class="two">
									<button class="name" onclick="textBoxCreate()">add(Owner,AddharCard)</button>
									<button class="email" onclick="other()">Other</button>
									<button class="email" onclick="self()">Self</button>
									
									</div>
									
									<div class="third">
									<form action="NewFile.jsp" id="mainform" method="get" name="mainform">
									<p id="myForm"></p><input type="submit" value="Submit">
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
	<!-- <script type="text/javascript">
	function add_fields() {
  	 var d = document.getElementById("content");
  
   	d.innerHTML += "<br /><input type='text'style='width:48px;'value='' />";
}
</script> -->
</body>

	<!--   Core JS Files   -->
	<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/material.min.js" type="text/javascript"></script>

	

	
	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	
	

</html>
