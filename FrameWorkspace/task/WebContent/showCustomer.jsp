<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>查看所有用户</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <script type="text/javascript" src="easyUI/jquery.min.js"></script>
    <script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyUI/locale/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
		.btn-link {
			color: blue;
			background-color: #FFFFFF;
			border: 0px none;
			font-size: 15px;
			text-decoration:underline;
		}
		.btn-link:hover{
			border: none;
			cursor: hand;
			cursor: pointer;
			text-decoration:underline;
		}
		.btn-link:focus {
			outline: none;
		}

	</style>
</head>
<body>
<!--用户的展示区  -->
<table id="dg"></table>
<!-- 添加客户的表单(窗口)，closed:true默认是隐藏的 -->
	<div id="winAdd" class="easyui-window" title="添加客户" style="width:600px;height:200px"   
			data-options="iconCls:'icon-save',modal:true,closed:true">   
	    <form id="formAdd" method="post">
			<table cellSpacing=0 cellPadding=5  border=0>
				<tr>
					<td>客户名称：</td>
					<td><input class=textbox id=sChannel style="width: 180px" maxLength=50 name="cust_name"></td>
					<td>客户级别 ：</td>
					<td><input class=textbox id=sChanne2 style="width: 180px" maxLength=50 name="cust_level"></td>
				</tr>
				<tr>
					<td>信息来源 ：</td>
					<td><input class=textbox id=sChanne3 style="width: 180px" maxLength=50 name="cust_source"></td>
					<td>客户行业：</td>
					<td><input class=textbox id=sChanne4 style="width: 180px" maxLength=50 name="cust_industry"></td>
				</tr>
				<tr>
					<td>固定电话 ：</td>
					<td><input class=textbox id=sChanne5 style="width: 180px" maxLength=50 name="cust_phone"></td>
				<td>移动电话 ：</td>
				<td><input class=textbox id=sChanne6 style="width: 180px" maxLength=50 name="cust_mobile"></td>
				</tr>
				<tr>
					<td rowspan=2><button type="button" onclick="save()">保存</button></td>
				</tr>
			</table>   
		</form>
	</div>

<div id="winUpdate" class="easyui-window" title="修改客户" style="width:600px;height:200px"
	 data-options="iconCls:'icon-save',modal:true,closed:true">
	<form id="formUpdate" method="post">
		<table cellSpacing=0 cellPadding=5  border=0>
			<tr>
				<td>客户名称：</td>
				<td><input class=textbox style="width: 180px" maxLength=50 name="cust_name"></td>
				<td>客户级别 ：</td>
				<td><input class=textbox style="width: 180px" maxLength=50 name="cust_level"></td>
			</tr>
			<tr>
				<td>信息来源 ：</td>
				<td><input class=textbox  style="width: 180px" maxLength=50 name="cust_source"></td>
				<td>客户行业：</td>
				<td><input class=textbox  style="width: 180px" maxLength=50 name="cust_industry"></td>
			</tr>
			<tr>
				<td>固定电话 ：</td>
				<td><input class=textbox  style="width: 180px" maxLength=50 name="cust_phone"></td>
				<td>移动电话 ：</td>
				<td><input class=textbox  style="width: 180px" maxLength=50 name="cust_mobile"></td>
			</tr>
			<tr>
				<td rowspan=2><button type="button" onclick="update()">保存</button></td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
    $(function() {
        //使用js来创建datagrid
        function dg_load(url) {
            $('#dg').datagrid({
                url: url, //请求路径（接收json格式）
                columns: [[
                    {field: 'cust_id', title: '客户编号', width: 60},
                    {field: 'cust_name', title: '客户名称', width: 100},
                    {field: 'cust_source', title: '客户来源', width: 100},
                    {field: 'cust_industry', title: '客户所属行业', width: 120},
                    {field: 'cust_level', title: '客户级别', width: 100},
                    {field: 'cust_phone', title: '固定电话', width: 150},
                    {field: 'cust_mobile', title: '移动电话', width: 150},
                    {
                        field: 'xxxxx', title: '其他操作', width: 100,
                        formatter: function (value, row, index) { //用来格式化列的
                            return "<span class='btn-link cust-update'>编辑</span> | <a href='customer_delete?cust_id=" + row.cust_id + "'>删除</a>";
                        }
                    }
                ]],
                striped: true, //条纹表格
                pagination: true, //分页工具
                pageNumber: 1, //初始化页数
                fitColumns: true,
                pageSize: 3,
                pageList: [3, 6, 9, 12], //分页数列表
                toolbar: [{
                    iconCls: 'icon-add',
                    handler: function () {
                        $('#winAdd').window('open'); //让隐藏的窗口显示出来
                    }
                }, '-', {
                    iconCls: 'icon-remove',
                    handler: function () {
                        alert('删除按钮')
                    }
                }, '-', {
                    iconCls: 'icon-edit',
                    handler: function () {
                        alert('编辑按钮')
                    }
                }, '-', {
                    iconCls: 'icon-search',
                    handler: function () {
                        $.messager.prompt("查询", "请输入要查询的姓名：", function (data) {
                            if (data) {
                                console.log("customer_find?cust_name="+data)
                                dg_load("customer_find?cust_name="+data)
                            }
                        });
                    }
                }, '-', {
                    iconCls: 'icon-help',
                    handler: function () {
                        alert('帮助按钮')
                    }
                }]

            });
        }
        dg_load('customer_find')
        function save() {
            //1.异步提交表单
            $('#formAdd').form('submit', {
                url: "customer_save.action",
                success: function (data) { //此时的data只是一个普通字符串，不会自动被解析成json对象
                    var jsonData = JSON.parse(data);
                    //2.关闭窗口
                    $('#winAdd').window('close');
                    //3.弹出提示框
                    $.messager.show({
                        title: '提示消息',
                        msg: jsonData.msg,
                        timeout: 3000,
                        showType: 'slide'
                    });
                    //4.刷新datagrid(数据回显)
                    $('#dg').datagrid('reload');
                }
            });
        }

    })
</script>
</body>
</html>







