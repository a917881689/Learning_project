<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>亚马逊-最近浏览</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/recently_browse.js" type="text/javascript"></script>
<style type="text/css">
	.rb-img{
		width: 54px; 
		height: 54px;
	}
</style>
</head>
<body>
<input id="path" type="hidden" value="${pageContext.request.contextPath}"/>
	<div class="pre_look">
		<h3>最近浏览</h3>
		<div id="recently_browse_div">
			<dl>
				<dt>
					<img style="width: 54px; height: 54px;" src="" />
				</dt>
				<dd>
					<a href=""></a>
				</dd>
			</dl>
		</div>
		
	</div>
</body>
</html>