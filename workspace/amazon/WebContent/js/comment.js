$(function () {
	function get_cm () {
		$.ajax({
			url : "getComment",// 请求的servlet地址
			type : "GET",// 请求方式
			data : {},// 发送到服务器的数据
			dataType : "json",// 设置返回数据类型
			success : function(result) {
				var html = "";
				$.each(result,function(index,cm) {
					html +='<li>'+
						'<dl>'+
						'<dt>内容：'+cm.content+'</dt>'+
						'<dd class="author"><span>作者：'+cm.nickName+'</span></dd>'+
						'<dd>评论时间：'+cm.createTime+'</dd>'+
						'<dd>回复：'+cm.reply+'</dd>'+
						'<dd>回复时间：'+cm.replyTime+'</dd>'+
						'</dl>'+
						'</li>';
				})
				$('#comment-ul').html(html);
			},
			error : function(XMLHttpRequest, statusText) {

			}
		});
	}
	get_cm();
	$('#sub-cm-form').click(function () {
		if($("[name=guestName]").val()==""){
			show_tips("请输入昵称！");
			return;
		}

		if($("[name=guestTitle]").val()==""){
			show_tips("请输入标题！");
			return;
		}

		if($("[name=guestContent]").val()==""){
			show_tips("请输入留言内容！");
			return;
		}
		$.ajax({
			url : "addComment",// 请求的servlet地址
			type : "GET",// 请求方式
			data : $('#cm-form').serialize(),// 发送到服务器的数据
			dataType : "text",// 设置返回数据类型
			success : function(result) {
				if ("suc" == result) {
					show_tips("提交成功")
					get_cm();
					$('.text').val("");
					return;
				}
				show_tips("提交失败")
			},
			error : function(XMLHttpRequest, statusText) {

			}
		});

	})
	function show_tips (info) {
		BootstrapDialog.show({
			title: '提示',
			message:info
		});
	}
})
