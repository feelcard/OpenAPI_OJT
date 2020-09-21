DROP TABLE IF EXISTS `FORUM`;

CREATE TABLE `FORUM` (
	`forum_id`	VARCHAR(100)	NULL,
	`member_id`	VARCHAR(100)	NOT NULL,
	`subsi_id`	VARCHAR(100)	NOT NULL,
	`forum_field`	VARCHAR(255)	NULL,
	`forum_title`	VARCHAR(50)	NULL,
	`forum_create_date`	VARCHAR(30)	NOT NULL,
	`forum_update_date`	VARCHAR(30)	NULL,
	`forum_update_by`	VARCHAR(30)	NULL,
	`forum_create_by`	VARCHAR(30)	NULL
);

DROP TABLE IF EXISTS `AUTHORITY`;

CREATE TABLE `AUTHORITY` (
	`auth_code`	VARCHAR(100)	NOT NULL,
	`auth_name`	VARCHAR(30)	NULL,
	`auth_create_by`	VARCHAR(30)	NULL,
	`auth_create_date`	VARCHAR(30)	NULL,
	`auth_update_by`	VARCHAR(30)	NULL,
	`auth_update_date`	VARCHAR(30)	NULL,
	`auth_delete`	VARCHAR(1)	NULL
);

DROP TABLE IF EXISTS `REPLY`;

CREATE TABLE `REPLY` (
	`reply_id`	VARCHAR(100)	NOT NULL,
	`forum_id`	VARCHAR(100)	NOT NULL,
	`member_id`	VARCHAR(100)	NOT NULL,
	`reply_field`	VARCHAR(150)	NULL,
	`parent_reply_id`	BINARY(16)	NULL,
	`reply_update_date`	VARCHAR(30)	NULL,
	`reply_update_by`	VARCHAR(30)	NULL,
	`reply_create_date`	VARCHAR(30)	NULL,
	`reply_create_by`	VARCHAR(30)	NULL
);

DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `MEMBER` (
	`member_id`	VARCHAR(100)	NOT NULL,
	`subsi_id`	VARCHAR(100)	NOT NULL,
	`auth_code`	VARCHAR(100)	NOT NULL,
	`member_name`	VARCHAR(30)	NULL,
	`member_delete`	VARCHAR(1)	NULL,
	`member_create_date`	VARCHAR(30)	NULL,
	`member_update_date`	VARCHAR(30)	NULL,
	`member_update_by`	VARCHAR(30)	NULL

);

DROP TABLE IF EXISTS `DISPLAY`;

CREATE TABLE `DISPLAY` (
	`display_id`	VARCHAR(100)	NOT NULL,
	`display_name`	VARCHAR(30)	NULL,
	`display_status`	VARCHAR(30)	NULL,
	`display_url`	VARCHAR(200)	NULL,
	`display_create_by`	VARCHAR(30)	NULL,
	`display_create_date`	VARCHAR(30)	NULL,
	`display_update_by`	VARCHAR(30)	NULL,
	`display_update_date`	VARCHAR(30)	NULL,
	`display_delete`	VARCHAR(1)	NULL
);

DROP TABLE IF EXISTS `DISPLAY_AUTH`;

CREATE TABLE `DISPLAY_AUTH` (
	`display_auth_id`	VARCHAR(100)	NOT NULL,
	`display_id`	VARCHAR(100)	NOT NULL,
	`auth_code`	VARCHAR(30)	NOT NULL
);

DROP TABLE IF EXISTS `FORUM_HIS`;

CREATE TABLE `FORUM_HIS` (
	`forum_his_id`	VARCHAR(100)	NOT NULL,
	`forum_id`	BINARY(16)	NULL,
	`member_id`	BINARY(16)	NULL,
	`subsi_id`	BINARY(16)	NULL,
	`auth_code`	VARCHAR(30)	NULL,
	`forum_title`	VARCHAR(50)	NULL,
	`forum_field`	VARCHAR(255)	NULL,
	`forum_create_date`	VARCHAR(30)	NULL,
	`forum_delete_date`	VARCHAR(30)	NULL,
	`forum_create_by`	VARCHAR(30)	NULL,
	`forum_delete_by`	VARCHAR(30)	NULL
);

DROP TABLE IF EXISTS `REPLY_HIS`;

CREATE TABLE `REPLY_HIS` (
	`reply_his_id`	VARCHAR(100)	NOT NULL,
	`forum_id`	BINARY(16)	NULL,
	`member_id`	BINARY(16)	NULL,
	`reply_field`	VARCHAR(150)	NULL,
	`parent_reply_id`	BINARY(16)	NULL,
	`reply_create_date`	VARCHAR(30)	NULL,
	`reply_delete_date`	VARCHAR(30)	NULL,
	`reply_delete_by`	VARCHAR(30)	NULL,
	`reply_create_by`	VARCHAR(30)	NULL
);

DROP TABLE IF EXISTS `SUBSIDIARY`;

CREATE TABLE `SUBSIDIARY` (
	`subsi_id`	VARCHAR(100)	NOT NULL,
	`subsi_name`	VARCHAR(30)	NULL,
	`subsi_create_date`	VARCHAR(30)	NULL,
	`subsi_create_by`	VARCHAR(30)	NULL,
	`subsi_update_date`	VARCHAR(30)	NULL,
	`subsi_update_by`	VARCHAR(30)	NULL,
	`subsi_delete`	VARCHAR(1)	NULL
);

DROP TABLE IF EXISTS `FILE`;

CREATE TABLE `FILE` (
	`file_id`	VARCHAR(100)	NOT NULL,
	`forum_id`	VARCHAR(100)	NULL,
	`file_path`	VARCHAR(255)	NULL,
	`file_size`	VARCHAR(30)	NULL,
	`file_create_date`	VARCHAR(30)	NULL,
	`file_type`	VARCHAR(10)	NULL
);

DROP TABLE IF EXISTS `FILE_HIS`;

CREATE TABLE `FILE_HIS` (
	`file_his_id`	VARCHAR(100)	NOT NULL,
	`file_id`	BINARY(16)	NULL,
	`file_path`	VARCHAR(30)	NULL,
	`file_size`	VARCHAR(30)	NULL,
	`file_create_date`	VARCHAR(30)	NULL,
	`file_create_by`	VARCHAR(30)	NULL,
	`file_delete_date`	VARCHAR(30)	NULL,
	`file_delete_by`	VARCHAR(30)	NULL,
	`forum_id`	BINARY(16)	NULL,
	`file_type`	VARCHAR(10)	NULL
);

ALTER TABLE `FORUM` ADD CONSTRAINT `PK_FORUM` PRIMARY KEY (
	`forum_id`,
	`member_id`,
	`subsi_id`
);

ALTER TABLE `AUTHORITY` ADD CONSTRAINT `PK_AUTHORITY` PRIMARY KEY (
	`auth_code`
);

ALTER TABLE `REPLY` ADD CONSTRAINT `PK_REPLY` PRIMARY KEY (
	`reply_id`,
	`forum_id`,
	`member_id`
);

ALTER TABLE `MEMBER` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`member_id`,
	`subsi_id`,
	`auth_code`
);

ALTER TABLE `DISPLAY` ADD CONSTRAINT `PK_DISPLAY` PRIMARY KEY (
	`display_id`
);

ALTER TABLE `DISPLAY_AUTH` ADD CONSTRAINT `PK_DISPLAY_AUTH` PRIMARY KEY (
	`display_auth_id`,
	`display_id`,
	`auth_code`
);

ALTER TABLE `FORUM_HIS` ADD CONSTRAINT `PK_FORUM_HIS` PRIMARY KEY (
	`forum_his_id`
);

ALTER TABLE `REPLY_HIS` ADD CONSTRAINT `PK_REPLY_HIS` PRIMARY KEY (
	`reply_his_id`
);

ALTER TABLE `SUBSIDIARY` ADD CONSTRAINT `PK_SUBSIDIARY` PRIMARY KEY (
	`subsi_id`
);

ALTER TABLE `FILE` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
	`file_id`,
	`forum_id`
);

ALTER TABLE `FILE_HIS` ADD CONSTRAINT `PK_FILE_HIS` PRIMARY KEY (
	`file_his_id`
);

ALTER TABLE `FORUM` ADD CONSTRAINT `FK_MEMBER_TO_FORUM_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `MEMBER` (
	`member_id`
);

ALTER TABLE `REPLY` ADD CONSTRAINT `FK_FORUM_TO_REPLY_1` FOREIGN KEY (
	`forum_id`
)
REFERENCES `FORUM` (
	`forum_id`
);

ALTER TABLE `REPLY` ADD CONSTRAINT `FK_MEMBER_TO_REPLY_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `MEMBER` (
	`member_id`
);

ALTER TABLE `MEMBER` ADD CONSTRAINT `FK_SUBSIDIARY_TO_MEMBER_1` FOREIGN KEY (
	`subsi_id`
)
REFERENCES `SUBSIDIARY` (
	`subsi_id`
);

ALTER TABLE `FORUM` ADD CONSTRAINT `FK_MEMBER_TO_FORUM_2` FOREIGN KEY (
	`subsi_id`
)
REFERENCES `MEMBER` (
	`subsi_id`
);

ALTER TABLE `MEMBER` ADD CONSTRAINT `FK_AUTHORITY_TO_MEMBER_1` FOREIGN KEY (
	`auth_code`
)
REFERENCES `AUTHORITY` (
	`auth_code`
);

ALTER TABLE `DISPLAY_AUTH` ADD CONSTRAINT `FK_DISPLAY_TO_DISPLAY_AUTH_1` FOREIGN KEY (
	`display_id`
)
REFERENCES `DISPLAY` (
	`display_id`
);

ALTER TABLE `DISPLAY_AUTH` ADD CONSTRAINT `FK_AUTHORITY_TO_DISPLAY_AUTH_1` FOREIGN KEY (
	`auth_code`
)
REFERENCES `AUTHORITY` (
	`auth_code`
);

ALTER TABLE `FILE` ADD CONSTRAINT `FK_FORUM_TO_FILE_1` FOREIGN KEY (
	`forum_id`
)
REFERENCES `FORUM` (
	`forum_id`
);

alter table `member` add `member_password` VARCHAR(255);

insert into authority(auth_code,auth_name,auth_create_by,auth_create_date,auth_update_by,auth_update_date,auth_delete) values("ANONYMOUS","비회원","admin","2020-09-16T09:19:00","admin","2020-09-16T09:19:00","N");
insert into authority(auth_code,auth_name,auth_create_by,auth_create_date,auth_update_by,auth_update_date,auth_delete) values("USER","회원","admin","2020-09-16T09:19:00","admin","2020-09-16T09:19:00","N");


use test;

select * from member;
alter table `member` add `member_password` VARCHAR(255);
select * from authority;
select * from subsidiary;
insert into authority(auth_code,auth_name,auth_create_by,auth_create_date,auth_update_by,auth_update_date,auth_delete) values("ANONYMOUS","비회원","admin","2020-09-16T09:19:00","admin","2020-09-16T09:19:00","N");
insert into authority(auth_code,auth_name,auth_create_by,auth_create_date,auth_update_by,auth_update_date,auth_delete) values("USER","회원","admin","2020-09-16T09:19:00","admin","2020-09-16T09:19:00","N");
delete from subsidiary where subsi_id ='';

INSERT INTO `test`.`subsidiary` (`subsi_id`, `subsi_name`, `subsi_create_date`, `subsi_create_by`, `subsi_update_date`, `subsi_update_by`, `subsi_delete`) 
VALUES ('0259e849-1dde-45a7-903b-3956f0ce7a46', 'KB생명보험', '122020-09-16T09:19:003', 'admin', '2020-09-16T09:19:00', 'admin', 'N');



delete from member where auth_code='USER';

# insert into member value("test","test","test","testname","N","2020-09-16",null,null );

alter table member modify column member_password  varchar(255);