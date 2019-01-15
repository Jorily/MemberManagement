/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : member

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-12-26 12:18:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `group`
-- ----------------------------

DROP TABLE IF EXISTS `group1`;
CREATE TABLE `group1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `mem_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group1` VALUES ('01', '幼儿组1', '15');
INSERT INTO `group1` VALUES ('02', '幼儿组2', '2');
INSERT INTO `group1` VALUES ('03', '幼儿组3', null);
INSERT INTO `group1` VALUES ('04', '幼儿组4', '2');
INSERT INTO `group1` VALUES ('05', '少儿组1', '4');
INSERT INTO `group1` VALUES ('06', '少儿组2', '6');
INSERT INTO `group1` VALUES ('07', '少儿组3', '3');
INSERT INTO `group1` VALUES ('08', '青少年组1', '3');
INSERT INTO `group1` VALUES ('09', '青少年组1', '5');
INSERT INTO `group1` VALUES ('10', '成人组1', '10');
INSERT INTO `group1` VALUES ('11', '成人组2', '2');
-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  KEY `aa` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `member` VALUES ('001', '小赵', '男', '12', '12345678901','01');
INSERT INTO `member` VALUES ('002', '小钱', '女', '26', '15445678901','02');
INSERT INTO `member` VALUES ('003', '小孙', '女', '40', '12354678901','03');
INSERT INTO `member` VALUES ('004', ' 小李', '男', '26','12125678901','04');
INSERT INTO `member` VALUES ('005', '小周', '男', '20', '12345670901','05');
INSERT INTO `member` VALUES ('006', '小吴', '男', '26', '12345378901','06');
INSERT INTO `member` VALUES ('007', '小郑', '女', '22', '12345678941','07');
INSERT INTO `member` VALUES ('008', '小王', '男', '21', '12345678961','08');
INSERT INTO `member` VALUES ('009', '小刘', '男', '21', '12345678911','09');
INSERT INTO `member` VALUES ('010', '小张', '男', '12', '12345678971','10');
INSERT INTO `member` VALUES ('011', '大张', '男', '21', '12345673901','11');
INSERT INTO `member` VALUES ('012', 'Joy', '男', '21',  '12345677901','01');
INSERT INTO `member` VALUES ('013', '小宋', '男', '21', '12345676901','02');
INSERT INTO `member` VALUES ('014', '小于', '男', '21', '12345674901','03');
INSERT INTO `member` VALUES ('015', '小杨', '女', '1', '12347678901','04');
INSERT INTO `member` VALUES ('016', '小郭', '男', '24', '12343678901','05');
INSERT INTO `member` VALUES ('017', '老白', '男', '1', '12347678901','06');
INSERT INTO `member` VALUES ('018', '大嘴', '男', '20', '12385678901','07');
-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `c_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('001', '布加迪','12');
INSERT INTO `car` VALUES ('002', '劳斯莱斯','3');
INSERT INTO `car` VALUES ('003', '宾利','23');
INSERT INTO `car` VALUES ('004', '法拉利','4');
INSERT INTO `car` VALUES ('005', '兰博基尼','14');
INSERT INTO `car` VALUES ('006', '迈巴赫','12');
INSERT INTO `car` VALUES ('007', '','1');
INSERT INTO `car` VALUES ('009', '帕加尼','2');
INSERT INTO `car` VALUES ('010', '柯尼塞格','1');
INSERT INTO `car` VALUES ('011', '布加迪威龙','41');
INSERT INTO `car` VALUES ('012', '宝马','23');
INSERT INTO `car` VALUES ('013', '奔驰','24');
INSERT INTO `car` VALUES ('014', '红牛F1','31');
INSERT INTO `car` VALUES ('015', 'null','1');
-- ----------------------------
-- Table structure for `r_g_c`
-- ----------------------------
DROP TABLE IF EXISTS `r_g_c`;
CREATE TABLE `r_g_c` (
  `g_id` int(11) NOT NULL DEFAULT '0',
  `c_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`g_id`,`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of r_g_c
-- ----------------------------
INSERT INTO `r_g_c` VALUES ('01', '001');
INSERT INTO `r_g_c` VALUES ('01', '002');
INSERT INTO `r_g_c` VALUES ('01', '013');
INSERT INTO `r_g_c` VALUES ('01', '014');
INSERT INTO `r_g_c` VALUES ('01', '005');
INSERT INTO `r_g_c` VALUES ('02', '011');
INSERT INTO `r_g_c` VALUES ('02', '012');
INSERT INTO `r_g_c` VALUES ('02', '003');
INSERT INTO `r_g_c` VALUES ('02', '014');
INSERT INTO `r_g_c` VALUES ('02', '005');
INSERT INTO `r_g_c` VALUES ('02', '007');
INSERT INTO `r_g_c` VALUES ('03', '008');
INSERT INTO `r_g_c` VALUES ('03', '012');
INSERT INTO `r_g_c` VALUES ('03', '009');
INSERT INTO `r_g_c` VALUES ('03', '014');
INSERT INTO `r_g_c` VALUES ('03', '005');
INSERT INTO `r_g_c` VALUES ('04', '006');
INSERT INTO `r_g_c` VALUES ('04', '003');
INSERT INTO `r_g_c` VALUES ('05', '004');
INSERT INTO `r_g_c` VALUES ('05', '011');
INSERT INTO `r_g_c` VALUES ('06', '012');
INSERT INTO `r_g_c` VALUES ('06', '014');
INSERT INTO `r_g_c` VALUES ('06', '011');
INSERT INTO `r_g_c` VALUES ('07', '011');
INSERT INTO `r_g_c` VALUES ('08', '001');
INSERT INTO `r_g_c` VALUES ('09', '009');
INSERT INTO `r_g_c` VALUES ('10', '007');
INSERT INTO `r_g_c` VALUES ('10', '001');
INSERT INTO `r_g_c` VALUES ('10', '003');
INSERT INTO `r_g_c` VALUES ('11', '014');
INSERT INTO `r_g_c` VALUES ('11', '013');
-- ---------------------------
-- ----------------------------
-- Table structure for `message`
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) not NULL,
  `c_id` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `ymd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('0001', '001', '006', '175', '151211');
INSERT INTO `message` VALUES ('0002', '001', '001', '175', '150611');
INSERT INTO `message` VALUES ('0003', '002', '001', '90', '170203');
INSERT INTO `message` VALUES ('0004', '002', '006', '90', '150411');
INSERT INTO `message` VALUES ('0005', '002', '007', '90', '151211');
INSERT INTO `message` VALUES ('0006', '003', '002', '710', '181223');
INSERT INTO `message` VALUES ('0007', '003', '003', '710', '180223');
INSERT INTO `message` VALUES ('0008', '003', '004', '710', '180523');
INSERT INTO `message` VALUES ('0009', '003', '005', '710', '180723');
INSERT INTO `message` VALUES ('0010', '003', '006', '710', '171222');
INSERT INTO `message` VALUES ('0011', '003', '007', '710', '161220');
INSERT INTO `message` VALUES ('0012', '003', '008', '710', '180909');
INSERT INTO `message` VALUES ('0013', '004', '003', '63', '150617');
INSERT INTO `message` VALUES ('0014', '005', '004', '65', '160731');
INSERT INTO `message` VALUES ('0015', '005', '005', '65', '160931');
INSERT INTO `message` VALUES ('0016', '005', '006', '65', '170731');
INSERT INTO `message` VALUES ('0017', '006', '011', '95', '170821');
INSERT INTO `message` VALUES ('0018', '007', '013', '90', '190101');
INSERT INTO `message` VALUES ('0019', '008', '012', '82', '181111');
INSERT INTO `message` VALUES ('0020', '009', '011', '192', '190105');
INSERT INTO `message` VALUES ('0021', '009', '001', '192', '190505');
INSERT INTO `message` VALUES ('0022', '010', '002', '85', '171212');
INSERT INTO `message` VALUES ('0023', '010', '012', '85', '171225');
INSERT INTO `message` VALUES ('0024', '011', '005', '85', '161111');
INSERT INTO `message` VALUES ('0025', '012', '006', '95', '170117');
INSERT INTO `message` VALUES ('0026', '012', '003', '95', '170118');
INSERT INTO `message` VALUES ('0027', '012', '007', '95', '170817');
INSERT INTO `message` VALUES ('0028', '013', '004', '190', '161115');
INSERT INTO `message` VALUES ('0029', '014', '005', '901', '150904');
INSERT INTO `message` VALUES ('0030', '014', '006', '901', '151204');
INSERT INTO `message` VALUES ('0031', '015', '006', '910', '170910');
INSERT INTO `message` VALUES ('0032', '016', '007', '92', '190110');
INSERT INTO `message` VALUES ('0033', '016', '007', '92', '180110');
INSERT INTO `message` VALUES ('0034', '017', '009', '801', '170101');
INSERT INTO `message` VALUES ('0035', '018', '010', '810', '180808');
INSERT INTO `message` VALUES ('0036', '018', '009', '810', '160606');
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  
  `username` varchar(50) not null,
  `password` varchar(50) not null,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ( 'abc', '123');
INSERT INTO `user` VALUES ( 'admin', '111111');
INSERT INTO `user` VALUES ( 'tom', '111');
INSERT INTO `user` VALUES ( 'aaa', '111');
-- ----------------------------
-- View structure for `v_g_c`
-- ----------------------------
DROP VIEW IF EXISTS `v_g_c`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_g_c` AS (select `r`.`g_id` AS `g_id`,`g`.`name` AS `g_name`,`r`.`c_id` AS `c_id`,`c`.`name` AS `c_name` from ((`group1` `g` left join `r_g_c` `r` on((`g`.`id` = `r`.`g_id`))) left join `car` `c` on((`r`.`c_id` = `c`.`id`)))) ;
-- ----------------------------
-- View structure for `v_emp_mess`
-- CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_emp_mess` AS (select  `e`.`id` AS `e_id`,`e`.`name` AS `e_name`,`g`.`id` AS `g_id`,`g`.`name` AS `g_name`,`c`.`id` AS `c_id`,`c`.`name` AS `c_name`,`mess`.`id` AS `mess_id`,`mess`.`time` AS `time`,`mess`.`ymd` AS `ymd` from ((((`employee` `e` left join `group1` `g` on((`e`.`g_id` = `g`.`id`))) left join `r_g_c` `r` on((`g`.`id` = `r`.`g_id`))) left join `car` `c` on((`r`.`c_id` = `c`.`id`))) left join `message` `mess` on(((`e`.`id` = `mess`.`e_id`) and (`c`.`id` = `mess`.`c_id`))))) ;
-- ----------------------------
DROP VIEW IF EXISTS `v_mem_mess`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_mem_mess` AS (select  `m`.`id` AS `m_id`,`m`.`name` AS `m_name`,`g`.`id` AS `g_id`,`g`.`name` AS `g_name`,`c`.`id` AS `c_id`,`c`.`name` AS `c_name`,`mess`.`id` AS `mess_id`,`mess`.`time` AS `time`,`mess`.`ymd` AS `ymd` from ((((`member` `m` left join `group1` `g` on((`m`.`g_id` = `g`.`id`))) left join `message` `mess` on((`m`.`id` = `mess`.`m_id`))) left join `car` `c` on((`mess`.`c_id` = `c`.`id`))))) ;

-- ----------------------------
-- ----------------------------
-- Procedure structure for `setMem Count`

-- ----------------------------
#对数据进行增删改查会实时更新分组会员数量
DROP PROCEDURE IF EXISTS `setMemCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setMemCount`()
BEGIN
DECLARE tId int;
DECLARE tCount int;
DECLARE isLoop int DEFAULT 1;
DECLARE cur cursor for select g.id,count(m.id) from group1 as g left join member as m  on m.g_id=g.id GROUP BY g.id;
DECLARE  continue handler  for not found set isLoop=0;
open cur;
while isLoop>0
DO
fetch  cur into tId,tCount;

update group1 set mem_count=tCount where id=tId;

end while;
close cur;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `aa`;
DELIMITER ;;
CREATE TRIGGER `aa` BEFORE INSERT ON `member` FOR EACH ROW begin
update group1 set mem_count=ifnull(mem_count,0)+1 where id=new.g_id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `bb`;
DELIMITER ;;
CREATE TRIGGER `bb` BEFORE UPDATE ON `member` FOR EACH ROW begin
update group1 set mem_count=ifnull(mem_count,0)-1 where id=old.g_id;
update group1 set mem_count=ifnull(mem_count,0)+1 where id=new.g_id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `cc`;
DELIMITER ;;
CREATE TRIGGER `cc` BEFORE DELETE ON `member` FOR EACH ROW begin
update group1 set mem_count=ifnull(mem_count,0)-1 where id=old.g_id;
end
;;
DELIMITER ;
