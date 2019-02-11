CREATE TABLE `People` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	`email` varchar(100),
	`house_id` INT(100),
	PRIMARY KEY (`id`)
);

CREATE TABLE `House` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`street` varchar(100) NOT NULL,
	`number` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Password` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`number` varchar(100),
	`realize` varchar(100),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Book` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	`author` varchar(100),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Book_People` (
	`book_id` INT NOT NULL,
	`people_id` INT NOT NULL,
	PRIMARY KEY (`book_id`,`people_id`)
);

ALTER TABLE `People` ADD CONSTRAINT `People_fk0` FOREIGN KEY (`house_id`) REFERENCES `House`(`id`);

ALTER TABLE `Password` ADD CONSTRAINT `Password_fk0` FOREIGN KEY (`id`) REFERENCES `People`(`id`);

ALTER TABLE `Book_People` ADD CONSTRAINT `Book_People_fk0` FOREIGN KEY (`book_id`) REFERENCES `Book`(`id`);

ALTER TABLE `Book_People` ADD CONSTRAINT `Book_People_fk1` FOREIGN KEY (`people_id`) REFERENCES `People`(`id`);
