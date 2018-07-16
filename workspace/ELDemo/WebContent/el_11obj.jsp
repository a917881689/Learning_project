<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL的十一大内置对象</title>
</head>
<body>
	<h2>1.四个域的范围(pageScpe,requestScope,sessionScope,applicationScope)</h2>
	<h3>2.获取请求参数 param、paramValues</h3>
	<!-- get请求不乱码,是因为修改了web.xml的URIEcoding编码方式 -->
	<%= request.getParameter("uname") %>
	${param.uname}
	${paramValues.hubby}
	<h3>2.获取请求头信息 header、headerValues</h3>
	<%= request.getHeader("User-Agent") %>
	${header["user-agent"]}
	<%-- ${header} --%>
	<%-- ${header.cookie}
	${header.Connection} --%>
	<h3>4.cookie</h3>
	${cookie}
	<h3>5.获取初始化参数</h3>
	<%= config.getServletContext().getInitParameter("p") %>
	${initParam.p}
	<h3>6.获取当前工程的路径</h3>
	<a href="${pageContext.request.contextPath}/test"></a>
	${pageContext.request.contextPath}
	
</body>
</html>