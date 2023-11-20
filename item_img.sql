CREATE TABLE item_img (
   item_img_id       NUMBER(20)       NOT NULL,
   item_id           NUMBER(20)       NOT NULL,
   img_name       VARCHAR2(255)   NOT NULL,
   ori_img_name   VARCHAR2(255)   NOT NULL,
   img_url           VARCHAR2(255)   DEFAULT 'C:/ezen-lecture/final_workspace/shoppingmall-project/upload',
   rep_img_yn       VARCHAR2(255)   DEFAULT 'N'
);
DROP TABLE ITEM_IMG;
-- 대표이미지 여부 제약조건 추가
ALTER TABLE ITEM_IMG ADD CONSTRAINT REP_IMG_YN_CHECK CHECK(
    REP_IMG_YN LIKE 'Y' OR 
    REP_IMG_YN LIKE 'N' OR
    REP_IMG_YN = null
);


-- 테이블 item_img 임시데이터 C:\Users\USER\Desktop\00_project\shoppingmall_project\src\main\resources\web\upload\item\


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 01, 'item01_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 01, 'item01_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 01, 'item01_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 01, 'item01_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 01, 'item01_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 02, 'item02_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 02, 'item02_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 02, 'item02_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 02, 'item02_image04v','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 02, 'item02_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 03, 'item03_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 03, 'item03_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 03, 'item03_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 03, 'item03_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 03, 'item03_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 04, 'item04_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 04, 'item04_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 04, 'item04_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 04, 'item04_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 04, 'item04_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 05, 'item05_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 05, 'item05_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 05, 'item05_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 05, 'item05_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 05, 'item05_image05.png','image05');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 06, 'item06_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 06, 'item06_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 06, 'item06_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 06, 'item06_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 06, 'item06_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 07, 'item07_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 07, 'item07_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 07, 'item07_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 07, 'item07_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 07, 'item07_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 08, 'item08_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 08, 'item08_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 08, 'item08_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 08, 'item08_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 08, 'item08_image05.png','image05');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 09, 'item09_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 09, 'item09_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 09, 'item09_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 09, 'item09_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 09, 'item09_image05.png','image05');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 10, 'item10_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 10, 'item10_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 10, 'item10_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 10, 'item10_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 10, 'item10_image05.png','image05');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 11, 'item11_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 11, 'item11_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 11, 'item11_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 11, 'item11_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 11, 'item11_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( 01 , 12, 'item12_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 02 , 12, 'item12_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 03 , 12, 'item12_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 04 , 12, 'item12_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( 05 , 12, 'item12_image05.png','image05');

truncate table item_img;


commit;

select item_img_id, item_id, img_name, ori_img_name, img_url, rep_img_yn from item_img;


select M.img_name, M.img_name, M.img_url, M.rep_img_yn
		from item_img M
				 inner join item I
							on I.item_id = M.item_id
		where I.item_id = 1 and M.rep_img_yn= 'Y';

