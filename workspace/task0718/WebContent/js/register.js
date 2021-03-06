/**
 * Created by Administrator on 2018/7/5.
 */
//+function(){}(jQuery)
// $(function () {} 让页面先加载,在加载JS
$(function () {
	var reg_regist = [/^[A-z_]\w{3,15}$/,/^.+$/,/^.+$/,/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,/^1[3456789]\d{9}$/,/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/]
    // 账号验证
    var u_name = $("#uname");
    var name_info = $('#uname_s');
    var flag = false;
    u_name.focus(function () {
        name_info.text('用户名必须4-16位，包括数字字母下划线，不能数字开头').css({"color":"gray"});
    });
    u_name.blur(function () {
        var $uname = u_name.val();
        if ("" == $uname) {
            name_info.text('×用户名不能为空').css({"color":"red"});
            return;
        }
        if (!reg_regist[0].test($uname)) {
            name_info.text('×格式错误 用户名必须4-16位，包括数字字母下划线，不能数字开头').css({"color":"Red"});
            return;
        }
        $.ajax({
        	url: "queryUserByName",
        	type: "post",
        	async: true,
        	data: {"uname":$uname},
        	dataType: "text",
        	success: function (result) {
        		if ("error" == result) {
        			name_info.text('x用户名请求错误').css({"color":"blue"});
        			flag = false;
        			return;
        		}
        		if ("use" == result) {
        			name_info.text('x用户名可用').css({"color":"grren"});
        			flag = true;
        		}
        		if ("unuse" == result) {
        			name_info.text('x用户名已存在').css({"color":"red"});
        			flag = false;
        			return;
        		}
        		
        	}
        })
    });
    // 密码验证
    var u_pwd = $("#pwd");
    var pwd_info = $('#pwd_s');

    u_pwd.focus(function () {
        pwd_info.text('');
    });
    u_pwd.blur(function () {
        var $pwd = u_pwd.val();
        if (!reg_regist[1].test($pwd)) {
            pwd_info.text('×密码不能为空').css({"color":"red"});
            return;
        }
        pwd_info.text('√ ').css({"color":"green"});
    });

    // 双重密码验证
    var u_pwd2 = $("#pwd2");
    var pwd_info2 = $('#pwd2_s');

    u_pwd2.focus(function () {
        pwd_info2.text('');
    });
    u_pwd2.blur(function () {
        var $pwd = u_pwd.val();
        var $pwd2 = u_pwd2.val();
        if (!reg_regist[2].test($pwd2)) {
            pwd_info2.text('×密码不能为空').css({"color":"red"});
            return;
        }
        if ($pwd != $pwd2) {
            pwd_info2.text('×两次密码不一致').css({"color":"red"});
            return;
        }
        pwd_info2.text('√ 两次密码一致').css({"color":"green"});
    });

    // 身份证验证
    var u_id = $("#idCard");
    var id_info = $('#idCard_s');

    u_id.focus(function () {
        id_info.text('');
    });
    u_id.blur(function () {
        var $id = u_id.val();
        if ("" == $id) {
            id_info.text('×身份证不能为空').css({"color":"red"});
            return;
        }
        if (!reg_regist[3].test($id)) {
            id_info.text('×身份证不符合规范,请输入正确的身份证号').css({"color":"Red"});
            return;
        }
        id_info.text('√ 正确').css({"color":"green"});
    });
    
    // 手机号验证
    var u_tel = $("#mobile");
    var tel_info = $('#mobile_s');

    u_tel.focus(function () {
        tel_info.text('');
    });
    u_tel.blur(function () {
        var $tel = u_tel.val();
        if ('' == $tel) {
            tel_info.text('×手机号不能为空').css({"color":"red"});
            return;
        }
        if (!reg_regist[4].test($tel)) {
            tel_info.text('×手机号不符合规范,请输入正确的手机号').css({"color":"Red"});
            return;
        }
        tel_info.text('√ 正确').css({"color":"green"});
    });

    

    // 邮箱验证
    var u_email = $("#email");
    var email_info = $('#email_s');

    u_email.focus(function () {
        email_info.text('');
    });
    u_email.blur(function () {
        var $email = u_email.val();
        if ("" == $email) {
            email_info.text('×邮箱不能为空').css({"color":"red"});
            return;
        }
        if (!reg_regist[5].test($email)) {
            email_info.text('×邮箱不符合规范,请输入正确的邮箱').css({"color":"Red"});
            return;
        }
        email_info.text('√ 正确').css({"color":"green"});
    });

// 注册按钮
    $('#register').click(function (){
    	var $input = $('input:text,input:password');
        for (var index = 0;index < $input.length;index++) {
            if ('' == $input.eq(index).val() || !reg_regist[index].test($input.eq(index).val())) {
                $input.eq(index).blur();
                return;
            }
        }
        if (!flag){
        	u_name.blur();
        	return;
        }
        $('#registForm').submit();
    })
    //
    $('#login').click(function () {
    	$(location).prop('href', 'loginUI.jsp')
    });
})


