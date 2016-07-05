<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>组织结构管理</title>
	<%@ include file="/commons/basejs.jsp" %>
  </head>
  
  <body>
    <div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'west',split:true " style="width:15%;">
			<ul id="sysDeptTree"></ul> 
		</div>
		<div data-options="region:'center' ">
			<%--treegrid不适合做搜索查询  --%>
			<table id="sysDeptTreeGrid"></table>
			<!-- <div style="height:5%;padding: 3px;">
				部门编号：<input type="text" id="query_deptid" />&nbsp;
				部门名称：<input type="text" id="query_name" />&nbsp;
				<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search' " onclick="searchData();">查询</a>
			</div> 
			<%--为了grid的fit属性起效果 --%>
			<div style="height:95%;">
				<table id="sysDeptGrid"></table>
			</div>
			-->
		</div>
		
		<!-- 表单(放在layout里面，放在外面会影响grid的高度) -->
		<div id="dlg" class="easyui-dialog" style="width:450px;height:360px;" 
			data-options="closed:true, modal:true, left:100, top:50, buttons:'#dlg-buttons' ">
	    	<form id="fm" method="post" novalidate>
	    		<input id="id" name="id" type="hidden">
	    		<table class="form-table">
		    		<tr>
		    			<td class="form-td-left"> 部门id:</td>
		    			<td><input class="easyui-textbox form-input" name="deptid" 
		    				data-options="" maxlength="50" missingMessage="请填写部门id" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 部门名称:</td>
		    			<td><input class="easyui-textbox form-input" name="name" 
		    				data-options="" maxlength="50" missingMessage="请填写部门名称" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 父id:</td>
		    			<td><input class="easyui-textbox form-input" name="pid" 
		    				data-options="" maxlength="50" missingMessage="请填写父id" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 层级:</td>
		    			<td><input class="easyui-textbox form-input" name="levels" 
		    				data-options="" maxlength="2" missingMessage="请填写层级" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 创建时间:</td>
		    			<td><input class="easyui-datebox form-input" name="createtime" 
		    				data-options="" maxlength="" missingMessage="请填写创建时间" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 描述:</td>
		    			<td><input class="easyui-textbox form-input" name="description" 
		    				data-options="" maxlength="3000" missingMessage="请填写描述" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td class="form-td-left"> 排序号:</td>
		    			<td><input class="easyui-numberbox form-input" name="sotid" 
		    				data-options="" maxlength="" missingMessage="请填写排序号" />
		    			</td>
		    		</tr>
		    	</table>
	        </form>
	        <div id="dlg-buttons">
		        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
		        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#dlg').dialog('close');" style="width:90px">取消</a>
		    </div>
	    </div>
	</div>
	
<script type="text/javascript">

	var $grid = $('#sysDeptGrid');
	var $tree = $('#sysDeptTree');
	var $treeGrid = $('#sysDeptTreeGrid');
	
	$tree.tree({
		url:'${path}/sysDept/tree' , 
		animate:true ,
		checkbox:true ,
		//cascadeCheck : false ,
		onlyLeafCheck: true, //是否只在末级节点之前显示复选框,true是
		//dnd: true	//是否启用拖拽功能,true是
		onLoadSuccess : function(node, data){
			var rooNode = $tree.tree('getRoot');
			//console.log(rooNode);
			//展开根节点
			$tree.tree('expand',rooNode.target);
			//生效,但是是展开所有
			//$tree.tree('expandAll');
		}
	});
	
	/**
	 * 查询用户
	 */
	/*
	function searchData(){
		 $grid.datagrid('load',{
			//'deptid': $('#query_deptid').val(),
			'name': $('#query_name').val()
		}); 
	}*/
	
	$(function(){
		$treeGrid.treegrid({    
		    url:'${path}/sysDept/treeGrid',    
		    idField:'deptid',    
		    treeField:'name',
		    fit:true ,//填充父容器
		    rownumbers:true ,
			//singleSelect:false , //true为单选模式 ,false为多选
		    columns:[[    
				{field:'ck', width:50, checkbox: true},      
				{field:'deptid',title:'部门id'},    
				{field:'name',title:'部门名称'},    
				{field:'pid',title:'父id'},    
				{field:'levels',title:'层级'},    
				{field:'createtime',title:'创建时间'},    
				{field:'description',title:'描述'},    
				{field:'sotid',title:'排序号'}     
		    ]],
		    toolbar:[{
	    		text:'新 增' ,
				iconCls:'icon-add' , 
				handler:function(){
	    			initAdd();
				}
		    },{
		    	text:'修 改' ,
				iconCls:'icon-edit' , 
				handler:function(){
					initEdit();
				}
		     },{
		    	text:'删 除' ,
				iconCls:'icon-remove' , 
				handler:function(){
		    		del();
				}
		     },{
		    	text:'刷新' ,
				iconCls:'icon-refresh' , 
				handler:function(){
					$treeGrid.treegrid('reload');
				}
		    }],
		    onLoadSuccess : function(node, data){
				var rooNode = $treeGrid.treegrid('getRoot');
				//console.log(rooNode);
				//展开根节点
				$treeGrid.treegrid('expand',rooNode.deptid);//指定的是idField对应的值
				//生效,但是是展开所有
				//$treeGrid.treegrid('expandAll');
			}
		});  
		
		
		/* 
		$grid.datagrid({
			idField:'id' ,		//只要创建数据表格 就必须要加 ifField
			fit:true ,//填充父容器
			fitColumns:true ,  //自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
			striped: true , //隔行变色特性 
			loadMsg: '数据正在加载,请耐心的等待...' ,
			rownumbers:true ,
			pagination: true , //启用分页
			//singleSelect:true , //单选模式 
			url:'${path}/sysDept/list', 
		    columns:[[
		        {field:'ck', width:50, checkbox: true},
				{field:'deptid',title:'部门id'},    
				{field:'name',title:'部门名称'},    
				{field:'pid',title:'父id'},    
				{field:'levels',title:'层级'},    
				{field:'createtime',title:'创建时间'},    
				{field:'description',title:'描述'},    
				{field:'sotid',title:'排序号'},    
		    ]] ,
		    toolbar:[{
	    		text:'新 增' ,
				iconCls:'icon-add' , 
				handler:function(){
	    			initAdd();
				}
		    },{
		    	text:'修 改' ,
				iconCls:'icon-edit' , 
				handler:function(){
					initEdit();
				}
		     },{
		    	text:'删 除' ,
				iconCls:'icon-remove' , 
				handler:function(){
		    		del();
				}
		    }]
		}); */
	});
	
	var url='';//表单提交url
	
	/**增加*/
	function initAdd(){
		//清空表单
		$('#fm').form('clear');
		//如果上面的表单清空不好用,则换成jq的表单清空
		//$('#fm').get(0).reset();
		
		//显示
		$('#dlg').dialog('open').dialog('setTitle','新增表单');
	    url='save';
	}
	
	/**修改*/
	function initEdit(){
		/*//多选下的内容
		var row = $treeGrid.treegrid('getSelections');
		if(row.length != 1){
			$.messager.alert('警告','请选择一行操作数据，且只能选择一行！');
		}else{
			//清空表单
			$('#fm').form('clear');
			//如果上面的表单清空不好用,则换成jq的表单清空
			//$('#fm').get(0).reset();
			$('#dlg').dialog('open').dialog('setTitle','修改表单');
			
	        //数据回显
	        $('#fm').form('load',row[0]);
	        url='update';
		} */
	    var row = $treeGrid.treegrid('getSelected');
	    if (row){
	    	//清空表单
			$('#fm').form('clear');
			//如果上面的表单清空不好用,则换成jq的表单清空
			//$('#fm').get(0).reset();
			$('#dlg').dialog('open').dialog('setTitle','修改表单');
	        $('#dlg').dialog('open').dialog('setTitle','修改表单');
	        //数据回显
	        $('#fm').form('load',row);
	        url='update';
	    }else{
	    	$.messager.alert('警告','请选择一行操作数据，且只能选择一行！');    
	    }
	}
	
	/**表单保存(含新增和修改)*/
	function save(){
		$('#fm').form('submit',{
	        url: '${path}/sysDept/' + url,
	        onSubmit: function(param){
	       		var isValid = $(this).form('validate');
				if(isValid){
					$.messager.progress({
							title:'请稍后',
			                msg:'数据保存中...'
						});
				 }
	            return isValid;
	        },
	        success: function(result){
	        	var result = JSON.parse(result);//Json对象
	        	//var result = $.parseJSON(result);//jq对象
	       	 	$.messager.progress('close');
	            if (result=='success'){
		        	$('#dlg').dialog('close');
		        	$treeGrid.treegrid('reload');
	            }else if(result=='error'){
	            	$.messager.alert('警告','保存失败');
	            }else{
	            	$.messager.alert('警告',result);
	            }
	        }
		 });
	}
	
	/**删除*/
	function del(){
		var row = $treeGrid.treegrid('getSelected');
	    if (row){
	    	$.messager.confirm('提示','确定要删除此信息?',function(r){
	        	if(r){
		        	$.messager.progress({
			                title:'请稍后',
			                msg:'正在删除...'
			            });
	        		/* var ids = '';
					for(var i =0 ;i<row.length;i++){
						ids += row[i].id + ',' ;
					}
					ids = ids.substring(0 , ids.length-1); */
		            $.ajax({
		            	//url:'${path}/sysDept/deletes/'+ids,
		            	url:'${path}/sysDept/delete/'+ row.id,
		            	dataType:"text",
		        		success:function(data){
		        			$.messager.progress('close');
		        			if (data=='success'){
		                    	$treeGrid.treegrid('reload');
		                    	//清空idField(避免删除后在进行修改操作的bug)
								$treeGrid.treegrid('unselectAll');
		                    }else if(data=='error'){
		                    	$.messager.alert('警告','删除失败');
		                    }else{
		                    	$.messager.alert('警告',data);
		                    }
		        		},
		        		error:function(request,msg){
		        			$.messager.progress('close');
		        			$.messager.alert('警告','删除失败' + msg);
		        		}
		            });
	        	}
	        });
	    }else{
	    	$.messager.alert('警告','请选择一行操作数据，且只能选择一行！');    
	    }
	  	/* //多选下的内容
		//此处是getSelections(返回所有被选中的行)
		var row = $treeGrid.treegrid('getSelections');
		if(row.length <=0){
			$.messager.show({
				title:'提示信息!',
				msg:'至少选择一行记录进行删除!'
			});
		} else {
	        //删除操作
		} */
	}
	
</script>

  </body>
</html>
