mvn clean source:jar install
	项目打包同时生成源码包

项目名：myoa

多web项目暂时没实现

===========版本：1.0.1==============
更新时间：2016-7-4
增加内容：
(1)系统日志。aop实现
(2)登录和主拦截器


===========版本：1.0.0==============
更新时间：2016-6-30
增加内容：
(1)后端(model、dao、service、controller) + 前端(easyui) 代码生成。【只支持单表】
(2)maven分模块开发
	oa-app(model、dao、service), oa-app-web(controller、jsp)。 【app代表模块】
(3)easyUI使用的组件
	tabs(选项卡)、 accordion(分类,手风琴)、 layout(布局)
	linkbutton(按钮)
	form(表单)以及form组件
		textbox(文本框)、 combobox(下拉列表框)、  datebox(日期输入框)、 numberbox(数值输入框)
		combotree(树形下拉框)、 combogrid(数据表格下拉框)	【数据组装失败】
	dialog(对话框窗口)、 messager(消息窗口)
	datagrid(数据表格)
	
	tree(树)
	treegrid(树形表格) 【数据组装失败】
	