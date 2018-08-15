/**
 * Created by Administrator on 2018/7/26.
 */
$(function () {
    var info = $('#info').val();
    $('#input_info').prop({"value":info});

    var path = $('#path').val();
    var cid =  $('#cid').val();
    var count_pro_list = 0;
    var totalPage = 0;
    // 请求获取分类分页商品信息的方法
    function get_pro_list(page,pro_info,cid) {
        console.log("页码"+page+"条件"+pro_info+"id:"+cid)
        // 获取条件
        var data = {};
        // 判断条件是否为空
        if (pro_info == '') {
            if (cid == '') {
                data = {"page":page}
            }else {
                data = {"page":page,"cid":cid}
            }
        }else{
            if (cid == '') {
                data = {"page":page,"info":pro_info}
            }else {
                data = {"page":page,"info":pro_info,"cid":cid}
            }

        }
        // 执行ajax正式发送请求
        $.ajax({
            url:"query_pro_list",
            type:"get",
            async: true,
            data: data,
            dataType: "json",
            success: function (data) {
                if (data == null) {
                    if (count_pro_list <= 3) {
                        get_pro_list(page,pro_info,cid);
                        count_pro_list += 1;
                    }else{
                        console.log("暂无数据")
                    }
                    return;
                }
                $('#page').prop({"value":data.currentPage});
                $('#input_page').val(data.currentPage);
                totalPage = data.totalPage;
                var html = "";
                console.log("开始写入分类分页商品数据...")
                $.each(data.list,function (idenx,pro){
                    html += "<div class='pro-info'>"+
                        "<div class='pro-img'>"+
                        "<a href='"+path+"/productDetail.jsp?pid="+pro.id+"'><img src='"+path+"/"+pro.imgSource+"' alt=''/></a>"+
                        "</div>"+
                        "<div class='pro-type'>"+
                        "<div class='pro-string'>"+pro.name+"</div>"+
                        "<div class='pro-price'>￥"+pro.price+"</div>"+
                        "<div class='btn-details'><a href='"+path+"/productDetail.jsp?pid="+pro.id+"'>查看详情</a></div>"+
                        "</div>"+
                        "</div>";
                })
                $('#pro_list_div').html(html);
                console.log("写入分类分页商品数据成功")
                console.log("开始写入分类分页跳转标签...")
                set_pro_hover();// 给增加商品,添加悬停事件
                // 处理分页按钮跳转
                var page_html = "";
                if (data.currentPage == 1) {
                    page_html +="<span class='disabled'>首页</span>"+
                    "<span class='disabled'>上一页</span>"
                }else {
                    page_html +="<span class='link_btn'>首页</span>"+
                        "<span class='link_btn'>上一页</span>"
                }
                var flag = true;
                var i = get_index(Number(data.currentPage),Number(data.totalPage));
                console.log("页码开始:"+i);
                // j控制5次循环,i是页码
                for (var j = 0;j < 5 && i <= data.totalPage;i++,j++) {
                    if (flag && i == data.currentPage) {
                        page_html +="<span class='current'>"+i+"</span>";
                        flag = false;
                    }else {
                        page_html +="<span class='link_num'>"+i+"</span>";
                    }
                }

                if (data.currentPage == data.totalPage) {
                    page_html +="<span class='disabled'>下一页</span>"+
                        "<span class='disabled'>尾页</span>"
                }else {
                    page_html +="<span class='link_btn'>下一页</span>"+
                    "<span class='link_btn'>尾页</span>"
                }
                page_html += "共"+data.totalPage+"页";
                $('#pagination').html(page_html);
                console.log("写入分类分页跳转标签成功")
                set_link_click(); // 给增加的分页,添加点击事件
            },
            error: function () {
                console.log("ajax请求错误,重新请求")
                if (count_pro_list <= 3) {
                    get_pro_list(page,pro_info,cid);
                    count_pro_list += 1;
                }else{
                    console.log("请求超时")
                }

            }
        })
    }
    get_pro_list($('#page').val(),info,cid);
    // 用于设置商品的悬停事件
    function set_pro_hover () {
        $('.pro-type').hover(function () {
            $(this).children('.pro-string').hide();
            $(this).children('.btn-details').show();
            $(this).children('.pro-price').css({'height': '40px', 'line-height': '40px'});
        }, function () {
            $(this).children('.pro-string').show();
            $(this).children('.btn-details').hide();
            $(this).children('.pro-price').css({'height': '33px', 'line-height': '33px'});
        })
    }
    // 用于设置分页标签的点击事件
    function set_link_click () {
        $('.link_btn').click(function () {
            var choose = $(this).text();
            switch (choose) {
                case '首页':
                    get_pro_list(1,info);
                    break;
                case '上一页':
                    get_pro_list(Number($('#page').val())-1,info);
                    break;
                case '下一页':
                    get_pro_list(Number($('#page').val())+1,info);
                    break;
                case '尾页':
                    get_pro_list(totalPage,info);
                    break;
                case '跳转':
                    get_pro_list(Number($('#input_page').val()),info);
                    break;
                default :
                    alert("未知错误!")
                    break;
            }
        })
        $('.link_num').click(function () {
            var page = $(this).text();
            get_pro_list(page,info);
        })
    }
    // 用于获取显示的第一个页码
    function get_index(select_page,max_page) {
        if (max_page <= 5 || select_page <= 3) {
            return 1;
        }
        if (select_page+2 >= max_page) {
            return max_page - 4;
        }
        return select_page - 2;
    }
    $('.input_page').focus(function () {
        $(this).css({'border':'1px solid #f04848'})
        $(this).select();
    })
    $('.input_page').blur(function () {
        $(this).css({'border':'1px solid #bbb'})
    })
    $('#btn-query').click(function () {
        get_pro_list($('#page').val(),$('#input_info').val(),$('#cid').val());

    })
    $('#cancel').click(function () {
    	$.ajax({url: "cancel"})
    	window.location.reload();
    })
})