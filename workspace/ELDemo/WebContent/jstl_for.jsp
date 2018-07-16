<%@page import="java.util.ArrayList"%>
<%@page import="com.yosakura.beans.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>迭代</title>
</head>
<body>
	<%
	ArrayList<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1,"张三",6666));
		list.add(new Emp(2,"李四",8888));
		request.setAttribute("list",list);
	%>
	<!-- 1.forEach的高级迭代  var:每次迭代接收的变量名，items需要迭代的内容-->
	<c:forEach var="emp" items="${list}">
		${emp.id} ${emp.name} ${emp.salary} ${emp.salary*12} <br/>
	</c:forEach>
	<!-- 基础迭代 -->
	<c:forEach var="i" begin="1" end="9"> ${i} </c:forEach> <br/>
	<c:forEach var="i" begin="1" end="9"> ${i*i} </c:forEach> <br/>
	<c:forEach var="i" begin="1" end="9" step="2"> ${i} </c:forEach> <br/>
	<hr/>
	<h3>打印九九乘法表</h3>
	<c:forEach var="row" begin="1" end="9">
		<c:forEach var="col" begin="1" end="${row}">
			${row} &#42;${col} &#61; ${row*col} &emsp;
		</c:forEach>
		<br/>
	</c:forEach> <br/>
	<!-- 3.面试有可能会出现的迭代, delims分割条件，类似于split分割-->
	<c:forTokens var="company" items="baidu,oracle,mysql" delims=",">${company}</c:forTokens>
</body>
</html>