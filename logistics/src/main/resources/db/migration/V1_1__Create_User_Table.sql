CREATE TABLE users (
  id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  firstName VARCHAR(100) DEFAULT NULL,
  middleName VARCHAR(100) DEFAULT NULL,
  lastName VARCHAR(100) DEFAULT NULL,
  phoneCode VARCHAR(10) DEFAULT NULL,
  phoneNumber VARCHAR(20) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL UNIQUE,
  password VARCHAR(255) DEFAULT NULL,
  profileImage VARCHAR(255) DEFAULT 'default_user.png',
  loginType ENUM('email', 'phone', 'apple', 'google', 'facebook') NOT NULL DEFAULT 'phone' COMMENT 'type of logins: ("email", "phone", "apple", "google", "facebook")',
  socialId VARCHAR(255) DEFAULT NULL,
  otp VARCHAR(10) DEFAULT NULL,
  otpSendDate VARCHAR(255) DEFAULT NULL,
  isOtpVerification TINYINT(1) DEFAULT 0,
  isAgreement TINYINT(1) NOT NULL DEFAULT 0,
  isProfileComplete TINYINT(1) DEFAULT 0,
  address TEXT DEFAULT NULL,
  latitude VARCHAR(30) DEFAULT NULL,
  longitude VARCHAR(30) DEFAULT NULL,
  deviceToken TEXT DEFAULT NULL,
  deviceType TINYINT(1) DEFAULT 0 COMMENT '0. android / 1. iOS',
  deviceName VARCHAR(255) DEFAULT NULL,
  referCode VARCHAR(50) DEFAULT NULL,
  referId INT(11) DEFAULT NULL COMMENT 'id of users table (to identify who''s refer.)',
  isOnline TINYINT(1) DEFAULT 0,
  message TEXT DEFAULT NULL,
  customerId VARCHAR(255) DEFAULT NULL,
  accountId VARCHAR(255) DEFAULT NULL,
  isOnboard TINYINT(1) DEFAULT 0,
  isDeleted TINYINT(1) DEFAULT 0 COMMENT '0. account not deleted / 1. account deleted',
  deletedAt DATETIME DEFAULT NULL,
  createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (referId) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
)




