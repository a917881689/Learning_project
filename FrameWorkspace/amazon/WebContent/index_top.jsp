
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
<input id="path" type="hidden" value="${pageContext.request.contextPath}"/>
<input id="cid" type="hidden" value="${param.cid}"/>
<input id="user" type="hidden" value="${loginUser}"/>
<div id="header">
	<div class="login_menu">
		<div class="login_container">
			<ul class="m_left" id="login-user-info">
				<c:if test="${empty loginUser }"> <!-- 未登录时 -->
					<li><span class="c_red dialog_login_click" >请登录</span>&nbsp;&nbsp;&nbsp;</li>
					<li><a href="register.jsp">请注册</a></li>
            	</c:if>
                <c:if test="${!empty loginUser }"> <!-- 登录时 -->
		           	<li><a href="javascript:;">用户:${loginUser.uname}</a>&nbsp;&nbsp;&nbsp;</li>
		            <li><a href="" id="cancel">注销</a></li>
            	</c:if>
				
			</ul>

			<ul class="m_right">
				<li><img src="images/icon_3.png" alt="" /><a
					href="shopping.jsp" class="c_red">购物车</a></li>
				<li><img src="images/icon_4.png" alt="" /><a
					href="javascript:AddFavorite('我的网站',location.href)">收藏</a></li>
				<li><img src="images/icon_2.png" alt="" /><a href="guestbook.jsp">留言</a></li>
				<li><img src="images/icon_1.png" alt="" /><a href="index.jsp">首页</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="row height-120">
			<div class="margin-top-30 col-md-2 col-md-push-1 ">
				<a href="index.jsp"><img src="images/LOGO.png" alt="" id="logo-img" /></a>
			</div>
			<div class="col-md-9 margin-top-40">
				<div class="dropdown col-md-2 col-md-push-2">
				    <button type="button" class="btn btn-red" data-toggle="dropdown" id="choose_btn_classify">
				        全部类别 <span class="caret"></span>
				    </button>
				    <ul class="dropdown-menu bg-orange" id="pro_top_classify"><li><a class="choose_classify" href="javascript:void(0)" name="">全部类别</a></li><li class="dropdown dropdown-submenu"><a class="choose_classify dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)" name="1">图音</a><ul class="dropdown-menu bg-orange"><li><a class="choose_classify" href="javascript:void(0)" name="4">音乐</a></li><li><a class="choose_classify" href="javascript:void(0)" name="28">qq</a></li></ul></li><li class="dropdown dropdown-submenu"><a class="choose_classify dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)" name="2">百货</a><ul class="dropdown-menu bg-orange"><li><a class="choose_classify" href="javascript:void(0)" name="7">家居</a></li><li><a class="choose_classify" href="javascript:void(0)" name="9">母婴</a></li><li><a class="choose_classify" href="javascript:void(0)" name="10">食品</a></li><li><a class="choose_classify" href="javascript:void(0)" name="11">手机数码</a></li><li><a class="choose_classify" href="javascript:void(0)" name="12">家居首饰</a></li><li><a class="choose_classify" href="javascript:void(0)" name="13">手表饰品</a></li><li><a class="choose_classify" href="javascript:void(0)" name="15">家电</a></li><li><a class="choose_classify" href="javascript:void(0)" name="16">电脑办公</a></li><li><a class="choose_classify" href="javascript:void(0)" name="19">服饰</a></li><li><a class="choose_classify" href="javascript:void(0)" name="20">彩票充值</a></li></ul></li><li class="dropdown dropdown-submenu"><a class="choose_classify dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)" name="21">品牌</a><ul class="dropdown-menu bg-orange"><li><a class="choose_classify" href="javascript:void(0)" name="14">鞋包</a></li><li><a class="choose_classify" href="javascript:void(0)" name="17">玩具文具</a></li><li><a class="choose_classify" href="javascript:void(0)" name="18">汽车用品</a></li></ul></li><li class="dropdown dropdown-submenu"><a class="choose_classify dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)" name="22">团购</a><ul class="dropdown-menu bg-orange"><li><a class="choose_classify" href="javascript:void(0)" name="8">美妆</a></li></ul></li><li class="dropdown dropdown-submenu"><a class="choose_classify dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)" name="23">易买社区</a></li></ul>
				</div>
				<div class="col-md-9 col-md-push-1 margin-left-22">
					<input type="text" placeholder="输入宝贝" id="input_info" />
					<button class="query_button" id="btn-query">搜索</button>
				</div>
			</div>
		</div>
	</div>
	<div class="nav_bar">
		<div class="nav_bar_container">
			<ul>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
			</ul>
		</div>
	</div>
</div>

</body>
</html>
