$(function () {
	var path = $('#path').val();
	var count_pro_cart = 0;
	var user = $("#user").val();
	function get_pro_cart() {
		$.ajax({
			url:"getShopCart",
			type:"get",
			async: true,
			data: {},
			dataType: "json",
			success: function (data) {

				console.log("开始写入购物车信息...");
				var html = "";
				$.each(data,function (index,pro){
					html += "<tr><td class='thumb'><input type='checkbox' name='choose_shop' value='"+pro.shop.id+"' />"+
						"<img style='width: 100px; height: 100px;' src='"+path+"/"+pro.pro.imgSource+"' />"+
						"<a href=''>"+pro.pro.name+"</a></td>"+
						"<td class='price'>￥"+pro.pro.price+"</td>"+
						"<td class='number'><div class='quantity' >"+
						"<span class='shop-num reduce-num'>-</span>"+
						"<input type='text' class='itxt pro-num' value='"+pro.shop.pnum+"' minnum='1'  maxlength='5' onkeyup='value=value.replace(/[^\d]/g,"+"''"+")'/>"+
						"<span class='shop-num add-num' >+</span>"+
						"</div></td>"+
						"<td class='price pro-price-sum'>￥"+(Number(pro.pro.price)*Number(pro.shop.pnum))+"</td>"+
						"<td class='delete'><button type='button' class='btn btn-link btn-del-shop'>删除</button></td>"+
						"<input type='hidden' value='"+pro.pro.id+"' class='pro-pid'/>"+
						"<input type='hidden' value='"+pro.shop.id+"' class='pro-sid'/>"+
						"<input type='hidden' value='"+pro.pro.stock+"' class='pro-stock'/>"+
						"<input type='hidden' value='"+pro.pro.price+"' class='pro-price'/>"+
						"</tr>";
				});
				$('#shopCart_tbody').html(html);
				console.log("html:"+html);
				console.log("写入购物车成功!");
				set_pro_event();
				console.log("设置点击事件完成");
				set_input_iCkeck();
				console.log("设置复选框样式完成");
				set_ck_click();
				console.log("设置复选框点击事件完成");
			},
			error: function () {
				if (count_pro_cart <= 3) {
					count_pro_cart += 1;
					get_pro_cart();
				}else{
					console.log("请求超时")
				}
			}
		})
	}
	get_pro_cart();

	function set_pro_event() {
		// 数量框变动时
		$('.pro-num').change(function() {
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
			var stock = $(this).parent().parent().siblings('.pro-stock').eq(0).val();
			if (flag && Number($(this).val()) > stock){
				$(this).val(stock);
				show_tips('您选择的数量超过库存!');
			}
			set_pro_price($(this));
			pro_num_event($(this));
		});
		// 数量增加按钮
		$('.add-num').click(function () {
			var stock = $(this).parent().parent().siblings('.pro-stock').eq(0).val();
			var pro_num = $(this).siblings('.pro-num').eq(0);
			if (Number(pro_num.val()) > stock){
				show_tips('您选择的数量超过库存!');
				return;
			}
			pro_num.val(Number(pro_num.val())+1);
			set_pro_price($(this));
			pro_num_event($(this));
		});
		// 数量减少按钮
		$('.reduce-num').click(function () {
			var pro_num = $(this).siblings('.pro-num').eq(0);
			if (Number(pro_num.val()) <= 1) {
				show_tips('选择的数量不能低于1!');
				return;
			}
			pro_num.val(Number(pro_num.val())-1);
			set_pro_price($(this));
			pro_num_event($(this));
		});
		// 删除按钮
		$('.btn-del-shop').click (function () {
			var pid = $(this).parent().siblings('.pro-pid').eq(0).val();
			var sid = $(this).parent().siblings('.pro-sid').eq(0).val();
			$(this).parent().parent().remove();
			pro_del(sid,pid);
		})
	}
	// 设置商品总价
	function set_pro_price (choose) {
		var price_show = choose.parent().parent().siblings('.pro-price-sum').eq(0);
		var pnum = Number(choose.parent().children('.pro-num').val());
		var price = choose.parent().parent().siblings('.pro-price').eq(0).val();
		price_show.text("￥"+(Number(pnum)*Number(price)));
	}
	// 商品数量修改事件
	function pro_num_event(choose) {
		var pnum = Number(choose.parent().children('.pro-num').val());
		var pid = choose.parent().parent().siblings('.pro-pid').eq(0).val();
		var sid = choose.parent().parent().siblings('.pro-sid').eq(0).val();
		$.ajax({
			url:"updateShopCart",
			type:"post",
			async: true,
			data: {"sid":sid,"pid":pid,"pnum":pnum},
			dataType: "text",
			success: function (data) {
				switch (data) {
					case "sue":
						console.log("数量修改成功");
						break;
					case "error":
						console.log("数量修改失败");
						break;
					default:
						console.log("未知错误");
						break;
				}
			}
		})
	}
	// 设置删除事件
	function pro_del(sid,pid) {
		$.ajax({
			url:"deleteShopCart",
			type:"post",
			async: true,
			data: {"sid":sid,"pid":pid},
			dataType: "text",
			success: function (data) {
				switch (data) {
					case "sue":
						console.log("删除成功");
						break;
					case "error":
						console.log("删除失败");
						break;
					default:
						console.log("未知错误");
						break;
				}
			}
		})
	}
	// 设置复选框点击事件
	function set_ck_click() {
		$('#check-all').on('ifChecked ifUnchecked', function(event) {
			if (event.type == 'ifChecked') { //判断是否选中
				$('[name=choose_shop]:checkbox').iCheck('check');
			}else {
				$('[name=choose_shop]:checkbox').iCheck('uncheck');
			}
		});
		$('[name=choose_shop]:checkbox').on('ifChecked ifUnchecked', function(event) {
			var son_len = $('[name=choose_shop]:checkbox').length;
			var son_ck_len = $('[name=choose_shop]:checkbox').filter(":checked").length;
			if (event.type == 'ifChecked') {
				if (son_len == son_ck_len) {
					$('#check-all').prop('checked',true);
				}
			} else {
				$('#check-all').prop('checked',false);
			}
			$('#check-all').iCheck('update');
		});
	}
	// 设置复选框、单选框样式
	function set_input_iCkeck() {
		$('input').iCheck({
			labelHover : false,
			cursor : true,
			checkboxClass :'icheckbox_square-green',
			radioClass :'iradio_square-green',
			increaseArea :'20％'
		});
	}
	// 结算按钮点击事件
	$('#btn-payment').click(function () {
		if (get_login_token()) {
			dialog_login();
			return;
		}
		$.ajax({
			url: "payment",
			type: "POST",
			data: $('#shop-form').serialize(),
			dataType: "json",
			success: function (result) {
				if (result == null || "" == result) {
					$('[name=choose_shop]:checkbox').filter(":checked").parent().parent().parent().remove();
					$('#check-all').prop('checked',false).iCheck('update');
					payment_suc();
					return;
				}
			},
			error : function() {
				show_tips('异常');
			}
		});
	})
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
	// 获取用户登录状态
	function get_login_token() {
		if (user == null || user == "") {
			return true;
		}
		return false;

	}
	// 模态框登录事件
	function dialog_login() {
		console.log("模态框登录事件")
		BootstrapDialog.show({
			title: '用户登录',
			message: '用户名:<input type="text" id="uname" class="form-control"> <div class="margin-top-15">密码:<input id="pwd" type="password" class="form-control"></div>',
			draggable: true, //设置可以拖动
			buttons: [{
				label: '登录',
				hotkey: 13,
				action: function(dialog) {
					var uname = dialog.getModalBody().find('#uname').val();
					var pwd = dialog.getModalBody().find('#pwd').val();
					dialog_login_ajax(dialog,uname,pwd);
				}
			}, {
				label: '注册',
				action: function(dialog) {
					location.href=path+"/register.jsp";
					dialog.close();
				}
			}]
		});
	}
	// 登录后的ajax事件
	function dialog_login_ajax(dialog,uname,pwd) {
		$.ajax({
			url: "dialogLogin",
			type: "POST",
			data: {"uname":uname,"pwd":pwd},
			dataType: "json",
			success: function (result) {
				if (result == null || result == "" || result.uname == null || result.uname == "") {
					show_tips('账户名或密码错误');
					return;
				}
				dialog.close();
				show_tips('登录成功');
				user = result;
				$('#not-logged-on').remove();
				$('#login-user-info').html('<li><a href="javascript:;">'+result.uname+'</a>&nbsp;&nbsp;&nbsp;</li><li><a href="cancel">注销</a></li>');
				get_pro_cart();
			},
			error : function() {
				show_tips('登录失败');
			}
		})
	}
	// 模态框提示
	function show_tips (info) {
		BootstrapDialog.show({
			title: '提示',
			message:info
		});
	}
	$('.dialog_login_click').click(function () {
		dialog_login();
	});
	var path = $('#path').val();
	$('#btn-query').click(function () {
		var info = $('#input_info').val();
		var cid = $('#cid').val();
		if ('' == info && '' == cid) {
			location.href=path+"/product-list.jsp";
			return;
		}
		if ('' == cid) {
			location.href=path+"/product-list.jsp?info="+info;
			return;
		}
		location.href=path+"/product-list.jsp?info="+info+"&cid="+cid;

	})
});




