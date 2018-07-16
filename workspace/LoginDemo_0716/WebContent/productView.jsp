<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品页面</title>
	<link rel="stylesheet" href="./css/style.css" type="text/css"/>
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="p-list">
    <ul>
    	<c:forEach var="pro" items="${products}">
    		<li>
	            <div class="p-img">
	                <img class="img" src="./img/${pro.img}" alt=""/>
	                <div class="img_big"><img src="./img/${pro.img}" alt=""/></div>
	            </div>
	            <a class="p-name" href="#">${pro.brand} ${pro.memo}</a>
	            <div class="p-price"> ${pro.price}</div>
        	</li>
    	</c:forEach>
    </ul>
</div>

</body>
</html>