/**Created by Administrator on 2018/8/8.*/
$(function () {
    function find() {
        $.ajax({
            url:"customer-find",
            type:"get",
            async: true,
            data:{},
            dataType:"json",
            success: function (result){
                result = JSON.parse(result);
                var html = "";
                $.each(result,function (index,customer) {
                    html += '<TR class="info-list">'+
                        '<TD>'+customer.cust_name+'</TD>'+
                        '<TD>'+customer.cust_level+'</TD>'+
                        '<TD>'+customer.cust_source+'</TD>'+
                        '<TD>'+customer.cust_industry+'</TD>'+
                        '<TD>'+customer.cust_phone+'</TD>'+
                        '<TD>'+customer.cust_mobile+'</TD>'+
                        '<TD>'+
                        '<span class="btn-link btn-update">修改</span>&nbsp;&nbsp;'+
                        '<span class="btn-link btn-delete">删除</a>'+
                        '</TD>'+
                        '</TR>';
                })
                $('#list-tboby').html(html);
            }
        })
    }
    find();
});