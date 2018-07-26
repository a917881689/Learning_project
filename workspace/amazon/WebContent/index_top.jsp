
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊-导航栏</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<script src="${pageContext.request.contextPath}/scripts/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/nav.js" type="text/javascript"></script>
</head>
<body>
<input id="path" type="hidden" value="${pageContext.request.contextPath}"/>
<div id="header">
	<div class="login_menu">
		<div class="login_container">
			<c:set value="${sessionScope.user }" var="user"></c:set>
			<ul class="m_left">
				<c:if test="${empty loginUser }"> <!-- 未登录时 -->
					<li><a href="SaveURLServlet?saveURL=${pageContext.request.requestURL}&queryString=${pageContext.request.queryString}" class="c_red">请登录</a>&nbsp;&nbsp;&nbsp;</li>
					<li><a href="register.jsp">请注册</a></li>
            	</c:if>
                <c:if test="${!empty loginUser }"> <!-- 登录时 -->
		           	<li><a href="javascript:;">用户:${loginUser.uname}</a>&nbsp;&nbsp;&nbsp;</li>
		            <li><a href="cancel">注销</a></li>
            	</c:if>
				
			</ul>

			<ul class="m_right">
				<li><img src="images/icon_3.png" alt="" /><a
					href="shopping.jsp" class="c_red">购物车</a></li>
				<li><img src="images/icon_4.png" alt="" /><a
					href="javascript:AddFavorite('我的网站',location.href)">收藏</a></li>
				<li><img src="images/icon_2.png" alt="" /><a href="guestbook.jsp">留言</a></li>
				<li><img src="images/icon_1.png" alt="" /><a href="index.jsp">首页</a></li>
			</ul>
		</div>
	</div>
	<div class="logo_search">
		<div class="logo">
			<a href="index.jsp"><img src="images/LOGO.png" alt="" id="logo-img"/></a>
		</div>
		<div class="search">
			<input type="text" placeholder="输入宝贝" id="input_info" />
			<button class="query_button" id="btn-query" >搜索</button>
		</div>
	</div>
	<div class="nav_bar">
		<div class="nav_bar_container">
			<ul>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>
