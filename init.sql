CREATE TABLE `User` (
   `userId`   bigint PRIMARY KEY AUTO_INCREMENT  NOT NULL,
   `nickName`   VARCHAR(15)   NOT NULL,
   `email`   VARCHAR(40)   NOT NULL,
   `password`   VARCHAR(40)   NOT NULL
);
CREATE TABLE `Hospital` (
   `hospitalId`   bigint PRIMARY KEY AUTO_INCREMENT  NOT NULL,
   `tel`   VARCHAR(20)   NOT NULL,
   `address`   VARCHAR(200)   NOT NULL,
   `hosName`   VARCHAR(20)   NOT NULL,
   `hosPic`   VARCHAR(20)   NOT NULL
);
CREATE TABLE `Review` (
   `reviewId`   bigint PRIMARY KEY AUTO_INCREMENT  NOT NULL,
   `userId`   bigint   NOT NULL,
   `hospitalId`   bigint   NOT NULL,
   `content`   VARCHAR(200)   NOT NULL
);
ALTER TABLE `Review`
ADD CONSTRAINT `FK_User_TO_Review_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`),
ADD CONSTRAINT `FK_Hospital_TO_Review_1` FOREIGN KEY (`hospitalId`) REFERENCES `Hospital` (`hospitalId`);

CREATE TABLE `Department` (
   `departmentId`   bigint PRIMARY KEY AUTO_INCREMENT  NOT NULL,
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

ALTER TABLE user AUTO_INCREMENT = 1;

INSERT INTO user (nickName, email, password) 
VALUES ('jy', 'jade0000@naver.com', 'admin1234');

INSERT INTO user (nickName, email, password) 
VALUES ('jy', 'jade1087@naver.com', 'admin1234');

INSERT INTO hospital (tel, address, hosName, hosPic) 
VALUES ('02-953-0075', '서울 성북구 동소문로 73 시티플레이스 B1, 1F, 2F', 'VIP동물의료센터', 'maltese.jpg');

INSERT INTO hospital (tel, address, hosName, hosPic) 
VALUES ('02-6956-0040', '서울 성북구 돈암동 644-2', '원러브동물의료센터', 'poodle.jpg');

INSERT INTO hospital (tel, address, hosName, hosPic) 
VALUES ('02-929-5496', '서울 성북구 동소문로 66 김의원빌딩', '나래동물병원', 'shiba.jpg');

INSERT INTO hospital (tel, address, hosName, hosPic) 
VALUES ('02-927-7878', '서울 성북구 아리랑로 27 1층, 2층', '로이동물병원', 'maltese.jpg');

INSERT INTO hospital (tel, address, hosName, hosPic) 
VALUES ('02-529-5575', '서울 강남구 도곡로 189 1층', '예은동물병원', 'poodle.jpg');

INSERT INTO hospital (tel, address, hosName, hosPic) 
VALUES ('02-574-7533', '서울 강남구 선릉로 806 킹콩빌딩 5층', '이안동물의학센터', 'shiba.jpg');

INSERT INTO review (userId, hospitalId, content) 
VALUES (1, 1, 'review test1');

INSERT INTO review (userId, hospitalId, content) 
VALUES (1, 2, 'review test2');

INSERT INTO review (userId, hospitalId, content) 
VALUES (1, 3, 'review test3');

INSERT INTO likeTbl (userId, hospitalId) 
VALUES (1, 1);

INSERT INTO likeTbl (userId, hospitalId) 
VALUES (2, 1);

INSERT INTO likeTbl (userId, hospitalId) 
VALUES (1, 2);

INSERT INTO likeTbl (userId, hospitalId) 
VALUES (2, 2);

INSERT INTO likeTbl (userId, hospitalId) 
VALUES (1, 3);

INSERT INTO likeTbl (userId, hospitalId) 
VALUES (1, 4);

INSERT INTO Department (departmentId, hospitalId, departName, price) 
VALUES (1, 1, '슬개골 탈구', 600000);

INSERT INTO Department (departmentId, hospitalId, departName, price) 
VALUES (2, 2, '슬개골 탈구', 580000);

INSERT INTO Department (departmentId, hospitalId, departName, price) 
VALUES (3, 1, '중성화', 300000);

INSERT INTO Department (departmentId, hospitalId, departName, price) 
VALUES (4, 2, '중성화', 320000);
