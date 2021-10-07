This is a java swing gui program that calculates gpa after receiving mandatory inputs such as
	-The user name;
	-The Mat number;
	-Semester;
	-course title;(optional)
	-course's credit value;
	-course's marks /100;
	
its display the various grades relative to the marks and calculates the gpa.
This code was built in netbeans

INSERT INTO `ussdsession` (`id`, `crtd`, `dele`, `iscon`, `lang`, `lib2`, `mdfi`, `phone`, `pos`, `preval`, `uuid`, `inval`, `nwpin`) VALUES ('4', NULL, '0', NULL, 'en', NULL, NULL, '679406774', NULL, '', '0002', '2', '4');



-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 07, 2021 at 10:14 AM
-- Server version: 5.7.21
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paymentapi`
--

-- --------------------------------------------------------

--
-- Table structure for table `ussdsession`
--

DROP TABLE IF EXISTS `ussdsession`;
CREATE TABLE IF NOT EXISTS `ussdsession` (
  `id` int(11) NOT NULL,
  `crtd` datetime(6) DEFAULT NULL,
  `dele` varchar(255) DEFAULT NULL,
  `inval` int(11) NOT NULL,
  `iscon` bit(1) DEFAULT NULL,
  `lang` varchar(255) DEFAULT NULL,
  `lib2` varchar(255) DEFAULT NULL,
  `mdfi` datetime(6) DEFAULT NULL,
  `nwotp` int(11) NOT NULL,
  `nwpin` int(11) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `pos` longtext,
  `preval` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


INSERT INTO `ussdsession` (`id`, `crtd`, `dele`, `inval`, `iscon`, `lang`, `lib2`, `mdfi`, `nwotp`, `nwpin`, `phone`, `pos`, `preval`, `status`, `uuid`) VALUES ('1', '2021-10-12 04:28:18.196118', '0', '2', NULL, 'en', NULL, '2020-08-12 10:35:00', '3', '3', '675669236', NULL, NULL, '3', '0001');

INSERT INTO `ussdsession` (`id`, `crtd`, `dele`, `inval`, `iscon`, `lang`, `lib2`, `mdfi`, `nwotp`, `nwpin`, `phone`, `pos`, `preval`, `status`, `uuid`) VALUES ('2', '2021-10-12 04:28:18.196118', '0', '2', NULL, 'en', NULL, '2020-08-12 10:35:00', '3', '3', '670552457', NULL, NULL, '0', '0002');
