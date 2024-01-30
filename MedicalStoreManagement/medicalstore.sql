/*
Navicat MySQL Data Transfer

Source Server         : Connection
Source Server Version : 50146
Source Host           : localhost:3306
Source Database       : medicalstore

Target Server Type    : MYSQL
Target Server Version : 50146
File Encoding         : 65001

Date: 2023-02-09 17:24:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `balance_sheet`
-- ----------------------------
DROP TABLE IF EXISTS `balance_sheet`;
CREATE TABLE `balance_sheet` (
  `date` varchar(20) NOT NULL,
  `cash_inhand` varchar(50) NOT NULL,
  `cash_inbank` varchar(50) NOT NULL,
  `bill_recivable` varchar(50) NOT NULL,
  `bill_pending` varchar(50) NOT NULL,
  `creditvoucher` varchar(50) NOT NULL,
  `bill_payable` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of balance_sheet
-- ----------------------------

-- ----------------------------
-- Table structure for `bankcreditdebite_status`
-- ----------------------------
DROP TABLE IF EXISTS `bankcreditdebite_status`;
CREATE TABLE `bankcreditdebite_status` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of bankcreditdebite_status
-- ----------------------------

-- ----------------------------
-- Table structure for `bank_info`
-- ----------------------------
DROP TABLE IF EXISTS `bank_info`;
CREATE TABLE `bank_info` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of bank_info
-- ----------------------------

-- ----------------------------
-- Table structure for `bouncecheck_detail`
-- ----------------------------
DROP TABLE IF EXISTS `bouncecheck_detail`;
CREATE TABLE `bouncecheck_detail` (
  `bank_name` varchar(100) NOT NULL,
  `vender_name` varchar(100) NOT NULL,
  `check_no` varchar(20) NOT NULL,
  `check_amount` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of bouncecheck_detail
-- ----------------------------
INSERT INTO `bouncecheck_detail` VALUES ('SBI', 'SHAH', '102030', '100000', '2014-01-01', 'ACTIVE');

-- ----------------------------
-- Table structure for `category_master`
-- ----------------------------
DROP TABLE IF EXISTS `category_master`;
CREATE TABLE `category_master` (
  `Category_id` int(10) NOT NULL AUTO_INCREMENT,
  `Category_name` varchar(50) NOT NULL,
  `Category_Description` varchar(100) NOT NULL,
  `Status` varchar(20) NOT NULL,
  PRIMARY KEY (`Category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of category_master
-- ----------------------------
INSERT INTO `category_master` VALUES ('1', 'SYP', 'SYRUP', 'ACTIVE');
INSERT INTO `category_master` VALUES ('2', 'INJ', 'INJECTION', 'ACTIVE');
INSERT INTO `category_master` VALUES ('3', 'TAB', 'TABLET', 'ACTIVE');
INSERT INTO `category_master` VALUES ('4', 'CAP', 'CAPSULES', 'ACTIVE');
INSERT INTO `category_master` VALUES ('5', 'VIAL', 'INJECTION POWDER', 'ACTIVE');
INSERT INTO `category_master` VALUES ('6', 'OTHER', 'OTHER CATEGORY', 'ACTIVE');
INSERT INTO `category_master` VALUES ('7', 'H1', 'SHEDUL H1', 'ACTIVE');

-- ----------------------------
-- Table structure for `companymaster`
-- ----------------------------
DROP TABLE IF EXISTS `companymaster`;
CREATE TABLE `companymaster` (
  `comp_id` int(10) NOT NULL AUTO_INCREMENT,
  `comp_name` varchar(100) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`comp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of companymaster
-- ----------------------------
INSERT INTO `companymaster` VALUES ('1', 'ABBOT CARDID', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('2', 'AGLLOWMED LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('3', 'AKUMENTIS ASPIRIS', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('4', 'ALEMBIC', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('5', 'APEX LABORATORIES LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('6', 'ASTRA  CARDIAC LTD.', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('7', 'BAYER INDIA LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('8', 'PIRAMAL', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('9', 'PREMIRE NUTRACEUTICALS PVT LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('10', 'PRECIA PHARMA', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('11', 'PULSE PHARMA PVT LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('12', 'RANBAXY(ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('13', 'BIDCON CARDIC', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('14', 'SANDOZ PRIVATE LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('15', 'CACHET PHARMCECUTICALS LTD.', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('16', 'SOLUSCARE', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('17', 'CIPLA(ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('18', 'SUN ONCO TEAM B', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('19', 'DABUR CONSUMAR', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('20', 'SOLUSCARE', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('21', 'DR. REDDY\'S LAB LTD.', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('22', 'EMCURE', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('23', 'SOLVAY PHARMA', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('24', 'ETHICARE REMEDIES', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('25', 'SUN(ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('26', 'FERRING', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('27', 'TABLET INDIA LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('28', 'FRESENIUS KABI', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('29', 'GALDERMA INDIA PVT LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('30', 'TETRAMED BIOTEK PVT LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('31', 'ICPA HEALTH PRODUCTS PVT LTD.', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('32', 'TORRENT (ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('33', 'LUPIN(ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('34', 'TRUE CARE (ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('35', 'MARK REMIDIES PVT LTD.', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('36', 'MEDINN BELLE', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('37', 'UTH HELTHCARE P LTD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('38', 'MEYER(ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('39', 'VIVO LIFE SCIENCES', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('40', 'MSD PHARMACEUTICALS', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('41', 'WOCKHARDT', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('42', 'WYETH CONSUMAR', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('43', 'MUCOS PHARMA', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('44', 'NATCO', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('45', 'NEON(ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('46', 'ZUVENTUS (ALL DIV)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('47', 'NICHOLES PIRAMAL CONSUMAR', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('48', 'NOVARTIS INDIA LTD.', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('49', 'ORCHID(CLASIC)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('50', 'ABBOT PHARMA', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('51', 'ALEMBIC ZENOVI', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('52', 'ABBOT PND', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('53', 'ALKEM(ACE)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('54', 'ABOTT PPD', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('55', 'ABBOTT LENBROOK', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('56', 'ABBOTT LENBROOK', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('57', 'ABBOTT HEPATIC CARE', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('58', 'AKUMENTIS CREATIS', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('59', 'HEALTHCARE', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('60', 'AKUMENTIS HEALTHCARE', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('61', 'AARYAMAN MEDIHEALTH', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('62', 'ABBOTT MAGNUS', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('63', 'ALKEM(BERGEN ZURIEVE)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('64', 'ABBOT(GENERAL CARE)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('65', 'AKUMENTIS INSPIRIS', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('66', 'ALKEM(BERGEN)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('67', 'ABBOTT NOVO NORDIS', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('68', 'ALEMBIC SUMMIT', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('69', 'ALKEM(COSMOKEM)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('70', 'ALKEM(CYTOMED)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('71', 'ALKEM(NEURO SCIENCES)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('72', 'ALKEM (MEDIVA)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('73', 'ALKEM(DERMA CARE)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('74', 'ALKEM(HOSPICARE)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('75', 'ALKEM(PENTACARE)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('76', 'ALKEM(DERMA CARE)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('77', 'ALKEM(ULTICARE)', 'ACTIVE');
INSERT INTO `companymaster` VALUES ('78', 'SCHEDULE H1', 'ACTIVE');

-- ----------------------------
-- Table structure for `countercollection`
-- ----------------------------
DROP TABLE IF EXISTS `countercollection`;
CREATE TABLE `countercollection` (
  `countersale_date` date NOT NULL,
  `counter_totalcollection` int(200) NOT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of countercollection
-- ----------------------------
INSERT INTO `countercollection` VALUES ('2014-06-02', '40', 'ACTIVE');
INSERT INTO `countercollection` VALUES ('2014-06-06', '104', 'ACTIVE');
INSERT INTO `countercollection` VALUES ('2014-06-13', '1000', 'ACTIVE');
INSERT INTO `countercollection` VALUES ('2014-06-19', '3400', 'ACTIVE');
INSERT INTO `countercollection` VALUES ('2014-06-26', '3420', 'ACTIVE');

-- ----------------------------
-- Table structure for `countersalesdata`
-- ----------------------------
DROP TABLE IF EXISTS `countersalesdata`;
CREATE TABLE `countersalesdata` (
  `Sr_no` int(11) NOT NULL,
  `countersale_date` date NOT NULL,
  `product_name` varchar(200) NOT NULL,
  `product_category` varchar(50) NOT NULL,
  `product_quantity` varchar(30) NOT NULL,
  `perunitprice` varchar(20) NOT NULL,
  `product_totalamount` varchar(20) NOT NULL,
  `counter_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of countersalesdata
-- ----------------------------

-- ----------------------------
-- Table structure for `creditors`
-- ----------------------------
DROP TABLE IF EXISTS `creditors`;
CREATE TABLE `creditors` (
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

-- ----------------------------
-- Records of creditors
-- ----------------------------
INSERT INTO `creditors` VALUES ('3', 'AMRUTRAJ', 'KOLHAPUR', '7276056675', '5', '2014-06-09', 'Partial Payment', '2096.0', '100.0', '1900.0', 'ACTIVE');

-- ----------------------------
-- Table structure for `customer_cashpay`
-- ----------------------------
DROP TABLE IF EXISTS `customer_cashpay`;
CREATE TABLE `customer_cashpay` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_cashpay
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_info`
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `customer_id` int(100) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(300) NOT NULL,
  `customer_address` varchar(500) NOT NULL,
  `customer_gender` varchar(300) NOT NULL,
  `customer_age` varchar(300) NOT NULL,
  `customer_contactnumber` varchar(500) NOT NULL,
  `customer_docname` varchar(300) NOT NULL,
  `customerstatus` varchar(20) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES ('1', 'SA', 'DS', 'Male', '12', '4545454545', 'ASDFSDA', 'ACTIVE');
INSERT INTO `customer_info` VALUES ('2', 'CUSTOMER', 'CUS	', 'Male', '100', '13215464654', 'DICTO', 'ACTIVE');

-- ----------------------------
-- Table structure for `damage_stock`
-- ----------------------------
DROP TABLE IF EXISTS `damage_stock`;
CREATE TABLE `damage_stock` (
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

-- ----------------------------
-- Records of damage_stock
-- ----------------------------
INSERT INTO `damage_stock` VALUES ('1', '1', '2014-05-24', '2014-05-24', 'asdf', 'QQQQ', 'QQQQ', '9876546310', 'Write-Off', '20', '10', '10', '		', 'ACTIVE');
INSERT INTO `damage_stock` VALUES ('2', '3', '2014-06-02', '2014-06-02', 'crosin', 'SERVICE ENGG', 'PUNE	', '1021211', 'Other', '60', '20', '40', 'asfdsafdsa', 'ACTIVE');

-- ----------------------------
-- Table structure for `debtors`
-- ----------------------------
DROP TABLE IF EXISTS `debtors`;
CREATE TABLE `debtors` (
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

-- ----------------------------
-- Records of debtors
-- ----------------------------
INSERT INTO `debtors` VALUES ('6', 'Amrutraj', '2', '2014-05-27', 'Cheque', '780', '500', '280.0', 'ACTIVE');
INSERT INTO `debtors` VALUES ('12', 'SERVICE ENGG', '3', '2014-06-02', 'Cash', '40', '20', '20', 'ACTIVE');

-- ----------------------------
-- Table structure for `distributors_details`
-- ----------------------------
DROP TABLE IF EXISTS `distributors_details`;
CREATE TABLE `distributors_details` (
  `distributors_id` int(100) NOT NULL AUTO_INCREMENT,
  `distributors_name` varchar(300) DEFAULT NULL,
  `distributors_address` varchar(500) DEFAULT NULL,
  `distributors_officeno` varchar(25) DEFAULT NULL,
  `distributors_mobileno` varchar(25) DEFAULT NULL,
  `distributors_email` varchar(150) DEFAULT NULL,
  `distributors_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`distributors_id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of distributors_details
-- ----------------------------
INSERT INTO `distributors_details` VALUES ('1', 'DARSHAN MEDICAL', 'PUNE	', '02022241552', '2014446522', 'snaket@gmail.com', 'DEACTIVE');
INSERT INTO `distributors_details` VALUES ('2', 'AMIT MEDICO', 'PUNE', 'NA', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('3', 'NEW AMAR AGENCY', 'PUNE	', '24490197', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('4', 'AVANTI DISTRBUTORS ', 'PUNE', 'NA', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('5', 'ARJAS MEDICAL DISTRIBUTORS', 'PUNE', '24495625', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('6', 'ACME ENTERPRISES', 'PUNE	', '24485813', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('7', 'ATUL MEDICALS', 'PUNE', '24485678', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('8', 'ARIHANT MEDICO', 'PUNE	', '24476235', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('9', 'APTE PHARMA', 'PUNE	', '24474604', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('10', 'ANAND MEDICAL DISTRIBUTORS', 'PUNE', '24478067', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('11', 'ASWAM & CO', 'PUNE', '24671606', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('12', 'AMBIKA DISTRIBUTORS', 'PUNE', '24452571', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('13', 'BALAJI ENTERPRISES', 'PUNE', '24670015', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('14', 'ANAND ENTERPRISES', 'PUNE', '24470330', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('15', 'AMOL DISTRIBUTORS', 'PUNE', '24486437', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('16', 'AMIT MEDICO', 'PUNE', 'NA', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('17', 'BALAJI DISTRIBTORS', 'PUNE', '24679961', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('18', 'BALAJI ENTERPRISES', 'PUNE	', '23833487', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('19', 'NEW AMARAGENCY', 'PUNE', '24450197', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('20', 'AVANTI DISTRIBUTORS', 'PUNE', 'NA', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('21', 'CHANDULAL. R. MEHTA', 'PUNE	', '24475010', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('22', 'ACME ENTERPRISES', 'PUNE', '24485813', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('23', 'CHANDAN PHARAMCEUTICALS', 'PUNE', '24475766', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('24', 'C. T. DISTRIBUTORS', 'PUNE', '24484721', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('25', 'ARSHANT MEDICO', 'PUNE', '24476325', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('26', 'CHOICE MEDICO', 'PUNE	', '24475218', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('27', 'APTE PHARMA', 'PUNE', '24474604', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('28', 'AMAR DISTRIBUTORS', 'PUNE', '24466440', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('29', 'DIAMOND DRUG STROES', 'PUNE	', '24430486', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('30', 'ASWAM & CO', 'PUNE', '24471606', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('31', 'DEEPA CORPORATION', 'PUNE	', '24472760', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('32', 'D. K. ENTERPRISES', 'PUNE	', '24489231', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('33', 'BALAJI ENTERPRISES', 'PUNE', '24470015', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('34', 'BALAJI DISTRIBUTORS', 'PUNE', '24479961', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('35', 'DATTA MEDICALS', 'PUNE', '24477279', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('36', 'BHAWANI ENTERPRISES', 'PUNE', '24433487', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('37', 'DATTA AGENCY', 'PUNE', '24461073', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('38', 'CHANDULALR MEHTA', 'PUNE', '24475019', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('39', 'CHANDAN PHARMACEUTICALS', 'PUNE', '24475766', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('40', 'NITIN DISTRIBUTORS (SURIGCALS)', 'PUNE', '24490211', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('41', 'C.T.DISTRIBUTORS', 'PUNE', '24484721', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('42', 'NOOTAN PHARMA', 'PUNE', '24466433', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('43', 'CHOICE MEDICO', 'PUNE', '24475219', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('44', 'NIHAL TRADING', 'PUNE	', '26816650', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('45', 'NEELU & CO', 'PUNE', '24494340', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('46', 'DIAMOND DRUG STORES', 'PUNE', '24430486', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('47', 'OSWAL ENTERPRISE', 'PUNE', '24463965', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('48', 'OMKAR ENTERPRISE', 'PUNE	', '24493563', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('49', 'KALE  PHARMA', 'PUNE', '24474758', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('50', 'PHARMA MARK', 'PUNE	', '24473520', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('51', 'K.D.P.SURGICALS', 'PUNE', '26120258', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('52', 'PEEYU DISTRIBUTORS', 'PUNE', '24478719', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('53', 'KANCHAN DURGS PVT.LTD', 'PUNE', '24452017', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('54', 'POOJA AGENCY', 'PUNE	', '24473838', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('55', 'KAPILA', 'PUNE', '24475201', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('56', 'KUNDAN DISTRIBUTORS', 'PUNE', '24473604', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('57', 'PADMASHREE MEDICAL DIST.', 'PUNE	', '24470137', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('58', 'KOHINOOR PHARMA', 'PUNE', '24487565', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('59', 'PRASAD DISTRIBUTORS ', 'PUNE', '24461400', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('60', 'KESARIYAAGENCY', 'PUNE', '24473108', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('61', 'LAGHATE PHARMACEUTICALS', 'PUNE', '24485947', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('62', 'PRASAD DISTRIBUTORS ', 'PUNE', '24436192', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('63', 'MEENA PHARMACEUTICALS', 'PUNE', '24456781', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('64', 'PRASAD DISTRIBUTORS ', 'PUNE', '24461400', 'NA', 'NA', 'DEACTIVE');
INSERT INTO `distributors_details` VALUES ('65', 'MEDEECO DISTRIBUTORS', 'PUNE', '24473398', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('66', 'PRASHANTI ENTERPRISES', 'PUNE', '24472456', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('67', 'MAJITHIA MEDICAL STORES', 'PUNE', '24473358', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('68', 'MAJITHIAAGENCY', 'PUNE', '24475082', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('69', 'PRAKASH PHARMA', 'PUNE ', '24436192', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('70', 'MAHARASHTRA DISTRIBUTORS', 'PUNE', '24457026', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('71', 'PRAKASH DISTRIBUTORS', 'PUNE', '24478553', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('72', 'MODERN DISTRIBUTORS  ', 'PUNE	', '24450057', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('73', 'PHARMA CHEM', 'PUNE', '26444500', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('74', 'MADANE SURGICALS', 'PUNE	', '25535090', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('75', 'PRADHIM MEDICO', 'PUNE	', '24470129', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('76', 'PHARMA LINK', 'PUNE', '24485665', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('77', 'PANKAJ PHARMA', 'PUNE	', '24470521', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('78', 'MAHENDRA DISTRIBUTORS', 'PUNE	', '24473899', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('79', 'DARSHAN MEDICAL DIST.', 'PUNE	', '24473265', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('80', 'MAYUR MEDICAL AGENCIES', 'PUNE', '24478123', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('81', 'EITHICAL AGENCY', 'PUNE	', '24473063', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('82', 'MAHALAXMI PHARMA', 'PUNE', '24482321', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('83', 'GUJAR & CO.', 'PUNE	', '24473001', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('84', 'NITIN AGENCY', 'PUNE', '24471671', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('85', 'NEW GUJAR PHARAMCEUTICALS', 'PUNE	', '24476178', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('86', 'POOJAAGENCY', 'PUNE', '24473838', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('87', 'HIRALAL MEHTA & CO', 'PUNE	', '24454320', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('88', 'HARIKRUPA ENTERPRISES', 'PUNE	', '24451118', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('89', 'PADMASHREE MEDICAL DIST', 'PUNE', '24470137', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('90', 'INPHARMA', 'PUNE	', '25535897', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('91', 'PRASAD DISTRIBUTORS', 'PUNE	', '24461400', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('92', 'PHARMDEAL', 'PUNE', '24488999', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('93', 'JEEVAN MEDISALES PVT. LTD. ', 'PUNE	', '24091994', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('94', 'KALE PHARMA', 'PUNE', '24476788', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('95', 'PRASHANTIENTERPRISES', 'PUNE', '24472456', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('96', 'PRAKASH DISTRIBUTORS', 'PUNE	', '24478553', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('97', 'K. D. B SURGICALS', 'PUNE	', '24452017', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('98', 'KAPILA', 'PUNE	', '24475201', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('99', 'PRAKASH PHARMA', 'PUNE	', '24456192', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('100', 'KUNDAN DISTRIBUTORS', 'PUNE	', '24473604', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('101', 'PHARMA CHEM', 'PUNE	', '25444500', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('102', 'KOHINOOR PHARMA', 'PUNE	', '24487565', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('103', 'PRADHIM MEDICO', 'PUNE	', '24470129', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('104', 'KESARIYA AGENCY', 'PUNE	', '24473108', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('105', 'PHARMALINK', 'PUNE	', '24485665', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('106', 'PANAKJ PHARMA', 'PUNE	', '24470519', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('107', 'LAGHATE PHARMACEUTICALS', 'PUNE	', '24485947', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('108', 'MEENA PHARMACEUTICALS', 'PUNE	', '24485947', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('109', 'PREMIER DISTRIBUTORS', 'PUNE	', '24451544', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('110', 'MEDEECO DISTRIBUTORS', 'PUNE	', '24473398', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('111', 'RAVI MEDICO', 'PUNE	', '24491282', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('112', 'ROHIT ENTERPRISES', 'PUNE	', '24474028', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('113', 'MAJITHIA MEDICAL STORES', 'PUNE	', '24473358', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('114', 'MAJITHIA AGNCY', 'PUNE	', '24475082', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('115', 'RAHUL MEDICO', 'PUNE	', '24479461', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('116', 'SENIOR AGENCY', 'PUNE	', '24478910', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('117', 'RAJAN DRUG HOUSE', 'PUNE', '24452625', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('118', 'SHAH MEDICO/MEDICALS', 'PUNE	', '24486722', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('119', 'SHUBH PHARMA(GENERIC)', 'PUNE	', '24476549', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('120', 'SHAH ENTERPRISES', 'PUNE	', '24472616', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('121', 'SHREERAM ENTERPRISES', 'PUNE	', '24482021', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('122', 'SANJAY DISTRIBUTORS', 'PUNE	', '24477721', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('123', 'SHARP ENTERPRISES', 'PUNE	', '24472341', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('124', 'SHREYASH DISTRIBUTORS', 'PUNE	', '24478077', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('125', 'SANDESH ENTERPRISES', 'PUNE	', '24671973', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('126', 'SARIKA ENTERPRISES', 'PUNE	', '26688479', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('127', 'S. B. JOSHI & CO', 'PUNE	', '24672865', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('128', 'SWASTIK MEDICAL STORES', 'PUNE	', '24479536', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('129', 'TAPADIYA DISTRIBUTORS', 'PUNE	', '24478599', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('130', 'TRIPATHI & CO', 'PUNE	', '24479257', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('131', 'VINAYAK AGENCY', 'PUNE	', '24475041', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('132', 'VISHAL ENTERPRISES', 'PUNE	', '24461721', 'NA', 'NA', 'ACTIVE');
INSERT INTO `distributors_details` VALUES ('133', 'YASH PHARMA', 'PUNE	', '24476235', 'NA', 'NA', 'ACTIVE');

-- ----------------------------
-- Table structure for `employee_info`
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info` (
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employee_info
-- ----------------------------
INSERT INTO `employee_info` VALUES ('1', 'EMPLOYEE', '7894561230', '2014-01-01', 'EGW	', 'pune', 'Male', 'A+', '10', 'EGE2@SF.SDF', 'ACTIVE');

-- ----------------------------
-- Table structure for `expiry_info`
-- ----------------------------
DROP TABLE IF EXISTS `expiry_info`;
CREATE TABLE `expiry_info` (
  `Expiry_product_id` varchar(10) DEFAULT NULL,
  `Product_name` varchar(100) NOT NULL,
  `Quantity` varchar(10) NOT NULL,
  `mgf_date` varchar(20) NOT NULL,
  `Expiry_date` varchar(20) NOT NULL,
  `Expiry_Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of expiry_info
-- ----------------------------

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_status` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', 'admin', 'admin', 'ACTIVE');
INSERT INTO `login` VALUES ('2', 'user', 'user', 'DEACTIVE');

-- ----------------------------
-- Table structure for `material_inward_info`
-- ----------------------------
DROP TABLE IF EXISTS `material_inward_info`;
CREATE TABLE `material_inward_info` (
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

-- ----------------------------
-- Records of material_inward_info
-- ----------------------------
INSERT INTO `material_inward_info` VALUES ('1', '2014-05-24', '1', '2014/5/24', '25', 'QQQQ', 'asdf', 'Tablet', '10', '10', '10', '5%', '10', '100', '2014-01-01', '20654', 'ACTIVE', 'testing');
INSERT INTO `material_inward_info` VALUES ('2', '2014-05-27', '2', '2014/5/27', '10', 'Amrutraj', 'combiflam', 'Tablet', '200', '78', '278', '5%', '10', '780', '201-041', '2001-41', 'ACTIVE', 'asdfdf	');
INSERT INTO `material_inward_info` VALUES ('3', '2014-06-02', '9', '2014/6/2', '10', 'SERVICE ENGG', 'crosin', 'asf', '50', '20', '70', '5%', '2', '40', '2014-01-01', '2014-05-05', 'ACTIVE', 'hjhjkhjkhjkh');

-- ----------------------------
-- Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `distributors_id` int(100) DEFAULT NULL,
  `distributor_name` varchar(100) DEFAULT NULL,
  `companyname` varchar(100) DEFAULT NULL,
  `product_name` varchar(300) DEFAULT NULL,
  `product_batchno` varchar(300) DEFAULT NULL,
  `product_category` varchar(50) DEFAULT NULL,
  `product_manfdate` varchar(300) DEFAULT NULL,
  `product_expdate` varchar(300) DEFAULT NULL,
  `product_min` int(20) DEFAULT NULL,
  `product_max` int(20) DEFAULT NULL,
  `product_rateperunit` int(20) DEFAULT NULL,
  `totalstock` varchar(100) DEFAULT NULL,
  `col` varchar(20) DEFAULT NULL,
  `row` varchar(20) DEFAULT NULL,
  `product_vat` varchar(20) DEFAULT NULL,
  `Actual_price` int(10) DEFAULT NULL,
  `product_description` varchar(500) DEFAULT NULL,
  `productstatus` varchar(20) DEFAULT NULL,
  `dateofcreation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=914 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'CRINA 20 ', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('2', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'ADIZA', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('3', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'EPILEX 200 TAB', '0', 'TABLET', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('4', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CELEX OD 500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('5', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE GEL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('6', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'EPLIEX 500 TAB', '0', 'TABLET', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('7', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMA GEL', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('8', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'CRINA 20', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('9', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMA HEP', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('10', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMADIAT DUO', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('11', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'CYCLOSET-SY', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('12', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMADIATE', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('13', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMAFFIN (MF)', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('14', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'CYCLOSET-TM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('15', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMAFFIN (WHITE)', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('16', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE GEL(MF)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('17', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'FOLINAL', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('18', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMAFFIN (WHITE)', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('19', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'FOLINAL PLUS', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('20', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMAFFIN  MIXED FRUI', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('21', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE GEL(OR)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('22', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'FOLIRIPE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('23', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMAFFIN  PLUS', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('24', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE GEL(ORNG)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('25', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CERMAFFIN  10MG  TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('26', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'EPILEX CHRONO 200MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('27', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 100', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('28', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE GEL(PINK)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('29', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'FLDICET', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('30', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE GEL(STRWABRY)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('31', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 100 INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('32', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'EPILEX CHRONO 300MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('33', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'ELDICET ENTAMIZOL PLUS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('34', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'EPILEX CHRONO 500MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('35', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 200', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('36', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE GEL MF 100ML', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('37', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'GANATON 50 MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('38', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 200 INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('39', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'EPTION 300 ER', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('40', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'GANATON  OD', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('41', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 200 SR', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('42', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'GANATON  TOTAL', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('43', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 300', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('44', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'CUPEN 500', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('45', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 300 SR', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('46', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 400', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('47', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE TAB(MINT)9*', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('48', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'GESTOFIT 400 SR', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('49', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'EPTION 50 MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('50', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE TAB(MF)9*', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('51', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'HARMONY', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('52', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'KLACID IV 500MG', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('53', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'HARMONY F', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('54', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE TAB(OR)', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('55', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'PANKREOFLAT', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('56', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE TAB ASSORTED', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('57', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'ULCIKIT', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('58', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'LACTONIC 200GM GRA', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('59', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE TAB DANGLER', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('60', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'ENSURE POWDER (VANILA)', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('61', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'MEGAMOM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('62', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'ENSURE POWDER (CHOCOLATE)', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('63', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'EPTION INJ 2 ML', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('64', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'OVIGYN 2000 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('65', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'ENSURE VANILLA 1KG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('66', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'OVIGYN 5000 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('67', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE TAB PUDINA/JEERA', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('68', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'EPTOIN SUSPENSION', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('69', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'OVIGYN D', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('70', '16', 'AMIT MEDICO', 'ABBOT PHARMA', 'ENSURE VANILLA 53.4GM', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('71', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE TAB SUGAR FREE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('72', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'RICHAR - XT', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('73', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'EPTOIN TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('74', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'RICHAR - XT INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('75', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DIGENE TOTAL', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('76', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'GLUCERNA SR VANILLA', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('77', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'RICHAR - XT SUP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('78', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'LEVILEX 250', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('79', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'KINETONE ADVANCE', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('80', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'GLUCERNA SR VANILLA', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('81', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'LEVILEX 500', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('82', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'VEHYCAL', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('83', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'ISOMIL', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('84', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'LEVILEX 750', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('85', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'NAUSIDOME SUSPENSION', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('86', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'LEVILEX INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('87', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'MAMAS BEST CHOCOLATE', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('88', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'LEVILEX SYRUP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('89', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'NAUSIDOME TABLETS', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('90', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'YUTOPAR INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('91', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'LEVILEX XR 1000', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('92', '133', 'YASH PHARMA', 'ALEMBIC ZENOVI', 'YUTOPAR TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('93', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'PROTUSSA ', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('94', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'LEVILEX XR 500', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('95', '16', 'AMIT MEDICO', 'ABBOT PND', 'ENSURE POWDER(VANILLA)', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('96', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'LEVILEX  XR 750', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('97', '16', 'AMIT MEDICO', 'ABBOT PND', 'ENSURE POWDER(CHOCOLATE)', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('98', '16', 'AMIT MEDICO', 'ABBOT PND', 'ENSURE VANILA 1KG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('99', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'SACCHARIN 500\'S', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('100', '16', 'AMIT MEDICO', 'ABBOT PND', 'ENSURE VANILA 53.4GM', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('101', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'PROTHIADEN 25MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('102', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'PROTHIADEN 50', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('103', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'SURBEX OSTEO', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('104', '16', 'AMIT MEDICO', 'ABBOT PND', 'GLUCENA SR VANILA ', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('105', '16', 'AMIT MEDICO', 'ABBOT PND', 'GLUCENA SR VANILA ', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('106', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'PROTHIADEN 50(30)', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('107', '16', 'AMIT MEDICO', 'ABBOT PND', 'ISOMIL', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('108', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'SURBEX XT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('109', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'A TO Z GOLD SOFT', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('110', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'PROTHIADEN 75(30)', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('111', '16', 'AMIT MEDICO', 'ABBOT PND', 'MAMA\'S BEST CHOCOLATE ', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('112', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'PROTHIADEN 75 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('113', '16', 'AMIT MEDICO', 'ABBOT PND', 'MAMA\'S BEST VANILA', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('114', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'PROTHIADEN M', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('115', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DENSIA', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('116', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'ALCIPRO I.V.INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('117', '16', 'AMIT MEDICO', 'ABBOT PND', 'NEPRO HP VANILA', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('118', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DENSIA FORTE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('119', '16', 'AMIT MEDICO', 'ABBOT PND', 'NEPRO LP VANILA', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('120', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'REVILIFE 100MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('121', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'ALERATA 1 GM INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('122', '16', 'AMIT MEDICO', 'ABBOT PND', 'PEDIA COMP CHOC', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('123', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'REVILIFE 50MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('124', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DOLENTIA 50', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('125', '16', 'AMIT MEDICO', 'ABBOT PND', 'PEDIA COMP CHOC 900GM', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('126', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'ALEPRUTTI ', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('127', '16', 'AMIT MEDICO', 'ABBOT PND', 'PEDIA COMP CHOC VANILA', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('128', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'REX XR 250', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('129', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'DOLENTIA TOTAL', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('130', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'ALEPRUTTI (H)', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('131', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'REX XR-500', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('132', '16', 'AMIT MEDICO', 'ABBOT PND', 'PEDIASURE CHOC-TRAL-PAC', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('133', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'BELOSIX 40 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('134', '16', 'AMIT MEDICO', 'ABBOT PND', 'PEDIASURE VANI-TRAL-PAC', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('135', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'FOLIACT N', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('136', '16', 'AMIT MEDICO', 'ALEMBIC ZENOVI', 'ZOLFRESH 10 MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('137', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'BELOSIX 80 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('138', '16', 'AMIT MEDICO', 'ABBOT PND', 'PEDIASURE VANILLA 900GM', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('139', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'GAURDPILL', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('140', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'CILAXTER 250 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('141', '16', 'AMIT MEDICO', 'ABBOT PND', 'PROSURE ORANGE', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('142', '16', 'AMIT MEDICO', 'ABBOT PND', 'SIMILAC1', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('143', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'CILAXTER 500 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('144', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'CLAVAM -XR', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('145', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'HI-D', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('146', '16', 'AMIT MEDICO', 'ABOTT PPD', 'LUCRPIN DEPOT 11.25', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('147', '16', 'AMIT MEDICO', 'ABOTT PPD', 'LUCRPIN DEPOT 3.75', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('148', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'DORIKEM 500(H)', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('149', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'IRENTIA PLUSC', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('150', '16', 'AMIT MEDICO', 'ABOTT PPD', 'SURVANTA', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('151', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'FOSTITOL SYRUP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('152', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'IRENTIA PLUS', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('153', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'ITOPAN CAP', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('154', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'JAUNDIF NASAL DROPS', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('155', '16', 'AMIT MEDICO', 'ABOTT PPD', 'AGLOZYME C SY', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('156', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LINOKEM 600', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('157', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'JOYCLOV', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('158', '16', 'AMIT MEDICO', 'ABOTT PPD', 'AGLOZYME CAPS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('159', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LINOKEM  IV 600', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('160', '16', 'AMIT MEDICO', 'ABOTT PPD', 'AGLOZYME  SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('161', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LINOKEM  IV 600 (H)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('162', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'JOYCLAV DRY SYP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('163', '16', 'AMIT MEDICO', 'ABOTT PPD', 'AZIPOS -250 MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('164', '16', 'AMIT MEDICO', 'ABBOTT LENBROOK', 'OMACOR 1000MG', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('165', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LARSUMO-4 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('166', '16', 'AMIT MEDICO', 'ABOTT PPD', 'AZIPOS -500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('167', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'OMESTAR', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('168', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LARSUMO-8 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('169', '16', 'AMIT MEDICO', 'ABOTT PPD', 'B-N-C CAP', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('170', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LARSUMO-8 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('171', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'OMESTAR D', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('172', '16', 'AMIT MEDICO', 'ABOTT PPD', 'B-N-C SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('173', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LARSUMO FORTE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('174', '16', 'AMIT MEDICO', 'ABOTT PPD', 'B-N-C SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('175', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'STARMUNE', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('176', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LARSUMO MR-4', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('177', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'STARMUNE SYRUP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('178', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LARSUMO MR-8', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('179', '16', 'AMIT MEDICO', 'ABOTT PPD', 'CIFOMED 250 MG TABS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('180', '16', 'AMIT MEDICO', 'ABOTT PPD', 'CIFOMED 350 MG TABS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('181', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'LARSUMO SR', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('182', '16', 'AMIT MEDICO', 'ORCHID(CLASIC)', 'STARMUNE-I', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('183', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'MOVACE MR-4', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('184', '16', 'AMIT MEDICO', 'ABOTT PPD', 'CIFOMED TZ 1*10', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('185', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'MOVACE MR-8', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('186', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'MOVACE P', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('187', '16', 'AMIT MEDICO', 'ABBOTT HEPATIC CARE', 'HEPTRAL 400MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('188', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'MOVACE SP', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('189', '16', 'AMIT MEDICO', 'ABOTT PPD', 'GATOMED 200', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('190', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'NEWTAP 100', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('191', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'NEWTAP 50', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('192', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'NEWTAP 75', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('193', '16', 'AMIT MEDICO', 'ABOTT PPD', 'GLOBIRON CAPSULES', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('194', '16', 'AMIT MEDICO', 'ABOTT PPD', 'GLOBIRON SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('195', '16', 'AMIT MEDICO', 'AKUMENTIS CREATIS', 'ADOVA', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('196', '16', 'AMIT MEDICO', 'ABOTT PPD', 'GLOBIRON XT', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('197', '16', 'AMIT MEDICO', 'AKUMENTIS CREATIS', 'I-FAG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('198', '16', 'AMIT MEDICO', 'ABOTT PPD', 'GLOBIRON XT SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('199', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'NOVOCRYPT 0.25 INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('200', '16', 'AMIT MEDICO', 'AKUMENTIS CREATIS', 'XFERT-F', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('201', '16', 'AMIT MEDICO', 'ABOTT PPD', 'GLOBIRON  Z SY', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('202', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'NOVOCRYPT 0.5 ML', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('203', '16', 'AMIT MEDICO', 'ABOTT PPD', 'INSTACODIN SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('204', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'OXUM SOLUTION', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('205', '16', 'AMIT MEDICO', 'ABOTT PPD', 'INSTACODIN COLD', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('206', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'OXUM SOLUTION (H)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('207', '16', 'AMIT MEDICO', 'ABOTT PPD', 'INSTACODIN  COLD SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('208', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'PAN 20 (H)', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('209', '16', 'AMIT MEDICO', 'ABOTT PPD', 'INSTACODIN  D SYP.', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('210', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'PAN 20 TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('211', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'PAN 40 TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('212', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'ACER', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('213', '16', 'AMIT MEDICO', 'ABOTT PPD', 'INSTACODIN  EXPECTORANT', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('214', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'PAN L', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('215', '16', 'AMIT MEDICO', 'ABOTT PPD', 'INSTACODIN  -P SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('216', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'PRAZOLE 40', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('217', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'PROWEL ', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('218', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'AKUTIM EYE DROP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('219', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'PROWEL DRY SYP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('220', '16', 'AMIT MEDICO', 'ABOTT PPD', 'LEMED 250 MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('221', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'PRAZOLE D', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('222', '16', 'AMIT MEDICO', 'ABOTT PPD', 'LEMED 500 MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('223', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'AKUVITIS  EYE DROPS', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('224', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'ZIBACT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('225', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'ZIME 200', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('226', '16', 'AMIT MEDICO', 'ABOTT PPD', 'LIZOMED 600 MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('227', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'ALIVHER', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('228', '16', 'AMIT MEDICO', 'ABOTT PPD', 'LIZOMED DRY SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('229', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'ALL9', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('230', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'ZOLFRESH 5MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('231', '16', 'AMIT MEDICO', 'ABOTT PPD', 'NUTAXIN 1G INJ', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('232', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'ARGENTA', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('233', '16', 'AMIT MEDICO', 'ABOTT PPD', 'OFLAMED 200 MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('234', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'PROWEL SACHET', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('235', '16', 'AMIT MEDICO', 'ABOTT PPD', 'OFLAMED OZ SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('236', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'SUMP-SPAS', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('237', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'SEFTIZONE 1 GM', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('238', '16', 'AMIT MEDICO', 'ABOTT PPD', 'OFLAMED TZ ', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('239', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TAXCLAV 100 DT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('240', '16', 'AMIT MEDICO', 'ABOTT PPD', 'OFLAMED-OZ', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('241', '16', 'AMIT MEDICO', 'ABOTT PPD', 'PANCEF 100 DT', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('242', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TAXCLAV 100 TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('243', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'DOLENTIA AQ INJ', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('244', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TAXCLAV 200 TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('245', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'BETONIN XT', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('246', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'DOLENTIA AQ INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('247', '16', 'AMIT MEDICO', 'ABOTT PPD', 'PANCEF O DRY SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('248', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TAXCLAV 50 DT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('249', '16', 'AMIT MEDICO', 'ABOTT PPD', 'PANCEF O 100', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('250', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TAXCLAV DRY SYP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('251', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'DIGECT 30 ', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('252', '16', 'AMIT MEDICO', 'ABOTT PPD', 'PANCEF O 200 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('253', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'HYTRIN 1 MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('254', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TAXIM -O 400', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('255', '16', 'AMIT MEDICO', 'ABOTT PPD', 'PANOPAZ D', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('256', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'HYTRIN 2 MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('257', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'DURAJECT 60', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('258', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TRINERVE', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('259', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'HYTRIN 5 MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('260', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TRINERVE CAP (H)', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('261', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TRINERVE FORTE', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('262', '16', 'AMIT MEDICO', 'ABOTT PPD', 'TROXY A', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('263', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TRINERVE FORTE', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('264', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'LEPTTOS 10', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('265', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'FORCIGRA', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('266', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'LEPOTS 15 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('267', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'TRINERVE INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('268', '16', 'AMIT MEDICO', 'ABOTT PPD', 'CLAVENITA 1.5 GM', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('269', '16', 'AMIT MEDICO', 'ABOTT PPD', 'CLAVENITA 250', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('270', '16', 'AMIT MEDICO', 'ABOTT PPD', 'CLAVENITA 500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('271', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'OBIGLO MD 0.2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('272', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'IRENTIA -S', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('273', '16', 'AMIT MEDICO', 'ALKEM(ACE)', 'XONE XP 1.125 GM', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '	', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('274', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'OBGLO MD 0.3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('275', '16', 'AMIT MEDICO', 'ABOTT PPD', 'CLAVENITA  CEF 750', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('276', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'LAFTY', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('277', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'OBIMET ', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('278', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'MASTERCLAV', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('279', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'OBIMET  GX 1 FORTE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('280', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'MASTERTAZ 1 GM', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('281', '16', 'AMIT MEDICO', 'ABBOTT MAGNUS', 'OBIMET  GX 1 FORTE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('282', '16', 'AMIT MEDICO', 'ABOTT PPD', 'DOLENTIA MR', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('283', '16', 'AMIT MEDICO', 'ABOTT PPD', 'DOLENTIA  RELAX GEL', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('284', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'NO DRY EYE DROPS', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('285', '16', 'AMIT MEDICO', 'ABOTT PPD', 'DOLENTIA  SR-100', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('286', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'NO DRY LIQUIGEL EYE DROPS', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('287', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'OBIMET  GX 2 FORTE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('288', '16', 'AMIT MEDICO', 'ABOTT PPD', 'MASTER 250MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('289', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'OBIMET  GX1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('290', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'AGOPRIDE', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('291', '16', 'AMIT MEDICO', 'ABOTT PPD', 'NEWBONA', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('292', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'OBIMET  GX2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('293', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'NTN 10 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('294', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'AGOPRIDE 1MG', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('295', '16', 'AMIT MEDICO', 'ABOTT PPD', 'NEWBONA ONE IV', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('296', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'NTN 200 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('297', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'OBIMET  SR 1000 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('298', '16', 'AMIT MEDICO', 'ABOTT PPD', 'NEWBONA  PLUS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('299', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'CARNIMED PLUS', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('300', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'NTN 25 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('301', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'NTN 50 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('302', '16', 'AMIT MEDICO', 'ABOTT PPD', 'REPESA', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('303', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'DROTANIC- M', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('304', '16', 'AMIT MEDICO', 'ABOTT PPD', 'REPESA D', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('305', '16', 'AMIT MEDICO', 'ALKEM(BERGEN ZURIEVE)', 'FEFAZIN XT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('306', '16', 'AMIT MEDICO', 'ABOTT PPD', 'STARMUNE OS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('307', '16', 'AMIT MEDICO', 'ABOTT PPD', 'UROSTAT', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('308', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'SECURE 100', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('309', '16', 'AMIT MEDICO', 'ABOTT PPD', 'UROSTAT 40', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('310', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'SECURE 200', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('311', '16', 'AMIT MEDICO', 'ABOTT PPD', 'UROSTAT N', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('312', '16', 'AMIT MEDICO', 'AARYAMAN MEDIHEALTH', 'STARMUNE GOLD', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('313', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'OBIMET  SR 1000 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('314', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'FEFAZIN XT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('315', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'OBIMET  SR 500', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('316', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'SURBEX GOLD', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('317', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'FEFAZIN XT SUSP', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('318', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYROCAB 10MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('319', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BETONIN SYP 400 ML', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('320', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'FERTIFLAX CAP', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('321', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BETONIN SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('322', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYROCAB 20 (100)', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('323', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUFEN 200', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('324', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYROCAB  20MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('325', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'FOGSY SYRUP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('326', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUFEN 400', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('327', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUFEN 600', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('328', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYROCAB 5MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('329', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUFEN JUNIOR SUSP', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('330', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYROCAB 5MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('331', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'GEMCAL MOM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('332', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUFEN MR', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('333', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUGEL', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('334', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'INDUCENT 150 INJ ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('335', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'INDUCENT 75 INJ ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('336', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUGEL ACTIFAST GEL', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('337', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUSPAZ 4', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('338', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYROCAL D-3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('339', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'BRUSPAZ  8 MG ', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('340', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'LETRO PLUS 2.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('341', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'CEFTIZONE 250', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('342', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM -75 MCG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('343', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'DIGECAIN', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('344', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'CEFTIZONE 500', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('345', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'MAGNACENT -150', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('346', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'MAGNACENT -75', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('347', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 100 MCG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('348', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'DIGEN FASTMELT JEERA', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('349', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'OVSTORE ', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('350', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'DIGEN FASTMELT LEMON', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('351', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'DOLENTIA FORTE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('352', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 112 MCG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('353', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'DIGEN FASTMELT ORANGE', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('354', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'PROFICENT 5000 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('355', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'DOLENTIA GRANULES', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('356', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 12.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('357', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'SPERMIQ CAP', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('358', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 125 MCG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('359', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'DOLENTIA RELAX', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('360', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'ULTIGEST -100 INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('361', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'DOLENTIA Z', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('362', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'ULTIGEST -200', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('363', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 137 MCG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('364', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'ULTIGEST -200 INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('365', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'IRENTIA DROPS', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('366', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 150 MCG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('367', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'IRENTIA SUSP', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('368', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'VESTOVA INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('369', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 25 MCG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('370', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 50 MCG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('371', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'MASTERCLAV DRY SYP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('372', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 62.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('373', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'MASTERPOD 100 DRY SYP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('374', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYRONORM 88MCG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('375', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'THYROWEL', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('376', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'MASTERPOD 100 DT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('377', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'TRIOBIMET 1 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('378', '16', 'AMIT MEDICO', 'ABBOT(GENERAL CARE)', 'TRIOBIMET 2 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('379', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'MASTERPOD 50 DRY SYP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('380', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'PUOCEF', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('381', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ACUFLAM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('382', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ATEMIDE TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('383', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'STARMUNE GOLD SYP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('384', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'BALOXIN', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('385', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'BALOXIN 200', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('386', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'THERMODOL DR', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('387', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'ACTRAPID FLEXPEN', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('388', '16', 'AMIT MEDICO', 'AKUMENTIS INSPIRIS', 'THERMODOL IV', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('389', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'CEFAST 1GM HOSPITAL ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('390', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'ACTRAPID  HUM PENFIL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('391', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'CEFAST 1GM ING', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('392', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'CEFAST XP-1GM ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('393', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'ACTRAPID  HUMAN (H)', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('394', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'CEFAST XP-250', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('395', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'CEFAST XP-500', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('396', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'ACTRAPID NOVOLET 5,S', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('397', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'CEFAST -MAX 1.5', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('398', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'AMLO- PURE 2.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('399', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'GLUCAGON 1 ML', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('400', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'AMLO- PURE 5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('401', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOCORT -1 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('402', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOCORT -6MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('403', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ATECARD 100 MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('404', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOCORT 24', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('405', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'HUMAN MIXTARD 100IU', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('406', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOCORT SUSP', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('407', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ATECARD 25 TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('408', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'HUMAN MIXTARD 40IU', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('409', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOCORT -30MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('410', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ATECARD 50 TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('411', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'HUMAN MIXTARD 50 IU**', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('412', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOFLAM -TP', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('413', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ATECARD D TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('414', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOFLAM -GEL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('415', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ATECARD AM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('416', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOFLAM TABS', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('417', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'INSULATARD(HUM) INJ', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('418', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOFLEX 4', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('419', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ENOLK -2.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('420', '16', 'AMIT MEDICO', 'ALKEM(BERGEN)', 'ENZOFLEX 8', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('421', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'INSULATARD FLEXPEN', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('422', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ENBOLK 5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('423', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ENBOLK F', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('424', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'INSULTARD HM PENFILL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('425', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ETERNEX F', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('426', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'INSULATARD NOVOLET 5\"S', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('427', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ETERNEX 10', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('428', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ETERNEX 20', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('429', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'LEVEMIR FLEXPEN', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('430', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ETERNEX EZ', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('431', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN -1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('432', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'MIXTARD 30 FLEXPEN', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('433', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN -2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('434', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN -3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('435', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN -4', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('436', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'MIXTARD 30 NOVOLET 5,S', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('437', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN -5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('438', '16', 'AMIT MEDICO', 'ABBOTT NOVO NORDIS', 'MIXTARD 30 HM PENFILE', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('439', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN MF FORTE 1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('440', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN MF FORTE 2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('441', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN MF -1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('442', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'MIXTARD 50 HM PENFILE', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('443', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN MF -2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('444', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN PM-1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('445', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'MIXTARD  H M PENFIL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('446', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'GLISEN PM-2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('447', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'MIXTARD HUMAN(H)', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('448', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'METOFIX X 1000MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('449', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVOFINE NEEDLES', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('450', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'METOFIX X 500MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('451', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'OSTEOFIT -C', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('452', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'PIOSIX MF 15 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('453', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVOFINE  30 FLEXPEN', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('454', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'PIOSIX MF 30 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('455', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'PIOSIX MF 15', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('456', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'PIOSIX MF 30', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('457', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVOMIX 50 FLEXPEN', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('458', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVOMIX PENFILL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('459', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'PLAVAS 150 MG', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('460', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'PLAVAS 75', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('461', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'PLAVAS 25', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('462', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'REVAS 25', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('463', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVONORM TAB 0.5MG 30', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('464', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'REVAS 50', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('465', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVONORM TAB 1 MG 30', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('466', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'REVAS AM 2.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('467', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVONORM TAB 2 MG 30', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('468', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'REVAS AM 5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('469', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'REVAS AT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('470', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVOPEN 3', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('471', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVOPEN 4', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('472', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'REVAS H-TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('473', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVORAPID', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('474', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'REVAS R 2.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('475', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVORAPID 100IU', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('476', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'REVAS R 5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('477', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVORAPID @ FLEXPEN', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('478', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ROSAVE 10', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('479', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NOVORAPID PENFILL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('480', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ROSAVE 20', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('481', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ROSAVE 5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('482', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'VICTOZA PEN', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('483', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ROSAVE F-10', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('484', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ROSAVE F-5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('485', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'STRESSCOM CAPS ', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('486', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TELLZY-20', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('487', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TELLZY-40', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('488', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TELLZY-80', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('489', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TELLZY-AM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('490', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TELLZY-H', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('491', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TELLZY-MT 5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('492', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TELLZY-MT 50', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('493', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TELLZY-MT RS', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('494', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TVOGO 0.2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('495', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TVOGO -0.3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('496', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'ENZORIL', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('497', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TVOGO  M-0.2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('498', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NODIMOX 500 DT', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('499', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TVOGO  M-0.3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('500', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL CAPS', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('501', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NODIMOX PLUS 250 DT', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('502', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'VOGO  M-0.3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('503', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL D-3', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('504', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NODIMOX PLUS 500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('505', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL DS-SG', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('506', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NODIMOX PLUS  LB 500 MG CAP', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('507', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL GRO SUSP', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('508', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NULOC 20MG TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('509', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'NULOC D', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('510', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'OLEVON CAPS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('511', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'OLEVON  4 MG TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('512', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'OLEVON  8 MG TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('513', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ONDEM INJECTION 2ML', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('514', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ONDEM INJECTION 4ML', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('515', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ONDEM MD-4', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('516', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ONDEM MD-8', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('517', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ONDEM  SY 30 ML', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('518', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ORGOGARD MOUTH WASH', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('519', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'SOULUFER XT SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('520', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'SOULUFER XT TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('521', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'SOULUFER TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('522', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'SOULUFER  XT INU', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('523', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'SOULUFER  XT INU', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('524', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TAZID ING 1GM', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('525', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'TAZID XP-1.125', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('526', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'UPRISE D3', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('527', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'UPRISE D3-60K', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('528', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'VANCOGEN INU 500MG HOSPITAL', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('529', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'VANCOZINCOCET SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('530', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'VANCOZINCOCET-A SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('531', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 1.5 INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('532', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 1.5 INJ(H)', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('533', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 125 TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('534', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 250 INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('535', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 250 TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('536', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 250 TAB(H)', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('537', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 500 TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('538', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL GRO SUSP', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('539', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 500 TAB(H)', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('540', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 750 INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('541', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL  KIT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('542', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF 750 INJ(H)', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('543', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF CV 500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('544', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF CV 250', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('545', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL  NASAL SPRAY ', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('546', '16', 'AMIT MEDICO', 'ALEMBIC SUMMIT', 'ZOCEF DRY SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('547', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL  NASAL SPRAY(H)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('548', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCAL  SY', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('549', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCERIN', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('550', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCERIN -50', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('551', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMCERIN -G', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('552', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'GEMFOS', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('553', '16', 'AMIT MEDICO', 'ALKEM(COSMOKEM)', 'RENOCIA CONDITIONER', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('554', '16', 'AMIT MEDICO', 'ALKEM(COSMOKEM)', 'RENOCIA SHAMPOO', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('555', '16', 'AMIT MEDICO', 'ALKEM(COSMOKEM)', 'RENOCIA SOLUTION', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('556', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', ' GEMIDRO 150', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('557', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'HYSAM 200', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('558', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'HYSAM 400', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('559', '133', 'YASH PHARMA', 'ALKEM(BERGEN)', 'LEVOZ SYRUP', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('560', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALCRIST 1MG INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('561', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALRUBICIN 100MG', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('562', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALRUBICIN 10MG INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('563', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALRUBICIN 150 INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('564', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALRUBICIN 50MG INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('565', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALTANIB 400', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('566', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALTAXEL 260MG', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('567', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALTAXEL NOVA 100', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('568', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALTAXEL NOVA 250', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('569', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALTAXEL NOVA 260', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('570', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALTAXEL NOVA 30', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('571', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALTAXEL NOVA 300', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('572', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ALTRAZ 1 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('573', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'APRISET 125/80', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('574', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'APRISET KIT 125/80', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('575', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ARSIKEM INJ 10 MG', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('576', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'BIPROSTA 50MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('577', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'CAOETA 500MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('578', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'CARBOKEM 150 INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('579', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'CARBOKEM NOVA 150', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('580', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'CARBOKEM NOVA 450', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('581', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'CARBOKEM NOVA 600', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('582', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'CELGEM 1000MG', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('583', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'CELGEM 200MG', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('584', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'DACAREX 100 MG INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('585', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'DACAREX 200 MG INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('586', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'DACAREX 500 MG INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('587', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ERLOKEM 150', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('588', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'FASTOGRAF 300', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('589', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'FASTOVORIN 50MG INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('590', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'FYTOP 100MG INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('591', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'GLISTROMA 100MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('592', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'GLISTROMA 20', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('593', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'CITISURE 500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('594', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'GLISTROMA 250 MG', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('595', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'CLOBANKEM-10', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('596', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'CLOBANKEM-5', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('597', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'HONDREA 500', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('598', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'EDASURE INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('599', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'GLUCORYL M2-1000MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('600', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'LAMOKEM OD-100', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('601', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'LAMOKEM OD-50', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('602', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'HOMOCHECK CAP', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('603', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'IFOXAN+MESNA INJ.', '0', 'INJ', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('604', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'LEV SR-500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('605', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'INSUMIN FORTE', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('606', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'LEV SR-750', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('607', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'LETROPLUS -2.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('608', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'MIRTAKEM 15', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('609', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'INSUMIN PLUS', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('610', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'MIRTAKEM 30', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('611', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'MIRTAKEM 7.5', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('612', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'JUPIROS 10', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('613', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'NEXVENULA OD-50', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('614', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'OLESOFT PH 5.5 BAR', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('615', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'LIPSOL INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('616', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'JUPIROS 10 (H)', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('617', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'OXRING 150', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('618', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'JUPIROS 20', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('619', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'OLESOFT LOTION', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('620', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'OXRING 300', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('621', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'JUPIROS 20(H)', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('622', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'OLESOFT LOTION(200ML)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('623', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'OXRING OD- 300', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('624', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'LYPHIDOX 10 NJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('625', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'OXRING OD- 600', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('626', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'JUPIROS 5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('627', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'P-THRIN CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('628', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'LYPHIDOX 50 ING', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('629', '16', 'AMIT MEDICO', 'ALKEM(NEURO SCIENCES)', 'PRYNERVE M-75', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('630', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'JUPIROSE F', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('631', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'TERBIKEM 250', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('632', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'TERBIKEM CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('633', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'LARA -SA', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('634', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'MEGAPLAT -100 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('635', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'TITROL OINT', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('636', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'PRYNERVE OD-150', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('637', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'MEGAPLAT -50 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('638', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'LARA 25MG TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('639', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'PRYNERVE OD-75', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('640', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'UVRID LOTION ', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('641', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'LARA 50MG TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('642', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'UVRID NF', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('643', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SKIZOLEV 100', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('644', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ORALOZ -10 TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('645', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SKIZOLEV 25', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('646', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'LARA H', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('647', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SKIZOLEV 50', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('648', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'MAXXIO D-SG', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('649', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'P-CARZINE-50', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('650', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SUPRABENZ 0.25', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('651', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SUPRABENZ 0.50', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('652', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'NEBIPIL 2.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('653', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'TOLKEM', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('654', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'PATIKEM NOVO 10MG', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('655', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'NEBIPIL 5MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('656', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'TRALIN TAB 50 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('657', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'CILAXTER 125 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('658', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'PATIKEM NOVO 50MG', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('659', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'TRALIN TAB 100 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('660', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'NEBIPIL H', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('661', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VERGO 25 TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('662', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'HOSPICASP 50 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('663', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VERGO 75 TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('664', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'HOSPICASP 70 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('665', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'OLKEM 20', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('666', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'REMCYTA 500MG INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('667', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'HOSPICASP B-50 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('668', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VESBAL-16', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('669', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'OLKEM 20-AM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('670', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VESBAL-8', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('671', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'OLKEM 20-H', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('672', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'HOSPITAZ 1000', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('673', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'OLKEM 40', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('674', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'REMTREX 15 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('675', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'OLKEM 40-AM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('676', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'PHENYKEM 100', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('677', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'REMTREX 50 INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('678', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'OLKEM 40-H', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('679', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'REMTREX 500', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('680', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'SWITCH DROPS', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('681', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'ALOKEM BODY WASH', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('682', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'CEHAM INJ-250', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('683', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'RACE -2.5', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('684', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'ZEPCAR 200 CR', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('685', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'CEHAM INJ-250', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('686', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'RACE -5', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('687', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'ZEPCAR 400 CR', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('688', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'CEHAM M', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('689', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'RACE -H 2.5', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('690', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'CEHAM  P', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('691', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'CEHAM  SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('692', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'SOLVENT FOR DOCETAXEL 120MG IN', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('693', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'RACE -H 5 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('694', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'CEHAM  TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('695', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'ACTISPRIN 150', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('696', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'ACTISPRIN 75', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('697', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'CLAYPOD 50 DRY SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('698', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'RANDEAR ER 1000', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('699', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'THALODA 100MG CAP', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('700', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'RANDEAR ER 500', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('701', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'AMLOKEM M-2.5/25', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('702', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DEPAXIL CR 12.5', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('703', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'THALODA 50MG CAP', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('704', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DEPAXIL CR 25', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('705', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'AMLOKEM M-5/25', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('706', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'RAPEED IT', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('707', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'AMLOKEM M-5/50', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('708', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP 10(H)', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('709', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'ANGIBLOC AM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('710', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP 1O MG TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('711', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'SORBACID LIQ', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('712', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'TUBITERE 120MG INJ', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('713', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'ANGIBLOC ER-25', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('714', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP  5 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('715', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'THYROPIL 100 MCG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('716', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'THYROPIL 25 MCG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('717', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'ANGIBLOC ER-H-50', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('718', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP  5  O DT', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('719', '16', 'AMIT MEDICO', 'ALKEM (MEDIVA)', 'THYROPIL 50 MCG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('720', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'TUBITERE NOVA 120', '0', 'VIAL', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('721', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'CILOKEM 100', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('722', '16', 'AMIT MEDICO', 'ALKEM(CYTOMED)', 'ZEFOTIB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('723', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP  5  O DT', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '-', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('724', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'DIBOSET -0.2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('725', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'DIBOSET -0.3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('726', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP 5 MG', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('727', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'ESIA 10 MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('728', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART 20MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('729', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP M', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('730', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP M FORTE', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('731', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'EUCLIDE M TABS', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('732', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART 40 MG TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('733', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'EUCLIDE M TABS', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('734', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'DONEP  SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('735', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART 80', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('736', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART 80 AM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('737', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'EDAKEM INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('738', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'EUCLIDE TABS 40MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('739', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'EUCLIDE TABS 80MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('740', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART 80 H', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('741', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'JOYKEM 100', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('742', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART AM', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('743', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'JOYKEM 50', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('744', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'AL-PTHRIN CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('745', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART H TAB', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('746', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'JOYKEM  SR 200', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('747', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'AL-PTHRIN LOTION', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('748', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'FORMIN P-15', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('749', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELTOLAN 2.5', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('750', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART M-40/25', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('751', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'AL-PTHRIN SOAP', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('752', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELTOLAN 2.5(H)', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('753', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'FORMIN P-30', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('754', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELTOLAN  10 TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('755', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'ALERT -L', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('756', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'TSART M-40-/25', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('757', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'FORMIN PG-1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('758', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELTOLAN  15 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('759', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'FORMIN PG-2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('760', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELTOLAN  20 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('761', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'VASC-F', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('762', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'FORMIN PGL-1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('763', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELTOLAN  7.5', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('764', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'ALOKEM 75 GEL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('765', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'FORMIN PGL-2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('766', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'VOGLIKEM 0.2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('767', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELZAP 0.25 MD', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('768', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'AZENTO -250', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('769', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'FORMIN SR-1000', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('770', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'VOGLIKEM 0.3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('771', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELZAP 0.50 MD', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('772', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'FORMIN SR-500', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('773', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'AZENTO -500', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('774', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'VOGLIKEM M-0.2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('775', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELZAP 1 MG TAB 10', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('776', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GABATA 300', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('777', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MELZAP 2 MD TAB 10', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('778', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'VOGLIKEM M-0.3', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('779', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'BITOZED', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('780', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GABATA PLUS TAB ', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('781', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MIGRABETA A', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('782', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'BITOZED FORTE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('783', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MIGRABETA  PLUS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('784', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GB-LIN M SR 75', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('785', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MIGRABETA  TR-20', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('786', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'CALKEM LOTION', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('787', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MIGRABETA  TR 80', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('788', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GBLIN M-75', '0', 'CAP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('789', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MIGRABETA  TR 40 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('790', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'CALKEM LOTION(100ML)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('791', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'MIGRABETA  TR 60 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('792', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GLUCORYL1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('793', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'NERUROKEM-150', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('794', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GLUCORYL2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('795', '16', 'AMIT MEDICO', 'ALKEM(PENTACARE)', 'NERUROKEM-75', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('796', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'CUTIDERM  CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('797', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GLUCORYL M1', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('798', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GLUCORYL M1 FORTE', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('799', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'DANDROP LOTION', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('800', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GLUCORYL M2', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('801', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'DANDROP LOTION(50ML)', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('802', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GLUCORYL M2 FORTE ', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('803', '16', 'AMIT MEDICO', 'ALKEM(HOSPICARE)', 'GLUCORYL M1-1000MG', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('804', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'DERRIM CREAM ', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('805', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'DERRIM CREAM ', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('806', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NEUROKEM-M', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('807', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NEUROKEM FORTE', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('808', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NEUROKEM  PLUS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('809', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'GLINTRA B GEL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('810', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NEWCITA 10', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('811', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'GLINTRA GEL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('812', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NEWCITA 10(H)', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('813', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'GLINTRA SOAP', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('814', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NEWCITA 5', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('815', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NEWCITA PLUS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('816', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'GLYCOVIRA CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('817', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NOPLAQ AS 75', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('818', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NOPLAQ AS 150', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('819', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NOPLAQ TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('820', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'HOLOSOL CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('821', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'HOLOSOL S', '0', 'SYP', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('822', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'PHENYKEM INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('823', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'RIJ LS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('824', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'RIJ  PLUS', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('825', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'HERPESAFE 200 DT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('826', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SC-TALO 10 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('827', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SC-TALO 5 MG', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('828', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'HERPESAFE 400 DT', '0', 'TAB', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('829', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SEIZLAC 100', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('830', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'SEIZLAC 50', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('831', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'HERPESAFE 5% GEL ', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('832', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'TOPEMA 25', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('833', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'HERPESAFE 800 DT', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('834', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'TOPEMA  50', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('835', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VALKEM OD 1000', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('836', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'KOJIGLO GEL', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('837', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VALKEM OD 250', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('838', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VALKEM OD 500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('839', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VALKEM OD 750', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('840', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'LUMAGLO CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('841', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VALKEM  200 CR TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('842', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VALKEM  300 CR TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('843', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MILGAIN-2ML', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('844', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VALKEM  500 CR TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('845', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MILGAIN-5ML', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('846', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'VALPEX SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('847', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MILGAIN 2%', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('848', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MINOKEM 5%', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('849', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'ZOPENTA ER 12.5', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('850', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MINOKEM 2%', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('851', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'ZOPENTA ER 6.25', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('852', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MINOKEM N 5 %', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('853', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MINOKEM N -2%', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('854', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MINOKEM SPRAY 2%', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('855', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'AMITEX 500 INJ', '', 'INJ', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('856', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MINOKEM SPRAY 5%', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('857', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ABROFYL', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('858', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MOMISOFT CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('859', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ABROFYL SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('860', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'MOMISOFT F CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('861', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ABROFYL M', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('862', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'NADIKEM CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('863', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ALPROVIT GRANULES', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('864', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'OLESOFT CREAM', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('865', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ALPROVIT PLUS SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('866', '16', 'AMIT MEDICO', 'ALKEM(DERMA CARE)', 'OLESOFT LOTION', '0', 'OTHER', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('867', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ALPROVIT POWDER(200 GM)', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('868', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ALPROVIT SY', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('869', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'AMITAX INJ 100', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('870', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'AMITAX INJ 250', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('871', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'AMITAX INJ 500', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('872', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'BROADICLOX CAP 500', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('873', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'BROADICLOX INJ 1 GM', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('874', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'BROADICLOX INJ 500', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('875', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'BROADICLOX  NOVO', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('876', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'CALKARIAA 150', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('877', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'CALKARIAA 300', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('878', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'CLAVPOO 325', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('879', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'CLAVPOO  100 DRY SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('880', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ESOKEM 20', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('881', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ESOKEM 40', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('882', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'ESOKEM D', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('883', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'FEROFAST', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('884', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'FEROFAST SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('885', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'MAGTAM NOVO 1500', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('886', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'MAGTAM  1GM', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('887', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'MAGTAM  O2', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('888', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'MAGTAM  OZ SUS', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('889', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'MAGANOR OZ', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('890', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'MAGANOR OZ SUS', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('891', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'MAGANOR SUSP', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('892', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'MAGANOR TAB', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('893', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'METRON I.V.', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('894', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'METRON TAB 200', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('895', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'NOWORM SY', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('896', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'NOWORM  TAB', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('897', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'NOZUKA', '', 'TAB', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('898', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'NOZUKA AF DROPS', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('899', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'NOZUKA AF SYP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('900', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'NOZUKA NASAL SPRAY', '', 'OTHER', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('901', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'NOZUKA  SYRUP', '', 'SYP', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('902', '16', 'AMIT MEDICO', 'ALKEM(ULTICARE)', 'REVOTAZ 1.125 GM', '', 'VIAL', '', '', '0', '0', '0', '0', '', '', 'None', '0', '', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('903', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'ALPRAZOLAM', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('904', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'BALOFLOXACIN', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('905', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'BUPRENORPHINE', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('906', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'CAPRENORPHINE', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('907', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'CAPREOMYCIN', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('908', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'CEFDINIR', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('909', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'CEFDITOREN', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('910', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'CEFEPIME', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('911', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'CEFETAMET', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('912', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'CEFIXIME', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');
INSERT INTO `product_info` VALUES ('913', '16', 'AMIT MEDICO', 'SCHEDULE H1', 'CEFOPERAZONE', '0', 'H1', '0', '0', '0', '0', '0', '0', '0', '0', 'None', '0', '0', 'ACTIVE', '2014/6/27');

-- ----------------------------
-- Table structure for `purchase_invoice`
-- ----------------------------
DROP TABLE IF EXISTS `purchase_invoice`;
CREATE TABLE `purchase_invoice` (
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

-- ----------------------------
-- Records of purchase_invoice
-- ----------------------------
INSERT INTO `purchase_invoice` VALUES ('2', 'BORA DIST', '1', '1', '2014-05-13', '2', '2014/5/13', 'Cheque', 'Partial Payment', '500', 'Yes', '200', '300', 'sbi baanmk', '874578', 'ACTIVE');
INSERT INTO `purchase_invoice` VALUES ('2', 'Amrutraj', '6', '2', '2014-05-27', '2', '2014/5/27', 'Cheque', 'Partial Payment', '780', 'Yes', '500', '280', 'asdf', '102010', 'ACTIVE');
INSERT INTO `purchase_invoice` VALUES ('3', 'SERVICE ENGG', '12', '3', '2014-06-02', '9', '2014/6/2', 'Cash', 'Partial Payment', '40', 'Yes', '20', '20', 'a', 's', 'ACTIVE');

-- ----------------------------
-- Table structure for `purchase_order`
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order` (
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

-- ----------------------------
-- Records of purchase_order
-- ----------------------------

-- ----------------------------
-- Table structure for `purchase_return`
-- ----------------------------
DROP TABLE IF EXISTS `purchase_return`;
CREATE TABLE `purchase_return` (
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

-- ----------------------------
-- Records of purchase_return
-- ----------------------------
INSERT INTO `purchase_return` VALUES ('1', 'Damaged Stock', '1', '2014-05-24', 'QQQQ', 'asdf', '10', 'testing', 'Write-Off', 'ACTIVE');

-- ----------------------------
-- Table structure for `retailersales_return`
-- ----------------------------
DROP TABLE IF EXISTS `retailersales_return`;
CREATE TABLE `retailersales_return` (
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

-- ----------------------------
-- Records of retailersales_return
-- ----------------------------

-- ----------------------------
-- Table structure for `retailer_info`
-- ----------------------------
DROP TABLE IF EXISTS `retailer_info`;
CREATE TABLE `retailer_info` (
  `retailer_id` int(100) NOT NULL AUTO_INCREMENT,
  `retailer_name` varchar(300) NOT NULL,
  `retailer_address` varchar(500) NOT NULL,
  `retailer_contactno` varchar(20) NOT NULL,
  `retailer_officeno` varchar(20) NOT NULL,
  `retailer_email` varchar(200) NOT NULL,
  `retailer_status` varchar(20) NOT NULL,
  PRIMARY KEY (`retailer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of retailer_info
-- ----------------------------

-- ----------------------------
-- Table structure for `salesretailerbilldetail`
-- ----------------------------
DROP TABLE IF EXISTS `salesretailerbilldetail`;
CREATE TABLE `salesretailerbilldetail` (
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

-- ----------------------------
-- Records of salesretailerbilldetail
-- ----------------------------

-- ----------------------------
-- Table structure for `sales_store`
-- ----------------------------
DROP TABLE IF EXISTS `sales_store`;
CREATE TABLE `sales_store` (
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

-- ----------------------------
-- Records of sales_store
-- ----------------------------

-- ----------------------------
-- Table structure for `sale_return`
-- ----------------------------
DROP TABLE IF EXISTS `sale_return`;
CREATE TABLE `sale_return` (
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

-- ----------------------------
-- Records of sale_return
-- ----------------------------

-- ----------------------------
-- Table structure for `substituemaster`
-- ----------------------------
DROP TABLE IF EXISTS `substituemaster`;
CREATE TABLE `substituemaster` (
  `sub_id` int(15) NOT NULL AUTO_INCREMENT,
  `productname` varchar(200) NOT NULL,
  `subname` varchar(200) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of substituemaster
-- ----------------------------
