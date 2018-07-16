<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
        table,table tr th, table tr td { border:1px solid #0094ff; }
        table {text-align: center; border-collapse: collapse;width:300px;}
    </style>
</head>
<body>
<table>
	<thead>
	<tr>
		<th>工号</th>
		<th>姓名</th>
		<th>薪资</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="emp" items="${requestScope.list}">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.salary}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
	
</body>
</html>