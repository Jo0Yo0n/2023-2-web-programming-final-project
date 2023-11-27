CREATE TABLE `User` (
   `userId`   bigint PRIMARY KEY  NOT NULL,
   `nickName`   VARCHAR(15)   NOT NULL,
   `email`   VARCHAR(40)   NOT NULL,
   `password`   VARCHAR(40)   NOT NULL
);
CREATE TABLE `Hospital` (
   `hospitalId`   bigint PRIMARY KEY  NOT NULL,
   `tel`   VARCHAR(20)   NOT NULL,
   `address`   VARCHAR(200)   NOT NULL,
   `hosName`   VARCHAR(20)   NOT NULL,
   `hosPic`   VARCHAR(20)   NOT NULL
);
CREATE TABLE `Review` (
   `reviewId`   bigint PRIMARY KEY  NOT NULL,
   `userId`   bigint   NOT NULL,
   `hospitalId`   bigint   NOT NULL,
   `content`   VARCHAR(200)   NOT NULL
);
ALTER TABLE `Review`
ADD CONSTRAINT `FK_User_TO_Review_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`),
ADD CONSTRAINT `FK_Hospital_TO_Review_1` FOREIGN KEY (`hospitalId`) REFERENCES `Hospital` (`hospitalId`);

CREATE TABLE `Department` (
   `departmentId`   bigint PRIMARY KEY  NOT NULL,
   `hospitalId`   bigint   NOT NULL,
   `departName`   VARCHAR(40)   NOT NULL,
   `price`   bigint   NOT NULL
);

ALTER TABLE `Department`
ADD CONSTRAINT `FK_Hospital_TO_Department_1` FOREIGN KEY (`hospitalId`) REFERENCES `Hospital` (`hospitalId`);

CREATE TABLE `likeTbl` (
   `userId`   bigint  NOT NULL,
   `hospitalId`   bigint NOT NULL
);

ALTER TABLE `likeTbl`
ADD CONSTRAINT `FK_User_TO_like_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`),
ADD CONSTRAINT `FK_Hospital_TO_like_1` FOREIGN KEY (`hospitalId`) REFERENCES `Hospital` (`hospitalId`);