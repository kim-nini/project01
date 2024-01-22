-- CREATE ITEM,ITEM_IMG,CATEGORY---------------------------------

CREATE TABLE item (
   item_id           INT PRIMARY KEY,
   cate_code         INT NOT NULL,
   item_name         VARCHAR(50) NOT NULL,
   item_price        INT NOT NULL,
   item_amount       INT NOT NULL,
   item_detail       VARCHAR(255) NOT NULL,
   item_sell_status  ENUM('sell', 'sold_out') DEFAULT 'sell'
);


-- 임시데이터 -------------------------------------

-- 임시데이터
insert into item values(01, 1001 , '상품1', 10000, 46, '상품설명1', 'sell');
insert into item values(02, 1002 , '상품2', 10000, 47, '상품설명2', 'sell');
insert into item values(03, 1003 , '상품3', 10000, 48, '상품설명3', 'sell');
insert into item values(04, 1004 , '상품4', 10000, 49, '상품설명4', 'sell');
insert into item values(05, 2001 , '상품5', 10000, 50, '상품설명5', 'sell');
insert into item values(06, 2002 , '상품6', 10000, 51, '상품설명6', 'sell');
insert into item values(07, 2003 , '상품7', 10000, 52, '상품설명7', 'sell');
insert into item values(08, 2004 , '상품8', 10000, 53, '상품설명8', 'sell');
insert into item values(09, 2005 , '상품9', 10000, 54, '상품설명9', 'sell');
insert into item values(10, 3001, '상품10', 10000, 55, '상품설명10', 'sell');
insert into item values(11, 3002 , '상품11', 10000, 56, '상품설명11', 'sell');
insert into item values(12, 3003 , '상품12', 10000, 56, '상품설명12', 'sell');


CREATE TABLE item_img (
   item_img_id       INT AUTO_INCREMENT NOT NULL,
   item_id           INT NOT NULL,
   img_name          VARCHAR(255) NOT NULL,
   ori_img_name      VARCHAR(255) NOT NULL,
   img_url           VARCHAR(255) DEFAULT 'C:/grrreung/shoppingmall-project/upload/',
   rep_img_yn        ENUM('Y', 'N') DEFAULT 'N',
   PRIMARY KEY (item_img_id)
);


-- 임시데이터 ---------------------------
-- item_id가 01인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (01, 'item01_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (01, 'item01_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (01, 'item01_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (01, 'item01_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (01, 'item01_image05.png', 'image05');


-- item_id가 02인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (02, 'item02_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (02, 'item02_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (02, 'item02_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (02, 'item02_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (02, 'item02_image05.png', 'image05');


-- item_id가 03인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (03, 'item03_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (03, 'item03_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (03, 'item03_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (03, 'item03_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (03, 'item03_image05.png', 'image05');


-- item_id가 04인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (04, 'item04_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (04, 'item04_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (04, 'item04_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (04, 'item04_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (04, 'item04_image05.png', 'image05');


-- item_id가 05인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (05, 'item05_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (05, 'item05_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (05, 'item05_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (05, 'item05_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (05, 'item05_image05.png', 'image05');


-- item_id가 06인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (06, 'item06_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (06, 'item06_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (06, 'item06_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (06, 'item06_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (06, 'item06_image05.png', 'image05');


-- item_id가 07인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (07, 'item07_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (07, 'item07_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (07, 'item07_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (07, 'item07_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (07, 'item07_image05.png', 'image05');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (07, 'item07_description.png', 'image07');


-- item_id가 08인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (08, 'item08_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (08, 'item08_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (08, 'item08_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (08, 'item08_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (08, 'item08_image05.png', 'image05');


-- item_id가 09인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (09, 'item09_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (09, 'item09_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (09, 'item09_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (09, 'item09_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (09, 'item09_image05.png', 'image05');


-- item_id가 10인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (10, 'item10_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (10, 'item10_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (10, 'item10_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (10, 'item10_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (10, 'item10_image05.png', 'image05');


-- item_id가 11인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (11, 'item11_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (11, 'item11_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (11, 'item11_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (11, 'item11_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (11, 'item11_image05.png', 'image05');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (11, 'item11_description01.png', 'image06');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (11, 'item11_description02.png', 'image07');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (11, 'item11_description03.png', 'image08');


-- item_id가 12인 데이터
INSERT INTO item_img (item_id, img_name, ori_img_name, rep_img_yn)
VALUES (12, 'item12_image01.png', 'image01', 'Y');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (12, 'item12_image02.png', 'image02');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (12, 'item12_image03.png', 'image03');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (12, 'item12_image04.png', 'image04');

INSERT INTO item_img (item_id, img_name, ori_img_name)
VALUES (12, 'item12_image05.png', 'image05');



