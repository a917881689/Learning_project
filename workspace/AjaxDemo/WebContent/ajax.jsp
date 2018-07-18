<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基于jQuery的ajax语法</title>
	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<a href="testAjax?uname=admin&pwd=123">测试同步请求</a>
	<h2>基于jQuery的ajax语法</h2>
	<script type="text/javascript">
		$(function () {
			// ajax只有一个json参数
			$.ajax({
				// 异步请求的url路径（过滤器、servlet）
				url:"testAjax", 
				// 请求方式（get,post）
				type:"GET",
				// 是否异步请求（false是同步请求）
				async:true,
				data:"uname=admin&pwd=123",
				// 预计服务器返回的数据格式
				dataType:"html",
				success: function (context) {
					alert(context);
				},
				error: function () {
					alert("请求错误");
					// url错误
					// 服务器返回数据类型与dataType不一致
				}
			});
			
		})
	</script>
</body>
</html>