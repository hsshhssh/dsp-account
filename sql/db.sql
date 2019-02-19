create table t_floor_config(
	id int not null auto_increment comment '主键id',
	title varchar(100) not null default '' comment '标题',
	type tinyint(4) unsigned not null default 1 comment '楼层类型',
	weight int unsigned not null default 0 comment '权重',
	createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='楼层配置表';

create table t_type_1_config(
	id int not null auto_crement comment '主键id',
	floor_id int unsigned not null default 0 comment '楼层id',
	game_id int unsigned not null default 0 comment '游戏id',
	type tinyint(4) unsigned not null default 1 comment '跳转类型 1跳转到图片 2跳转到小程序',
	weight int unsigned not null default 0 comment '权重',
	createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='一行楼层配置表';

create table t_type_2_config(
	id int not null auto_increment comment '主键id',
	floor_id int unsigned not null default 0 comment '楼层id',
	content_id int unsigned not null default 0 comment '内容id',
	weight int unsigned not null default 0 comment '权重',
	createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='左右滑动配置表';

create table t_type_3_config(
	id int not null auto_increment comment '主键id',
	floor_id int unsigned not null default 0 comment '楼层id',
	game_id int unsigned not null default 0 comment '游戏id',
	type tinyint(4) unsigned not null default 1 comment '跳转类型 1跳转到图片 2跳转到小程序',
	weight int unsigned not null default 0 comment '权重',
	createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='多行配置表';

create table t_type_4_config(
	id int not null auto_increment comment '主键id',
	floor_id int unsigned not null default 0 comment '楼层id',
	content_id int unsigned not null default 0 comment '内容id',
	weight int unsigned not null default 0 comment '权重',
	createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='上下滑动配置表';


create table t_game_category(
	id int not null auto_increment comment '主键id',
	name varchar(50) not null default '' comment '名称',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='游戏分类表';

create table t_game(
	id int not null auto_increment comment '主键id',
	category_id int unsigned not null default 0 comment '游戏分类id',
	name varchar(50) not null default '' comment '游戏名称',
	icon varchar(500) not null default '' comment '游戏图标',
	picture varchar(500) not null default '' comment '游戏图片',
	app_id varchar(100) not null default '' comment 'appId',
	path varchar(500) not null default '' comment '小程序跳转路径',
	extra_data varchar(1024) not null default '' comment '小程序跳转扩展参数',
	createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='游戏表';

create table t_content(
  id int not null auto_increment comment '主键id',
  content text comment '内容',
  picture varchar(500) not null default '' comment '图片',
	createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	primary key (`id`)
) engine=innodb default charset=utf8 comment='内容表';
