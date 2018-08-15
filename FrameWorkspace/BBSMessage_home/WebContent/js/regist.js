/**
 * Created by Administrator on 2018/8/4.
 */
$(function () {
    var path = $('#path').val()
    function show_tips (info) {
        BootstrapDialog.show({
            title: '提示',
            message:info
        });
    }
    $(document).keydown(function(event){
        if(event.keyCode==13){
            $("#btn-register").click();
        }
    });
    var account_flag = false;
    $("#uname").focus(function () {
        $('#info').text('');
    })
    $("#uname").blur(function () {
        var $uname = $(this).val();
        var info = $('#info');
        if ("" == $uname) {
            info.text('X用户名不能为空');
            return;
        }
        $.ajax({
            url: "queryUserByName",
            type: "get",
            async: true,
            data: {"uname":$uname},
            dataType: "json",
            success: function (result) {
                switch (result) {
                    case "error":
                        info.text('X请求错误');
                        account_flag = false;
                        break;
                    case "unuse":
                        info.text('');
                        account_flag = true;
                        break;
                    case "use":
                        info.text('X用户名已存在');
                        account_flag = false;
                        break;
                    default :
                        show_tips('异常!');
                }

            }
        })
    });
    $('#btn-register').click(function () {
        if (!account_flag) {
            return;
        }
        $.ajax({
            url:"doRegister",
            type:"post",
            async: true,
            data: $('#regist-form').serialize(),
            dataType: "json",
            success: function (result) {
                switch (result) {
                    case "error":
                        show_tips('信息不完整,或用户名重复!');
                        break;
                    case "success":
                        show_tips('注册成功');
                        location.href=path+"/main";
                        break;
                    default :
                        show_tips('异常!');
                }
            },
            error: function () {
                show_tips('异常!');
            }
        })
    })
})