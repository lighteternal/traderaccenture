<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Trade System</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">


<link href="<c:url value="css/demo.css" />" rel="stylesheet">
<link href="<c:url value="css/style3.css" />" rel="stylesheet">
<link href="<c:url value="css/animate-custom.css" />" rel="stylesheet">

<style>
body {
	background-image:
		url("http://wallpaper-gallery.net/images/accenture-wallpaper/accenture-wallpaper-2.jpg");
	background-size: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<!-- Codrops top bar -->
		<div class="codrops-top">


			<div class="clr"></div>
		</div>
		<!--/ Codrops top bar -->
		<header>
			<h1>
				Trade System <span> Login to my System</span>
			</h1>
			<nav class="codrops-demos">

				<c:if test="${param.error ne null}">
					<div style="color: red">Invalid credentials.</div>
					
					
				</c:if>
				
				<c:out value="${msg}" escapeXml="false">${msg}</c:out>
				
				<c:out value="${success}" escapeXml="false">${success}</c:out>
				
				
			</nav>
		</header>
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">



						<form action="/login" method="post">

							<h1>Log in</h1>
							<p>
								<label for="username" class="uname" data-icon="u"> Your
									email or username </label> <input type="text" class="form-control"
									id="username" name="username">
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">
									Your password </label> <input type="password" class="form-control"
									id="pwd" name="password">
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping"
									value="loginkeeping" /> <label for="loginkeeping">Keep
									me logged in</label>
							</p>
							<p class="login button">
								<input type="submit" value="Login" />
							</p>
							<p class="change_link">
								Not a member yet ? <a href="/register" class="to_register">Join
									us</a>
							</p>

							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />


						</form>
					</div>

					<div id="register" class="animate form">
						<form action="mysuperscript.php" autocomplete="on">
							<h1>Sign up</h1>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u">Your
									username</label> <input id="usernamesignup" name="usernamesignup"
									required="required" type="text"
									placeholder="mysuperusername690" />
							</p>
							<p>
								<label for="emailsignup" class="youmail" data-icon="e">
									Your email</label> <input id="emailsignup" name="emailsignup"
									required="required" type="email"
									placeholder="mysupermail@mail.com" />
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd" data-icon="p">Your
									password </label> <input id="passwordsignup" name="passwordsignup"
									required="required" type="password" placeholder="eg. X8df!90EO" />
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd"
									data-icon="p">Please confirm your password </label> <input
									id="passwordsignup_confirm" name="passwordsignup_confirm"
									required="required" type="password" placeholder="eg. X8df!90EO" />
							</p>
							<p class="signin button">
								<input type="submit" value="Sign up" />
							</p>
							<p class="change_link">
								Already a member ? <a href="#tologin" class="to_register">
									Go and log in </a>
							</p>
						</form>
					</div>

				</div>
			</div>
		</section>
	</div>
</body>
</html>