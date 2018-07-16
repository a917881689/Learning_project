<%@page import="com.yosakura.beans.Emp"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 导入标准标签库中的核心库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1.核心库中的set标签  javaBean map-->
	<% 
		request.setAttribute("name","admin");
		Emp emp = new Emp(1,"嬴政",10000);
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("name","八戒");
		hm.put("sex","妖");
		request.setAttribute("emp",emp);
		request.setAttribute("hm",hm);
	%>
	<c:set var="name" value="张三" scope="session"/>
	${requestScope.name}
	${sessionScope.name}
	${hm.name} <!-- map使用获取键的值 -->
	<!-- 思考：将map中的sex:妖 修改成猪妖 -->
	${hm.name}
	<c:set target="${hm}" property="sex" value="猪妖"></c:set>
	<!-- 思考：修改emp对象中的属性 -->
	<c:set target="${emp}" property="salary" value="20000"></c:set>
	${emp.salary}
	<!-- 
		总结：target必须是实体类或者是map ,property必须是类中的字段或者map的键
		c:set 会默认调用setXXX();
		EL 会默认调用getXXX();
	 -->
</body>
</html>




