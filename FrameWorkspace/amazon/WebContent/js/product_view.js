$(function () {
	var pid = $('#pro-id').val();
	var path = $('#path').val();
	var user = $("#user").val();
	function update_user () {
		user = $("#user").val();
	}
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
				"商品价格：￥"+pro.price+"<br /> 商品库存："+pro.stock+"<br />"+
				"<input type='hidden' value='"+pro.name+"' id='$pro-name'/>");
		},
		error : function(XMLHttpRequest, statusText) {
		}
	})
	// 直接购买
	$('#buy-Pro').click(function () {
		if (get_login_token()) {
			$('.dialog_login_click').click();
			return;
		}
		BootstrapDialog.show({
			title: '确认购买',
			message: '是否确认购买:<img src="'+$('#pro-img').prop("src")+'"/> <br/> 数量:'+
				$('#pro-num').val()+'价格:'+(Number($('#pro-num').val())*Number($('#pro-price').text())),
			draggable: true, //设置可以拖动
			buttons: [{
				label: '确认',
				hotkey: 13,
				action: function(dialog) {
					dialog.close();
					buy_pro();
				}
			}, {
				label: '返回',
				action: function(dialog) {
					dialog.close();
				}
			}]
		});


	})
	// 购买事件
	function buy_pro(){
		var pid = $('#pro-id').val();
		var pnum = $('#pro-num').val();
		$.ajax({
			url: "buyPro",
			type: "POST",
			data: {"pid":pid,"pnum":pnum},
			dataType: "json",
			success: function (result) {
				if (result == null || "" == result) {
					payment_suc();
					return;
				}
			},
			error : function() {
				show_tips('异常');
			}
		});
	}
	// 购买成功后弹框
	function payment_suc () {
		BootstrapDialog.show({
			title: '成功结算',
			message: '已经成功结算,是否前往订单页面？',
			draggable: true, //设置可以拖动
			buttons: [{
				label: '前往',
				hotkey: 13,
				action: function(dialog) {
					dialog.close();
					location.href=path+"/orders_view.jsp";
				}
			}, {
				label: '返回',
				action: function(dialog) {
					dialog.close();
				}
			}]
		});
	}
	function get_login_token() {
		update_user();
		if (user == null || user == "") {
			return true;
		}
		return false;
	}
	// 数量框变动时
	$('#pro-num').change(function() {
		var flag = true;
		if (isNaN($(this).val())) {
			$(this).val(1);
			show_tips('请输入数字!');
			flag = false;
		}
		if(flag && $(this).val() == "") {
			$(this).val(1);
			flag = false;
		}
		if (flag && Number($(this).val()) < 1){
			$(this).val(1);
			show_tips('选择的数量不能低于1!');
			flag = false;
		}
		var stock = Number($('#pro-stock').text());
		if (flag && Number($(this).val()) > stock){
			$(this).val(stock);
			show_tips('您选择的数量超过库存!');
		}
	});
	// 数量增加按钮
	$('#add-num').click(function () {
		var num = Number($('#pro-stock').text());
		var pro_num = Number($('#pro-num').val());
		if (pro_num >= num){
			show_tips("您选择的数量超过库存!");
			return;
		}
		$('#pro-num').val(pro_num+1);
	})
	// 数量减少按钮
	$('#reduce-num').click(function () {
		var num = Number($('#pro-num').val());
		if (num <= 1) {
			show_tips("您选择的数量超过库存!");
			return;
		}
		$('#pro-num').val(num-1);
	})

	// 添加到购物车
	$('#add-shop-Pro').click(function() {
		$.ajax({
			url: "addShop",
			type: "get",
			async: true,
			data:{"pid":pid,"pnum":$('#pro-num').val()},
			dataType:"text",
			success: function (data) {
				if (data == "suc") {
					show_tips("添加成功");
				}
				if (data == "fail") {
					show_tips("添加失败");
				}
			}
		})
	});
	function show_tips (info) {
		BootstrapDialog.show({
			title: '提示',
			message:info
		});
	}
})




