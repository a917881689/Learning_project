<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax技术</title>
<script type="text/javascript" src="js/jquery-3.1.0.min.js" ></script>
</head>
<body>
	<span id="s1"></span>
	<hr/>
	<button type="button" id="mySend">发送ajax请求</button>
<script type="text/javascript" >
	//点击按钮发送ajax请求
	$('#mySend').click(funtion () {
		$.ajax({
			url:"testAjax",
			type:"get",
			async:true,
			dataType: "json",
			success: function(data) {
				data = JSON.parse(data);
				alert(data);
			})
		})
	})
</script>
</body>
</html>