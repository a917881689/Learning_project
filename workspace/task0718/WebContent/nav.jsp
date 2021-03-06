<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航条</title>
<link rel="stylesheet" href="./css/style.css" type="text/css"/>
</head>
<body>
<div id="nav_bar">
    <ul id="nav">
        <li><a href="">首页</a></li>
        <li><a href="doShop">购物车</a></li>
        <li>
            <a href="doOrder">订单</a>
        </li>
        <li>
            <a href="">个人中心</a>
            <ul>
            	<c:if test="${empty loginUser }"> <!-- 未登录时 -->
		           	<li><a href="loginUI.jsp">登录</a></li>
		            <li><a href="registUI.jsp">注册</a></li>
            	</c:if>
                <c:if test="${!empty loginUser }"> <!-- 未登录时 -->
		           	<li><a href="javascript:;">${loginUser.uname}</a></li>
		            <li><a href="zhuxiao">注销</a></li>
            	</c:if>
                <li><a href="productView">商品展示</a></li>
                <li><a href="lasterHistory">最近浏览</a></li>
            </ul>
        </li>
    </ul>
</div>
</body>
</html>