<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>读短消息</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/page.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/head.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/readMsg.js" ></script>

</head>
<body>
	<input id="m_id" type="hidden" value="${param.mid}"/>
	<div id="main">
		<div class="mainbox">
			<div class="title readMessage png"></div>
			<%@ include file="head.jsp" %>
			<div class="content">
				<div class="message">
					<div class="tmenu">
						<ul class="clearfix" id="msg-top">
							<li>标题：</li>
							<li>来自：</li>
							<li>时间：</li>
						</ul>
					</div>
					<div class="view">
						<p id="msg-view">
							
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
