$(function () {
	var path = $('#path').val();
	var count_pro_cart = 0;
	function get_pro_cart() {
		$.ajax({
			url:"getShopCart",
			type:"get",
			async: true,
			data: {},
			dataType: "json",
			success: function (data) {
				console.log("ajax请求成功写入数据:")
				var html = "";
				$.each(data,function (index,pro){
					html += "<tr><td class='thumb'>"+
						"<img style='width: 100px; height: 100px;' src='"+path+"/"+pro.pro.imgSource+"' />"+
						"<a href=''>"+pro.pro.name+"</a></td><td class='price'>￥"+pro.pro.price+
						"<input type='hidden' value='"+pro.pro.id+"' class='pro-id'/>"+
						"<input type='hidden' value='"+pro.pro.price+"' class='pro-price'/>"+
						"<input type='hidden' value='"+pro.pro.stock+"' class='pro-stock'/></td>"+
						"<td class='number'><div class='quantity' >"+
						"<a href='javascript:void(0);' class='shop-num reduce-num'  >-</a>"+
						"<input type='text' class='itxt' value='1' minnum='1' id='pro-num' maxlength='5' onkeyup='value=value.replace(/[^\d]/g,"+"''"+")'>"+
						"<a href='javascript:void(0);' class='shop-num add-num' >+</a>"+
						"</div></td><td class='delete'><a href=''>删除</a></td>"+
						"</tr>";
				})
				$('#shopCart_table').html(html);
				console.log("html:"+html)
			},
			error: function () {
				if (count_pro_cart <= 10) {
					count_pro_cart += 1;
					get_pro_cart();
				}else{
					console.log("请求超时")
				}
			}
		})
	}
	get_pro_cart();
})










