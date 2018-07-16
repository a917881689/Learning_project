<%@page import="java.util.ArrayList"%> <!-- page导包语句 -->
<%@page import="java.lang.Math" isErrorPage="true"%>
<!-- exception对象是存放在错误页面的 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP三大指令：指导jsp翻译和运行的指令</title>
</head>
<body>
	<%-- 静态包含指令 --%>
	<%-- <%@ include file="nav.jsp" %> --%>
	<%
		session.setAttribute("uname","admin");
		// 默认会在翻译的时候回自动创建session
		ArrayList<String> list = new ArrayList<String>();
		// int a = 10/0;
		out.print(Math.random()); // out:jspWrite
	%>
	<%-- jsp动作指令:动态包含 --%>
	<jsp:include page="nav.jsp"/>
	<%-- 第三大指令：taglib 导入第三方的库（c,fmt）struts2框架 OGNL表达式 --%>
</body>
</html>