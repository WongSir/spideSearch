--查询到的内容表
CREATE TABLE `searchItem`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(128) NOT NULL,
	`content` VARCHAR(2048),
	`url` VARCHAR(1024) NOT NULL,
	PRIMARY KEY(`id`)
)

--关键字表
CREATE TABLE `keyword`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`key` VARCHAR(128) NOT NULL,
	PRIMARY KEY(`id`)
)