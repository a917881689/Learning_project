/**Created by Administrator on 2018/8/8.*/
$(function () {
    var path = $('#path').val();
    $('#btn-add').click(function () {
        $.ajax({
            url:"linkman-add",
            type:"get",
            async: true,
            data:$('#add-form').serialize(),
            dataType:"json",
            success: function (result){
                console.log(result)

            }
        })
    })
})