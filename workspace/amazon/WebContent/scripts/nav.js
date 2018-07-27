/**
 * Created by Administrator on 2018/7/25.
 */
$(function () {
    var path = $('#path').val()
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

})