CREATE TABLE `user` (
	`userId` VARCHAR(100) NOT NULL COLLATE 'utf8_unicode_ci',
	`password` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`name` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`gender` INT(10) NULL DEFAULT NULL,
	`email` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`userId`) USING BTREE
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;
