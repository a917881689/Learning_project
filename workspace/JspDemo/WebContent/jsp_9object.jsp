<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--  JSP九大隐式（内置）对象：JSP被翻译后的servlet中的service中定义的九个变量 --%>
	<%
		// 1. out (JspWriter) 页面输出（out缓冲区）
		out.write("我是out对象");
		// 2.request 请求对象
		String name = request.getParameter("uname");
		request.setAttribute("pwd","888");
		String pwd = (String)session.getAttribute("pwd");
		// 3.response 响应对象
		response.getWriter().write("请求参数："+name);
		// 4.session 用于会话跟踪（session域对象:一次对象）
		session.setAttribute("pwd","666");
		String p2 = (String)session.getAttribute("pwd");
		// 5.application (类型是ServletContext web 应用上下文对象 域对象：整个应用)
		application.setAttribute("pwd","111");
		String p3 = (String)application.getAttribute("pwd");
		// 6.config (类型是类型是ServletConfig,获取类型是ServletContext 获取初始化参数)
		String driver = config.getServletContext().getInitParameter("driver");
		System.out.print(driver);
		// 7.page指的是jsp被翻译后的当前servlet对象
		
		// 8.pageContext(页面上下文对象、page域对象：当前jsp页面)
		pageContext.setAttribute("pwd","999");
		String p4 = (String)pageContext.getAttribute("pwd");
			// 获取除它之外的其它八大内置对象
			ServletRequest req = pageContext.getRequest();
			// 可以向指定域中放值 (开发中不用)
			// pageContext.setAttribute("pwd","123456",pageContext.REQUEST_SCOPE);
			//
			// String p5 = (String)pageContext.getAttribute("pwd",pageContext.REQUEST_SCOPE);
			// 重点 可以从任意域中查找对象	
			String pwd2 = (String)pageContext.findAttribute("pwd");
			out.write("<h2>"+pwd2+"</h2>");
		// 9.exception 异常对象，只有错误页面才有	
	%>
	
	<!--
		<%= session.getAttribute("name") %> 
		javaWeb中的四大域对象（开发中存储数据用）
		范围从小到大
		page域(pageContext):当前jsp页面
		request域：一次请求
		session域:一次会话
		application域：整个web应用
		
		pageContext.findAttribute(键);
		默认从最小的域中取值
		规范：开发中不同域中键值尽量不要重复
	 -->
</body>
</html>