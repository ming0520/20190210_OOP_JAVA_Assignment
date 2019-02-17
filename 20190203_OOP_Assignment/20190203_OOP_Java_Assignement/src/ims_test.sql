-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 17, 2019 at 06:03 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ims_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `claimrecord`
--

CREATE TABLE `claimrecord` (
  `id` int(11) NOT NULL,
  `claimID` varchar(20) NOT NULL,
  `empID` varchar(20) NOT NULL,
  `claimTypeID` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `amount` float NOT NULL,
  `remark` varchar(100) NOT NULL,
  `approverID` varchar(20) NOT NULL,
  `claimStatus` enum('PENDING','APPROVED','REJECTED','CANCELLED') DEFAULT NULL,
  `decisionRemark` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `claimrecord`
--

INSERT INTO `claimrecord` (`id`, `claimID`, `empID`, `claimTypeID`, `date`, `amount`, `remark`, `approverID`, `claimStatus`, `decisionRemark`) VALUES
(5, '3052', 'IMS-S-002', '002', 'Thu Feb 14, 2019', 500, 'New Amount', 'ADMIN', 'PENDING', 'Submited'),
(6, '6932', 'IMS-S-002', '002', 'Thu Feb 14, 2019', 1231230, '123123', 'ADMIN', 'PENDING', 'Submited'),
(7, '1872', 'IMS-S-001', '004', 'Thu Feb 14, 2019', 123123000, '123', 'ADMIN', 'CANCELLED', 'ABC'),
(8, '1945', 'IMS-S-002', '001', 'Thu Feb 14, 2019', 12312300000, '123', 'ADMIN', 'PENDING', 'Submited'),
(9, '996', 'ADMIN', '002', 'Sat Feb 16, 2019', 500, 'Death', 'ADMIN', 'PENDING', 'Submited'),
(10, '2110', 'ADMIN', '002', 'Sat Feb 16, 2019', 500, 'Death', 'ADMIN', 'PENDING', 'Submited'),
(11, '8512', 'ADMIN', '003', 'Sat Feb 16, 2019', 500, 'A', 'ADMIN', 'CANCELLED', 'Repeated record'),
(12, '3926', 'ADMIN', '004', 'Sat Feb 16, 2019', 200, '1', 'ADMIN', 'PENDING', 'Submited'),
(13, '9193', 'ADMIN', '002', 'Sat Feb 16, 2019', 200, 'ADmin', 'ADMIN', 'PENDING', 'Submited'),
(14, '7630', 'ADMIN', '003', 'Sat Feb 16, 2019', 5000, 'admin', 'ADMIN', 'PENDING', 'Submited'),
(15, '2921', 'ADMIN', '002', 'Sat Feb 16, 2019', 100, 'A', 'ADMIN', 'PENDING', 'Submited'),
(16, '4608', 'ADMIN', '003', 'Sat Feb 16, 2019', 200, 'ADMIn', 'ADMIN', 'PENDING', 'Submited'),
(17, '7578', 'IMS-S-001', '003', 'Sat Feb 16, 2019', 50000, 'ADB', 'ADMIN', 'PENDING', 'Submited'),
(19, '9605', 'IMS-S-001', '001', 'Sat Feb 16, 2019', 200, 'ad', 'ADMIN', 'APPROVED', 'Rich'),
(20, '5767', 'IMS-S-001', '003', 'Sat Feb 16, 2019', 200, '123', 'ADMIN', 'PENDING', 'Submited'),
(21, '1000', 'IMS-S-001', '003', 'Sat Feb 16, 2019', 400, 'as', 'ADMIN', 'PENDING', 'Submited'),
(22, '1040', 'IMS-S-001', '003', 'Sat Feb 16, 2019', 1000, '1', 'ADMIN', 'PENDING', 'Submited'),
(23, '1414', 'IMS-H-001', '002', 'Sat Feb 16, 2019', 123, '1', 'ADMIN', 'PENDING', 'Submited'),
(24, '1061', 'IMS-H-001', '003', 'Sat Feb 16, 2019', 123, 'asd', 'ADMIN', 'PENDING', 'Submited');

-- --------------------------------------------------------

--
-- Table structure for table `claimtype`
--

CREATE TABLE `claimtype` (
  `claimTypeID` varchar(20) NOT NULL,
  `claimTypeName` varchar(20) NOT NULL,
  `applicableToPosition` varchar(20) NOT NULL,
  `claimLimit` float NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `claimtype`
--

INSERT INTO `claimtype` (`claimTypeID`, `claimTypeName`, `applicableToPosition`, `claimLimit`, `id`) VALUES
('001', 'Accidental Death', 'Manager', 1000000, 1),
('002', 'DEATH or TPD', 'CEO', 500000, 2),
('004', 'Vision loss', 'Sales', 50000, 3),
('003', 'Leg Injury', 'Sales', 5000, 4);

-- --------------------------------------------------------

--
-- Table structure for table `empdetails`
--

CREATE TABLE `empdetails` (
  `empID` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `department` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL,
  `userRole` enum('ADMIN','USER') NOT NULL,
  `stat` enum('ACTIVE','INACTIVE') NOT NULL,
  `superiorID` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empdetails`
--

INSERT INTO `empdetails` (`empID`, `pass`, `name`, `department`, `position`, `userRole`, `stat`, `superiorID`, `id`) VALUES
('ADMIN', 'BCS1105', 'TanFong', 'Computer Science', 'Manager', 'ADMIN', 'ACTIVE', 'A', 1),
('CEO-001', '123', 'Sam', 'Executive Officer', 'CEO', 'ADMIN', 'ACTIVE', 'A', 2),
('IMS-D-001', '123', 'Terence', 'Director', 'Chief of Director', 'ADMIN', 'ACTIVE', 'B', 3),
('IMS-H-001', '123', 'Alexandar', 'Human Resource', 'Manager', 'ADMIN', 'INACTIVE', 'C', 4),
('IMS-S-001', '123', 'Bryan', 'Marketing', 'Sales', 'USER', 'ACTIVE', 'D', 5),
('IMS-S-002', '123', 'Mami', 'Marketing', 'Sales', 'USER', 'ACTIVE', 'D', 6),
('IMS-T-001', '123', 'Julice', 'IT Department', 'Manager', 'ADMIN', 'ACTIVE', 'C', 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `claimrecord`
--
ALTER TABLE `claimrecord`
  ADD PRIMARY KEY (`id`),
  ADD KEY `claimTypeID` (`claimTypeID`) USING BTREE,
  ADD KEY `empID` (`empID`) USING BTREE;

--
-- Indexes for table `claimtype`
--
ALTER TABLE `claimtype`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `claimTypeID` (`claimTypeID`);

--
-- Indexes for table `empdetails`
--
ALTER TABLE `empdetails`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `empID` (`empID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `claimrecord`
--
ALTER TABLE `claimrecord`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `claimtype`
--
ALTER TABLE `claimtype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `empdetails`
--
ALTER TABLE `empdetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `claimrecord`
--
ALTER TABLE `claimrecord`
  ADD CONSTRAINT `claimrecord_ibfk_1` FOREIGN KEY (`empID`) REFERENCES `empdetails` (`empID`),
  ADD CONSTRAINT `claimrecord_ibfk_2` FOREIGN KEY (`claimTypeID`) REFERENCES `claimtype` (`claimTypeID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
