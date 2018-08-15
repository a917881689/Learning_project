/**
 * Created by Administrator on 2018/7/29.
 */
$(function () {
    var path = $('#path').val();
    function get_user_order() {
        $.ajax({
            url : "getOrder",// 请求的servlet地址
            type : "GET",// 请求方式
            data : {},// 发送到服务器的数据
            dataType : "json",// 设置返回数据类型
            success : function(result) {
                var html = "";
                $.each(result,function(index,order) {
                    html +='<tr>'+
                                '<th>订单时间:'+order.orderTime+'</th>'+
                                '<th>订单号:'+order.id+'</th>'+
                                '<th>订单总额:'+order.totalPrice+'</th>'+
                                '<th>状态:</th>'+
                            '</tr>'+
                            '<tr>'+
                                '<td class="thumb"><img style="width: 100px; height: 100px;" src="'+path+'/'+order.pro.imgSource+'" />' +
                                    '<a href="">'+order.pro.name+'</a></td>'+
                                '<td class="price">￥<span>'+order.pro.price+'</span>'+
                                '</td>'+
                                '<td class="number"><span>'+order.pnum+'</span></td>'+
                                '<td class="delete">正在发货</td>'+
                            '</tr>';
                })
                $('#oderview').html(html);
            },
            error : function(XMLHttpRequest, statusText) {

            }
        })
    }
    get_user_order();
})