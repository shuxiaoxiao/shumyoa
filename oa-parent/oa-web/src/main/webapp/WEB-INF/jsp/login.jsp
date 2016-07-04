<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>登录页</title>
  </head>
  
  <body>
  <form method="post" id="loginform">
		<div class="easyui-panel" title="Login to system" style="width:400px;padding:30px 70px 20px 70px">
			<div style="margin-bottom:10px;">
				<input class="easyui-textbox" name="loginname" style="width:100%;height:40px;line-height:40px;padding:12px" 
				data-options="required: true,reprompt:'loginname',iconCls:'icon-man',iconWidth:38" />
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" type="password" name="password" style="width:100%;height:40px;padding:12px" 
				data-options="required: true,prompt:'Password',iconCls:'icon-lock',iconWidth:38" />
			</div>
			
			<div>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;"
					onclick="submitForm()">
					<span style="font-size:14px;">登 录</span>
				</a>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$(function(){
			// 登录
            $('#loginform').form({
                url:'${path }/login',
                onSubmit : function() {
                	var isValid = $(this).form('validate');
    				if(isValid){
    					$.messager.progress({
    							title:'请稍后',
    			                msg:'数据保存中...'
    						});
    				 }
    	            return isValid;
                },
                success:function(result){
                    console.log(result);
                	//关闭
                	$.messager.progress('close');
                    result = $.parseJSON(result);
                    console.log(result);
                    if (result.success) {
                        //window.location.href='${path }' + result.msg;
                        window.location.href='${path }/home';
                    }else{
                         $.messager.show({
                            title:'提示',
                            msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>'+ result.msg +'</div></div>',
                            showType:'show'
                        });
                    }
                }
            });
			
		});
		
		function submitForm(){
            $('#loginform').submit();
        }
        function clearForm(){
            $('#loginform').form('clear');
        }
        //回车登录
        function enterlogin(){
            if (event.keyCode == 13){
                event.returnValue=false;
                event.cancel = true;
                $('#loginform').submit();
            }
        }
		
	</script>
  </body>
</html>
