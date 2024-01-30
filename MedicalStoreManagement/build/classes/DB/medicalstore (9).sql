-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2014 at 08:34 AM
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `medicalstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `balance_sheet`
--

CREATE TABLE IF NOT EXISTS `balance_sheet` (
  `date` varchar(20) NOT NULL,
  `cash_inhand` varchar(50) NOT NULL,
  `cash_inbank` varchar(50) NOT NULL,
  `bill_recivable` varchar(50) NOT NULL,
  `bill_pending` varchar(50) NOT NULL,
  `creditvoucher` varchar(50) NOT NULL,
  `bill_payable` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bankcreditdebite_status`
--

CREATE TABLE IF NOT EXISTS `bankcreditdebite_status` (
  `Sr_No` int(11) NOT NULL AUTO_INCREMENT,
  `Date` varchar(20) NOT NULL,
  `party_name` varchar(100) NOT NULL,
  `bank_name` varchar(100) NOT NULL,
  `account_no` varchar(20) NOT NULL,
  `opening_balance` varchar(20) NOT NULL,
  `type` varchar(50) NOT NULL,
  `amount` varchar(10) NOT NULL,
  `total_amount` varchar(10) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`Sr_No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bank_info`
--

CREATE TABLE IF NOT EXISTS `bank_info` (
  `bank_id` int(20) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(100) NOT NULL,
  `bank_address` varchar(200) NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `account_no` varchar(20) NOT NULL,
  `micr_code` varchar(20) NOT NULL,
  `ifsc_code` varchar(20) NOT NULL,
  `opening_balance` varchar(50) NOT NULL,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bouncecheck_detail`
--

CREATE TABLE IF NOT EXISTS `bouncecheck_detail` (
  `bank_name` varchar(100) NOT NULL,
  `vender_name` varchar(100) NOT NULL,
  `check_no` varchar(20) NOT NULL,
  `check_amount` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bouncecheck_detail`
--

INSERT INTO `bouncecheck_detail` (`bank_name`, `vender_name`, `check_no`, `check_amount`, `date`, `status`) VALUES
('SBI', 'SHAH', '102030', '100000', '2014-01-01', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `category_master`
--

CREATE TABLE IF NOT EXISTS `category_master` (
  `Category_id` int(10) NOT NULL AUTO_INCREMENT,
  `Category_name` varchar(50) NOT NULL,
  `Category_Description` varchar(100) NOT NULL,
  `Status` varchar(20) NOT NULL,
  PRIMARY KEY (`Category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `category_master`
--

INSERT INTO `category_master` (`Category_id`, `Category_name`, `Category_Description`, `Status`) VALUES
(1, 'H1', 'HHHH', 'ACTIVE'),
(2, 'TABLET', 'tav', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `companymaster`
--

CREATE TABLE IF NOT EXISTS `companymaster` (
  `comp_id` int(10) NOT NULL AUTO_INCREMENT,
  `comp_name` varchar(100) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`comp_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `companymaster`
--

INSERT INTO `companymaster` (`comp_id`, `comp_name`, `status`) VALUES
(1, 'ranbaxy', 'ACTIVE'),
(2, 'CIPLA', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `countercollection`
--

CREATE TABLE IF NOT EXISTS `countercollection` (
  `countersale_date` date NOT NULL,
  `counter_totalcollection` int(200) NOT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `countercollection`
--

INSERT INTO `countercollection` (`countersale_date`, `counter_totalcollection`, `status`) VALUES
('2014-06-02', 40, 'ACTIVE'),
('2014-06-06', 104, 'ACTIVE'),
('2014-06-13', 1000, 'ACTIVE'),
('2014-06-19', 3400, 'ACTIVE'),
('2014-06-26', 3420, 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `countersalesdata`
--

CREATE TABLE IF NOT EXISTS `countersalesdata` (
  `Sr_no` int(11) NOT NULL,
  `countersale_date` date NOT NULL,
  `product_name` varchar(200) NOT NULL,
  `product_category` varchar(50) NOT NULL,
  `product_quantity` varchar(30) NOT NULL,
  `perunitprice` varchar(20) NOT NULL,
  `product_totalamount` varchar(20) NOT NULL,
  `counter_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `countersalesdata`
--

INSERT INTO `countersalesdata` (`Sr_no`, `countersale_date`, `product_name`, `product_category`, `product_quantity`, `perunitprice`, `product_totalamount`, `counter_status`) VALUES
(0, '2014-06-21', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(0, '2014-06-21', 'combiflam', 'Tablet', '3', '100', '300.0', 'ACTIVE'),
(0, '2014-06-21', 'combiflam', 'Tablet', '3', '100', '300.0', 'ACTIVE'),
(1, '2014-06-21', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(1, '2014-06-21', 'combiflam', 'Tablet', '3', '100', '300.0', 'ACTIVE'),
(2, '2014-06-21', 'combiflam', 'Tablet', '3', '100', '300.0', 'ACTIVE'),
(2, '2014-06-21', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(3, '2014-06-21', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(3, '2014-06-21', 'combiflam', 'Tablet', '3', '100', '300.0', 'ACTIVE'),
(4, '2014-06-23', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(4, '2014-06-23', 'combiflam', 'Tablet', '2', '100', '200.0', 'ACTIVE'),
(5, '2014-06-23', 'combiflam', 'Tablet', '10', '100', '1000.0', 'ACTIVE'),
(6, '2014-06-23', 'combiflam', 'Tablet', '10', '100', '1000.0', 'ACTIVE'),
(6, '2014-06-23', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(7, '2014-06-23', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(7, '2014-06-23', 'czed', 'asf', '10', '3', '30.0', 'ACTIVE'),
(7, '2014-06-23', 'vicks', 'asf', '20', '5', '100.0', 'ACTIVE'),
(8, '2014-06-23', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(8, '2014-06-23', 'vicks', 'asf', '30', '5', '150.0', 'ACTIVE'),
(8, '2014-06-23', 'czed', 'asf', '10', '3', '30.0', 'ACTIVE'),
(9, '2014-06-23', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(10, '2014-06-23', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(11, '2014-06-23', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(12, '2014-06-23', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(13, '2014-06-23', 'czed', 'asf', '5', '3', '15.0', 'ACTIVE'),
(14, '2014-06-23', 'vicks', 'asf', '10', '5', '50.0', 'ACTIVE'),
(15, '2014-06-23', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(16, '2014-06-23', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(17, '2014-06-23', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(18, '2014-06-23', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(19, '2014-06-23', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(20, '2014-06-23', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(21, '2014-06-23', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(22, '2014-06-23', 'czed', 'asf', '5', '3', '15.0', 'ACTIVE'),
(23, '2014-06-23', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(24, '2014-06-23', 'czed', 'asf', '5', '3', '15.0', 'ACTIVE'),
(25, '2014-06-23', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(26, '2014-06-23', 'vicks', 'asf', '10', '5', '50.0', 'ACTIVE'),
(27, '2014-06-23', 'vicks', 'asf', '10', '5', '50.0', 'ACTIVE'),
(27, '2014-06-23', 'czed', 'asf', '10', '3', '30.0', 'ACTIVE'),
(28, '2014-06-23', 'vicks', 'asf', '10', '5', '50.0', 'ACTIVE'),
(28, '2014-06-23', 'czed', 'asf', '10', '3', '30.0', 'ACTIVE'),
(29, '2014-06-23', 'czed', 'asf', '5', '3', '15.0', 'ACTIVE'),
(30, '2014-06-24', 'combiflam', 'Tablet', '5', '100', '500.0', 'ACTIVE'),
(30, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(30, '2014-06-24', 'czed', 'asf', '10', '3', '30.0', 'ACTIVE'),
(31, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(31, '2014-06-24', 'czed', 'asf', '5', '3', '15.0', 'ACTIVE'),
(32, '2014-06-24', 'czed', 'asf', '5', '3', '15.0', 'ACTIVE'),
(32, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(33, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(34, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(35, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(36, '2014-06-24', 'czed', 'asf', '5', '3', '15.0', 'ACTIVE'),
(37, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(38, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(39, '2014-06-24', 'vicks', 'asf', '2', '5', '10.0', 'ACTIVE'),
(40, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(41, '2014-06-24', 'vicks', 'asf', '1', '5', '5.0', 'ACTIVE'),
(42, '2014-06-24', 'vicks', 'asf', '5', '5', '25.0', 'ACTIVE'),
(43, '2014-06-24', 'vicks', 'asf', '2', '5', '10.0', 'ACTIVE'),
(44, '2014-06-24', 'czed', 'asf', '2', '3', '6.0', 'ACTIVE'),
(45, '2014-06-24', 'vicks', 'asf', '1', '5', '5.0', 'ACTIVE'),
(46, '2014-06-24', 'czed', 'asf', '1', '3', '3.0', 'ACTIVE'),
(47, '2014-06-24', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(48, '2014-06-24', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(49, '2014-06-24', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(50, '2014-06-24', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(51, '2014-06-24', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(52, '2014-06-24', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(53, '2014-06-24', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(54, '2014-06-24', 'vicks', 'asf', '1', '5', '5.0', 'ACTIVE'),
(55, '2014-06-24', 'vicks', 'asf', '1', '5', '5.0', 'ACTIVE'),
(56, '2014-06-24', 'combiflam', 'Tablet', '1', '100', '100.0', 'ACTIVE'),
(56, '2014-06-24', 'vicks', 'asf', '1', '5', '5.0', 'ACTIVE'),
(56, '2014-06-24', 'czed', 'asf', '1', '3', '3.0', 'ACTIVE'),
(57, '2014-06-26', 'combiflam', 'TABLET', '1', '10', '10.0', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `creditors`
--

CREATE TABLE IF NOT EXISTS `creditors` (
  `creditors_id` varchar(20) DEFAULT NULL,
  `creditors_name` varchar(100) NOT NULL,
  `creditor_address` varchar(200) NOT NULL,
  `creditors_mob` varchar(15) NOT NULL,
  `so_number` varchar(10) NOT NULL,
  `dated` date NOT NULL,
  `pay_mode` varchar(100) NOT NULL,
  `total_amount` varchar(20) NOT NULL,
  `paid_amount` varchar(20) NOT NULL,
  `pending_amount` varchar(20) NOT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `creditors`
--

INSERT INTO `creditors` (`creditors_id`, `creditors_name`, `creditor_address`, `creditors_mob`, `so_number`, `dated`, `pay_mode`, `total_amount`, `paid_amount`, `pending_amount`, `status`) VALUES
('3', 'AMRUTRAJ', 'KOLHAPUR', '7276056675', '5', '2014-06-09', 'Partial Payment', '2096.0', '100.0', '1900.0', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `customer_cashpay`
--

CREATE TABLE IF NOT EXISTS `customer_cashpay` (
  `date` varchar(100) NOT NULL,
  `cust_name` varchar(100) NOT NULL,
  `address` varchar(300) NOT NULL,
  `cont_no` varchar(20) NOT NULL,
  `pending_amt` varchar(10) NOT NULL,
  `paid_amt` varchar(10) NOT NULL,
  `disct` varchar(10) NOT NULL,
  `voucher_no` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`voucher_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE IF NOT EXISTS `customer_info` (
  `customer_id` int(100) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(300) NOT NULL,
  `customer_address` varchar(500) NOT NULL,
  `customer_gender` varchar(300) NOT NULL,
  `customer_age` varchar(300) NOT NULL,
  `customer_contactnumber` varchar(500) NOT NULL,
  `customer_docname` varchar(300) NOT NULL,
  `customerstatus` varchar(20) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`customer_id`, `customer_name`, `customer_address`, `customer_gender`, `customer_age`, `customer_contactnumber`, `customer_docname`, `customerstatus`) VALUES
(1, 'SA', 'DS', 'Male', '12', '4545454545', 'ASDFSDA', 'ACTIVE'),
(2, 'CUSTOMER', 'CUS	', 'Male', '100', '13215464654', 'DICTO', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `damage_stock`
--

CREATE TABLE IF NOT EXISTS `damage_stock` (
  `Damage_Stock_No` varchar(15) DEFAULT NULL,
  `GR_number` varchar(20) NOT NULL,
  `GRN_Date` varchar(20) NOT NULL,
  `dated` varchar(20) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `Distributor_Name` varchar(50) NOT NULL,
  `Distributor_Address` varchar(50) NOT NULL,
  `Distributor_Contact` varchar(20) NOT NULL,
  `Reason` varchar(35) NOT NULL,
  `total_stock` varchar(20) NOT NULL,
  `damage_stock` varchar(20) NOT NULL,
  `remaining_stock` varchar(20) NOT NULL,
  `description` varchar(400) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `damage_stock`
--

INSERT INTO `damage_stock` (`Damage_Stock_No`, `GR_number`, `GRN_Date`, `dated`, `product_name`, `Distributor_Name`, `Distributor_Address`, `Distributor_Contact`, `Reason`, `total_stock`, `damage_stock`, `remaining_stock`, `description`, `status`) VALUES
('1', '1', '2014-05-24', '2014-05-24', 'asdf', 'QQQQ', 'QQQQ', '9876546310', 'Write-Off', '20', '10', '10', '		', 'ACTIVE'),
('2', '3', '2014-06-02', '2014-06-02', 'crosin', 'SERVICE ENGG', 'PUNE	', '1021211', 'Other', '60', '20', '40', 'asfdsafdsa', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `debtors`
--

CREATE TABLE IF NOT EXISTS `debtors` (
  `debtors_id` varchar(20) DEFAULT NULL,
  `debtors_name` varchar(50) NOT NULL,
  `po_number` int(10) NOT NULL,
  `dated` varchar(20) NOT NULL,
  `payment_mode` varchar(100) NOT NULL,
  `total_amount` varchar(20) NOT NULL,
  `paid_amount` varchar(20) NOT NULL,
  `pending_amount` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `debtors`
--

INSERT INTO `debtors` (`debtors_id`, `debtors_name`, `po_number`, `dated`, `payment_mode`, `total_amount`, `paid_amount`, `pending_amount`, `status`) VALUES
('6', 'Amrutraj', 2, '2014-05-27', 'Cheque', '780', '500', '280.0', 'ACTIVE'),
('12', 'SERVICE ENGG', 3, '2014-06-02', 'Cash', '40', '20', '20', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `distributors_details`
--

CREATE TABLE IF NOT EXISTS `distributors_details` (
  `distributors_id` int(100) NOT NULL AUTO_INCREMENT,
  `distributors_name` varchar(300) DEFAULT NULL,
  `distributors_address` varchar(500) DEFAULT NULL,
  `distributors_officeno` varchar(25) DEFAULT NULL,
  `distributors_mobileno` varchar(25) DEFAULT NULL,
  `distributors_email` varchar(150) DEFAULT NULL,
  `distributors_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`distributors_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=134 ;

--
-- Dumping data for table `distributors_details`
--

INSERT INTO `distributors_details` (`distributors_id`, `distributors_name`, `distributors_address`, `distributors_officeno`, `distributors_mobileno`, `distributors_email`, `distributors_status`) VALUES
(1, 'DARSHAN MEDICAL', 'PUNE	', '02022241552', '2014446522', 'snaket@gmail.com', 'DEACTIVE'),
(2, 'AMIT MEDICO', 'PUNE', 'NA', 'NA', 'NA', 'ACTIVE'),
(3, 'NEW AMAR AGENCY', 'PUNE	', '24490197', 'NA', 'NA', 'ACTIVE'),
(4, 'AVANTI DISTRBUTORS ', 'PUNE', 'NA', 'NA', 'NA', 'ACTIVE'),
(5, 'ARJAS MEDICAL DISTRIBUTORS', 'PUNE', '24495625', 'NA', 'NA', 'ACTIVE'),
(6, 'ACME ENTERPRISES', 'PUNE	', '24485813', 'NA', 'NA', 'ACTIVE'),
(7, 'ATUL MEDICALS', 'PUNE', '24485678', 'NA', 'NA', 'ACTIVE'),
(8, 'ARIHANT MEDICO', 'PUNE	', '24476235', 'NA', 'NA', 'ACTIVE'),
(9, 'APTE PHARMA', 'PUNE	', '24474604', 'NA', 'NA', 'ACTIVE'),
(10, 'ANAND MEDICAL DISTRIBUTORS', 'PUNE', '24478067', 'NA', 'NA', 'ACTIVE'),
(11, 'ASWAM & CO', 'PUNE', '24671606', 'NA', 'NA', 'ACTIVE'),
(12, 'AMBIKA DISTRIBUTORS', 'PUNE', '24452571', 'NA', 'NA', 'ACTIVE'),
(13, 'BALAJI ENTERPRISES', 'PUNE', '24670015', 'NA', 'NA', 'ACTIVE'),
(14, 'ANAND ENTERPRISES', 'PUNE', '24470330', 'NA', 'NA', 'ACTIVE'),
(15, 'AMOL DISTRIBUTORS', 'PUNE', '24486437', 'NA', 'NA', 'ACTIVE'),
(16, 'AMIT MEDICO', 'PUNE', 'NA', 'NA', 'NA', 'ACTIVE'),
(17, 'BALAJI DISTRIBTORS', 'PUNE', '24679961', 'NA', 'NA', 'ACTIVE'),
(18, 'BALAJI ENTERPRISES', 'PUNE	', '23833487', 'NA', 'NA', 'ACTIVE'),
(19, 'NEW AMARAGENCY', 'PUNE', '24450197', 'NA', 'NA', 'ACTIVE'),
(20, 'AVANTI DISTRIBUTORS', 'PUNE', 'NA', 'NA', 'NA', 'ACTIVE'),
(21, 'CHANDULAL. R. MEHTA', 'PUNE	', '24475010', 'NA', 'NA', 'ACTIVE'),
(22, 'ACME ENTERPRISES', 'PUNE', '24485813', 'NA', 'NA', 'ACTIVE'),
(23, 'CHANDAN PHARAMCEUTICALS', 'PUNE', '24475766', 'NA', 'NA', 'ACTIVE'),
(24, 'C. T. DISTRIBUTORS', 'PUNE', '24484721', 'NA', 'NA', 'ACTIVE'),
(25, 'ARSHANT MEDICO', 'PUNE', '24476325', 'NA', 'NA', 'ACTIVE'),
(26, 'CHOICE MEDICO', 'PUNE	', '24475218', 'NA', 'NA', 'ACTIVE'),
(27, 'APTE PHARMA', 'PUNE', '24474604', 'NA', 'NA', 'ACTIVE'),
(28, 'AMAR DISTRIBUTORS', 'PUNE', '24466440', 'NA', 'NA', 'ACTIVE'),
(29, 'DIAMOND DRUG STROES', 'PUNE	', '24430486', 'NA', 'NA', 'ACTIVE'),
(30, 'ASWAM & CO', 'PUNE', '24471606', 'NA', 'NA', 'ACTIVE'),
(31, 'DEEPA CORPORATION', 'PUNE	', '24472760', 'NA', 'NA', 'ACTIVE'),
(32, 'D. K. ENTERPRISES', 'PUNE	', '24489231', 'NA', 'NA', 'ACTIVE'),
(33, 'BALAJI ENTERPRISES', 'PUNE', '24470015', 'NA', 'NA', 'ACTIVE'),
(34, 'BALAJI DISTRIBUTORS', 'PUNE', '24479961', 'NA', 'NA', 'ACTIVE'),
(35, 'DATTA MEDICALS', 'PUNE', '24477279', 'NA', 'NA', 'ACTIVE'),
(36, 'BHAWANI ENTERPRISES', 'PUNE', '24433487', 'NA', 'NA', 'ACTIVE'),
(37, 'DATTA AGENCY', 'PUNE', '24461073', 'NA', 'NA', 'ACTIVE'),
(38, 'CHANDULALR MEHTA', 'PUNE', '24475019', 'NA', 'NA', 'ACTIVE'),
(39, 'CHANDAN PHARMACEUTICALS', 'PUNE', '24475766', 'NA', 'NA', 'ACTIVE'),
(40, 'NITIN DISTRIBUTORS (SURIGCALS)', 'PUNE', '24490211', 'NA', 'NA', 'ACTIVE'),
(41, 'C.T.DISTRIBUTORS', 'PUNE', '24484721', 'NA', 'NA', 'ACTIVE'),
(42, 'NOOTAN PHARMA', 'PUNE', '24466433', 'NA', 'NA', 'ACTIVE'),
(43, 'CHOICE MEDICO', 'PUNE', '24475219', 'NA', 'NA', 'ACTIVE'),
(44, 'NIHAL TRADING', 'PUNE	', '26816650', 'NA', 'NA', 'ACTIVE'),
(45, 'NEELU & CO', 'PUNE', '24494340', 'NA', 'NA', 'ACTIVE'),
(46, 'DIAMOND DRUG STORES', 'PUNE', '24430486', 'NA', 'NA', 'ACTIVE'),
(47, 'OSWAL ENTERPRISE', 'PUNE', '24463965', 'NA', 'NA', 'ACTIVE'),
(48, 'OMKAR ENTERPRISE', 'PUNE	', '24493563', 'NA', 'NA', 'ACTIVE'),
(49, 'KALE  PHARMA', 'PUNE', '24474758', 'NA', 'NA', 'ACTIVE'),
(50, 'PHARMA MARK', 'PUNE	', '24473520', 'NA', 'NA', 'ACTIVE'),
(51, 'K.D.P.SURGICALS', 'PUNE', '26120258', 'NA', 'NA', 'ACTIVE'),
(52, 'PEEYU DISTRIBUTORS', 'PUNE', '24478719', 'NA', 'NA', 'ACTIVE'),
(53, 'KANCHAN DURGS PVT.LTD', 'PUNE', '24452017', 'NA', 'NA', 'ACTIVE'),
(54, 'POOJA AGENCY', 'PUNE	', '24473838', 'NA', 'NA', 'ACTIVE'),
(55, 'KAPILA', 'PUNE', '24475201', 'NA', 'NA', 'ACTIVE'),
(56, 'KUNDAN DISTRIBUTORS', 'PUNE', '24473604', 'NA', 'NA', 'ACTIVE'),
(57, 'PADMASHREE MEDICAL DIST.', 'PUNE	', '24470137', 'NA', 'NA', 'ACTIVE'),
(58, 'KOHINOOR PHARMA', 'PUNE', '24487565', 'NA', 'NA', 'ACTIVE'),
(59, 'PRASAD DISTRIBUTORS ', 'PUNE', '24461400', 'NA', 'NA', 'ACTIVE'),
(60, 'KESARIYAAGENCY', 'PUNE', '24473108', 'NA', 'NA', 'ACTIVE'),
(61, 'LAGHATE PHARMACEUTICALS', 'PUNE', '24485947', 'NA', 'NA', 'ACTIVE'),
(62, 'PRASAD DISTRIBUTORS ', 'PUNE', '24436192', 'NA', 'NA', 'ACTIVE'),
(63, 'MEENA PHARMACEUTICALS', 'PUNE', '24456781', 'NA', 'NA', 'ACTIVE'),
(64, 'PRASAD DISTRIBUTORS ', 'PUNE', '24461400', 'NA', 'NA', 'DEACTIVE'),
(65, 'MEDEECO DISTRIBUTORS', 'PUNE', '24473398', 'NA', 'NA', 'ACTIVE'),
(66, 'PRASHANTI ENTERPRISES', 'PUNE', '24472456', 'NA', 'NA', 'ACTIVE'),
(67, 'MAJITHIA MEDICAL STORES', 'PUNE', '24473358', 'NA', 'NA', 'ACTIVE'),
(68, 'MAJITHIAAGENCY', 'PUNE', '24475082', 'NA', 'NA', 'ACTIVE'),
(69, 'PRAKASH PHARMA', 'PUNE ', '24436192', 'NA', 'NA', 'ACTIVE'),
(70, 'MAHARASHTRA DISTRIBUTORS', 'PUNE', '24457026', 'NA', 'NA', 'ACTIVE'),
(71, 'PRAKASH DISTRIBUTORS', 'PUNE', '24478553', 'NA', 'NA', 'ACTIVE'),
(72, 'MODERN DISTRIBUTORS  ', 'PUNE	', '24450057', 'NA', 'NA', 'ACTIVE'),
(73, 'PHARMA CHEM', 'PUNE', '26444500', 'NA', 'NA', 'ACTIVE'),
(74, 'MADANE SURGICALS', 'PUNE	', '25535090', 'NA', 'NA', 'ACTIVE'),
(75, 'PRADHIM MEDICO', 'PUNE	', '24470129', 'NA', 'NA', 'ACTIVE'),
(76, 'PHARMA LINK', 'PUNE', '24485665', 'NA', 'NA', 'ACTIVE'),
(77, 'PANKAJ PHARMA', 'PUNE	', '24470521', 'NA', 'NA', 'ACTIVE'),
(78, 'MAHENDRA DISTRIBUTORS', 'PUNE	', '24473899', 'NA', 'NA', 'ACTIVE'),
(79, 'DARSHAN MEDICAL DIST.', 'PUNE	', '24473265', 'NA', 'NA', 'ACTIVE'),
(80, 'MAYUR MEDICAL AGENCIES', 'PUNE', '24478123', 'NA', 'NA', 'ACTIVE'),
(81, 'EITHICAL AGENCY', 'PUNE	', '24473063', 'NA', 'NA', 'ACTIVE'),
(82, 'MAHALAXMI PHARMA', 'PUNE', '24482321', 'NA', 'NA', 'ACTIVE'),
(83, 'GUJAR & CO.', 'PUNE	', '24473001', 'NA', 'NA', 'ACTIVE'),
(84, 'NITIN AGENCY', 'PUNE', '24471671', 'NA', 'NA', 'ACTIVE'),
(85, 'NEW GUJAR PHARAMCEUTICALS', 'PUNE	', '24476178', 'NA', 'NA', 'ACTIVE'),
(86, 'POOJAAGENCY', 'PUNE', '24473838', 'NA', 'NA', 'ACTIVE'),
(87, 'HIRALAL MEHTA & CO', 'PUNE	', '24454320', 'NA', 'NA', 'ACTIVE'),
(88, 'HARIKRUPA ENTERPRISES', 'PUNE	', '24451118', 'NA', 'NA', 'ACTIVE'),
(89, 'PADMASHREE MEDICAL DIST', 'PUNE', '24470137', 'NA', 'NA', 'ACTIVE'),
(90, 'INPHARMA', 'PUNE	', '25535897', 'NA', 'NA', 'ACTIVE'),
(91, 'PRASAD DISTRIBUTORS', 'PUNE	', '24461400', 'NA', 'NA', 'ACTIVE'),
(92, 'PHARMDEAL', 'PUNE', '24488999', 'NA', 'NA', 'ACTIVE'),
(93, 'JEEVAN MEDISALES PVT. LTD. ', 'PUNE	', '24091994', 'NA', 'NA', 'ACTIVE'),
(94, 'KALE PHARMA', 'PUNE', '24476788', 'NA', 'NA', 'ACTIVE'),
(95, 'PRASHANTIENTERPRISES', 'PUNE', '24472456', 'NA', 'NA', 'ACTIVE'),
(96, 'PRAKASH DISTRIBUTORS', 'PUNE	', '24478553', 'NA', 'NA', 'ACTIVE'),
(97, 'K. D. B SURGICALS', 'PUNE	', '24452017', 'NA', 'NA', 'ACTIVE'),
(98, 'KAPILA', 'PUNE	', '24475201', 'NA', 'NA', 'ACTIVE'),
(99, 'PRAKASH PHARMA', 'PUNE	', '24456192', 'NA', 'NA', 'ACTIVE'),
(100, 'KUNDAN DISTRIBUTORS', 'PUNE	', '24473604', 'NA', 'NA', 'ACTIVE'),
(101, 'PHARMA CHEM', 'PUNE	', '25444500', 'NA', 'NA', 'ACTIVE'),
(102, 'KOHINOOR PHARMA', 'PUNE	', '24487565', 'NA', 'NA', 'ACTIVE'),
(103, 'PRADHIM MEDICO', 'PUNE	', '24470129', 'NA', 'NA', 'ACTIVE'),
(104, 'KESARIYA AGENCY', 'PUNE	', '24473108', 'NA', 'NA', 'ACTIVE'),
(105, 'PHARMALINK', 'PUNE	', '24485665', 'NA', 'NA', 'ACTIVE'),
(106, 'PANAKJ PHARMA', 'PUNE	', '24470519', 'NA', 'NA', 'ACTIVE'),
(107, 'LAGHATE PHARMACEUTICALS', 'PUNE	', '24485947', 'NA', 'NA', 'ACTIVE'),
(108, 'MEENA PHARMACEUTICALS', 'PUNE	', '24485947', 'NA', 'NA', 'ACTIVE'),
(109, 'PREMIER DISTRIBUTORS', 'PUNE	', '24451544', 'NA', 'NA', 'ACTIVE'),
(110, 'MEDEECO DISTRIBUTORS', 'PUNE	', '24473398', 'NA', 'NA', 'ACTIVE'),
(111, 'RAVI MEDICO', 'PUNE	', '24491282', 'NA', 'NA', 'ACTIVE'),
(112, 'ROHIT ENTERPRISES', 'PUNE	', '24474028', 'NA', 'NA', 'ACTIVE'),
(113, 'MAJITHIA MEDICAL STORES', 'PUNE	', '24473358', 'NA', 'NA', 'ACTIVE'),
(114, 'MAJITHIA AGNCY', 'PUNE	', '24475082', 'NA', 'NA', 'ACTIVE'),
(115, 'RAHUL MEDICO', 'PUNE	', '24479461', 'NA', 'NA', 'ACTIVE'),
(116, 'SENIOR AGENCY', 'PUNE	', '24478910', 'NA', 'NA', 'ACTIVE'),
(117, 'RAJAN DRUG HOUSE', 'PUNE', '24452625', 'NA', 'NA', 'ACTIVE'),
(118, 'SHAH MEDICO/MEDICALS', 'PUNE	', '24486722', 'NA', 'NA', 'ACTIVE'),
(119, 'SHUBH PHARMA(GENERIC)', 'PUNE	', '24476549', 'NA', 'NA', 'ACTIVE'),
(120, 'SHAH ENTERPRISES', 'PUNE	', '24472616', 'NA', 'NA', 'ACTIVE'),
(121, 'SHREERAM ENTERPRISES', 'PUNE	', '24482021', 'NA', 'NA', 'ACTIVE'),
(122, 'SANJAY DISTRIBUTORS', 'PUNE	', '24477721', 'NA', 'NA', 'ACTIVE'),
(123, 'SHARP ENTERPRISES', 'PUNE	', '24472341', 'NA', 'NA', 'ACTIVE'),
(124, 'SHREYASH DISTRIBUTORS', 'PUNE	', '24478077', 'NA', 'NA', 'ACTIVE'),
(125, 'SANDESH ENTERPRISES', 'PUNE	', '24671973', 'NA', 'NA', 'ACTIVE'),
(126, 'SARIKA ENTERPRISES', 'PUNE	', '26688479', 'NA', 'NA', 'ACTIVE'),
(127, 'S. B. JOSHI & CO', 'PUNE	', '24672865', 'NA', 'NA', 'ACTIVE'),
(128, 'SWASTIK MEDICAL STORES', 'PUNE	', '24479536', 'NA', 'NA', 'ACTIVE'),
(129, 'TAPADIYA DISTRIBUTORS', 'PUNE	', '24478599', 'NA', 'NA', 'ACTIVE'),
(130, 'TRIPATHI & CO', 'PUNE	', '24479257', 'NA', 'NA', 'ACTIVE'),
(131, 'VINAYAK AGENCY', 'PUNE	', '24475041', 'NA', 'NA', 'ACTIVE'),
(132, 'VISHAL ENTERPRISES', 'PUNE	', '24461721', 'NA', 'NA', 'ACTIVE'),
(133, 'YASH PHARMA', 'PUNE	', '24476235', 'NA', 'NA', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `employee_info`
--

CREATE TABLE IF NOT EXISTS `employee_info` (
  `employee_id` int(100) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(300) NOT NULL,
  `employee_contactno` varchar(300) NOT NULL,
  `employee_dob` date NOT NULL,
  `employee_address` varchar(500) NOT NULL,
  `employee_education` varchar(300) NOT NULL,
  `employee_gender` varchar(100) NOT NULL,
  `employee_bloodgroup` varchar(100) NOT NULL,
  `employee_age` varchar(100) NOT NULL,
  `employee_email` varchar(300) NOT NULL,
  `employee_status` varchar(20) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `employee_info`
--

INSERT INTO `employee_info` (`employee_id`, `employee_name`, `employee_contactno`, `employee_dob`, `employee_address`, `employee_education`, `employee_gender`, `employee_bloodgroup`, `employee_age`, `employee_email`, `employee_status`) VALUES
(1, 'EMPLOYEE', '7894561230', '2014-01-01', 'EGW	', 'pune', 'Male', 'A+', '10', 'EGE2@SF.SDF', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `expiry_info`
--

CREATE TABLE IF NOT EXISTS `expiry_info` (
  `Expiry_product_id` varchar(10) DEFAULT NULL,
  `Product_name` varchar(100) NOT NULL,
  `Quantity` varchar(10) NOT NULL,
  `mgf_date` varchar(20) NOT NULL,
  `Expiry_date` varchar(20) NOT NULL,
  `Expiry_Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_status` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`user_id`, `user_name`, `user_password`, `user_status`) VALUES
('1', 'admin', 'admin', 'ACTIVE'),
('2', 'user', 'user', 'DEACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `material_inward_info`
--

CREATE TABLE IF NOT EXISTS `material_inward_info` (
  `GR_no` varchar(15) NOT NULL,
  `GR_date` varchar(20) NOT NULL,
  `PO_number` varchar(20) NOT NULL,
  `PO_date` varchar(20) NOT NULL,
  `Batch_number` varchar(20) DEFAULT NULL,
  `distributors_name` varchar(50) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `Brand` varchar(50) DEFAULT NULL,
  `Available_stock` varchar(20) NOT NULL,
  `Stock_to_Update` varchar(20) NOT NULL,
  `Total_Stock` varchar(20) NOT NULL,
  `VAT_purchase` varchar(15) NOT NULL,
  `purchase_unit_price` varchar(20) NOT NULL,
  `total_purchase_price` varchar(20) NOT NULL,
  `Mfg_Date` varchar(20) DEFAULT NULL,
  `Expiry_Date` varchar(20) NOT NULL,
  `Material_Status` varchar(10) DEFAULT NULL,
  `Material_Description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `material_inward_info`
--

INSERT INTO `material_inward_info` (`GR_no`, `GR_date`, `PO_number`, `PO_date`, `Batch_number`, `distributors_name`, `product_name`, `Brand`, `Available_stock`, `Stock_to_Update`, `Total_Stock`, `VAT_purchase`, `purchase_unit_price`, `total_purchase_price`, `Mfg_Date`, `Expiry_Date`, `Material_Status`, `Material_Description`) VALUES
('1', '2014-05-24', '1', '2014/5/24', '25', 'QQQQ', 'asdf', 'Tablet', '10', '10', '10', '5%', '10', '100', '2014-01-01', '20654', 'ACTIVE', 'testing'),
('2', '2014-05-27', '2', '2014/5/27', '10', 'Amrutraj', 'combiflam', 'Tablet', '200', '78', '278', '5%', '10', '780', '201-041', '2001-41', 'ACTIVE', 'asdfdf	'),
('3', '2014-06-02', '9', '2014/6/2', '10', 'SERVICE ENGG', 'crosin', 'asf', '50', '20', '70', '5%', '2', '40', '2014-01-01', '2014-05-05', 'ACTIVE', 'hjhjkhjkhjkh');

-- --------------------------------------------------------

--
-- Table structure for table `product_info`
--

CREATE TABLE IF NOT EXISTS `product_info` (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `distributors_id` int(100) NOT NULL,
  `distributor_name` varchar(100) NOT NULL,
  `companyname` varchar(100) NOT NULL,
  `product_name` varchar(300) NOT NULL,
  `product_batchno` varchar(300) NOT NULL,
  `product_category` varchar(50) NOT NULL,
  `product_manfdate` varchar(300) NOT NULL,
  `product_expdate` varchar(300) NOT NULL,
  `product_min` int(20) NOT NULL,
  `product_max` int(20) NOT NULL,
  `product_rateperunit` int(20) NOT NULL,
  `totalstock` varchar(100) NOT NULL,
  `col` varchar(20) NOT NULL,
  `row` varchar(20) NOT NULL,
  `product_vat` varchar(20) NOT NULL,
  `Actual_price` int(10) NOT NULL,
  `product_description` varchar(500) NOT NULL,
  `productstatus` varchar(20) NOT NULL,
  `dateofcreation` varchar(100) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `product_info`
--

INSERT INTO `product_info` (`product_id`, `distributors_id`, `distributor_name`, `companyname`, `product_name`, `product_batchno`, `product_category`, `product_manfdate`, `product_expdate`, `product_min`, `product_max`, `product_rateperunit`, `totalstock`, `col`, `row`, `product_vat`, `Actual_price`, `product_description`, `productstatus`, `dateofcreation`) VALUES
(1, 16, 'AMIT MEDICO', '', 'VICKS', '10', 'H1', '102000', '101010', 5, 10, 8, '100', 'A', '6', '12.5', 10, 'SDFASDF	', 'ACTIVE', '2014/6/25'),
(2, 16, 'AMIT MEDICO', 'CIPLA', 'VICKS', '10', 'H1', '2014-01-01', '2014-01-01', 5, 10, 8, '8', 'V', '6', '12.5', 10, 'ASDF	', 'ACTIVE', '2014/6/26'),
(3, 16, 'AMIT MEDICO', 'CIPLA', 'combiflam', '10210', 'TABLET', '2014-01-01', '2014-01-01', 5, 10, 8, '498', 'a', '5', '12.5', 10, 'sasd	', 'ACTIVE', '2014/6/26');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_invoice`
--

CREATE TABLE IF NOT EXISTS `purchase_invoice` (
  `GR_no` varchar(200) DEFAULT NULL,
  `distributors_name` varchar(200) NOT NULL,
  `distributor_id` varchar(100) NOT NULL,
  `invoice_no` varchar(20) NOT NULL,
  `invoice_date` date NOT NULL,
  `PO_number` varchar(20) NOT NULL,
  `podate` varchar(20) NOT NULL,
  `payment_mode` varchar(50) NOT NULL,
  `payment_type` varchar(100) NOT NULL,
  `actual_amount` varchar(50) NOT NULL,
  `VAT` varchar(20) NOT NULL,
  `amount_paid` varchar(50) NOT NULL,
  `balance_amount` varchar(50) NOT NULL,
  `bank` varchar(100) NOT NULL,
  `ref_no` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_invoice`
--

INSERT INTO `purchase_invoice` (`GR_no`, `distributors_name`, `distributor_id`, `invoice_no`, `invoice_date`, `PO_number`, `podate`, `payment_mode`, `payment_type`, `actual_amount`, `VAT`, `amount_paid`, `balance_amount`, `bank`, `ref_no`, `status`) VALUES
('2', 'BORA DIST', '1', '1', '2014-05-13', '2', '2014/5/13', 'Cheque', 'Partial Payment', '500', 'Yes', '200', '300', 'sbi baanmk', '874578', 'ACTIVE'),
('2', 'Amrutraj', '6', '2', '2014-05-27', '2', '2014/5/27', 'Cheque', 'Partial Payment', '780', 'Yes', '500', '280', 'asdf', '102010', 'ACTIVE'),
('3', 'SERVICE ENGG', '12', '3', '2014-06-02', '9', '2014/6/2', 'Cash', 'Partial Payment', '40', 'Yes', '20', '20', 'a', 's', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_order`
--

CREATE TABLE IF NOT EXISTS `purchase_order` (
  `po_no` varchar(10) NOT NULL,
  `podate` varchar(100) NOT NULL,
  `distributors_id` varchar(100) NOT NULL,
  `distributors_name` varchar(200) NOT NULL,
  `distributors_address` varchar(300) NOT NULL,
  `distributors_officeno` varchar(300) NOT NULL,
  `distributors_mobileno` varchar(100) NOT NULL,
  `distributors_email` varchar(100) NOT NULL,
  `product_id` varchar(200) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_category` varchar(100) NOT NULL,
  `product_orderedQty` varchar(100) NOT NULL,
  `po_status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_return`
--

CREATE TABLE IF NOT EXISTS `purchase_return` (
  `prn_number` varchar(100) NOT NULL,
  `prntype` varchar(200) NOT NULL,
  `GRN_number` varchar(20) NOT NULL,
  `grndate` date DEFAULT NULL,
  `distributorname` varchar(200) DEFAULT NULL,
  `product_name` varchar(300) NOT NULL,
  `qty` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `reason` varchar(200) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_return`
--

INSERT INTO `purchase_return` (`prn_number`, `prntype`, `GRN_number`, `grndate`, `distributorname`, `product_name`, `qty`, `description`, `reason`, `status`) VALUES
('1', 'Damaged Stock', '1', '2014-05-24', 'QQQQ', 'asdf', '10', 'testing', 'Write-Off', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `retailersales_return`
--

CREATE TABLE IF NOT EXISTS `retailersales_return` (
  `sales_return_id` varchar(20) DEFAULT NULL,
  `dated` varchar(20) DEFAULT NULL,
  `sales_return_reason` varchar(20) DEFAULT NULL,
  `bill_no` varchar(20) NOT NULL,
  `sales_date` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `ph_number` varchar(20) NOT NULL,
  `prod_name` varchar(50) NOT NULL,
  `actual_price` varchar(20) NOT NULL,
  `vat` varchar(20) NOT NULL,
  `price_per_unit` varchar(20) NOT NULL,
  `quantity` varchar(20) NOT NULL,
  `discount` varchar(20) NOT NULL,
  `total` varchar(20) NOT NULL,
  `payment_mode` varchar(20) NOT NULL,
  `paid_amount` varchar(20) NOT NULL,
  `remaining_amount` varchar(20) NOT NULL,
  `total_return_amount` varchar(20) NOT NULL,
  `return_payment_mode` varchar(20) NOT NULL,
  `amount_returned` varchar(20) NOT NULL,
  `balance_amount` varchar(20) NOT NULL,
  `return_status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `retailer_info`
--

CREATE TABLE IF NOT EXISTS `retailer_info` (
  `retailer_id` int(100) NOT NULL AUTO_INCREMENT,
  `retailer_name` varchar(300) NOT NULL,
  `retailer_address` varchar(500) NOT NULL,
  `retailer_contactno` varchar(20) NOT NULL,
  `retailer_officeno` varchar(20) NOT NULL,
  `retailer_email` varchar(200) NOT NULL,
  `retailer_status` varchar(20) NOT NULL,
  PRIMARY KEY (`retailer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `salesretailerbilldetail`
--

CREATE TABLE IF NOT EXISTS `salesretailerbilldetail` (
  `bill_id` int(20) NOT NULL,
  `cust_id` varchar(20) NOT NULL,
  `saledate` date NOT NULL,
  `cust_name` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `phn_no` varchar(20) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  `vat` varchar(20) NOT NULL,
  `product_perunitrate` varchar(20) NOT NULL,
  `product_quantity` varchar(20) NOT NULL,
  `without_vat` varchar(20) NOT NULL,
  `product_price` varchar(20) NOT NULL,
  `bill_total` varchar(20) NOT NULL,
  `pay_mode` varchar(20) NOT NULL,
  `paid_cash` varchar(20) NOT NULL,
  `paid_amount` varchar(20) NOT NULL,
  `remaning_amount` varchar(20) NOT NULL,
  `sales_discount` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sales_store`
--

CREATE TABLE IF NOT EXISTS `sales_store` (
  `bill_id` int(20) NOT NULL,
  `cust_id` varchar(20) NOT NULL,
  `saledate` date NOT NULL,
  `cust_name` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `phn_no` varchar(20) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  `vat` varchar(20) NOT NULL,
  `product_perunitrate` varchar(20) NOT NULL,
  `product_quantity` varchar(20) NOT NULL,
  `without_vat` varchar(20) NOT NULL,
  `product_price` varchar(20) NOT NULL,
  `bill_total` varchar(20) NOT NULL,
  `pay_mode` varchar(20) NOT NULL,
  `paid_cash` varchar(20) NOT NULL,
  `paid_amount` varchar(20) NOT NULL,
  `remaning_amount` varchar(20) NOT NULL,
  `sales_discount` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sale_return`
--

CREATE TABLE IF NOT EXISTS `sale_return` (
  `invoice_no` int(11) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `product_name` varchar(150) NOT NULL,
  `product_code` varchar(10) NOT NULL,
  `rate` varchar(10) NOT NULL,
  `quantity` varchar(10) NOT NULL,
  `total_amount` varchar(10) NOT NULL,
  `description` varchar(300) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
