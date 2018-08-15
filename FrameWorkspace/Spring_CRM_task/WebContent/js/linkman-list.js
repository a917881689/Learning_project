/**Created by Administrator on 2018/8/8.*/
$(function () {
    function find() {
        $.ajax({
            url:"linkman-find",
            type:"get",
            async: true,
            data:{},
            dataType:"json",
            success: function (linkman){
                console.log(linkman)
                linkman = JSON.parse(linkman);
                var html = "";
                console.log(linkman) 
                for (var i = 0;i < linkman.length;i++) {
                    html += '<TR class="info-list">'+
                        '<TD>'+linkman[i].lkm_name+'</TD>'+
                        '<TD>'+linkman[i].lkm_gender+'</TD>'+
                        '<TD>'+linkman[i].lkm_phone+'</TD>'+
                        '<TD>'+linkman[i].lkm_mobile+'</TD>'+
                        '<input type="hidden" class="lkm_id" value="'+linkman[i].lkm_id+'"/>'+
                        '<TD>'+
                        '<span class="btn-link btn-update">修改</span>&nbsp;&nbsp;'+
                        '<span class="btn-link btn-delete">删除</a>'+
                        '</TD>'+
                        '</TR>';
                }
                $('#list-tboby').html(html);
            }
        })
    }
    find();
    $('.btn-update').click(function () {
    	location.href="linkman_updateUI?lkm_id="+$(this).siblings('.lkm_id').val();
    })
})