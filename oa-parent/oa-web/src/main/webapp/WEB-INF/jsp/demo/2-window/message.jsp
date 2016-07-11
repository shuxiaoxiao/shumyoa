<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>Messager（消息窗口）</title>
  </head>
  
  <body>
	<%--
  	$.messager.show(options) 
		showType：定义将如何显示该消息。可用值有：null,slide,fade,show。默认：slide。
		showSpeed：定义窗口显示的过度时间。默认：600毫秒。
		width：定义消息窗口的宽度。默认：250px。
		height：定义消息窗口的高度。默认：100px。
		title：在头部面板显示的标题文本。
		msg：显示的消息文本。
		style：定义消息窗体的自定义样式。
		timeout：如果定义为0，消息窗体将不会自动关闭，除非用户关闭他。如果定义成非0的树，消息窗体将在超时后自动关闭。默认：4秒。 
  	 --%>
	<div style="margin:10px;">
	  	 在屏幕右下角显示一条消息窗口
		<a href="#" class="easyui-linkbutton" onclick="show()">Show</a>
		<a href="#" class="easyui-linkbutton" onclick="slide()">Slide</a>
	</div>
	
	<%--
	top:document.body.scrollTop+document.documentElement.scrollTop(最上面)
	bottom:-document.body.scrollTop-document.documentElement.scrollTop(最下面)
	center定位则是right:'',bottom:''即可
	 --%>
	<div style="margin:10px;">
	  	 利用style来控制show的位置
	  	 <p>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topLeft();">TopLeft</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topCenter()">TopCenter</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topRight()">TopRight</a>
		</p>
		<p>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="centerLeft()">CenterLeft</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="center()">Center</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="centerRight()">CenterRight</a>
		</p>
		<p>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="bottomLeft()">BottomLeft</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="bottomCenter()">BottomCenter</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="bottomRight()">BottomRight</a>
		</p>
	</div>
	
  	<%--
  	$.messager.alert(title, msg, icon, fn)
	  	title：在头部面板显示的标题文本。
		msg：显示的消息文本。
  		icon：显示的图标图像。可用值有：error,question,info,warning。
		fn: 在窗口关闭的时候触发该回调函数。
  	 --%>
  	<div style="margin:10px;">
	  	 警告窗口
		<a href="#" class="easyui-linkbutton" onclick="alert1()">Alert</a>
		<a href="#" class="easyui-linkbutton" onclick="alert2()">Alert-Error</a>
		<a href="#" class="easyui-linkbutton" onclick="alert3()">Alert-callback</a>
	</div>
	
	<%--
	$.messager.confirm(title, msg, fn)
		title：在头部面板显示的标题文本。
		msg：显示的消息文本。
		fn(b): 当用户点击“确定”按钮的时侯将传递一个true值给回调函数，否则传递一个false值。 
	 --%>
	<div style="margin:10px;">
		 确认消息窗口
		<a href="#" class="easyui-linkbutton" onclick="confirm()">Confirm</a>
	</div>
	
	<%--
	$.messager.prompt(title, msg, fn) 
		title：在头部面板显示的标题文本。
		msg：显示的消息文本。
		fn(val): 在用户输入一个值参数的时候执行的回调函数。 
	 --%>
	<div style="margin:10px;">
		输入框
		<a href="#" class="easyui-linkbutton" onclick="prompt()">Prompt</a>
	</div>
	
	<%--
  	$.messager.progress(options)
		title：在头部面板显示的标题文本。默认：空。【建议不修改该属性】
		msg：显示的消息文本。默认：空。 
		text：在进度条上显示的文本。【建议不修改该属性】
		interval：每次进度更新的间隔时间。默认：300毫秒。
  	 --%>
	<div style="margin:10px;">
	  	 进度消息窗体
		<a href="#" class="easyui-linkbutton" onclick="progress()">Progress</a>
	</div>
	
	<script>
		function alert1(){
			$.messager.alert('My Title','Here is a message!');
		}
		function alert2(){
			$.messager.alert('My Title','Here is a error message!','error');
		}
		function alert3(){
			$.messager.alert('My Title','Here1 is a error message!', 'info',
				function(){
					$.messager.alert('My Title','已关闭' );
				}
			);
			/* fn触发不了，因为参数顺序，漏掉了icon参数
			$.messager.alert('My Title','Here2 is a error message!',
				function(){
					$.messager.alert('My Title','已关闭' );
				}
			); */
			
		}
		
		//===================//
		function show(){
			$.messager.show({
				title:'My Title',
				msg:'Message will be closed after 4 seconds.',
				showType:'show'
			});
		}
		function slide(){
			$.messager.show({
				title:'My Title',
				msg:'Message will be closed after 5 seconds.',
				timeout:5000,
				showType:'slide'
			});
		}
		
		//===================//
		function confirm(){
			$.messager.confirm('My Title', 'Are you confirm this?', function(r){
				if (r){
					$.messager.alert('提示','confirmed: '+r);
				}
			});
		}
		
		//===================//
		function prompt(){
			$.messager.prompt('My Title', 'Please type something', function(r){
				if (r){
					$.messager.alert('提示','you type: '+r);
				}
			});
		}
		
		//===================//
		function progress(){
			//显示
			$.messager.progress({
				msg:'Loading data...'
			});
			setTimeout(function(){
				//关闭
				$.messager.progress('close');
			},5000)
		}
		
		//===================//
		function topLeft(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'show',
				style:{
					right:'',
					left:0,
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			});
		}
		function topCenter(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'slide',
				style:{
					right:'',
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			});
		}
		function topRight(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'show',
				style:{
					left:'',
					right:0,
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			});
		}
		function centerLeft(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'fade',
				style:{
					left:0,
					right:'',
					bottom:''
				}
			});
		}
		function center(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'fade',
				style:{
					right:'',
					bottom:''
				}
			});
		}
		function centerRight(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'fade',
				style:{
					left:'',
					right:0,
					bottom:''
				}
			});
		}
		function bottomLeft(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'show',
				style:{
					left:0,
					right:'',
					top:'',
					bottom:-document.body.scrollTop-document.documentElement.scrollTop
				}
			});
		}
		function bottomCenter(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'slide',
				style:{
					right:'',
					top:'',
					bottom:-document.body.scrollTop-document.documentElement.scrollTop
				}
			});
		}
		function bottomRight(){
			$.messager.show({
				title:'My Title',
				msg:'The message content',
				showType:'show'
			});
		}
		
	</script>
  </body>
</html>
