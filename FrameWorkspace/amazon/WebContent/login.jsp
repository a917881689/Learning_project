<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 登录</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" />
<link rel="stylesheet" href="css/nav.css"/>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/adv.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="js/nav.js" type="text/javascript"></script>
<script src="js/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<%@ include file="index_top.jsp"  %>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到亚马逊</h1>
			<form id="loginForm" method="post" action="doLogin">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="reg_text" type="text" name="uname" id="uname"/><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="reg_text" type="password" id="pwd" name="pwd" /> &nbsp;<a href="retrieve_password.jsp">忘记密码</a></td>
		
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input class="reg_text verycode" type="text" id="veryCode" maxlength="4"/>
						<img id="veryCode-img" src="${pageContext.request.contextPath}/getVeryCode" />
						<span></span></td>
					</tr>
					<tr style="border:none;">
						<td></td>
						<td><button type="button" style="width:150px;"  class="btn btn-success" id="btn-login">立即登录</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2018  上海海文 All Rights Reserved
</div>
</body>
</html>
