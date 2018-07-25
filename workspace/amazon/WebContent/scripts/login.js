// JavaScript Document

$(function (){
	$("#uname").blur(function () {
        var $uname = $(this).val();
        var name_info = $(this).siblings('span').eq(0);
        if ("" == $uname) {
            name_info.text('用户名不能为空').prop("class","error");
            return;
        }
    });
    
    // 密码验证
    $("#pwd").blur(function () {
        var $pwd = $(this).val();
        var pwd_info = $(this).siblings('span').eq(0);
        if ("" == $pwd) {
            pwd_info.text('密码不能为空').prop("class","error");
            return;
        }
        pwd_info.text('').prop("class","");
    });
    var veryCode_flag = false;
    $("#veryCode").blur(function () {
        var $veryCode = $(this).val();
        var info = $(this).siblings('span').eq(0);
        
        if ("" == $veryCode) {
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
    
    $('#veryCode-img').click(function () {
    	$(this).prop("src","getvalidateCode?" + new Date().getTime());
    })
    
    // 登录按钮
    $('#btn-login').click(function (){
    	var $input = $('.reg_text');
        for (var index = 0;index < $input.length;index++) {
            if ('' == $input.eq(index).val()) {
                $input.eq(index).blur();
                return;
            }
        }
        if (!veryCode_flag){
        	$("#veryCode").blur();
        	return;
        }
        $('#loginForm').submit();
    })

})