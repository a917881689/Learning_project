/**
 * Created by Administrator on 2018/7/25.
 */
$(function () {
    var path = $('#path').val()
    $('#btn-query').click(function () {
        var info = $('#input_info').val();
        if ('' == info) {
            location.href=path+"/product-list.jsp";
        }else {
            location.href=path+"/product-list.jsp?info="+info;
        }


    })
})