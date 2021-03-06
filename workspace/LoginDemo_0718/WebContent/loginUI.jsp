<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
	<link rel="stylesheet" href="css/login.css" type="text/css"/>
    <script type="text/javascript" src="./js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="./js/login.js" ></script>
</head>
<body>
	<%@ include file="nav.jsp" %>
<!-- 登录页面 -->
<form action="doLogin" method="post" id="loginForm">
<div id="container">
    <div id="title">
        <h1>登陆</h1>
    </div>
    <div id="view">
        <input type="text" id="uname" name="uname" placeholder="  用户名"/>
        <span id="login_info" class="info"></span>
        <input type="text" id="pwd" name="pwd" placeholder="  密码"/>
        <span id="pwd_info" class="info"></span>
        <div id="pw_check">
            <input type="radio" id="u_user" name="utype" value="0" checked="checked"/>
            <label for="u_user">用户</label>
            <input type="radio" name="utype" id="u_admin" value="1"/>
            <label for="u_admin">管理员</label>
        </div>
    </div>
    <div id="d_btn">
        <button type="button" id="login">登录</button>
        <button type="button" id="register">注册</button>
    </div>
</div>
</form>
</body>
</html>