<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.yosakura.beans.Emp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式的计算功能</title>
</head>
<body>
	
	<% request.setAttribute("emp",new Emp(1,"王五",8000)); %>
	<p>计算5*4:${5*4}</p>
	<p>打印结果：${5>4?"ok":"error"}</p>
	<p>王五年薪：${emp.salary *12}</p>
	<p>判断域中对象是否为空(重点)：${empty emp}</p>
</body>
</html>
