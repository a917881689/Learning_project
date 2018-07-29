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
    $('.dialog_login_click').click(function () {
        dialog_login();
    })
    function dialog_login() {
        console.log("模态框登录事件")
        BootstrapDialog.show({
            title: '用户登录',
            message: '用户名:<input type="text" id="uname" class="form-control"> <div class="margin-top-15">密码:<input id="pwd" type="password" class="form-control"></div>',
            draggable: true, //设置可以拖动
            buttons: [{
                label: '登录',
                hotkey: 13,
                action: function(dialog) {
                    var uname = dialog.getModalBody().find('#uname').val();
                    var pwd = dialog.getModalBody().find('#pwd').val();
                    dialog_login_ajax(dialog,uname,pwd);
                }
            }, {
                label: '注册',
                action: function(dialog) {
                    location.href=path+"/register.jsp";
                    dialog.close();
                }
            }]
        });
    }
    // 登录后的ajax事件
    function dialog_login_ajax(dialog,uname,pwd) {
        $.ajax({
            url: "dialogLogin",
            type: "POST",
            data: {"uname":uname,"pwd":pwd},
            dataType: "json",
            success: function (result) {
                if (result == null || result == "" || result.uname == null || result.uname == "") {
                    show_tips('账户名或密码错误');
                    return;
                }
                dialog.close();
                show_tips('登录成功');
                $('#user').val(result);
                $('#not-logged-on').remove();
                $('#login-user-info').html('<li><a href="javascript:;">'+result.uname+'</a>&nbsp;&nbsp;&nbsp;</li><li><a href="cancel">注销</a></li>');
                window.location.reload();
            },
            error : function() {
                show_tips('登录失败');
            }
        })
    }
    function show_tips (info) {
        BootstrapDialog.show({
            title: '提示',
            message:info
        });
    }

})