/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.31 : Database - ncun
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ncun` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ncun`;

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `article_title` varchar(100) NOT NULL COMMENT '标题',
  `article_text` longtext NOT NULL COMMENT '文章正文',
  `article_summary` varchar(255) NOT NULL COMMENT '文章摘要',
  `article_type` varchar(255) NOT NULL COMMENT '文章类型(原创，转载)',
  `article_categories` varchar(255) NOT NULL COMMENT '博客分类',
  `article_label` varchar(255) DEFAULT NULL COMMENT '文章标签',
  `article_special` varchar(255) DEFAULT NULL COMMENT '文章专题',
  `article_grade` int(4) DEFAULT NULL COMMENT '文章热度（10表示置顶）',
  `article_author` varchar(255) NOT NULL COMMENT '文章作者',
  `article_imgs` varchar(255) DEFAULT NULL COMMENT '缩略图像',
  `article_url` varchar(255) DEFAULT NULL COMMENT '文章路径',
  `article_likes` bigint(20) DEFAULT NULL COMMENT '文章点赞数',
  `article_views` bigint(20) DEFAULT NULL COMMENT '文章查看数',
  `comment_status` varchar(2) NOT NULL COMMENT '是否允许评论（0-不开启 1-开启）',
  `status` varchar(2) NOT NULL COMMENT '状态（0-草稿  1-发布）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='博客操作';

/*Data for the table `t_blog` */

/*Table structure for table `t_blog_plugin` */

DROP TABLE IF EXISTS `t_blog_plugin`;

CREATE TABLE `t_blog_plugin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `plugin_name` varchar(255) DEFAULT NULL COMMENT '插件名(url)',
  `plugin_describe` varchar(255) DEFAULT NULL COMMENT '插件描述',
  `plugin_img` varchar(255) DEFAULT NULL COMMENT '插件预览图',
  `status` varchar(2) CHARACTER SET utf8mb4 NOT NULL DEFAULT '1' COMMENT '状态 1 -- 生效  0  -- 弃用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='插件操作';

/*Data for the table `t_blog_plugin` */

/*Table structure for table `t_blog_theme` */

DROP TABLE IF EXISTS `t_blog_theme`;

CREATE TABLE `t_blog_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `theme_name` varchar(255) DEFAULT NULL COMMENT '主题名(url)',
  `theme_describe` varchar(255) DEFAULT NULL COMMENT '主题描述',
  `theme_img` varchar(255) DEFAULT NULL COMMENT '主题预览图',
  `status` varchar(2) CHARACTER SET utf8mb4 NOT NULL DEFAULT '1' COMMENT '状态 1 -- 生效  0  -- 弃用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='主题操作';

/*Data for the table `t_blog_theme` */

/*Table structure for table `t_blog_type` */

DROP TABLE IF EXISTS `t_blog_type`;

CREATE TABLE `t_blog_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `label_name` varchar(255) NOT NULL COMMENT '标签名称',
  `type_url` varchar(255) DEFAULT NULL COMMENT '分类路径',
  `type_describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `type` varchar(2) NOT NULL DEFAULT '1' COMMENT '0  -- 类型  1 -- 分类   2 -- 标签   3 -- 专题',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '0  -- 未读  1 -- 已用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='分类操作';

/*Data for the table `t_blog_type` */

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `blog_id` int(11) NOT NULL COMMENT '博客id',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `mail` varchar(255) NOT NULL COMMENT '邮箱',
  `site` varchar(255) NOT NULL COMMENT '站点',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `parent_id` int(11) NOT NULL COMMENT '父ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(2) NOT NULL DEFAULT '0' COMMENT '状态（0-待审核  1-已审核）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='评论操作';

/*Data for the table `t_comment` */

/*Table structure for table `t_common` */

DROP TABLE IF EXISTS `t_common`;

CREATE TABLE `t_common` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `param_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '参数名称',
  `param_key` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '参数key',
  `param_value` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '参数value',
  `param_desc` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '参数描述',
  `key1` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key1',
  `value1` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value1',
  `key2` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key2',
  `value2` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value2',
  `key3` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key3',
  `value3` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value3',
  `key4` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key4',
  `value4` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value4',
  `key5` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key5',
  `value5` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value5',
  `key6` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key6',
  `value6` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value6',
  `key7` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key7',
  `value7` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value7',
  `key8` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key8',
  `value8` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value8',
  `key9` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key9',
  `value9` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value9',
  `key10` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key10',
  `value10` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value10',
  `key11` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key11',
  `value11` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value11',
  `key12` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key12',
  `value12` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value12',
  `key13` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'key13',
  `value13` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'value13',
  `status` varchar(2) CHARACTER SET utf8mb4 NOT NULL DEFAULT '1' COMMENT '状态 1 -- 生效  0  -- 弃用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典操作';

/*Data for the table `t_common` */

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `file_preview_path` varchar(255) DEFAULT NULL COMMENT '预览地址',
  `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `file_size` varchar(255) DEFAULT NULL COMMENT '文件大小',
  `file_suffix` varchar(255) DEFAULT NULL COMMENT '后缀',
  `status` varchar(2) CHARACTER SET utf8mb4 NOT NULL DEFAULT '1' COMMENT '状态 1 -- 生效  0  -- 弃用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文件操作';

/*Data for the table `t_file` */

/*Table structure for table `t_friend_url` */

DROP TABLE IF EXISTS `t_friend_url`;

CREATE TABLE `t_friend_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `link_name` varchar(255) NOT NULL COMMENT '友链名',
  `link_img` varchar(255) NOT NULL COMMENT '友链头像',
  `link_info` varchar(255) NOT NULL COMMENT '友链介绍',
  `link_url` varchar(255) NOT NULL COMMENT '友链地址',
  `status` varchar(2) CHARACTER SET utf8mb4 NOT NULL DEFAULT '1' COMMENT '状态 1 -- 生效  0  -- 弃用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='友链操作';

/*Data for the table `t_friend_url` */

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `menu_url` varchar(255) NOT NULL COMMENT '菜单url（Controller 请求路径）',
  `menu_name` varchar(255) NOT NULL COMMENT '菜单名称',
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `menu_sort` int(11) DEFAULT NULL COMMENT '排序',
  `menu_target` varchar(255) DEFAULT NULL COMMENT '打开方式',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '0  -- 未读  1 -- 已用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单操作';

/*Data for the table `t_menu` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `role_code` varchar(255) NOT NULL COMMENT '角色代码',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '0  -- 未读  1 -- 已用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色操作';

/*Data for the table `t_role` */

/*Table structure for table `t_role_menus` */

DROP TABLE IF EXISTS `t_role_menus`;

CREATE TABLE `t_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单表id',
  `role_id` int(11) NOT NULL COMMENT '角色表id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '0  -- 未读  1 -- 已用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单操作';

/*Data for the table `t_role_menus` */

/*Table structure for table `t_system_log` */

DROP TABLE IF EXISTS `t_system_log`;

CREATE TABLE `t_system_log` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `business_no` varchar(255) NOT NULL COMMENT '流水号',
  `req_url` varchar(255) NOT NULL COMMENT '请求路径',
  `req_desc` varchar(255) NOT NULL COMMENT '请求描述',
  `req_body` longtext NOT NULL COMMENT '请求报文',
  `resp_body` longtext NOT NULL COMMENT '响应报文',
  `time_cost` varchar(255) NOT NULL COMMENT '请求耗时',
  `req_ip` varchar(255) NOT NULL COMMENT '请求IP',
  `ip_addr` varchar(255) NOT NULL COMMENT 'IP归属',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='日志操作';

/*Data for the table `t_system_log` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `login_enable` varchar(255) DEFAULT '0' COMMENT '是否禁用登录',
  `login_error` int(11) DEFAULT NULL COMMENT '登录失败次数',
  `login_last_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `user_image` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `user_display_name` varchar(255) DEFAULT NULL COMMENT '显示名称',
  `username` varchar(255) NOT NULL COMMENT '姓名',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `user_desc` varchar(255) DEFAULT NULL COMMENT '简介',
  `sex` varchar(2) DEFAULT '1' COMMENT '1 -- 男  0  -- 女',
  `phone` varchar(18) DEFAULT NULL COMMENT '手机号',
  `email` varchar(68) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(11) DEFAULT NULL COMMENT 'qq',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户操作';

/*Data for the table `t_user` */

/*Table structure for table `t_user_roles` */

DROP TABLE IF EXISTS `t_user_roles`;

CREATE TABLE `t_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `user_id` int(11) NOT NULL COMMENT '用户表id',
  `role_id` int(11) NOT NULL COMMENT '角色表id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '0  -- 未读  1 -- 已用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色操作';

/*Data for the table `t_user_roles` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
