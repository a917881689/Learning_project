<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊-新闻动态</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<script src="${pageContext.request.contextPath}/scripts/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/news.js" type="text/javascript"></script>
<style type="text/css">
	h2 {
		margin-top: 0;
	}
</style>
</head>
<body>
	<input id="path" type="hidden" value="${pageContext.request.contextPath}"/>
	<div class="newsList">
		<h2>新闻动态</h2>
		<ul id="newsCol">
		<li><a href="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
		</ul>
	</div>
</body>
</html>

