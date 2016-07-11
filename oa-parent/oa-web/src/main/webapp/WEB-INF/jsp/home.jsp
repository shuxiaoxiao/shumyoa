<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>首页</title>
  </head>
  
  <body>
  	<%-- split:true,可缩动	collapsed:true,在初始化的时候折叠面板
  	iconCls:'icon-ok',添加图标
  	 --%>
    <div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north'" style="height:50px">
			logo
			<p><a href="javascript:void(0);" class="easyui-linkbutton" onclick="logout()" icon="icon-clear" >安全退出</a></p>
		</div>
		<div data-options="region:'south'" style="height:30px;">
			copyright
		</div>
		<div data-options="region:'west',split:true,title:'West'" style="width:15%;">
			<!-- <ul id="menuTree"></ul> -->
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="权限管理" style="padding:10px;" >
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="员工管理" fullTitle="权限管理 --员工管理" url="${path }/sysUser/init">员工管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="组织结构管理" fullTitle="权限管理 --组织结构管理" url="${path }/sysDept/init">组织结构管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="组资源菜单管理" fullTitle="权限管理 --资源菜单管理" url="${path }/sysMenu/init">资源菜单管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="角色管理" fullTitle="权限管理 --角色管理" url="${path }/sysRole/init">角色管理</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="字典管理" fullTitle="权限管理 --字典管理" url="${path }/sysDictionary/init">字典管理</a>
					</p>
				</div>
				<div title="商品-消费管理" style="padding:10px;">
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="商品管理" fullTitle="商品-消费管理 --商品管理" url="${path }/shopGoods/init">商品管理</a>
					</p>
				</div>
				<div title="demo示例" style="padding:10px" data-options="selected:true">
					<%-- <iframe frameborder=0 style=width:100%;height:100% src='${path }/leftDemo' ></iframe> --%>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="LinkButton（按钮）" fullTitle="demo示例-LinkButton（按钮）" url="${path }/initLinkButton">LinkButton（按钮）</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Panel（面板）" fullTitle="demo示例-Panel（面板）" url="${path }/initPanel">Panel（面板）</a>
						&nbsp;|&nbsp;
						<a href="#" title="Panel-js（面板）" fullTitle="demo示例-Panel-js（面板）" url="${path }/initPanel-js">Panel-js（面板）</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Messager（消息窗口）" fullTitle="demo示例-Messager（消息窗口）" url="${path }/initMessager">Messager（消息窗口）</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Window（窗口）" fullTitle="demo示例-Window（窗口）" url="${path }/initWindow">Window（窗口）</a>
						&nbsp;|&nbsp;
						<a href="#" title="Window-Style（窗口）" fullTitle="demo示例-Window-Style（窗口）" url="${path }/initWindow-style">Window-Style（窗口）</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Dialog（对话框窗口）" fullTitle="demo示例-Dialog（对话框窗口）" url="${path }/initDialog">Dialog（对话框窗口）</a>
						&nbsp;|&nbsp;
						<a href="#" title="Dialog-js（对话框窗口）" fullTitle="demo示例-Dialog-js（对话框窗口）" url="${path }/initDialog-js">Dialog-js（对话框窗口）</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Dialog-form（表单）" fullTitle="demo示例-Dialog-form（表单）" url="${path }/initForm">Dialog-form（表单）</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="ComboBox（下拉列表框）" fullTitle="demo示例-ComboBox（下拉列表框）" url="${path }/initComboBox">ComboBox（下拉列表框）</a>
						&nbsp;|&nbsp;
						<a href="#" title="ComboBox-js（下拉列表框）" fullTitle="demo示例-ComboBox-js（下拉列表框）" url="${path }/initComboBox-js">ComboBox-js（下拉列表框）</a>
					</p>
					<p>
						<img src="${staticPath }/images/user.png" />
						<a href="#" title="Tree（窗口）" fullTitle="demo示例-Tree（窗口）" url="${path }/initTree">Tree（窗口）</a>
						&nbsp;|&nbsp;
						<a href="#" title="Tree-js（窗口）" fullTitle="demo示例-Tree-js（窗口）" url="${path }/initTree-js">Tree-js（窗口）</a>
					</p>
				</div>
			</div>
		</div>
		<div data-options="region:'east',split:true,title:'East',collapsed:true " style="width:15%;">
			聊天
		</div>
		<div id="centerPanel" data-options="region:'center',title:'title' ">
			<div id="mainTab" style="width:500px;height:250px;">
	    		<div title="欢迎页面" style="padding:20px;">
	    			<%--直接将整个页面嵌入 --%>
	    			<iframe frameborder=0 style=width:100%;height:100% src='${path }/welcome' ></iframe>
	    		</div>
	    	</div> 
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			var $menu = $('a[url]');
			var $mainTab = $('#mainTab');
			$mainTab.tabs({
				fit : true,
				pill : true,//选中时是气泡模式
				//选中事件
				onSelect : function(title,index){
					/* console.log(title+','+index);
					console.log($menu.eq(index));
					console.log($menu.length); */
					var fullTitle = '欢迎页面';
					if(index != 0){
						fullTitle = $menu.eq(index).attr('fullTitle');
					}
					//console.log(fullTitle);
					changeTitle(fullTitle);
				}
			});
			
			$menu.click(function(){
				var src = $(this).attr('url');
				var title = $(this).html();
				var fullTitle =  $(this).attr('fullTitle');
				
				if($mainTab.tabs('exists' ,title)){
					$mainTab.tabs('select',title);
				} else {
					$mainTab.tabs('add',{
					    title:title,
					    content:'<iframe frameborder=0 style=width:100%;height:100% src='+ src +' ></iframe>',   
					    closable:true
					});
				}
				changeTitle(fullTitle);
			});
			
			
		});
		
		//更改centerPanel的title
		function changeTitle(newTitle){
			$('#centerPanel').panel('setTitle',newTitle);
		}
		
		function logout(){
			$.messager.confirm('提示','确定要退出吗?',function(r){
	        	if(r){
		        	$.messager.progress({
			                title:'请稍后',
			                msg:'正在退出...'
			            });
		        	$.post('${path }/logout', function(result) {
		        			console.log(result);
		                    if(result.success){
		                    	$.messager.progress('close');
		                        window.location.href='${path }';
		                    }
		                }, 'json');
	        	}
				
			});
		}
		
	</script>
  </body>
</html>
