CREATE TABLE `admin_users` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `username` varchar(45) collate latin1_general_ci NOT NULL default '',
  `password` char(32) collate latin1_general_ci NOT NULL,
  `display_name` varchar(64) collate latin1_general_ci default NULL,
  `email` varchar(255) collate latin1_general_ci NOT NULL default '',
  `avatar` varchar(255) collate latin1_general_ci default NULL,
  `last_ip` int(10) unsigned default NULL,
  `last_login_date` timestamp NOT NULL default '0000-00-00 00:00:00',
  `disabled` tinyint(1) default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UNIQUE` (`username`),
  UNIQUE KEY `admin_users_uniq` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci PACK_KEYS=1;
