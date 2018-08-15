<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" />
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
</head>

<body>
	<div id="regTitle" class="png"></div>
	<div id="regForm" class="userForm png">
	<input id="path" type="hidden" value="${pageContext.request.contextPath}"/>
		<form id="regist-form">
			<dl>
				<div id="info"></div>
				<dt>用 户 名：</dt>
				<dd>
					<input type="text" name="uname" id="uname"/>
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input type="password" name="pwd" id="pwd"/>
				</dd>
				<dt>确认密码：</dt>
				<dd>
					<input type="password" id="pwd2" />
				</dd>
				<dt>邮 箱：</dt>
				<dd>
					<input type="text" name="email" id="email"/>
				</dd>
			</dl>
			<div class="buttons">
				<input class="btn-reg png" type="button" id="btn-register"/><input
					class="btn-reset png" type="reset" value="" />
			</div>
			<div class="goback">
				<a href="index" class="png">返回登录页</a>
			</div>
		</form>
	</div>
</body>
</html>
