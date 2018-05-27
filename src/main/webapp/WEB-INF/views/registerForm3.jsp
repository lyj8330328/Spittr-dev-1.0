<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
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
<title>Spitter Login</title>
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/resources/login-register/css/demo.css" />" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/resources/login-register/css/style2.css" />" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/resources/login-register/css/animate-custom.css" />" />
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
				Registration <span><a href="<s:url value="/home" />">
						HOME</a></span>
			</h1>
		</header>
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->

				<div id="wrapper">
					<div id="login" class="animate form">
						<sf:form method="POST" modelAttribute="spitter"
							enctype="multipart/form-data">
							<h1>Sign up</h1>
							<p>
								<label for="usernamesignup" class="uname">注:用户名6~12个字符，可使用字母、数字，需以字母开头</label>
							</p>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u">Your
									username</label>
								<sf:input path="username" />
							</p>

							<p>
								<label for="usernamesignup" class="uname"><sf:errors
										path="username"></sf:errors> </label>
							</p>


							<p>
								<label for="emailsignup" class="youmail" data-icon="e">
									Your email</label>
								<sf:input path="email" />
							</p>

							<p>
								<label for="emailsignup" class="youmail"> <sf:errors
										path="email"></sf:errors>
								</label>
							</p>
							<p>

								<label for="passwordsignup" class="youpasswd" data-icon="p">Your
									password </label>
								<sf:password path="password" />
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd"><sf:errors
										path="password"></sf:errors> </label>
							</p>

							<p>
								<label for="passwordsignup_confirm" class="youpasswd"
									data-icon="p">Please confirm your password </label>
								<sf:password path="passwordconfirm" />
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd"><sf:errors
										path="passwordconfirm"></sf:errors></label>
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd">Your
									Profile</label> 
								<input type="file" name="profilePicture" onchange="xmTanUploadImg(this)"
									accept="image/jpeg,image/png,image/gif">
								<script type="text/javascript">
									//判断浏览器是否支持FileReader接口
									if (typeof FileReader == 'undefined') {
										alert("<h1>当前浏览器不支持FileReader接口</h1>");
									}
									//选择图片，马上预览
									function xmTanUploadImg(obj) {
										var file = obj.files[0];
										var reader = new FileReader();
										reader.onload = function(e) {
											var img = document.getElementById("img1");
											img.src = e.target.result;
										}
										reader.readAsDataURL(file);
									}
								</script>		
							</p>
							<p align="center">
								<img src="<s:url value="/resources/login-register/images/profile_img.png" />" style="border-radius:70%; height: 130px; margin-top: 20px"  id="img1">
							</p>
							<p class="signin button">
								<input type="submit" value="Sign up" />
							</p>
							<p class="change_link">
								Already a member ? <a href="<c:url value="/spitter/login" />"
									class="to_register"> Go and log in </a>
							</p>
						</sf:form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>