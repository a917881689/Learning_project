/**
 * Created by Administrator on 2018/8/5.
 */
$(function () {
    $.ajax({
        url:"getUserInfo",
        type:"get",
        async: true,
        date:{},
        dateType:"json",
        success:function(result) {
            if (result == null || result == "") {
                $('#user-select').html("<option value='-1' selected='selected' >暂无用户</option>");
                return;
            }
            result = $.parseJSON(result);
            console.log(result);
            console.log("resultjson:"+result[0].id+"=="+result[0].uname);
            var html = "";

            $.each(result,function(index,user) {
                html +="<option value='"+user.id+"'>"+user.uname+"</option>";
            })
            $('#recipient_uid').html(html);

        },
        error:function(){
            console.log("异常");
        }
    });
    $('#btn-submit').click(function () {
        if ("" == $.trim($('#recipient_uid').val()) || "-1" == $.trim($('#recipient_uid').val()) ) {
            show_tips("收件人不能为空");
            return;
        }
        if ("" == $.trim($('#title').val())) {
            show_tips("标题不能为空");
            return;
        }
        if ("" == $.trim($('#content').val())) {
            show_tips("标题不能为空");
            return;
        }

        /*
         var data = {"recipient_uid":$.trim($('#recipient_uid').val()),"title":$.trim($('#title').val()),"content":$.trim($('#content').val())}
         console.log(data);
         $('#newform').serialize()
        */
        $.ajax({
            url:"send-msg",
            type:"post",
            async: true,
            data: $('#newform').serialize(),
            dataType: "json",
            success:function(result) {
                switch (result) {
                    case "error":
                        console.log("异常")
                        break;
                    case "success":
                        show_tips('发送信息成功');
                        clean();
                        break;
                    default :
                        show_tips('异常!');
                }
            },
            error:function(){
                console.log("异常");
            }
        })
    });
    function clean () {
        $('#title').val("");
        $('#content').val("");
    }
    function show_tips (info) {
        BootstrapDialog.show({
            title: '提示',
            message:info
        });
    }
});