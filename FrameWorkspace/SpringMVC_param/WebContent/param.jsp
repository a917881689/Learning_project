<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试SpringMVC中对象的参数封装</title>
</head>
<body>
	<h3>测试SpringMVC中对象的参数封装</h3>
	<h3>普通对象参数封装</h3>
	<form action="testobj1.action" method="get">
		<input type="hidden" name="id" value="66">
		用户名：<input type="text" name="uname" /><br/>
		密码：<input type="text" name="pwd" /><br/>
		性别:<input type="radio" name="sex" value="男" checked="checked">男
		<input type="radio" name="sex" value="女">女
		<input type="submit"/>
	</form>
	
	<h3>封装对象参数封装</h3>
	<form action="testobj2.action" method="get">
		<input type="hidden" name="user.id" value="66">
		用户名：<input type="text" name="user.uname" /><br/>
		密码：<input type="text" name="user.pwd" /><br/>
		性别:<input type="radio" name="user.sex" value="男" checked="checked">男
		<input type="radio" name="user.sex" value="女">女
		<input type="submit"/>
	</form>
</body>
</html>