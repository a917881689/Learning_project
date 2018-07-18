<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证用户名是否存在</title>
	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	用户名： <input type="text" id="uname"/>
	<span id="uname_s"></span>
	<script type="text/javascript">
		$('#uname').focus(function () {
			$('#uname_s').text('4-16个字符，可使用英文小写、数字、下划线，下划线不能在首尾')
			.css({"font-size":"8px","color":"grey"})
			
		});
		$('#uname').blur(function () {
			var uname = $(this).val();
			if ("" == uname) {
				$('#uname_s').text('用户名为空')
				.css({"color":"red"})
				return;
			}
			var reg_uname = /^[a-z0-9][a-z0-9_]{2,14}[a-z0-9]$/
			if (!reg_uname.test(uname)) {
				$('#uname_s').text('x用户名为空')
				.css({"color":"blue"})
				return;
			}
			// 使用ajax来异步验证用户名是否存在数据库（不存在才可以提交表单）
			$.ajax({
				url: "queryUserByName",
				type: "post",
				async: true,
				data: {"uname":uname},// 在开发中不使用拼接方式,建议使用json或者表单提交来传递数据
				dateType: "text",
				success: function(result) {
					if ("ok" == result) {
						$('#uname_s').text('√用户名可用')
						.css({"color":"green"})
					}
					if ("error" == result) {
						$('#uname_s').text('x用户名已存在')
						.css({"color":"red"})
					}
				}
			})
		})
	</script>
</body>
</html>