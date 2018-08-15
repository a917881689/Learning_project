<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<input id="path" type="hidden" value="${pageContext.request.contextPath}"/>
<div class="menu">
	<span>当前用户：<a href="main">${loginUser.uname}</a></span> 
	<span><a href="newMsg">发短消息</a></span>
	<span><a href="javascript:void(0);" id="cancel">退出</a></span>
</div>