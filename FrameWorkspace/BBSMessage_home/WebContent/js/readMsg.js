/**
 * Created by Administrator on 2018/8/5.
 */
$(function () {
    var m_id = $('#m_id').val();
    console.log(m_id);
    $.ajax({
        url:"read-msg",
        type:"get",
        async: true,
        data: {"id":m_id},
        dataType: "json",
        success: function (msg) {
            if (msg == "error" || msg == "") {
                console.log("异常")
                return;
            }
            msg = JSON.parse(msg);
            var html = "<li>标题："+msg.title+"</li>"+
            "<li>来自："+msg.sender+"</li>"+
            "<li>时间："+get_time(msg.create_date)+"</li>";
            $('#msg-top').html(html);
            html = msg.content;
            $('#msg-view').html(html);
        },
        error: function () {
            console.log("异常");
        }
    })

    function get_time(time){
        var datetime = new Date();
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
        var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
        var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
        return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
    }
})