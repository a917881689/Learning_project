<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html注释 -->
	<%-- JSP注释(方式一) --%>
	<%
		// 方式二 嵌入java脚本 (最终被翻译到service方法中)
		int a = 10;
		System.out.println(a);
		response.getWriter().write(20013); //中 (输出在响应体中)
	%>
	<%= a %> <!-- 输出语句(输出在响应体中) System.out.print(a) 作为里面的参数 -->
	<%= a%2 == 0?"偶数":"奇数" %> <!-- System.out.print(a%2 == 0?"偶数":"奇数") -->
	<%!
		// 方式四,定义成员变量或方法
		private String driver = "mysql.jdbc.driver.Driver";
		public void show () {
			System.out.println("Hello JSP");
		}
	%>
</body>
</html>