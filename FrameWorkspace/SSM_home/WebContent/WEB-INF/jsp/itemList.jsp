<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
<style type="text/css">
	.input[type="text"] {
    width: 95%;
	}
</style>
</head>
<body> 
<form action="${pageContext.request.contextPath }/item/queryitem.action" id="items-form" method="post">
查询条件：
<table width="100%" border=1>
<tr>
	<td><input type="button" value="编辑"/> &nbsp;
	<input type="text" id="query-input"/><input type="button" id="btn-query" value="查询"/> &nbsp;
	<input type="button" id="btn-delete" value="批量删除"/> &nbsp;
	<input type="button" id="btn-update" value="批量更新"/></td>	
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td><input type="checkbox" id="selectAll" ></td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="item" varStatus="status">
<tr>
	<td><input type="checkbox" class="id_checkbox" value="${item.id}">
		<input type="hidden" name="list[${status.index}].id" value="${item.id}">
	</td>
	<td>${item.name }</td>
	<td><input type="text" class="input" name="list[${status.index}].price" value="${item.price }"></td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td><input type="text" class="input" name="list[${status.index}].detail" value="${item.detail }"></td>
	
	<td><a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a>
		<a href="${pageContext.request.contextPath }/itemDelete.action?id=${item.id}">删除</a>
	</td>

</tr>
</c:forEach>

</table>
</form>
<script type="text/javascript">
	console.log()
	$(function () {
		$('#selectAll').click(function () {
                $(".id_checkbox").prop("checked",$('#selectAll').prop("checked"));
		})
		
		$(".id_checkbox").click(function () {
			var son_len = $('.id_checkbox').length;
			var son_ck_len = $('.id_checkbox').filter(":checked").length;
			if ($(this).prop("checked")) {
				if (son_len == son_ck_len) {
					$('#selectAll').prop('checked',true);
				}
			} else {
				$('#selectAll').prop('checked',false);
			}
		})
		
		$('#btn-query').click(function (){
			location.href = "queryByName.action?name="+ $('#query-input').val()
		})
		
		$('#btn-delete').click(function (){
			var id_arr = new Array;
			$(".id_checkbox").filter(":checked").each(function(index){
				id_arr[index] = $(this).val();
            });
			var indata = {"idArray":id_arr}
			console.log(indata)
			$.ajax({
				url:"batchDelete.action",
				type:"get",
				async:true,
				data:indata,
				success:function(){
					location.reload()
				}
			})
		})
		$('#btn-update').click(function (){
			$('#items-form').prop("action","${pageContext.request.contextPath }/batchUpdate.action").submit();
		})
		
		
	})
</script>
</body>

</html>