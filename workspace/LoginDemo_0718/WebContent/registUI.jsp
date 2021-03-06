<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/style.css" type="text/css"/>
	<link rel="stylesheet" href="css/regist.css" type="text/css"/>
    <script type="text/javascript" src="./js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript"  charset="utf-8" src="./js/register.js" ></script>
</head>
<body>
<%@ include file="nav.jsp" %>
    <!-- 注册页面 -->
<form action="doRegist" method="post" id="registForm" >
	<input type="hidden" name="utype" value="0"/> <!-- 默认只能注册普通用户 -->
	<div id="container">
        <div id="title">
            <h1>注册</h1>
        </div>
        <div id="view">
            <from action="#">
                <input type="text" id="uname" name="uname" placeholder="  用户名"/>
                <div class="text_info"><p id="uname_s"></p></div>
                <input type="password" id="pwd" name="pwd" placeholder="  密码"/>
                <div class="text_info"><p id="pwd_s"></p></div>
                <input type="password" id="pwd2" placeholder="  确认密码"/>
                <div class="text_info"><p id="pwd2_s"></p></div>
                <input type="text" id="idCard" name="idCard" placeholder="  身份证号"/>
                <div class="text_info"><p id="idCard_s"></p></div>
                <input type="text" id="mobile" name="mobile" placeholder="  手机号"/>
                <div class="text_info"><p id="mobile_s"></p></div>
                <input type="text" id="email" name="email" placeholder="  邮箱"/>
                <div class="text_info"><p id="email_s"></p></div>
            </from>
        </div>
        <div id="d_btn">
            <button type="button" id="login">登录</button>
            <button type="button" id="register">注册</button>
        </div>
    </div>
</form>
</body>
</html>