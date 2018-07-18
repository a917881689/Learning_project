<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>传递普通pojo对象</title>
	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<button type="button" onclick="createHero();">生成英雄</button>
	<p id="heroConntainer"></p>
	<script type="text/javascript">
		function createHero() {
			$.ajax({
				url: "receiveObject",
				type: "get",
				async: true,
				// 自动将json字符串转换成json对象
				dataType: "json",
				success: function (hero) {
					var str = "英雄名:"+hero.name+",生命值:"+hero.hp+",战斗力:"+hero.fighting;
					$('#heroConntainer').text(str);
				}
			})
		}
	</script>
</body>
</html>