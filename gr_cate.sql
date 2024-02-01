CREATE TABLE category (
   cate_code   INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   cate_name   VARCHAR(30) NOT NULL,
   cate_top    VARCHAR(30) NULL
);

-- 테이블 category 임시데이터
insert into category values(1001, '방석', 'living');
insert into category(cate_code, cate_name, cate_top) values(1002, '이불', 'living');
insert into category(cate_code, cate_name, cate_top) values(1003, '넥카라', 'living');
insert into category(cate_code, cate_name, cate_top) values(1004, '계단', 'living');
insert into category(cate_code, cate_name, cate_top) values(1005, '쿠션', 'living');
insert into category(cate_code, cate_name, cate_top) values(1006, '매트', 'living');
insert into category(cate_code, cate_name, cate_top) values(1007, '식기', 'living');

insert into category(cate_code, cate_name, cate_top) values(2001, '하네스', 'walking');
insert into category(cate_code, cate_name, cate_top) values(2002, '포옹백', 'walking');
insert into category(cate_code, cate_name, cate_top) values(2003, '목줄', 'walking');
insert into category(cate_code, cate_name, cate_top) values(2004, '아웃도어 매트', 'walking');
insert into category(cate_code, cate_name, cate_top) values(2005, '바람막이', 'walking');
insert into category(cate_code, cate_name, cate_top) values(2006, '이동가방', 'walking');
insert into category(cate_code, cate_name, cate_top) values(2007, '벌레퇴치제', 'walking');
insert into category(cate_code, cate_name, cate_top) values(2008, '의류', 'walking');

insert into category(cate_code, cate_name, cate_top) values(3001, '트릿', 'food');
insert into category(cate_code, cate_name, cate_top) values(3002, '쮸르', 'food');
insert into category(cate_code, cate_name, cate_top) values(3003, '영양스튜', 'food');
insert into category(cate_code, cate_name, cate_top) values(3004, '미니캔', 'food');
insert into category(cate_code, cate_name, cate_top) values(3005, '덴탈', 'food');
SELECT cate_code, cate_name, cate_top FROM category;