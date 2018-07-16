<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<script type="text/javascript" src="./js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="./js/admin.js"></script>
</head>
<body>
<div>
	<div class="admin_title">
		<h2>欢迎管理员${sessionScope.loginUser.uname}登录</h2>
	</div>
	<div>
		<ul  class="link_ul">
			<li><a class="link father">添加商品</a>
				<div class="son">
					<form id="form_add" onsubmit="return false" >
						<input type="text" class="input_text" name="gname" placeholder="  商品名"/>
						商品类型：<select name="gtype" class="gtype">
					        <%-- <c:forEach var="goods"  items="${requestScope.goods}" >
					        	<option value="${goods.gId}" >${goods.gName}</option>
							</c:forEach> --%>
					    </select>
					    <input type="text" class="input_text" name="price" placeholder="  商品价格"/>
					    <button type="button" class="button_blue" id="add_btn">添加</button>
				    </form>
				</div>
			</li>
			<li >
				<a class="link father">删除商品</a>
				<div class="son">
					<form id="form_del" onsubmit="return false" >
						<!--删除商品 -->
						商品类型搜索：<select name="gtype" class="gtype"></select>
						<input type="text" class="input_text" name="gname" placeholder="  商品名(支持模糊搜索)"/>
						<button type="button" class="button_blue" id="query_del">查询</button>
						选择商品<select name="goods" class="goods" id="del_goods"></select>
						<button type="button" class="button_blue" id="del_btn">删除</button>
				    </form>
				</div>			
			</li>
				
			<li>
				<a class="link father">修改商品</a>
				<div class="son">
					<form id="form_update" onsubmit="return false" >
						<!--修改商品 -->
						选择商品<select name="goods" class="goods"></select>
						商品类型搜索：<select name="gtype" class="gtype">
						</select>
						<input type="text" class="input_text" name="gname" placeholder="  商品名(支持模糊搜索)"/>
						<button type="button" class="button_blue" id="query_update">查询</button>
						<div class="d_result">
							更改商品名:<input type="text" name="update_gname" class="input_text" placeholder="  更改后商品名"/>
							更改商品类型:<select name="update_gtype" class="gtype"></select>
							更改商品价格:<input type="text" name="update_price" class="input_text" placeholder="  更改后商品价格"/>
							<button type="button" class="button_blue" id="update_btn">修改</button>
						</div>
				    </form>
				</div>
			</li>
			<li>
				<a class="link father">查询商品</a>
				<div class="son">
					<form id="form_query" onsubmit="return false" >
						<!--查询商品 -->
						商品类型搜索：<select name="gtype" class="gtype">
						</select>
						<input type="text" class="input_text" name="gname" placeholder="  商品名(支持模糊搜索)"/>
						<button type="button" class="button_blue" id="query_btn">查询</button>
						<div class="d_result"  id="query_result"></div>
				    </form>
				</div>
			</li>
		</ul>
	</div>
</div>
	
</body>
</html>