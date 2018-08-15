/**
 * Created by Administrator on 2018/7/30.
 */
$(function () {
    var user = $("#user").val();
    function update_user () {
        user = $("#user").val();
    }
    function get_login_token() {
        update_user();
        if (user == null || user == "") {
            return true;
        }
        return false;
    }
    var account_flag = false;
    $('#btn-get-pwd').click(function () {
        if ($("#uname").val() == "") {
            show_tips('用户名不能为空');
            return;
        }
        if ($("#userName").val() == "") {
            show_tips('真实姓名不能为空');
            return;
        }
        if ($("#email").val() == "") {
            show_tips('邮箱不能为空');
            return;
        }
        uname_ck();
        if (account_flag) {
            $.ajax({
                url: "getPwd",
                type: "post",
                async: true,
                data: $('#get-pwd').serialize(),
                dataType: "json",
                success: function (result) {
                    if ("none" == result) {
                    	show_tips('信息不完整');
                        return;
                    }
                    if ("error" == result) {
                        show_tips('信息不匹配');
                        return;
                    }
                    show_tips('你的密码为:  "'+result+'"  ,请注意保存！');
                }
            })
        }
    });
    $("#userName").blur(function () {
        var $uname = $("#userName").val();
        $.ajax({
            url: "queryUserByName",
            type: "post",
            async: true,
            data: {"uname":$uname},
            dataType: "json",
            success: function (result) {
                if ("unuse" == result) {
                    account_flag = true;
                    return;
                }
                if ("error" == result) {
                    account_flag = false;
                    return;
                }
                if ("use" == result) {
                    account_flag = false;
                }
            }
        })
    });
    function uname_ck() {
        var $uname = $("#userName").val();
        $.ajax({
            url: "queryUserByName",
            type: "post",
            async: true,
            data: {"uname":$uname},
            dataType: "json",
            success: function (result) {
                if ("unuse" == result) {
                    account_flag = true;
                    return;
                }
                if ("error" == result) {
                    account_flag = false;
                    return;
                }
                if ("use" == result) {
                    show_tips('用户名不存在');
                    account_flag = false;
                }
            }
        })
    }
    function show_tips (info) {
        BootstrapDialog.show({
            title: '提示',
            message:info
        });
    }
});