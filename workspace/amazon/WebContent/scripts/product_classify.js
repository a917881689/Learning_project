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
                var html = "";
                $.each(data,function (index,pro){
                    html += "<dt><a href='"+path+"/path?id="+pro.product.id+"'>"+pro.product.name+"</a></dt>";
                    $.each(pro.son,function (index,pro){
                        html += "<dd><a href='"+path+"/path?id="+pro.product.id+"'>"+pro.product.name+"</a></dd>";
                    })
                })
                $('#proClassify').html(html);
            },
            error: function () {
                if (count_pro_classify <= 10) {
                    get_pro_classify();
                    count_pro_classify += 1;
                }else{
                    count_pro_classify = 0;
                    setTimeout(get_pro_classify(),3000);
                }

            }
        })
    }
    get_pro_classify()
})