<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/commons/basejs.jsp" %>
	<title>Basic Dialog（对话框窗口）</title>
</head>
<body>
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('open')">Open</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('close')">Close</a>
	</div>
	<div id="dlg" class="easyui-dialog" title="Basic Dialog" style="width:400px;height:200px;padding:10px">
		The dialog content.
	</div>
	<script type="text/javascript">
		var $dialog = $('#dlg');
		$(function(){
			$dialog.dialog({
				iconCls: 'icon-save',
				toolbar: [{
					text:'Add',
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},'-',{
					text:'Save',
					iconCls:'icon-save',
					handler:function(){
						alert('save');
					}
				}],
				buttons: [{
					text:'Ok',
					iconCls:'icon-ok',
					handler:function(){
						alert('ok');
					}
				},{
					text:'Cancel',
					iconCls:'icon-cancel',
					handler:function(){
						$dialog.dialog('close');
					}
				}]
			});
			
		});
	</script>
</body>
</html>