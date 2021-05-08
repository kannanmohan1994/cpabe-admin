-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2021 at 06:32 PM
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
('abcd', 'abcd', 'MEDICINE', 'MDCWARD3', 'abcd'),
('abcde', 'abcde', 'MEDICINE', 'MDCWARD6', 'abcde'),
('cardiodoc', 'cardiodoc', 'CARDIO', 'CRDWARD1', 'cardiodoc'),
('johndoe@gmail.com', 'John Doe', 'CARDIO', 'CRDWARD3', 'johndoe'),
('justin', 'justin', 'CARDIO', 'CRDWARD2', 'just'),
('kannan', 'kannan', 'MEDICINE', 'MDCWARD7', 'kannan'),
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
('cardiodemo', 'cardiodemo', 'CARDIO', 'CRDWARD1', 'cardiodemo', NULL, NULL),
('johnas@gmail.com', 'johnas kahnwald', 'CARDIO', 'CRDWARD3', 'dark', NULL, NULL),
('kiran', 'kiran', 'CARDIO', 'CRDWARD2', '123', 'cough', 'vicks'),
('patient', 'patient', 'MEDICINE', 'MDCWARD3', 'patient', 'Fever	', 'Dolo650'),
('tikku', 'tikku', 'MEDICINE', 'MDCWARD6', 'tikku', 'Fever	', 'dolo');

-- --------------------------------------------------------

--
-- Table structure for table `policyset`
--

CREATE TABLE `policyset` (
  `id` int(11) NOT NULL,
  `POLICY` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `policyset`
--

INSERT INTO `policyset` (`id`, `POLICY`) VALUES
(522, 'd:CARDIO 1of1 phr:CARDIO 1of1 a:view 1of1 3of3'),
(523, 'd:MEDICINE 1of1 phr:MEDICINE 1of1 a:view 1of1 3of3'),
(524, 'd:MDCWARD3 1of1 phr:MDCWARD3 1of1 a:edit 1of1 3of3'),
(525, 'd:MDCWARD6 1of1 phr:MDCWARD6 1of1 a:edit 1of1 3of3');

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

--
-- Indexes for table `policyset`
--
ALTER TABLE `policyset`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `policyset`
--
ALTER TABLE `policyset`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=526;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
