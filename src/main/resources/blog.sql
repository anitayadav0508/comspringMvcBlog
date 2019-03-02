-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 22, 2019 at 08:42 PM
-- Server version: 5.5.41
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blog`
--

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
CREATE TABLE IF NOT EXISTS `blog` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `description` varchar(5000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`id`, `title`, `description`) VALUES
(1, 'JAVA', 'Java is awsum Language'),
(2, 'JAVA', 'Java is awsum Language'),
(3, 'JAVA', 'Java is awsum Language'),
(4, 'JAVA', 'Java is awsum Language'),
(5, 'JAVA', 'Java is awsum Language'),
(6, 'JAVA', 'Java is awsum Language'),
(7, 'JAVA', 'Java is awsum Language'),
(8, 'JAVA', 'Java is awsum Language'),
(9, 'JAVA', 'Java is awsum Language'),
(10, 'JAVA', 'Java is awsum Language'),
(11, 'JAVA', 'Java is awsum Language'),
(12, 'JAVA', 'Java is awsum Language'),
(13, 'Anita', 'She is short Temper'),
(14, 'Arul', 'He is nice man'),
(15, 'dfgh', 'dsfghbn');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
