/**
 * Created by Administrator on 2018/7/25.
 */
$(function () {
    console.log("进入读取")
    var path = $('#path').val();
    // 读取cookie中的最近浏览数据
    var count_recently_browse = 0;
    function get_recently_browse() {
        $.ajax({
            url: "queryRecentlyBrowse",// 请求的servlet地址
            type: "GET",// 请求方式
            data: {},// 发送到服务器的数据
            dataType: "json",// 设置返回数据类型
            success: function (data) {
                if (data == null) {
                    if (count_recently_browse <= 10) {
                        get_recently_browse();
                        count_recently_browse += 1;
                    } else {
                        console.log("请求超时")
                    }
                    return;
                }
                var html = "";
                $.each(data, function (index, pro) {
                    html += "<dl><dt><a href='" + path + "/productDetail.jsp?pid=" + pro.id + "' target='_self'><img class='rb-img' src='" + path + "/" + pro.imgSource + "' /></a></dt><dd class='title'><a href='" + path + "/productDetail.jsp?pid=" + pro.id + "' target='_self'>" + pro.description + "</a></dd><dd class='price'>￥" + pro.price + "</dd></dl>"
                })
                $('#recently_browse_div').html(html);
            },
            error: function (XMLHttpRequest, statusText) {
                if (count_recently_browse <= 10) {
                    get_recently_browse();
                    count_recently_browse += 1;
                } else {
                    console.log("请求超时")
                }
            }
        })
    }
    get_recently_browse();
})