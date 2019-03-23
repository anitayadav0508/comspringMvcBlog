-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 23, 2019 at 06:46 PM
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
-- Database: `sharedonetoone`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `name`) VALUES
(1, 'Nodejs'),
(2, 'java');

-- --------------------------------------------------------

--
-- Table structure for table `bookdetail`
--

DROP TABLE IF EXISTS `bookdetail`;
CREATE TABLE IF NOT EXISTS `bookdetail` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `no_of_pages` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookdetail`
--

INSERT INTO `bookdetail` (`id`, `title`, `no_of_pages`) VALUES
(1, 'Serverless', 250),
(2, 'Beginner of java', 300);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookdetail`
--
ALTER TABLE `bookdetail`
  ADD CONSTRAINT `BookDetail_fk0` FOREIGN KEY (`id`) REFERENCES `book` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
