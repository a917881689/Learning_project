/**
 * Created by Administrator on 2018/8/5.
 */
$(function () {
    var path = $('#path').val();
    $('#btn-index').click(function (){
        location.href=path+"/index";
    });
});