-- 序列表
CREATE TABLE sequence ( 
     name VARCHAR(50) NOT NULL, 
     current_value INT NOT NULL, 
     increment INT NOT NULL DEFAULT 1, 
     PRIMARY KEY (name) 
) ENGINE=InnoDB; 
-- 查询当前值方法
DROP FUNCTION IF EXISTS currval; 
DELIMITER $ 
CREATE FUNCTION currval (seq_name VARCHAR(50)) 
     RETURNS INTEGER 
     LANGUAGE SQL 
     DETERMINISTIC 
     CONTAINS SQL 
     SQL SECURITY DEFINER 
     COMMENT '' 
BEGIN 
     DECLARE value INTEGER; 
     SET value = 0; 
     SELECT current_value INTO value 
          FROM sequence 
          WHERE name = seq_name; 
     RETURN value; 
END 
$ 
DELIMITER ;
-- 查询下一个值方法
DROP FUNCTION IF EXISTS nextval; 
DELIMITER $ 
CREATE FUNCTION nextval (seq_name VARCHAR(50)) 
     RETURNS INTEGER 
     LANGUAGE SQL 
     DETERMINISTIC 
     CONTAINS SQL 
     SQL SECURITY DEFINER 
     COMMENT '' 
BEGIN 
     UPDATE sequence 
          SET current_value = current_value + increment 
          WHERE name = seq_name; 
     RETURN currval(seq_name); 
END 
$ 
DELIMITER ; 
-- 设置当前值
DROP FUNCTION IF EXISTS setval; 
DELIMITER $ 
CREATE FUNCTION setval (seq_name VARCHAR(50), value INTEGER) 
     RETURNS INTEGER 
     LANGUAGE SQL 
     DETERMINISTIC 
     CONTAINS SQL 
     SQL SECURITY DEFINER 
     COMMENT '' 
BEGIN 
     UPDATE sequence 
          SET current_value = value 
          WHERE name = seq_name; 
     RETURN currval(seq_name); 
END 
$ 
DELIMITER ; 
-- 插入序列
INSERT INTO sequence VALUES ('custNoSeq', 1000000, 1);
-- 客户经理表
CREATE TABLE `crm_info` (
  `crm_seq` int NOT NULL AUTO_INCREMENT COMMENT '客户经理序号',
  `job_no` varchar(32) NOT NULL COMMENT '工号',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `dept_no` varchar(32) DEFAULT NULL COMMENT '所属网点',
  `team_no` varchar(32) DEFAULT NULL COMMENT '所属团队',
  `id_type` varchar(5) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(20) DEFAULT NULL COMMENT '证件号',
  `level` varchar(5) DEFAULT NULL COMMENT '客户经理等级',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`crm_seq`) USING BTREE,
  KEY `crm_info_index` (`crm_seq`,`job_no`)
) ENGINE=InnoDB AUTO_INCREMENT=10000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='客户经理信息表';

