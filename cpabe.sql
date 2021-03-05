-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2021 at 08:48 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cpabe`
--

-- --------------------------------------------------------

--
-- Table structure for table `admincredentials`
--

CREATE TABLE `admincredentials` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admincredentials`
--

INSERT INTO `admincredentials` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `special` varchar(25) NOT NULL,
  `ward` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`special`, `ward`) VALUES
('CARDIO', 'CRDWARD1'),
('CARDIO', 'CRDWARD2'),
('CARDIO', 'CRDWARD3'),
('MEDICINE', 'MDCWARD1'),
('MEDICINE', 'MDCWARD2'),
('MEDICINE', 'MDCWARD3'),
('MEDICINE', 'MDCWARD4'),
('MEDICINE', 'MDCWARD5'),
('MEDICINE', 'MDCWARD6'),
('MEDICINE', 'MDCWARD7');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `emailid` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `special` varchar(25) NOT NULL,
  `ward` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`emailid`, `name`, `special`, `ward`, `password`) VALUES
('janedoe@gmail.com', 'Jane Doe', 'CARDIO', 'CRDWARD3', 'janedoe'),
('johndoe@gmail.com', 'John Doe', 'MEDICINE', 'MDCWARD1', 'johndoe'),
('shiyafthayyil@gmail.com', 'shiyaf', 'MEDICINE', 'MDCWARD5', 'shiyaf');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `emailid` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `special` varchar(25) NOT NULL,
  `ward` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `diagnosis` varchar(100) DEFAULT NULL,
  `treatment` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`emailid`, `name`, `special`, `ward`, `password`, `diagnosis`, `treatment`) VALUES
('johnas@gmail.com', 'johnas kahnwald', 'CARDIO', 'CRDWARD3', 'dark', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`special`,`ward`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`emailid`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`emailid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
