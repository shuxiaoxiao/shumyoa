/*
Navicat MySQL Data Transfer

Source Server         : mysql57
Source Server Version : 50703
Source Host           : 127.0.0.1:3306
Source Database       : myoa

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2016-09-01 23:41:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deptid` varchar(50) DEFAULT NULL COMMENT '部门id',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `pid` varchar(50) DEFAULT NULL COMMENT '父id',
  `levels` varchar(2) DEFAULT NULL COMMENT '层级',
  `createtime` date DEFAULT NULL COMMENT '创建时间',
  `description` varchar(3000) DEFAULT NULL COMMENT '描述',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  `state` varchar(10) DEFAULT NULL COMMENT '节点状态，''open'' 或 ''closed''',
  `isenable` char(1) DEFAULT NULL COMMENT '状态, 0不可以 1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表_部门';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `name` varchar(100) DEFAULT NULL COMMENT '文字描述',
  `value` varchar(100) DEFAULT NULL COMMENT '具体值',
  `descs` varchar(500) DEFAULT NULL COMMENT '描述',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表_字典表';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(100) DEFAULT NULL COMMENT '登录名',
  `rolename` varchar(100) DEFAULT NULL COMMENT '角色名',
  `content` varchar(4000) DEFAULT NULL COMMENT '内容',
  `clientip` varchar(100) DEFAULT NULL COMMENT '客户端ip',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表_操作日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `levels` varchar(2) DEFAULT NULL COMMENT '层级',
  `createtime` date DEFAULT NULL COMMENT '创建时间',
  `requesturl` varchar(200) DEFAULT NULL COMMENT '请求路径',
  `menutype` varchar(2) DEFAULT NULL COMMENT '菜单类型,1菜单 2按钮',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表_菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL COMMENT '名称',
  `description` varchar(3000) DEFAULT NULL COMMENT '描述',
  `type` varchar(2) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表_角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `roleid` int(11) DEFAULT NULL COMMENT '角色表id',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单表id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单_中间表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `loginname` varchar(50) DEFAULT NULL COMMENT '登录名',
  `pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `phonenum` varchar(20) DEFAULT NULL COMMENT '手机号',
  `phonenum2` varchar(20) DEFAULT NULL COMMENT '备用号',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `states` char(1) DEFAULT NULL COMMENT '用户状态',
  `deptid` varchar(50) DEFAULT NULL COMMENT '部门id',
  `createtime` date DEFAULT NULL COMMENT '入职时间',
  `leavetime` date DEFAULT NULL COMMENT '离职时间',
  `usertype` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表_用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `userid` int(11) DEFAULT NULL COMMENT '用户表id',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单表id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户菜单_中间表';

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userid` int(11) DEFAULT NULL COMMENT '用户表id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色表id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色_中间表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
