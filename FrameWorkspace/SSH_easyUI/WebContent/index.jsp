<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入相应的css与JS(EasyUI是基于JQuery的，要先导入JQuery)-->
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <script type="text/javascript" src="easyUI/jquery.min.js"></script>
    <script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
    <style type="text/css">
        .myA{
            text-decoration: none;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $('.myA').click(function () {
                var content = $(this).text();
                var url = $(this).prop("href");
                createTabs(url,content);
                /*使得超链接不跳转*/
                return false;
            })
            function createTabs(url,content) {
                /*判断名字为：content的选项卡是否存在*/
                var flag = $('#myTab').tabs("exists",content);
                /*如果存在就选中*/
                if (flag) {
                    $('#myTab').tabs("select",content);
                }else {
                    /*添加选项卡*/
                    $('#myTab').tabs('add',{
                        title: content,
                        /*使用选项卡加载页面*/
                        content:gotoUrl(url),
                        closable:"true"
                    });

                }
            }
            /*使用内嵌框架加载指定URL页面*/
            function gotoUrl(url) {
                return '<iframe src="'+url+'" frameborder="0" width="100%" height="90%"></iframe>'
            }
        })
    </script>
</head>
<body>

<!--
    region: 方位（东：east，西：west，南：south，北：north，中：center）
    title: 模块标题的名称
    iconCls:(图标样式：add,remove,edit,search,reload)
    data-options="fit:true" :让容器自适应
-->
<div id="cc" class="easyui-layout" style="width:1050px;height:500px;">
    <div data-options="region:'north',title:'客户关系管理系统',split:true" style="height:100px;">
        <h2>客户关系管理系统</h2>
    </div>
    <div data-options="region:'west',title:'功能菜单',split:true" style="width:200px;">
        <div id="aa" class="easyui-accordion" data-options="fit:true">
            <div title="客户管理" data-options="selected:true" style="overflow:auto;padding:10px;">
                <a href="showCustomer.jsp" class="myA">展示客户</a>
            </div>
            <div title="联系人管理" style="padding:10px;">
                <a href="addLinkman.html" class="myA">添加联系人</a>
            </div>
            <div title="客户拜访管理">
                <a href="#" class="myA">添加客户访问记录</a>
            </div>
            <div title="综合查询">

            </div>
            <div title="统计分析">

            </div>
            <div title="系统管理">

            </div>
        </div>
    </div>
    <!--选项卡模块-->
    <!--布局容器-->
    <div data-options="region:'center',title:''" style="padding:5px;background:#eee;">
        <!--选项卡容器-->
        <div id="myTab" class="easyui-tabs" data-options="fit:'true'" style="width:500px;height:250px;">
            <!--选项卡-->
            <div title="数据操作" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">
                欢迎进入CRM管理系统
            </div>
        </div>
    </div>
</div>
</body>
</html>