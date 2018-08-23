<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>查看所有用户</title>
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
	<%--<script type="text/javascript" src="easyUI/jquery.min.js"></script>--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
	<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyUI/locale/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
		.btn-link {
			color: blue;
			background-color: #FFFFFF;
			border: 0px none;
			font-size: 12px;
			text-decoration:none;
		}
		.btn-link:hover{
			border: none;
			cursor: hand;
			cursor: pointer;
			text-decoration:underline;
		}
		.btn-link:focus {
			outline: none;
			text-decoration:underline;
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
		<input type="hidden" name="cust_id" id="cust_id">
		<table cellSpacing=0 cellPadding=5  border=0>
			<tr>
				<td>客户名称：</td>
				<td><input class=textbox id="cust_name" style="width: 180px" maxLength=50 name="cust_name"></td>
				<td>客户级别 ：</td>
				<td><input class=textbox id="cust_level" style="width: 180px" maxLength=50 name="cust_level"></td>
			</tr>
			<tr>
				<td>信息来源 ：</td>
				<td><input class=textbox id="cust_source"  style="width: 180px" maxLength=50 name="cust_source"></td>
				<td>客户行业：</td>
				<td><input class=textbox id="cust_industry"  style="width: 180px" maxLength=50 name="cust_industry"></td>
			</tr>
			<tr>
				<td>固定电话 ：</td>
				<td><input class=textbox id="cust_phone"  style="width: 180px" maxLength=50 name="cust_phone"></td>
				<td>移动电话 ：</td>
				<td><input class=textbox id="cust_mobile"  style="width: 180px" maxLength=50 name="cust_mobile"></td>
			</tr>
			<tr>
				<td rowspan=2><button type="button" onclick="update()">保存</button></td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
    function save() {
        var rows=$('#dg').datagrid('getRows');
        // 1.异步提交表单
        $('#formAdd').form('submit',{
            url:"customer_save.action",
            success:function(data){
                // 2.关闭窗口
                $('#winAdd').window('close');
                // 3.弹出提示框
                $.messager.show({
                    title:'提示消息',
                    msg:data.msg,
                    timeout:3000,
                    showType:'slide'
                });
                // 3.刷新datagrid(数据回显)
                $('#dg').datagrid('reload');
            }
        });
    }
    function _delete(cid) {
        // 1.异步删除
        $.ajax({
            url:"customer_delete.action",
			type:"get",
			data:{"cust_id":cid},
			dataType:"text",
            success:function(data){
                // 弹出提示框
                $.messager.show({
                    title:'提示消息',
                    msg:data.msg,
                    timeout:3000,
                    showType:'slide'
                });
                // 刷新datagrid(数据回显)
                $('#dg').datagrid('reload');
            }
		})
    }
    function update() {
        $('#formUpdate').form('submit',{
            url:"customer_update.action",
            success:function(data){
                // 2.关闭窗口
                $('#winUpdate').window('close');
                // 3.弹出提示框
                $.messager.show({
                    title:'提示消息',
                    msg:data.msg,
                    timeout:3000,
                    showType:'slide'
                });
                // 3.刷新datagrid(数据回显)
                $('#dg').datagrid('reload');
            }
        });
    }
    function _update($index) {
        //获取所有当前加载的数据行
        var row=rows[$index];
        console.log(row);
        $('#cust_id').val(row.cust_id);
        $('#cust_name').val(row.cust_name);
        $('#cust_source').val(row.cust_source);
        $('#cust_industry').val(row.cust_industry);
        $('#cust_level').val(row.cust_level);
        $('#cust_phone').val(row.cust_phone);
        $('#cust_mobile').val(row.cust_mobile);
        $('#winUpdate').window('open');
    }
    // 使用JS创建datagrid
    $(function () {
        function dg_load(url) {
			$('#dg').datagrid({
				// 请求路径（URL）
                url: url,
				toolbar: [{
					iconCls: 'icon-add',
					handler: function(){
						$('#winAdd').window('open');
					}
				},'-',{
					iconCls: 'icon-remove',
					handler: function(){alert('删除按钮')}
				},'-',{
					iconCls: 'icon-edit',
					handler: function(){alert('修改按钮')}
				},'-',{
					iconCls: 'icon-search',
					handler: function(){alert('查询按钮')}
				},'-',{
					iconCls: 'icon-help',
					handler: function(){alert('帮助按钮')}
				}],
				columns:[[
                    {field:'cust_id',title:'客户编号',width:60},
                    {field:'cust_name',title:'客户名称',width:100},
                    {field:'cust_source',title:'客户来源',width:100},
                    {field:'cust_industry',title:'客户所属行业',width:120},
                    {field:'cust_level',title:'客户级别',width:100},
                    {field:'cust_phone',title:'固定电话',width:150},
                    {field:'cust_mobile',title:'移动电话',width:150},
                    {field:'xxxxx',title:'其他操作',width:100,
						formatter: function (value, row, index) { //用来格式化列的
							return "<a href='#' onclick='_update("+index+")'>编辑</a> | <a href='#' onclick='_delete("+row.cust_id+")'>删除</a>";
						}
					}
				]],
				// 条纹表格
				striped:true,
				// 分页工具
				pagination:true,
				// 默认页码
				pageNumber:1,
				// 一页显示的数量
				pageSize:3,
                fitColumns: true,
				// 分页数列表
				pageList:[3,6,9,12],
                onLoadSuccess : function() {
                    $('#dg').datagrid("resize");
                    rows=$('#dg').datagrid('getRows');
                }
			});
		}
        dg_load('customer_find.action')

    })
</script>

</body>
</html>







