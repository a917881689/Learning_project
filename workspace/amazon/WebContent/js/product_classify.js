/**
 * Created by Administrator on 2018/7/23.
 */
$(function () {

    // 获取服务器地址
    var path = $('#path').val();
    var count_pro_classify = 0;
    // 异步获取商品分类信息
    function get_pro_classify() {
        $.ajax({
            url:"productClassify",
            type:"get",
            async: true,
            data: {},
            dataType: "json",
            success: function (data) {
                if (data == null) {
                    if (count_pro_classify <= 3) {
                        get_pro_classify();
                        count_pro_classify += 1;
                    }else{
                        console.log("请求超时")
                    }
                }
                if ($("#cid").val() != null) {
                    set_btn_choose_text(data);
                }
                console.log("开始写入商品分类信息...")
                var html = "";
                var html_top = "<li><a class='choose_classify'  href='javascript:void(0)' name=''>全部类别</a>";
                var token = false;
                $.each(data,function (index,pro){
                    html_top += "<li class='dropdown dropdown-submenu'>" +
                                    "<a class='choose_classify dropdown-toggle' data-toggle='dropdown' href='javascript:void(0)' name='"+pro.product.id+"'>"+pro.product.name+"</a>";
                    if (pro.son != null && "" != pro.son) {
                        html_top += "<ul class='dropdown-menu bg-orange'>"
                        token = true;
                    }
                    html += "<dt><a href='"+path+"/product-list.jsp?cid="+pro.product.id+"'>"+pro.product.name+"</a></dt>";
                    $.each(pro.son,function (index,pro){
                        html_top += "<li><a class='choose_classify' href='javascript:void(0)' name='"+pro.product.id+"'>"+pro.product.name+"</a></li>";
                        html += "<dd><a href='"+path+"/product-list.jsp?cid="+pro.product.id+"'>"+pro.product.name+"</a></dd>";

                    })

                    if (token) {
                        html_top += "</ul></li>"
                    }else {
                        html_top += "</li>"
                    }

                })
                $('#proClassify').html(html);
                $('#pro_top_classify').html(html_top);
                console.log("写入商品分类成功")
                set_choose_classify_click();
            },
            error: function () {
                if (count_pro_classify <= 3) {
                    get_pro_classify();
                    count_pro_classify += 1;
                }else{
                    console.log("请求超时")
                }

            }
        })
    }
    get_pro_classify()

    function set_choose_classify_click () {
        $('.choose_classify').click(function () {
            var cid = $(this).prop("name");
            var name = $(this).text();
            $('#choose_btn_classify').html(name+"<span class='caret'></span>")
            $("#cid").val(cid);
        })
    }
    function set_btn_choose_text(data) {
        $.each(data,function (index,pro){
            if (pro.product.id == $("#cid").val()) {
                $('#choose_btn_classify').html(pro.product.name+"<span class='caret'></span>")
                return;
            }
            $.each(pro.son,function (index,pro){
                if (pro.product.id == $("#cid").val()) {
                    $('#choose_btn_classify').html(pro.product.name+"<span class='caret'></span>")
                    return;
                }
            })
        })
    }
})