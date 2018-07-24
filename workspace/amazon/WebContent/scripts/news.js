/**
 * Created by Administrator on 2018/7/23.
 */
$(function () {
    // 获取服务器地址
    var path = $('#path').val();
    var count_news = 0;
    // 异步获取新闻信息
    function get_news() {
        $.ajax({
            url:"getNews",
            type:"get",
            async: true,
            data: {},
            dataType: "json",
            success: function (data) {
                var html = "";
                $.each(data,function (idenx,news){
                    html += "<li><a href='"+path+"/path?id="+news.id+"'>"+news.title+"</a></li>";
                })
                $('#newsCol').html(html);
            },
            error: function () {
                if (count_news <= 10) {
                    get_news();
                    count_news += 1;
                }else{
                    count_news = 0;
                    setTimeout(get_news(),3000);
                }

            }
        })
    }
    get_news();
})