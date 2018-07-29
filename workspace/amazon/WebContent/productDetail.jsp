<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品显示</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css" />
<link rel="stylesheet" href="css/nav.css"/>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="js/nav.js" type="text/javascript"></script>
<script type="text/javascript" src="js/product_view.js"></script>
<style type="text/css">
        .button>button.btn-orange {
        	margin: 0 20px;
            background-color: #fde3cf;
            color: #fd4401 ;
        }
        .button>button.btn-orange:hover{
            background-color: #fd4401;
            color: white;
        }
        .num-sp {
            padding: 6px 0 0 5px;
		    float: left;
		    margin-left: -1px;
		    width: 25px;
		    height: 30.5px;
		    border: 0.5px solid #a9a9a9;
        }
        .num-sp:hover {
        	cursor:pointer;
        }
        .num-sp:last-child {
        	margin-top: -1px;
        }
        #num-d{
		    padding-top: 25px;
		    display: inline-block;
		    width: 95px;
		    height: 60px;
        }
        #pro-num{
        	margin-top: 1px;
		    display: block;
		    float: left;
		    width: 70px;
		    height: 60px;
		    text-align: center;
		    vertical-align: middle;
        }
        #shop-d {
        	display:inline-block;
        }
    </style>
</head>
<body>
	<jsp:include page="index_top.jsp"/>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; <a href=""></a> &gt; <a
			href=""></a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
		<jsp:include page="index_product_sort.jsp"/>
		</div>
		<div id="product" class="main">
			<h1>商品名称:<span id="pro-name"></span></h1>
			<input type="hidden" value="${param.pid}" id="pro-id"/>
			<input type="hidden" value="${pageContext.request.contextPath}" id="path"/>
			<div class="infos">
				<div class="thumb">
					<img style="width: 100px; height: 100px;" id="pro-img" src="${pageContext.request.contextPath}/${pro.imgSource}" />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥<span id='pro-price'></span></span>
					</p>
					<p>
						库 存：<span id="pro-stock"></span>
						<span id="pro-stock-info">(无货)</span>
					</p>
					<div id="num-d">
						<input type="text" id="pro-num" class="pro-click" value="1" minnum='1' maxlength="5" onkeyup="value=value.replace(/[^\d]/g,'')">
						<span class="glyphicon glyphicon-plus num-sp pro-click" id="add-num"></span>
						<span class="glyphicon glyphicon-minus num-sp pro-click" id="reduce-num"></span>
					</div>
					<div class="button" id="shop-d">
						<button type="button" class="btn btn-orange pro-click" id="buy-Pro">
							<span class="glyphicon glyphicon-shopping-cart"></span>
				        	&nbsp;立即购买
				    	</button>
						<button type="button" class="btn btn-orange pro-click" id="add-shop-Pro">
				        	<span class="glyphicon glyphicon-shopping-cart"></span>
				        	&nbsp;加入购物车
				    	</button>
					</div>

				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text" id="pro-info">
					商品名字：${pro.name}<br /> 商品描述：${pro.description}<br />
					商品价格：￥${pro.price}<br /> 商品库存：${pro.stock}<br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
	</div>
</body>
</html>

