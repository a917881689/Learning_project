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
    function show_tips_redirect (info) {
        BootstrapDialog.show({
            title: '提示',
            message:info,
            // 对话框隐藏时的时候执行方法
            onhide: function() {
                location.href=path+"/index";
            }
        });
    }
    $('#cancel').click(function () {
        $.ajax({
            url:"cancel",
            type:"get",
            async: true,
            data: {},
            dataType: "json",
            success: function (result) {
                switch (result) {
                    case "none":
                        show_tips_redirect('用户未登录,不能注销');
                        break;
                    case "success":
                        show_tips_redirect('注销成功');
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