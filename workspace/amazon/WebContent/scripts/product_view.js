$(function () {
	var pid = $('#pro-id').val();
	var path = $('#path').val();
	// 添加到最近查看
	$.ajax({
		url : "saveLastLook",// 请求的servlet地址
		type : "GET",// 请求方式
		data : {"pid":pid},// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(total) {

		},

		error : function(XMLHttpRequest, statusText) {

		}
	})

	// 根据id查询商品对象
	$.ajax({
		url : "queryProductByPId",// 请求的servlet地址
		type : "GET",// 请求方式
		data : {"pid":pid},// 发送到服务器的数据
		dataType : "json",// 设置返回数据类型
		success : function(pro) {
			$('#pro-name').text(pro.name);
			$('#pro-price').text(pro.price);
			if (Number(pro.stock) > 0) {
				$('#pro-stock').text(pro.stock);
				$('#pro-stock-info').text("(有货)");
			}else {
				pro.stock = "(无货)";
				$('#pro-stock-info').text("(无货)");
				// 让按钮不能点击
				$(".pro-click").css({"pointer-events":"none"})
			}
			$('#pro-img').prop("src",path+"/"+pro.imgSource);
			$('#pro-info').html(
				"商品名字："+pro.name+"<br /> 商品描述："+pro.description+"<br />"+
				"商品价格：￥"+pro.price+"<br /> 商品库存："+pro.stock+"<br />" );
		},
		error : function(XMLHttpRequest, statusText) {
		}
	})
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
		var num = Number($('#pro-stock').text());
		var pro_num = Number($('#pro-num').val());
		if (pro_num >= num){
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
		$.ajax({
			url: "addShop",
			type: "get",
			async: true,
			data:{"pid":pid,"pnum":$('#pro-num').val()},
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




