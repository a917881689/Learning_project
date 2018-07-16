<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户页面</title>
<link rel="stylesheet" href="./css/style.css" type="text/css"/>
<script type="text/javascript" src="./js/jquery-3.1.0.min.js"></script>
</head>
<body>
	作业：展示所有的商品（一行6个，一页显示两行数据）
	<ul class="gdoos_ul">
		<c:forEach var="goods"  items="${requestScope.goods}" >
        	<li>编号:${goods.gId} 商品名:${goods.gName} 商品类型:${goods.typeId} 商品价格:${goods.price}</li>
		</c:forEach>
	</ul>
	<a href="user?page=${param.page-1}">上一页</a>
	<a href="user?page=${param.page+1}">下一页</a>
</body>
</html>