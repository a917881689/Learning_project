<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异步请求的简写方式</title>
	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<span id="get">简易的get异步请求</span>
	<hr/>
	<span id="post">简易的post异步请求</span>
	<script type="text/javascript">
		/* $.get("路径",{"请求参数"},function(data){成功响应后执行},"预计服务器返回类型格式") */
		// 参数位置$.get（url,{json data},success,dataType）
		$('#get').click(function () {
			// get请求的ajax(只能发异步请求)
			$.get("test",{"uname":"张三"},function (data) {
				alert(data)
			},"text")
		})
		$('#post').click(function () {
			// get请求的ajax(只能发异步请求)
			$.post("test",{"uname":"张三"},function (data) {
				alert(data)
			},"text")
		})
		/* $.get()参数(地址栏：请求行)会出现中文乱码 
			$.post()参数 (请求体)不会出现中文乱码
			$.ajax()既可以同步请求,也可以发异步请求
		*/
			
		/* $.ajax({
			url: "请求路径",
			type: "get/post",
			async: true,
			data: {json请求参数},
			dataType: "预计服务器返回类型格式",
			success: function (item) {
				成功响应后执行的函数
			}
		}) */
	</script>
</body>
</html>