$(function () {
    // 页面加载完毕，获取商品类型信息
    var type_array = [];
    $.ajax({
        url : "admin?operation=getGoodsType",//请求地址
        dataType : "json",//预期服务器返回的数据格式
        type : "get",//请求方式
        async : false,//是否异步请求
        success : function(data) {   //如果请求成功，返回数据。
            var html = "";
            $.each(data, function(index, item){    //遍历json数组
                html +="<option value="+item.tId+" >"+item.tName+"</option>";
                type_array[item.tId] = item.tName;
            });
            $(".gtype").html(html); //在html页面class=gtype的标签里显示html内容
            $("#form_del,#form_update,#form_query").children('.gtype').prepend("<option value='-1' selected='selected'>全部</option>");
        }
    })
    // 页面加载完毕，获取商品信息
    var goodsId_array = [];
    $.ajax({
        url : "admin?operation=getGoods",//请求地址
        dataType : "json",//预期服务器返回的数据格式
        type : "get",//请求方式
        async : false,//是否异步请求
        success : function(data) {   //如果请求成功，返回数据。
            var html = "";
            $.each(data, function(index, item){    //遍历json数组
                goodsId_array[item.gId] = "商品编号:"+item.gId+"  商品名称:"+item.gName+"  类型:"+type_array[item.typeId]+"  价格:"+item.price;
                html +="<option value="+item.gId+" >  商品编号:"+item.gId+"  商品名称:"+item.gName+"  类型:"+type_array[item.typeId]+"  价格:"+item.price+"</option>";
            });
            $(".goods").html(html); //在html页面class=gtype的标签里显示html内容
        }
    })
    $('.father').click(function () {
        $(this).parent().siblings().children('.son').hide();
        $(this).next('.son').slideToggle(1000);
    })
    $('#add_btn').click(function () {
        $.ajax({
            url : "admin?operation=addGoods",//请求地址
            dataType : "text",//预期服务器返回的数据格式
            type : "post",//请求方式
            async : false,//是否异步请求
            data: $('#form_add').serialize(), // 序列化表单值
            success : function(data) {   //如果请求成功，返回数据。
                alert(Number(data)==1?"添加成功":"添加失败")
            }
        })
    })
    // 监听文本是否改变
    /*$('.goods').change(function () {
        alert(goodsId_array[1]);
        $(this).prevAll('.d_result').text(goodsId_array[$(this).val()]);
    })*/
    $('#query_del').click(function () {
        $.ajax({
            url : "admin?operation=getGoods_where",//请求地址
            dataType : "json",//预期服务器返回的数据格式
            type : "post",//请求方式
            async : false,//是否异步请求
            data: $('#form_del').serialize(), // 序列化表单值
            success : function(data) {   //如果请求成功，返回数据。
                var html = "";
                $.each(data, function(index, item){    //遍历json数组
                    goodsId_array[item.tId] = "商品编号:"+item.gId+"  商品名称:"+item.gName+"  类型:"+type_array[item.typeId]+"  价格:"+item.price;
                    html +="<option value="+item.gId+" >  商品编号:"+item.gId+"  商品名称:"+item.gName+"  类型:"+type_array[item.typeId]+"  价格:"+item.price+"</option>";
                });
                $("#del_goods").html(html); //在goods标签里显示html内容
            }
        })
    })
    
    // 删除按钮点击事件
    $('#del_btn').click(function () {
        $.ajax({
            url : "admin?operation=delGoods",//请求地址
            dataType : "text",//预期服务器返回的数据格式
            type : "post",//请求方式
            async : false,//是否异步请求
            data: $('#form_del').serialize(), // 序列化表单值
            success : function(data) {   //如果请求成功，返回数据。
                alert(Number(data)==1?"删除成功":"删除失败")
            }
        })
    })
    
    $('#query_update').click(function () {
        $.ajax({
            url : "admin?operation=getGoods_where",//请求地址
            dataType : "json",//预期服务器返回的数据格式
            type : "post",//请求方式
            async : false,//是否异步请求
            data: $('#form_update').serialize(), // 序列化表单值
            success : function(data) {   //如果请求成功，返回数据。
                var html = "";
                $.each(data, function(index, item){    //遍历json数组
                    goodsId_array[item.tId] = "商品编号:"+item.gId+"  商品名称:"+item.gName+"  类型:"+type_array[item.typeId]+"  价格:"+item.price;
                    html +="<option value="+item.gId+" >  商品编号:"+item.gId+"  商品名称:"+item.gName+"  类型:"+type_array[item.typeId]+"  价格:"+item.price+"</option>";
                });
                $("#del_goods").html(html); //在goods标签里显示html内容
            }
        })
    })
    // 修改按钮点击事件
    $('#update_btn').click(function () {
        $.ajax({
            url : "admin?operation=updateGoods",//请求地址
            dataType : "text",//预期服务器返回的数据格式
            type : "post",//请求方式
            async : false,//是否异步请求
            data: $('#form_update').serialize(), // 序列化表单值
            success : function(data) {   //如果请求成功，返回数据。
                alert(Number(data)==1?"修改成功":"修改失败")
            }
        })
    })
    // 查询界面查询按钮点击事件
    $('#query_btn').click(function () {
        $.ajax({
            url : "admin?operation=getGoods_where",//请求地址
            dataType : "json",//预期服务器返回的数据格式
            type : "post",//请求方式
            async : false,//是否异步请求
            data: $('#form_query').serialize(), // 序列化表单值
            success : function(data) {   //如果请求成功，返回数据。
                var html = "";
                $.each(data,function (index,item) {
                    html += "<p>商品编号:"+item.gId+"  商品名称:"+item.gName+"  类型:"+type_array[item.typeId]+"  价格:"+item.price+"</p>";
                });
                $("#query_result").html(html);
            }

        })
    })
})