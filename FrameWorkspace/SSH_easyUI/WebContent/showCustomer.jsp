<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <script type="text/javascript" src="easyUI/jquery.min.js"></script>
    <script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyUI/locale/easyui-lang-zh_CN.js"></script>
    
</head>
<body>
    <!-- <h1>EasyUI中的datagrids使用</h1> -->
    <table id="dg"></table>
    
    <!-- 添加客户的表单(窗口)，closed:true默认是隐藏的 -->
	<div id="winAdd" class="easyui-window" title="添加客户" style="width:600px;height:200px"   data-options="iconCls:'icon-save',modal:true,closed:true">   
        <form id="formAdd" method="post">
			<table cellSpacing=0 cellPadding=5  border=0>
				<tr>
					<td>客户名称：</td>
					<td><input class=textbox id=sChannel2 style="width: 180px" maxLength=50 name="cust_name"></td>
					<td>客户级别 ：</td>
					<td><input class=textbox id=sChannel2 style="width: 180px" maxLength=50 name="cust_level"></td>
				</tr>
				<tr>
					<td>信息来源 ：</td>
					<td><input class=textbox id=sChannel2 style="width: 180px" maxLength=50 name="cust_source"></td>
					<td>客户行业：</td>
					<td><input class=textbox id=sChannel2 style="width: 180px" maxLength=50 name="cust_industry"></td>
				</tr>
				
				<tr>
					<td>固定电话 ：</td>
					<td><input class=textbox id=sChannel2 style="width: 180px" maxLength=50 name="cust_phone"></td>
				<td>移动电话 ：</td>
				<td><input class=textbox id=sChannel2 style="width: 180px" maxLength=50 name="cust_mobile"></td>
				</tr>
				<tr>
					<td rowspan=2><button type="button" onclick="save()">保存</button></td>
				</tr>
			</table>   
		</form>
	</div>
	<script type="text/javascript">
	function save() {
		// 1.异步提交表单
		$('#formAdd').form('submit',{    
		    url:"customer_save.action",
		    success:function(data){
		    	data = JSON.parse(data);
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
        // 使用JS创建datagrid
        $(function () {
        	
            $('#dg').datagrid({
                // 请求路径（URL）
                url:'customer_findAll',
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
                    {field:'cust_id',title:'客户编号',width:100},
                    {field:'cust_name',title:'客户名称',width:100},
                    {field:'cust_source',title:'客户来源',width:100},
                    {field:'cust_industry',title:'客户所属行业',width:100},
                    {field:'cust_level',title:'客户级别',width:100},
                    {field:'cust_phone',title:'固定电话',width:100},
                    {field:'cust_mobile',title:'移动电话',width:100},
                    {field:'XXXXXX',title:'其他操作',width:100,formatter:function(){
                        return '<a style="color:blue" href="#">修改</a>/<a style="color:blue" href="#">删除</a>'}}
                ]],
                // 条纹表格
                striped:true,
                // 分页工具
                pagination:true,
                // 默认页码
                pageNumber:1,
                // 一页显示的数量
                pageSize:3,
                // 分页数列表
                pageList:[3,6,9,12]
            });
			
        })
    </script> 
</body>
</html>