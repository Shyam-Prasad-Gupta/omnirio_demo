#Attribute
CREATE TABLE `attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

INSERT INTO `attribute` (`id`,`name`,`value`) VALUES (1,'SIZE','MEDIUM');
INSERT INTO `attribute` (`id`,`name`,`value`) VALUES (2,'SIZE','SMALL');
INSERT INTO `attribute` (`id`,`name`,`value`) VALUES (3,'SIZE','LARGE');
INSERT INTO `attribute` (`id`,`name`,`value`) VALUES (4,'SIZE','EXTRA-LARGE');
INSERT INTO `attribute` (`id`,`name`,`value`) VALUES (5,'COLOR','RED');
INSERT INTO `attribute` (`id`,`name`,`value`) VALUES (6,'COLOR','YELLOW');
INSERT INTO `attribute` (`id`,`name`,`value`) VALUES (7,'COLOR','BLACK');
INSERT INTO `attribute` (`id`,`name`,`value`) VALUES (8,'COLOR','MULTICOLOR');

#Category
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `` (`id`,`name`) VALUES (1,'SHIRT');

#attribute_categories
CREATE TABLE `attribute_categories` (
  `Attribute_id` int(11) NOT NULL,
  `categories_id` int(11) NOT NULL,
  KEY `FK7asraux9w7si5csn4v3k37nnb` (`categories_id`),
  KEY `FKfg1qcqkxr567fgpfco5w9cykt` (`Attribute_id`),
  CONSTRAINT `FK7asraux9w7si5csn4v3k37nnb` FOREIGN KEY (`categories_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKfg1qcqkxr567fgpfco5w9cykt` FOREIGN KEY (`Attribute_id`) REFERENCES `attribute` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#category_attributes
CREATE TABLE `category_attributes` (
  `Category_id` int(11) NOT NULL,
  `attributes_id` int(11) NOT NULL,
  KEY `FKleaqlickkcw1p0y523oyq9reh` (`attributes_id`),
  KEY `FKpq49etqvb0nfx5kyq02m5box7` (`Category_id`),
  CONSTRAINT `FKleaqlickkcw1p0y523oyq9reh` FOREIGN KEY (`attributes_id`) REFERENCES `attribute` (`id`),
  CONSTRAINT `FKpq49etqvb0nfx5kyq02m5box7` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#product
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


