<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接受英雄集合</title>
	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<style type="text/css">
        table,table tr th, table tr td { border:1px solid #0094ff; }
        table {text-align: center; border-collapse: collapse;width:300px;}
    </style>
</head>
<body>
	<span id="rank">查看英雄排名</span>
	<table>
		<thead>
			<tr>
				<th>排名</th>
				<th>英雄名</th>
				<th>生命值</th>
				<th>战斗力</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	<script type="text/javascript">
		$('#rank').click(function () {
			// 异步接受返回的集合类型
			$.ajax({
				url: "receiveArray",
				type: "get",
				async: true,
				dataType: "json",
				success: function (heros) {
					var str = "";
					$.each(heros,function (idenx,hero){
						str += "<tr><td>"+hero.id+"</td><td>"+
						hero.name+"</td><td>"+hero.hp+"</td><td>"+hero.fighting+"</td></tr>";
					})
					$('table>tbody').append(str);
					$('table>tbody>tr>even').css({"background-color":"skyblue"})
				}
				
			})
			
		})
	</script>
</body>
</html>