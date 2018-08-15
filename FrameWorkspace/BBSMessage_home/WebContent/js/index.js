/**
 * Created by Administrator on 2018/8/4.
 */
$(function () {
    $.ajax({
        url:"login-ck",
        type:"get",
        async: true,
        data: {},
        dataType: "json",
        success: function (result) {
            switch (result) {
                case "none":
                    break;
                case "success":
                    location.href=path+"/main";
                    break;
                default :
                    console.log("异常");
            }
        },
        error: function () {

        }
    })
    var path = $('#path').val()
    function show_tips (info) {
        BootstrapDialog.show({
            title: '提示',
            message:info
        });
    }
    $(document).keydown(function(event){
        if(event.keyCode==13){
            $("#btn-login").click();
        }
    });
    $('#btn-login').click(function () {
        $.ajax({
            url:"doLogin",
            type:"post",
            async: true,
            data: $('#login-form').serialize(),
            dataType: "json",
            success: function (result) {
                switch (result) {
                    case "error":
                        show_tips('信息不完整!');
                        break;
                    case "none":
                        show_tips('账号或密码不正确!');
                        break;
                    case "success":
                        location.href=path+"/main";
                        break;
                    default :
                        show_tips('异常!');
                }
            },
            error: function () {

            }
        })
    })
    $('#btn-register').click(function () {
        location.href=path+"/register";
    })
})