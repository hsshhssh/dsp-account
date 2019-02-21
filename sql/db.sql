drop table if exists t_content;
drop table if exists t_content_floor_config;
drop table if exists t_floor_config;
drop table if exists t_game;
drop table if exists t_game_category;
drop table if exists t_game_floor_config;

CREATE TABLE `t_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` text COMMENT '内容',
  `picture` varchar(500) NOT NULL DEFAULT '' COMMENT '图片',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容表';

CREATE TABLE `t_content_floor_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `floor_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '楼层id',
  `content_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '内容id',
  `weight` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '权重',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容楼层配置表';

create table t_floor_config(
	id int not null auto_increment comment '主键id',
	title varchar(100) not null default '' comment '标题',
	type tinyint(4) unsigned not null default 1 comment '楼层类型',
	weight int unsigned not null default 0 comment '权重',
	state tinyint(4) unsigned not null default 1 comment '状态 1启用 2禁用',
	createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='楼层配置表';

CREATE TABLE `t_game` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `category_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '游戏分类id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '游戏名称',
  `icon` varchar(500) NOT NULL DEFAULT '' COMMENT '游戏图标',
  `picture` varchar(500) NOT NULL DEFAULT '' COMMENT '游戏图片',
  `app_id` varchar(100) NOT NULL DEFAULT '' COMMENT 'appId',
  `path` varchar(500) NOT NULL DEFAULT '' COMMENT '小程序跳转路径',
  `extra_data` varchar(1024) NOT NULL DEFAULT '' COMMENT '小程序跳转扩展参数',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏表';

CREATE TABLE `t_game_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏分类表';


CREATE TABLE `t_game_floor_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `floor_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '楼层id',
  `game_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '游戏id',
  `type` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '跳转类型 1跳转到图片 2跳转到小程序',
  `weight` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '权重',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏楼层配置表';
