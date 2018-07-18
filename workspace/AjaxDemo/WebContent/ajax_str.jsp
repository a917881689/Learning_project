<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点击span使用ajax动态改变内容</title>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<h2>不刷新页面来改变sapn内容</h2>
	<span id="recevie">测试接受字符串</span>
	<script type="text/javascript">
		$(function () {
			$('#recevie').click(function () {
				$.ajax({
					url: "recevieStr",
					type: "get",
					// 是否异步请求
					async: true,
					dataType:"text",
					success: function (data) {
						alert($(this).text);
						$('#recevie').text(data).css({"color":"red","font-size":"24px"});
					}
				})
			})
		})
	</script>
</body>
</html>