<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试SpringMVC中数组的参数封装</title>
</head>
<body>
	<h3>测试SpringMVC中数组的参数封装</h3>
	<h3>1.普通对象参数封装</h3>
	<form action="testArray1.action" method="post">
		兴趣爱好:<input type="checkbox" name="hobby" value="篮球"/>篮球
		<input type="checkbox" name="hobby" value="乒乓球"/>乒乓球
		<input type="checkbox" name="hobby" value="棒球"/>棒球
		<input type="checkbox" name="hobby" value="双球"/>双球
		<input type="submit"/>
	</form>
	<h3>2.对象中封装的数组获取</h3>
	<form action="testArray2.action" method="post">
		<input type="hidden" name="uname" value="桜">
		兴趣爱好:<input type="checkbox" name="hobby" value="篮球"/>篮球
		<input type="checkbox" name="hobby" value="乒乓球"/>乒乓球
		<input type="checkbox" name="hobby" value="棒球"/>棒球
		<input type="checkbox" name="hobby" value="双球"/>双球
		<input type="submit"/>
	</form>
</body>
</html>