/**
 * Created by Administrator on 2018/7/23.
 */
$(function () {

    // ��ȡ��������ַ
    var path = $('#path').val();
    var count_pro_classify = 0;
    // �첽��ȡ��Ʒ������Ϣ
    function get_pro_classify() {
        $.ajax({
            url:"productClassify",
            type:"get",
            async: true,
            data: {},
            dataType: "json",
            success: function (data) {
                if (data == null) {
                    if (count_pro_classify <= 10) {
                        get_pro_classify();
                        count_pro_classify += 1;
                    }else{
                        console.log("����ʱ")
                    }
                }
                var html = "";
                $.each(data,function (index,pro){
                    html += "<dt><a href='"+path+"/product-list.jsp?cid="+pro.product.id+"'>"+pro.product.name+"</a></dt>";
                    $.each(pro.son,function (index,pro){
                        html += "<dd><a href='"+path+"/product-list.jsp?cid="+pro.product.id+"'>"+pro.product.name+"</a></dd>";
                    })
                })
                $('#proClassify').html(html);
            },
            error: function () {
                if (count_pro_classify <= 10) {
                    get_pro_classify();
                    count_pro_classify += 1;
                }else{
                    console.log("����ʱ")
                }

            }
        })
    }
    get_pro_classify()
})