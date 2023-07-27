-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2023 at 07:24 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javafx`
--

-- --------------------------------------------------------

--
-- Table structure for table `emp`
--

CREATE TABLE `emp` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL DEFAULT 'Guriel'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp`
--

INSERT INTO `emp` (`id`, `name`, `address`) VALUES
(1, 'Ahmed muse Ahmed', 'Guriel'),
(2, 'Hassan Ali Ahmed', 'Hodan'),
(3, 'Hanan Ahmed Hassan', 'Deynile'),
(2, 'Hodan Abdi Ahmed', 'Kaxda');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'Zack', '123'),
(2, 'Abshir', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `parent` varchar(100) NOT NULL,
  `address` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `age`, `mobile`, `parent`, `address`) VALUES
(1, 'Mohamed Ali Khalif', 13, '615565645', 'Ali Khalif', 'Hodan'),
(2, 'Ahmed Hassan Ahmed', 12, '615654523', 'Hassan Ahmed', 'Kaxda'),
(3, 'Hanan Abdi Hassan', 27, '613342314', 'Abdi Hassan', 'Yaqshid'),
(4, 'Iqro Hassan Ali', 14, '615273615', 'Hamdi Ali Abdi', 'Bondhere'),
(5, 'Khadro Saleban Ahmed', 14, '613452435', 'Saleban Moha', 'Hodan'),
(7, 'Zakiya Ahmed', 12, '615452415', 'Ahmed Ali', 'Hodan'),
(8, 'Abdi Hassan Adan', 23, '617381712', 'Hassan Adan', 'Boondhere'),
(9, 'Ahmed Mukhtar Ali', 31, '617283910', 'Mukhtar Ali', 'Shibis'),
(10, 'Hanan Abdi Hassan', 17, '613342314', 'Abdi Hassan', 'Yaqshid'),
(11, 'Iqro Mohamed Dhubad', 24, '617872121', 'Mohamed Dhubad', 'Kaxda'),
(12, 'Halima Ahmed', 24, '615452476', 'Ahmed Hassan', 'Jowhar'),
(13, 'Mohamed Ali Yahye', 31, '615564256', 'Ali Yahye', 'Hodan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
