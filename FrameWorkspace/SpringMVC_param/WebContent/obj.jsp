<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试SpringMVC传参</title>
</head>
<body>
	<h2>测试SpringMVC传参</h2>
	<h3>1.普通参数的获取</h3>
	<a href='testParam1.action?id=123'>普通英文参数的传递(传统servletAPI获取)</a>
	<a href='testParam2.action?id=123'>普通英文参数的传递(使用类型名称绑定)</a>
	<a href='testParam3.action?id=123&uname=管理员'>双参数的传递(使用类型名称绑定)</a>
	<hr/>
	<a href='testParam4.action?uname=管理员'>普通中文参数的传递</a>
	<h3>表单get测试</h3>
	<form action="testParam5.action" method="get">
		用户名：<input type="text" name="uname" />
		密码：<input type="text" name="pwd" />
		<input type="submit"/>
	</form>
	<h3>测试post请求</h3>
	<form action="testParam6.action" method="post">
		用户名：<input type="text" name="uname" />
		密码：<input type="text" name="pwd" />
		<input type="submit"/>
	</form>
</body>
</html>