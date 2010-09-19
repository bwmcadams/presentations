CREATE TABLE `news` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `author_id` int(11) unsigned NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date default NULL,
  `headline` varchar(255) NOT NULL,
  `story` text NOT NULL,
  `archive` tinyint(1) default '0',
  PRIMARY KEY  (`id`),
  KEY `news_author` (`author_id`),
  CONSTRAINT `news_author` FOREIGN KEY (`author_id`) REFERENCES `admin_users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=latin1;
