<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>学士后 短消息平台</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
	<input id="path" type="hidden" value="${pageContext.request.contextPath}"/>
	<div id="loginTitle" class="png"></div>
	<div id="loginForm" class="userForm png">
		<form id="login-form" >
			<dl>
				<div id="info">登录</div>
				<dt>用户名：</dt>
				<dd>
					<input type="text" name="uname" />
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input type="password" name="pwd" />
				</dd>
			</dl>
			<div class="buttons">
				<input class="btn-login png" type="button" id="btn-login"/>
				<a href="register"><input class="btn-reg png" type="button" id="btn-register"/></a>
			</div>
		</form>
	</div>
</body>
</html>

