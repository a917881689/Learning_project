<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>常用标签</title>
</head>
<body>
	<!-- 1.out标签 -->
	<%= "out脚本"%> <!-- out.print() -->
	<c:out value="out标签"/>
	<!-- 2.remove 标签：删除指定域中的属性对 -->
	<c:set var="name" value="admin" scope="request"/>
	<c:remove var="name" scope="request"/>
	${name}
	<!-- 3.param 标签 -->>
	<c:set var="name" value="管理员" scope="request"/>
	<%-- <c:param name="name" value="管理员"/> --%>
	<c:redirect url="test.jsp"/>
	<%-- <jsp:forward page="test.jsp"/> --%>
</body>
</html>