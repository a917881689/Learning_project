<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/page.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/head.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js" ></script>

</head>
<body>
    <input id="page" type="hidden" value="1"/>
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<%@ include file="head.jsp" %>
			<!--错误信息  -->
			<div id="error"></div>
			<!--短消息列表  -->
			<div class="content messageList">
				<ul id="msg-content">
					<c:forEach items="${mList}" var="temp">
						<li class="${temp.state==1?'unReaded':''}">
							来自 ${temp.sendUser.username},${temp.title},${temp.msg_create_date}
							<em><a href="doShowMsg?id=${temp.id}">查看</a></em>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div id="page_div">
				<div class="pagination" id="pagination">
				    <span class='link_btn'>首页</span>
				    <span class='link_btn'>上一页</span>
				    <span class="current link-num">1</span>
				    <span class='link_btn' >下一页</span>
				    <span class='link_btn' >尾页</span>
				</div>
				<div class="pagination">
					<input type="text" id="input_page" class="input_page" value="1" minnum='1' maxlength="5" onkeyup="value=value.replace(/[^\d]/g,'')" />
					<span class='link_btn page' >跳转</span>
				</div>
			</div>

		</div>
	</div>
</body>
</html>






