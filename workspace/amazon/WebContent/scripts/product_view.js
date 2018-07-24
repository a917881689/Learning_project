function addToCart(pid) {
	
	var stock=$("#stock").html()
	var count=$("#count").val()
	
	if(parseInt(count)>parseInt(stock)){
		alert("您选择的数量超过库存!")
	}else{
		$.ajax({
			url : "addToCart",// 请求的servlet地址
			type : "GET",// 请求方式
			data : "" + pid+"_"+count,// 发送到服务器的数据
			dataType : "text",// 设置返回数据类型
			success : function(total) {
				$("#cartCount").html(total);
				alert("成功添加到购物车!")
			},// 响应成功后执行的回调方法data响应文本
			complete : function(XMLHttpRequest, statusText) {
				
			},// 响应完成后执行的回调方法
			error : function(XMLHttpRequest, statusText) {
				alert("添加到购物车失败!")
			}// 响应失败后执行的回调方法
		})
	}

}

$(function () {
	// 直接购买
	$('#buy-Pro').click(function () {
		var pid = $('#pro-id').val();

	})
	// 数量框变动时
	$('#pro-num').change(function() {
		if($(this).val() == "") {
			$(this).val(1);
		}
	});
	// 数量增加按钮
	$('#add-num').click(function () {
		var num = Number($('#stock').text());
		var pro_num = Number($('#pro-num').val());
		if (pro_num >= num) {
			alert("您选择的数量超过库存!")
			return;
		}
		$('#pro-num').val(pro_num+1);
	})
	// 数量减少按钮
	$('#reduce-num').click(function () {
		var num = Number($('#pro-num').val());
		if (num <= 1) {
			alert("您选择的数量超过库存!")
			return;
		}
		$('#pro-num').val(num-1);
	})

	$('#add-shop-Pro').click(function() {
		$('#p-id').val();
		$.ajax({
			url: "addShop",
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




