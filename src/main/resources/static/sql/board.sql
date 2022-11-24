CREATE TABLE `board` (
	`no` INT(11) NOT NULL AUTO_INCREMENT,
	`writer` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`subject` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`content` LONGTEXT NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`writedate` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	`originFile` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`saveFileDir` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`saveFileName` VARCHAR(500) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`password` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`viewCnt` INT(11) NULL DEFAULT '0',
	PRIMARY KEY (`no`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3007
;
