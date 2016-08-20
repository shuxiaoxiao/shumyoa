
===========部署操作==============
mvn clean source:jar install
	项目打包同时生成源码包

===========注意事项==============
1.如果xml中有关"创建时间"的默认值，则修改xml和修改数据库(加上默认值)
2.如果有like语句,修改相应xml的语句加上 CONCAT('%',#{province},'%')
3.easyui使用js方式时,需要渲染的组件放在$(function(){});里面，避免出现渲染有bug
5.注意mysql数据库的关键字，如desc, database，不要出现在表中

多web项目暂时没实现

===========版本：1.0.1==============
更新时间：2016-7-5
增加内容：
(1)安全退出
(2)bug修改:自动生成代码的模板优化;主拦截器多层次的路径，重定向的问题
(3)添加shopping模块

更新时间：2016-7-4
增加内容：
(1)系统日志。aop实现
(2)登录和主拦截器

===========版本：1.0.0==============
更新时间：2016-7-6
增加内容：
easyUI使用的组件
	combotree(树形下拉框)

更新时间：2016-7-5
增加内容：
easyUI使用的组件
	treegrid(树形表格)

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
		
	dialog(对话框窗口)、 messager(消息窗口)
	datagrid(数据表格)
	tree(树)
	
	