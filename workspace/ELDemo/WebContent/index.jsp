<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL(jsp中嵌入的java脚本：前后端分离思想)</title>
</head>
<body>
	<h2>EL用途：从域中取值，计算，计算并输出结果</h2>
	<a href="el_getAttr.jsp">1.EL从域中获取值</a>
	<a href="test">2.从后台域中</a> <br/>
	<a href="el_11obj.jsp?uname=管理员&hobby=篮球&hubby=足球">3.EL中的十一个内置对象</a><br/>
	<a href="el_calculate.jsp">4.EL的计算功能</a><br/>
	<hr/>
	<h2>JSTL用途:替换脚本的 逻辑部分代码</h2>
	<a href="jstl_set.jsp">1.jstl的set 方法</a><br/>
	<a href="jstl_code.jsp">2.jstl常用标签</a><br/>
	<a href="jstl_if.jsp">3.jstl条件标签</a> <br/>
	<a href="jstl_for.jsp">4.jstl迭代标签</a> <br/>
	<a href="jstl_time.jsp">5.jstl国际化事件标签</a> <br/>
	<a href="addEmp">6.servlet创建5员工并输出到网页表格中</a> <br/>
</body>
</html>