<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/basejs.jsp" %>  
    <title>Basic Panel（面板）</title>
  </head>
  
  <body>
	<!-- <div style="font-size: 12px;padding:0;"></div> -->
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

</body>
</html>
