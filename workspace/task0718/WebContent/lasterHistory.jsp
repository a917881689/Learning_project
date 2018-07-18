<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>历史记录</title>
<link rel="stylesheet" href="./css/product.css" type="text/css"/>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="p-list">
    <ul>
    	<c:forEach var="pro" items="${lasterHistory}">
    		<li>
	            <div class="p-img">
	                <a href="productDetail?currentid=${pro.id}">
	                <img class="img" src="./img/${pro.img}" alt=""/></a>
	                <div class="img_big"><img src="./img/${pro.img}" alt=""/></div>
	            </div>
	            <a href="productDetail?currentid=${pro.id}" class="p-name" >${pro.brand} ${pro.memo}</a>
	            <div class="p-price"> ${pro.price}</div>
        	</li>
    	</c:forEach>
    </ul>
</div>
</body>
</html>