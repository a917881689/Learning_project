<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/head.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/newMsg.js" ></script>
</head>
<body>
<div id="main">
	<div class="mainbox">
		<%@ include file="head.jsp" %>
		<div class="content">
			<div class="message">
				<form id="newform">
					<div class="tmenu">
						<ul class="clearfix">
							<li>发送给： 
								<select name="recipient_uid" id="recipient_uid">
										<option value=""></option>
								</select>
							</li>
							<li>标题：<input type="text" name="title" id="title" /></li>
						</ul>
					</div>
					<div class="view">
						<textarea name="content" id="content"></textarea>
						<div class="send">
							<input type="button" id="btn-submit"/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
