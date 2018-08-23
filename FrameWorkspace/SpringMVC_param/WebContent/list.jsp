<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试SpringMVC中对象集合的参数封装</title>
</head>
<body>
	<h3>测试SpringMVC中对象集合的参数封装</h3>
	<h3>1.普通对象参数封装</h3>
	<form action="testList.action" method="post">
		性名：<input type="text" name="list[0].uname" value="桜"/>&nbsp;
		密码：<input type="text" name="list[0].pwd" value="123" />&nbsp;
		性别:<input type="text" name="list[0].sex" value="女"/>
		<hr/>
		性名：<input type="text" name="list[1].uname" value="雨露"/>&nbsp;
		密码：<input type="text" name="list[1].pwd" value="123" />&nbsp;
		性别:<input type="text" name="list[1].sex" value="女"/>
		<hr/>
		性名：<input type="text" name="list[2].uname" value="sakura"/>&nbsp;
		密码：<input type="text" name="list[2].pwd" value="123" />&nbsp;
		性别:<input type="text" name="list[2].sex" value="女"/>
		<hr/>
		<input type="submit"/>
	</form>

</body>
</html>