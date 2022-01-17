-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2022 at 06:09 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `firstproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `demo`
--

CREATE TABLE `demo` (
  `id` int(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `student_master`
--

CREATE TABLE `student_master` (
  `id` int(100) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `gender` text NOT NULL,
  `DOB` date NOT NULL,
  `recInsertionDate` datetime NOT NULL,
  `age` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student_master`
--

INSERT INTO `student_master` (`id`, `fname`, `lname`, `gender`, `DOB`, `recInsertionDate`, `age`) VALUES
(1, 'Pramod', 'kumbhar', 'male', '1998-07-01', '2021-12-31 00:53:52', NULL),
(2, 'Deepak', 'Punde', 'male', '2000-07-01', '2021-12-31 01:00:50', NULL),
(3, 'Shubham', 'Patil', 'male', '1999-01-29', '2021-12-31 01:09:08', NULL),
(4, 'Pramod', 'Kumbhar', 'male', '1998-07-01', '2021-12-31 01:24:12', NULL),
(5, 'Sourabh', 'Ganguli', 'male', '1989-07-08', '2021-12-31 02:14:07', NULL),
(6, 'Vaibhav', 'Gavade', 'male', '1995-10-21', '2022-01-10 20:28:34', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student_master`
--
ALTER TABLE `student_master`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student_master`
--
ALTER TABLE `student_master`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
