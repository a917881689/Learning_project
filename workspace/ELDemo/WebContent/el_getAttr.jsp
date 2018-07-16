<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.yosakura.beans.Emp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL获取域中的值</title>
</head>
<body>
	<%
		// 1.request域中存放【字符串】
		request.setAttribute("uname","admin");
		// 2.在session域中存放【对象】
		Emp e1 = new Emp(1,"张三",6666);
		session.setAttribute("emp",e1);
		// 3.在request中存放【对象集合】
		ArrayList<Emp> list = new ArrayList<Emp>();
		list.add(e1);
		list.add(new Emp(2,"李四",8888));
		request.setAttribute("list",list);
	%>
	<%-- 1.使用原生的脚本嵌入方式 获取域中存放的【字符串】 --%>
	<% String uname = (String)request.getAttribute("uname"); %>
	<%= request.getAttribute("uname") %>
	<%-- 使用EL 获取 request域中的值 ${XXXScope.键} --%>
	${requestScope.uname}
	<hr/>
	<%-- 1.使用原生的脚本嵌入方式 获取域中存放的【对象的属性】 --%>
	<% 
		Emp emp = (Emp)session.getAttribute("emp"); 
		out.write("脚本获取："+emp.getName()+":"+emp.getSalary());	
	%> <br/>
	<%-- 使用EL 获取 request域中的对象的属性语法${XXXScope.对象.属性名} 默认调用getXXX 首字母变大写，拼接一个get 调用这个方法--%>
	EL获取：${sessionScope.emp} - ${sessionScope.emp.name} - ${sessionScope.emp.salary}
	<br/> <!-- 从最小的域往大搜索 -->
	EL简写：${emp.id} → ${emp.name} → ${emp.salary} 
	<hr/>
	<%-- 1.使用原生的脚本嵌入方式 获取域中存放的【集合对象的属性】 --%>
	<% 
		ArrayList<Emp> emp_list = (ArrayList<Emp>)request.getAttribute("list");
		for (Emp e:emp_list) {
			out.write(e.getName()+"#"+e.getSalary()+"<br/>");
		}
	%>
	<%-- 使用EL 获取 request域中的对象的属性语法${XXXScope.对象.属性名}--%>
	从指定域的EL中获取：${requestScope.list[0].name}  ${requestScope.list[1].name}
	<br/> ${list[0].name} ${list[1].name} 
	<h2>结论:EL用来替代脚本获取域中的值 (EL只能简单的获取数据,并不能处理复杂 的业务逻辑,后面会使用JSTL标签库来完成逻辑的判断和替换)</h2>
	
	
</body>
</html>










