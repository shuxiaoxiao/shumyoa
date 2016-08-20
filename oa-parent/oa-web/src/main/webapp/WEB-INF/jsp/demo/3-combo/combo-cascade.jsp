<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>ComboBox cascade（下拉列表框 级联）</title>
  </head>
  
  <body>
	一级：<input id="province" name="province" /> &nbsp;&nbsp;
	二级：<input id="city" name="city" />
	
	<%--实现解释：
		实质就是触发onSelect事件，使用reload方法 改变下级的URL(一般带有参数)
  	 --%>
	<script type="text/javascript">
		var $provinceCombo = $('#province');
		var $cityCombo = $('#city');
		
		$(function(){
			$provinceCombo.combobox({
				url : '${path}/sysDept/tree',
				valueField: 'id',
		        textField: 'text',
		        onSelect: function(record){
		        	 var url = '${path}/sysDept/tree?id='+record.id;  
		        	 $cityCombo.combobox('reload', url); 
		        }
			});
			
			$cityCombo.combobox({
				url : '',
				valueField: 'id',
		        textField: 'text',
			});
			
		});
	</script>
  </body>
</html>
