<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.zensoftech.eakarni.properties.*" %>
<%@ taglib uri="/WEB-INF/jstl-tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/jstl-tld/fmt.tld"  prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl-tld/sql.tld"  prefix="sql" %>

    <fmt:setLocale value="${applicationScope.deflocale}" />
<fmt:bundle basename="com.zensoftech.eakarni.properties.login" prefix="">

<html>
    <head>
        <meta charset="utf-8">        <title><fmt:message key="page.title"> </fmt:message></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
		<link rel="stylesheet" href="login page/css/style.css">
		
        <link href="login page/css1/bootstrap.css" rel="stylesheet">

        <link href="login page/css1/bootstrap-responsive.css" rel="stylesheet">
        <link href="login page/css1/style.css" rel="stylesheet">

        <!-- Fav and touch icons -->
       
        
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="login page/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="login page/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="login page/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="login page/ico/apple-touch-icon-57-precomposed.png">
        <link href="img/glyphicons-halflings.png" >
        
        <link rel="shortcut icon" href="login page/ico/favicon.png">
    </head>
<body>




	<div class="container spacing">
		<div class="row">
			<div class="navbar navbar-static-top">
				<div class="navbar-inner">            
					<!-- .btn-navbar is used as the toggle for collapsed navbar content -->
					<a class="btn btn-navbar mainbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</a>
					<div class="row">
						<div class="span12">
							<ul class="inline">
								
								<li style="float:left"><a class="brand" href="#"><img src="login page/img/chhotaudepur_logo1.png" height="150" width="150" alt="log.png" /></a></li>
								<li style="float:right"><a class="brand" href="#"><img src="login page/img/digital_india_logo.png" height="150" width="150" alt="log.png"/></a></li>
							</ul>
						</div>
					</div>
					
					<ul class="inline text-center">
						<li class="text-center"><fmt:message key="page.header"> </fmt:message></li>
					</ul>	
					
				</div>
			</div>
		</div>
		<!-- div class="row spacing"> -->
			<!-- div class="span2" id="myScrollspy">
			<div class="login"> --> -->
	<div class="container">
	 <div class="login">
      <h1><fmt:message key="login.h1"/></h1>
	 
<br>
		<h3 style="color:red"> Invalid Username and Password!!!</h3>
      <form method="post" action="LoginServlet">
        <p><input type="text" name="login" value="" placeholder=<fmt:message key="login.username.placeholder"/>></p>
        <p><input type="password" name="password" value="" placeholder=<fmt:message key="login.password.placeholder"/>></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            <fmt:message key="login.remember_me"/><br><br>
          </label>
        </p>
		<br>
        <p class="submit"><input type="submit" name="commit" value=<fmt:message key="login.h1"/>></p>
      </form>
	  
    </div>

    <div class="login-help">
      <p><fmt:message key="login.forgot_password"/> <a href="index.html"><fmt:message key="login.click"/></a>.</p>
    </div>
  </div>
				
			</div>
			<div class="span10"> 
			</div>	
		
	<div class="footer">
		<div class="text-center">
			<footer style="background: #1f1f1f; padding: 17px 0 17px 0;">
				<div class="footer-card" id="footer-card">
					<p style="color:#fff;"><fmt:message key="login.footer"/> <a href="#"><fmt:message key="login.footer_link"/></a></p>
				</div>
			</footer>
		</div>
	</div>
	</fmt:bundle>
</body>
</html>

