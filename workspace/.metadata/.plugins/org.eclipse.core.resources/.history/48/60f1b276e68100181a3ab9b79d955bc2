/**
 * Created by Administrator on 2018/7/5.
 */
//+function(){}(jQuery)
// $(function () {} 让页面先加载,在加载JS
$(function () {
    $('#uname').focus(function () {
        $uname_s = $('#uname_s');
        $uname_s.text('用户名必须是4~16位');
        $uname_s.css({"color":"grey"})
    });
    $('#uname').blur(function () {
        // 获取非空验证,正则验证
        var $uname = $(this).val();
        var $uname_s = $('#uname_s');
        if ('' == $uname) {
            $uname_s.text('用户名不能为空');
            $uname_s.css({"color":"red"});
            return;
        }
        var $reg_uname = /^.{4,16}$/;
        if (!$reg_uname.test($uname)) {
            $uname_s.text('×用户名格式错误');
            $uname_s.css({"color":"blue"});
            return;
        }
        $uname_s.text('');
    });
    // 密码
    $('#pwd2').focus(function () {
        $('#pwd2_s').text('');
    });
    $('#pwd2').blur(function () {
        var $pwd = $('#pwd').val();
        var $pwd2 = $(this).val();
        var $pwd_s = $('#pwd2_s');
        if ('' == $pwd || '' == $pwd2) {
            $pwd_s.text('×密码不能为空');
            $pwd_s.css({"color":"red"});
            return;
        }
        if ($pwd2 != $pwd) {
            $pwd_s.text('×两次密码不一致');
            $pwd_s.css({"color":"red"});
            return;
        }
        $pwd_s.text('');
    });
    // 3.身份证验证
    $('#idCard').blur(function () {
        var $idCard = $(this).val();

        var $idCard_s = $('#idCard_s');
        if ('' == $idCard) {
            $idCard_s.text('身份证不能为空');
            $idCard_s.css({"color":"red"});
            return;
        }
        var $reg_idCard = /^\d{17}[0-9X]$/
        if (!$reg_idCard.test($idCard)) {
            $idCard_s.text('×身份证格式错误');
            $idCard_s.css({"color":"blue"});
            return;
        }
        $idCard_s.text('');
    })
    // 4.手机号验证
    $('#mobile').blur(function () {
        var $mobile = $(this).val();

        var $mobile_s = $('#mobile_s');
        if ('' == $mobile) {
            $mobile_s.text('手机号不能为空');
            $mobile_s.css({"color":"red"});
            return;
        }
        var $reg_idCard = /^1[3456789]\d{9}$/
        if (!$reg_idCard.test($mobile)) {
            $mobile_s.text('×手机号格式错误');
            $mobile_s.css({"color":"blue"});
            return;
        }
        $mobile_s.text('');
    })
    // 5.邮箱验证
    $('#email').blur(function () {
        var $email = $(this).val();

        var $email_s = $('#email_s');
        if ('' == $email) {
            $email_s.text('邮箱不能为空');
            $email_s.css({"color":"red"});
            return;
        }
        var $reg_idCard = /^1[3456789]\d{9}$/
        if (!$reg_idCard.test($email)) {
            $email_s.text('×邮箱格式错误');
            $email_s.css({"color":"blue"});
            return;
        }
        $email_s.text('');
    })

// 登录按钮
    $('#login').click(function () {
        var $info = $('input:text');
        var $reg_login = [/^.{4,16}$/,/^.+$/];
        for (var index = 0;index < $info.length;index++) {
            if ('' == $info.eq(index).val() || !$reg_login[index].test($info.eq(index).val())) {
                $info.eq(index).blur();
                return;
            }
        }
        alert("提交");
        $('form').submit();
    });
})


