<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- set一般用来存放值的，var表示域中的值 -->
	<c:set var="age" value="${param.age}"/>
	<!-- c:if test:判断结果boolean 没有else,只需逻辑取反 !test-->
	您的年龄为：${param.age}岁，您处于阶段
	<c:if test="${param.age > 0 and param.age < 16}">
		青少年
	</c:if>
	<c:if test="${param.age >= 16 and param.age <= 30}">
		青年
	</c:if>
	<c:if test="${age > 30 and age <= 50}">
		中年
	</c:if>
	<c:if test="${age > 50 }">
		老年
	</c:if>
	
	<!-- 2.多分支语句 -->
	<c:choose>
		<c:when test="${age > 0 and age < 16}">好好学习,天天向上</c:when>
		<c:when test="${age >= 16 and age <= 30}">事业家庭并重</c:when>
		<c:when test="${age > 30 and age <= 50 }">走上人生巅峰</c:when>
		<c:when test="${age > 50}">该吃吃该喝喝，没事别往心里搁</c:when>
		<c:otherwise>奇行种</c:otherwise>
	</c:choose>
</body>
</html>