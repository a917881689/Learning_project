<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="8kb"%>
    <!-- buffer="8kb" 就是out缓冲区的大小，若改为0kb，则继续写入到response中 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp自带缓冲区</title>
</head>
<body>
	<%-- jsp的输出语句 --%>
	<%
		// A 写到response缓冲区
		response.getWriter().write(65);
		// 写到out缓冲区
		out.write("BBBBB");
	%>
	<%="CCCCC" %>
	<%
		// a
		response.getWriter().write(97);
	%>
	<!-- 默认顺序：out缓冲区最终要写入到response缓冲区，最后再写到页面中 -->
</body>
</html>