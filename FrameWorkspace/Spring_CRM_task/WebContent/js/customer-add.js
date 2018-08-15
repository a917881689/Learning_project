/**Created by Administrator on 2018/8/8.*/
$(function () {
    $('#btn-add').click(function () {
        $.ajax({
            url:"customer-add",
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