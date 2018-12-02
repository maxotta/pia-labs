CREATE DATABASE IF NOT EXISTS `pia`;

USE `pia`;

CREATE TABLE IF NOT EXISTS `danekja_user` (
    `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY(`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;;
