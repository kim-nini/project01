CREATE TABLE item_img (
   item_img_id       NUMBER(20)       NOT NULL,
   item_id           NUMBER(20)       NOT NULL,
   img_name       VARCHAR2(255)   NOT NULL,
   ori_img_name   VARCHAR2(255)   NOT NULL,
   img_url           VARCHAR2(255)   DEFAULT 'C:/grrreung/shoppingmall-project/upload',
   rep_img_yn       VARCHAR2(255)   DEFAULT 'N'
);

--img_url           VARCHAR2(255)   DEFAULT 'C:/ezen-lecture/final_workspace/shoppingmall-project/upload',

SELECT
    item_id,
    img_name,
    img_url
FROM
    item_img;



DROP TABLE ITEM_IMG;
-- 대표이미지 여부 제약조건 추가
ALTER TABLE ITEM_IMG ADD CONSTRAINT REP_IMG_YN_CHECK CHECK(
    REP_IMG_YN LIKE 'Y' OR 
    REP_IMG_YN LIKE 'N' OR
    REP_IMG_YN = null
);


create sequence item_img_id_sq;
-- 테이블 item_img 임시데이터 C:\Users\USER\Desktop\00_project\shoppingmall_project\src\main\resources\web\upload\item\


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( item_img_id_sq.nextval, 01, 'item01_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 01, 'item01_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 01, 'item01_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 01, 'item01_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 01, 'item01_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 02, 'item02_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 02, 'item02_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 02, 'item02_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 02, 'item02_image04v','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 02, 'item02_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( item_img_id_sq.nextval , 03, 'item03_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 03, 'item03_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 03, 'item03_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 03, 'item03_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 03, 'item03_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 04, 'item04_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 04, 'item04_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 04, 'item04_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 04, 'item04_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 04, 'item04_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 05, 'item05_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 05, 'item05_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 05, 'item05_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 05, 'item05_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 05, 'item05_image05.png','image05');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 06, 'item06_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 06, 'item06_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 06, 'item06_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 06, 'item06_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 06, 'item06_image05.png','image05');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 07, 'item07_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 07, 'item07_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 07, 'item07_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 07, 'item07_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 07, 'item07_image05.png','image05');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 07, 'item07_description.png','image07');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 08, 'item08_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 08, 'item08_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 08, 'item08_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 08, 'item08_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 08, 'item08_image05.png','image05');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values ( item_img_id_sq.nextval , 09, 'item09_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 09, 'item09_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 09, 'item09_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 09, 'item09_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 09, 'item09_image05.png','image05');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 10, 'item10_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 10, 'item10_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 10, 'item10_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 10, 'item10_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 10, 'item10_image05.png','image05');

insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 11, 'item11_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 11, 'item11_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 11, 'item11_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 11, 'item11_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 11, 'item11_image05.png','image05');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 11, 'item11_description01.png','image06');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 11, 'item11_description02.png','image07');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values ( item_img_id_sq.nextval , 11, 'item11_description03.png','image08');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, rep_img_yn)
values (item_img_id_sq.nextval , 12, 'item12_image01.png', 'image01', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 12, 'item12_image02.png','image02');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 12, 'item12_image03.png','image03');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 12, 'item12_image04.png','image04');
insert into item_img(item_img_id, item_id, img_name, ori_img_name)
values (item_img_id_sq.nextval , 12, 'item12_image05.png','image05');

truncate table item_img;


commit;

select item_img_id, item_id, img_name, ori_img_name, img_url, rep_img_yn from item_img;


select M.img_name, M.img_url, M.rep_img_yn
		from item_img M
				 inner join item I
							on I.item_id = M.item_id
		where I.item_id = 1 and M.rep_img_yn= 'Y';



SELECT
    i.item_id,
    m.img_name,
    m.img_url
FROM
         item_img m
    INNER JOIN item i ON i.item_id = m.item_id
WHERE
    i.item_id = 11 and
    m.img_name LIKE '%description%'
ORDER  BY img_name ASC;


	SELECT
			i.item_id,
			m.img_name,
			m.item_img_id,
			m.img_url,
			m.rep_img_yn
		FROM
			item_img m
				INNER JOIN item i ON i.item_id = m.item_id
		WHERE
			i.item_id = 11 and
            NOT m.img_name LIKE '%description%';
             

    

