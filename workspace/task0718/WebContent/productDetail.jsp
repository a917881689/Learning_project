<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<script type="text/javascript" src="./js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<h2>商品详情页</h2>
    <div>
        <div><img class="img" src="./img/${singleProduct.img}" alt=""/></div>
        <div>
            <span>${singleProduct.brand} ${singleProduct.memo}</span>
            <div>就是这么贵： ${singleProduct.price}</div>
            <div>
                <input type="hidden" id="p-id" value="${singleProduct.id}"/>
                <input type="text" id="pro-num" value="1"  onkeyup="value=value.replace(/[^\d]/g,'')"/>
                <button type="button" id="add-num">+</button>
                <button type="button" id="reduce-num">-</button>
                <span id="shop">加入购物车</span>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(function () {
            $('#pro-num').change(function() {
                if($(this).val() == "") {
                    $(this).val(1);
                }
            });
            $('#add-num').click(function () {
                $('#pro-num').val(Number($('#pro-num').val())+1);
            })
            $('#reduce-num').click(function () {
                var num = Number($('#pro-num').val());
                if (num <= 1) {
                    return;
                }
                $('#pro-num').val(num-1);
            })
            $('#shop').click(function() {
                $('#p-id').val();
                $.ajax({
                    url: "addshop",
                    type: "get",
                    async: true,
                    data:{"pid":$('#p-id').val(),"pnum":$('#pro-num').val()},
                    dataType:"text",
                    success: function (data) {
                        if (data == "suc") {
                            alert("添加成功")
                        }
                        if (data == "fail") {
                            alert("添加失败")
                        }
                    }
                })
            });
        })
    </script>
</body>
</html>