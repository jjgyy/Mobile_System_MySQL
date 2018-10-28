SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cost` float(10, 2) NOT NULL DEFAULT 0,
  `pname` varchar(64) NOT NULL,
  `intro` varchar(256) DEFAULT NULL,
  `climit` bigint(20) NOT NULL DEFAULT 0,
  `ccost` float(10, 2) NOT NULL DEFAULT 0,
  `mlimit` bigint(20) NOT NULL DEFAULT 0,
  `mcost` float(10, 2) NOT NULL DEFAULT 0,
  `llimit` bigint(20) NOT NULL DEFAULT 0,
  `lcost` float(10, 2) NOT NULL DEFAULT 0,
  `alimit` bigint(20) NOT NULL DEFAULT 0,
  `acost` float(10, 2) NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(32) NOT NULL DEFAULT '新用户',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user_plan`
-- ----------------------------
DROP TABLE IF EXISTS `user_plan`;
CREATE TABLE `user_plan` (
  `user_id` bigint(20) NOT NULL,
  `plan_id` bigint(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `keep` tinyint(1) NOT NULL DEFAULT 1,
  `del` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`, `plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user_plan_next`
-- ----------------------------
DROP TABLE IF EXISTS `user_plan_next`;
CREATE TABLE `user_plan_next` (
  `user_id` bigint(20) NOT NULL,
  `plan_id` bigint(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`, `plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user_call_record`
-- ----------------------------
DROP TABLE IF EXISTS `user_call_record`;
CREATE TABLE `user_call_record` (
  `call_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `value` int(10) NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`call_record_id`),
  INDEX (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user_msg_record`
-- ----------------------------
DROP TABLE IF EXISTS `user_msg_record`;
CREATE TABLE `user_msg_record` (
  `msg_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `value` int(10) NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`msg_record_id`),
  INDEX (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user_lflow_record`
-- ----------------------------
DROP TABLE IF EXISTS `user_lflow_record`;
CREATE TABLE `user_lflow_record` (
  `lflow_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `value` int(10) NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`lflow_record_id`),
  INDEX (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user_aflow_record`
-- ----------------------------
DROP TABLE IF EXISTS `user_aflow_record`;
CREATE TABLE `user_aflow_record` (
  `aflow_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `value` int(10) NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`aflow_record_id`),
  INDEX (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user_plan_record`
-- ----------------------------
DROP TABLE IF EXISTS `user_plan_record`;
CREATE TABLE `user_plan_record` (
  `plan_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `plan_id` bigint(20) NOT NULL,
  `type` varchar(32) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`plan_record_id`),
  INDEX (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;