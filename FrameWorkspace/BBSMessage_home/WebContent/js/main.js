/**
 * Created by Administrator on 2018/8/4.
 */
$(function () {
    function show_tips (info) {
        BootstrapDialog.show({
            title: '提示',
            message:info
        });
    }
    var path = $('#path').val()
    function get_msg(page) {
        $.ajax({
            url:"queryInbox",
            type:"get",
            async: true,
            data: {"page":page},
            dataType: "json",
            success: function (result) {
                switch (result) {
                    case "error":
                        show_tips('异常');
                        break;
                    case "none":
                        console.log("暂无数据");
                        break;
                    default :
                        console.log("开始写入数据");
                        result = JSON.parse(result);

                        // 获取选中页码
                        var select_page = Number(result.currentPage);

                        $('#page').val(select_page);
                        $('#input_page').val(select_page);

                        var html = "";
                        $.each(result.list,function (index,msg) {
                            html += "<li class='"+(msg.type == 1?"unReaded":"")+" msg-li'>"+
                                "来自 "+msg.sender+","+msg.title+","+get_time(msg.create_date)+
                                "<em><a href='readMsg?mid="+msg.id+"' ><span class='a_link'></span>查看</a></em>"+
                                "</li>";
                        })
                        $('#msg-content').html(html);
                        console.log("写入完成");

                        set_li_dbclick();

                        // 设置最大页面
                        var max_page = Number(result.totalPage);
                        // 设置显示最多页码数量
                        var page_num = 7;
                        // 获取开始页码
                        var begin_page = get_index(select_page,max_page,page_num);
                        // 获取页面中间下标
                        var mid_page = Math.ceil(page_num/2);


                        var page_html = "";
                        page_html +="<span class='"+(select_page==1?"disabled":"link_btn")+" page'>上一页</span>";

                        console.log("页码开始:"+begin_page);
                        if (mid_page < select_page) {
                            page_html +="<span class='link_num page'>1</span>";
                        }
                        if (mid_page+1 < select_page) {
                            page_html +="<span class='user-select-none'> ... </span>";
                        }

                        var flag = true;
                        // j控制循环,i是页码
                        for (var j = 0,i = begin_page;j < page_num && i <= max_page;i++,j++) {
                            if (flag && i == select_page) {
                                page_html +="<span class='current page'>"+i+"</span>";
                                flag = false;
                            }else {
                                page_html +="<span class='link_num page'>"+i+"</span>";
                            }
                        }
                        if (select_page+mid_page+1 < max_page) {
                            page_html +="<span class='user-select-none'> ... </span>";
                        }
                        if (select_page+mid_page < max_page) {
                            page_html +="<span class='link_num page'>"+max_page+"</span>";
                        }
                        page_html +="<span class='"+(select_page == max_page?"disabled":"link_btn")+" page'>下一页</span>";

                        page_html += "共"+max_page+"页";
                        $('#pagination').html(page_html);
                        console.log("写入分类分页跳转标签成功")
                        set_link_click(); // 给增加的分页,添加点击事件
                }
            },
            error: function () {
                console.log("异常");
            }
        })
    }
    get_msg(1);
    // 输入选中页码,最大页面,限制的一页显示的页码数量
    // 返回显示的第一个页码
    function get_index(select_page,max_page,page_num) {
        var mid_page = Math.ceil(page_num/2);
        if (max_page <= page_num || select_page <= mid_page) {
            return 1;
        }
        if (select_page+mid_page > max_page) {
            return max_page - page_num + 1;
        }
        return select_page - mid_page +1;
    }
    // 用于设置分页标签的点击事件
    function set_link_click () {
        $('.link_btn').click(function () {
            var choose = $(this).text();
            switch (choose) {
                case '上一页':
                    get_msg(Number($('#page').val())-1);
                    break;
                case '下一页':
                    get_msg(Number($('#page').val())+1);
                    break;
                    break;
                case '跳转':
                    get_msg(Number($('#input_page').val()));
                    break;
                default :
                    alert("未知错误!")
                    break;
            }
        })
        $('.link_num').click(function () {
            var page = $(this).text();
            get_msg(page);
        })
    }
    function set_li_dbclick() {
        $('.msg-li').dblclick(function () {
            // location.href = $(this).children('em').children('.a_link').prop("href");
            $(this).children('em').children('a').children('.a_link').click();
        })
    }
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