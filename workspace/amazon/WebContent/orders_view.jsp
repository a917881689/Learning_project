<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 订单页</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" />
<link rel="stylesheet" href="css/nav.css"/>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="js/nav.js" type="text/javascript"></script>
<script src="js/order.js" type="text/javascript"></script>
<style type="text/css">
#oderview {
	font-size: 14px;
}
div#shopping {
	overflow-y: auto;
    height: 600px;
}
</style>

</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; 最新订单
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="doBuy" method="post">
				<table id="oderview">
					<tr>
						<th>订单时间:</th>
						<th>订单号:</th>
						<th>订单总额:</th>
					</tr>
					<!-- 根据用户购物车生成列表 -->
					<tr id="product_id_1">
						<td class="thumb"><img style="width: 100px; height: 100px;"
							src="" /><a href=""></a></td>
						<td class="price">￥<span>单价：</span>
						</td>
						<td class="number"><span>X</span></td>
						<td class="delete">正在发货</td>

					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
	</div>
</body>
</html>

