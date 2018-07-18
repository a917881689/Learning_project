<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body>
	<h2>商品详情页</h2>
    <div>
        <div><img class="img" src="./img/${singleProduct.img}" alt=""/></div>
        <div>
            <span>${singleProduct.brand} ${singleProduct.memo}</span>
            <div>就是这么贵： ${singleProduct.price}</div>
            <div>
                <input type="text"/>
                <button type="button">+</button>
                <button type="button">-</button>
                <button type="button">加入购物车</button>
            </div>
        </div>
    </div>
</body>
</html>