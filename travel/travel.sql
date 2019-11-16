
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL ,
  `user_account` varchar(64) NOT NULL unique,
  `password` varchar(64) NOT NULL,
  `head_img_addr` varchar(256) DEFAULT NULL ,
  `gender` varchar(64) DEFAULT NULL ,
  `signature` varchar(256) DEFAULT NULL,
   `wx_code` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `view`;
CREATE TABLE `view` (
  `view_id` bigint(20) NOT NULL AUTO_INCREMENT ,
  `classify` varchar(64) NOT NULL DEFAULT 'others',
  `view_name` varchar(64) NOT NULL ,
  `location` varchar(256) NOT NULL ,
  `opentime` varchar(64) DEFAULT NULL  ,
  `introducation` varchar(20000) DEFAULT NULL  ,
  PRIMARY KEY (`view_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay` (
  `essay_id` bigint(20) NOT NULL AUTO_INCREMENT ,
  `title` varchar(64) NOT NULL ,
  `classify` varchar(64)  DEFAULT 'others',
  `tag` varchar(64)  DEFAULT 'journey',
  `author_id` int(11) NOT NULL ,
  `author_name` varchar(64) NOT NULL ,
   `img_url` varchar(256)  ,
  `create_time` datetime DEFAULT NULL ,
  `page_view` bigint(20) DEFAULT  0 ,
  `great_num` bigint(20) DEFAULT  0 ,
  `content` varchar(20000) DEFAULT NULL ,
  PRIMARY KEY (`essay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 ;



DROP TABLE IF EXISTS `user_view`;
CREATE TABLE `user_view` (
  `user_id` int(11) ,
  `view_id` bigint(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

DROP TABLE IF EXISTS `user_essay_collection`;
CREATE TABLE `user_essay_collection` (
  `user_id` int(11) ,
  `essay_id` bigint(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

DROP TABLE IF EXISTS `user_essay_great`;
CREATE TABLE `user_essay_great` (
  `user_id` int(11) ,
  `essay_id` bigint(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;