/**
 * Created by Administrator on 2018/7/23.
 */
$(function () {
	// 获取服务器地址
	var path = $('#path').val();
	var count_pro_index = 0;

	// 异步获取商品信息
	function get_product_index() {
		$.ajax({
			url:"productIndex",
			type:"get",
			async: true,
			data: {},
			dataType: "json",
			success: function (data) {
				if (data == null) {
					if (count_pro_index <= 10) {
						get_product_index();
						count_pro_index += 1;
					}else{
						console.log("请求超时")
					}
					return;
				}
				console.log("ajax请求成功写入数据:")
				var html = "";
				$.each(data,function (idenx,pro){
					html += "<li><dl><dt><a href='"+path+"/productDetail.jsp?pid="+pro.id+"' target='_self'><img src='"+path+"/"+pro.imgSource+"' /></a></dt><dd class='title'><a href='"+path+"/productDetail.jsp?pid="+pro.id+"' target='_self'>"+pro.description+"</a></dd><dd class='price'>￥"+pro.price+"</dd></dl></li>"
				})
				$('#major').html(html);
			},
			error: function () {
				console.log("ajax请求错误,重新请求")
				if (count_pro_index <= 10) {
					get_product_index();
					count_pro_index += 1;
				}else{
					console.log("请求超时")
				}

			}
		})
	}
	get_product_index();
	// 异步获取热卖推荐商品信息
	var count_popular = 0
	function get_popular_product() {
		$.ajax({
			url:"popularProduct",
			type:"get",
			async: true,
			data: {},
			dataType: "json",
			success: function (data) {
				if (data == null) {
					if (count_popular <= 10) {
						get_popular_product();
						count_popular += 1;
					}else{
						console.log("请求超时")
					}
					return;
				}
				var html = "";
				$.each(data,function (idenx,pro){
					html += "<li><dl><dt><a href='"+path+"/productDetail.jsp?pid="+pro.id+"' target='_self'><img src='"+path+"/"+pro.imgSource+"' /></a></dt><dd class='p_name'><a href='"+path+"/productDetail.jsp?pid="+pro.id+"' target='_self'>"+pro.description+"</a></dd><dd class='price'>￥"+pro.price+"</dd></dl></li>"
				})
				$('#hotSale').html(html);
			},
			error: function () {
				console.log("ajax请求错误,重新请求")
				if (count_popular <= 10) {
					get_popular_product();
					count_popular += 1;
				}else{
					console.log("请求超时")
				}

			}
		})
	}
	get_popular_product();
})