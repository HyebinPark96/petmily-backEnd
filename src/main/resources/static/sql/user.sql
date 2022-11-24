CREATE TABLE `user` (
	`userId` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`userPassword` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`userName` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`userRrn` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`userId`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
