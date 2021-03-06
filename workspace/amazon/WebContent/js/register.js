// JavaScript Document
$(function (){
	
	$('.reg_text').focus(function (){
		// obj.parentNode.parentNode.className = "current";
		// obj.parentNode.parentNode.className = "";
		var msgBox = $(this).siblings('span').eq(0);
		msgBox.text('');
		msgBox.removeClass("error");
	})
	
	var reg_regist = [/^[A-z_]\w{3,15}$/,/^.+$/,/^.+$/,/^((19\d{2})|(20\d{2}))-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/,/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/,/^1[3456789]\d{9}$/,/^.+$/,/^.+$/]
    // 账号验证
	var account_flag = false;
    $("#uname").blur(function () {
        var $uname = $(this).val();
        var name_info = $(this).siblings('span').eq(0);
        if ("" == $uname) {
            name_info.text('用户名不能为空').prop("class","error");
            return;
        }
        if (!reg_regist[0].test($uname)) {
            name_info.text('格式错误 用户名必须4-16位，包括数字字母下划线，不能数字开头').prop("class","error");
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
        			name_info.text('用户名请求错误').prop("class","error");
        			account_flag = false;
        			return;
        		}
        		if ("use" == result) {
        			name_info.text('').prop("class","");
        			account_flag = true;
        		}
        		if ("unuse" == result) {
        			name_info.text('用户名已存在').prop("class","error");
        			account_flag = false;
        			return;
        		}
        	}
        })
    });
    
    // 密码验证
    $("#pwd").blur(function () {
        var $pwd = $(this).val();
        var pwd_info = $(this).siblings('span').eq(0);
        if (!reg_regist[1].test($pwd)) {
            pwd_info.text('密码不能为空').prop("class","error");
            return;
        }
        pwd_info.text('').prop("class","");
    });

    // 双重密码验证
    $("#repwd").blur(function () {
        var $pwd = $("#pwd").val();
        var $pwd2 = $(this).val();
        var pwd_info2 = $(this).siblings('span').eq(0);
        if (!reg_regist[2].test($pwd2)) {
            pwd_info2.text('×密码不能为空').prop("class","error");
            return;
        }
        if ($pwd != $pwd2) {
            pwd_info2.text('×两次密码不一致').prop("class","error");
            return;
        }
        pwd_info2.text('').prop("class","");
    });
    
    // 出生日期验证
    $("#birthday").blur(function () {
        var $birthday = $(this).val();
        var info = $(this).siblings('span').eq(0);
        if ("" == $birthday) {
        	info.text('出生日期不能空').prop("class","error");
            return;
        }
        if (!reg_regist[3].test($birthday)) {
        	info.text('日期错误,格式为（1900-2099）').prop("class","error");
            return;
        }
        info.text('').prop("class","");
    });
    
    // 身份证验证
    $("#idCard").blur(function () {
        var $id = $(this).val();
        var id_info = $(this).siblings('span').eq(0);
        if ("" == $id) {
            id_info.text('×身份证不能为空').prop("class","error");
            return;
        }
        if (!reg_regist[4].test($id)) {
            id_info.text('×身份证不符合规范,请输入正确的身份证号').prop("class","error");
            return;
        }
        id_info.text('').prop("class","");
    });
    
    // 邮箱验证
    var email_flag = false;
    $("#email").blur(function () {
        var $email = $(this).val();
        var email_info = $(this).siblings('span').eq(0);
        if ("" == $email) {
            email_info.text('×邮箱不能为空').prop("class","error");
            return;
        }
        if (!reg_regist[5].test($email)) {
            email_info.text('×邮箱不符合规范,请输入正确的邮箱').prop("class","error");
            return;
        }
        $.ajax({
        	url: "queryUserByEmail",
        	type: "post",
        	async: true,
        	data: {"email":$email},
        	dataType: "text",
        	success: function (result) {
        		if ("error" == result) {
        			email_info.text('请求错误').prop("class","error");
        			email_flag = false;
        			return;
        		}
        		if ("use" == result) {
        			email_info.text('').prop("class","");
        			email_flag = true;
        		}
        		if ("unuse" == result) {
        			email_info.text('邮箱名已存在').prop("class","error");
        			email_flag = false;
        			return;
        		}
        	}
        })
    });
    
    // 手机号验证
    $("#mobile").blur(function () {
        var $tel = $(this).val();
        var tel_info = $(this).siblings('span').eq(0);
        if ('' == $tel) {
            tel_info.text('×手机号不能为空').prop("class","error");
            return;
        }
        if (!reg_regist[6].test($tel)) {
            tel_info.text('×手机号不符合规范,请输入正确的手机号').prop("class","error");
            return;
        }
        tel_info.text('').prop("class","");
    });
    
    // 地址验证
    $("#address").blur(function () {
        var $tel = $(this).val();
        var info = $(this).siblings('span').eq(0);
        
        if (!reg_regist[7].test($tel)) {
        	info.text('地址不能为空').prop("class","error");
            return;
        }
        info.text('').prop("class","");
    });
    
    // 验证码验证
    var veryCode_flag = false;
    $("#veryCode").blur(function () {
        var $veryCode = $(this).val();
        var info = $(this).siblings('span').eq(0);
        
        if (!reg_regist[8].test($veryCode)) {
        	info.text('验证码不能为空').prop("class","error");
            return;
        }
        //验证码验证
        $.ajax({
        	url: "queryUserByVeryCode",
        	type: "post",
        	async: true,
        	data: {"veryCode":$veryCode},
        	dataType: "text",
        	success: function (result) {
        		if ("error" == result) {
        			info.text('请求错误').prop("class","error");
        			veryCode_flag = false;
        			return;
        		}
        		if ("use" == result) {
        			info.text('').prop("class","");
        			veryCode_flag = true;
        		}
        		if ("unuse" == result) {
        			info.text('验证码不正确，请重新输入').prop("class","error");
        			veryCode_flag = false;
                    $('#veryCode-img').click();
        			return;
        		}
        	}
        })
    });
    
    // 注册按钮
    $('#btn-register').click(function (){
    	var $input = $('.reg_text');
        for (var index = 0;index < reg_regist.length;index++) {
            if ('' == $input.eq(index).val() || !reg_regist[index].test($input.eq(index).val())) {
                $input.eq(index).blur();
                return;
            }
        }
        if (!account_flag || !email_flag || !veryCode_flag){
        	$("#uname").blur();
        	$("#email").blur();
        	$("#veryCode").blur();
        	return;
        }
        $('#regForm').submit();
    })
    
    $('#veryCode-img').click(function () {
    	$(this).prop("src","getvalidateCode?" + new Date().getTime());
    })
})







