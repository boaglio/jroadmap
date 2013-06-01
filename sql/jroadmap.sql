--
-- JRoadmap - MySQL Database Script
-- [don't forget to update hibernate.cfg.xml file]
-- (C) 2007 Fernando Boaglio
--

CREATE DATABASE `jroadmap` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jroadmap`;

CREATE TABLE `jroadmap_plan` (
  `id` int(5) NOT NULL auto_increment,
  `release_date` date NOT NULL,
  `task_id` int(5) NOT NULL,
  `responsible_id` int(11) NOT NULL,
  `priority` int(1) NOT NULL,
  `status` int(1) NOT NULL default '0' COMMENT '0=Todo , 1=In Progress,2=Finished ',
  PRIMARY KEY  (`id`),
  KEY `task_id` (`task_id`),
  KEY `responsible_id` (`responsible_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1;

CREATE TABLE `jroadmap_project` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) collate latin1_bin NOT NULL,
  `description` varchar(100) collate latin1_bin default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1;

CREATE TABLE `jroadmap_responsible` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(60) collate latin1_bin NOT NULL,
  `email` varchar(100) collate latin1_bin default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1;

CREATE TABLE `jroadmap_task` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(255) collate latin1_bin NOT NULL,
  `project_id` int(5) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=1;

ALTER TABLE `jroadmap_plan`
  ADD CONSTRAINT `jroadmap_plan_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `jroadmap_task` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jroadmap_plan_ibfk_2` FOREIGN KEY (`responsible_id`) REFERENCES `jroadmap_responsible` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `jroadmap_task`
  ADD CONSTRAINT `jroadmap_task_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `jroadmap_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
