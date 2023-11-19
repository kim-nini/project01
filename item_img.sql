CREATE TABLE item_img (
   item_img_id       NUMBER(20)       NOT NULL,
   item_id           NUMBER(20)       NOT NULL,
   img_name       VARCHAR2(255)   NOT NULL,
   ori_img_name   VARCHAR2(255)   NOT NULL,
   img_url           VARCHAR2(255)   NOT NULL,
   rep_img_yn       VARCHAR2(255)   DEFAULT 'N'
);

-- 대표이미지 여부 제약조건 추가
ALTER TABLE ITEM_IMG ADD CONSTRAINT REP_IMG_YN_CHECK CHECK(
    REP_IMG_YN LIKE 'Y' OR 
    REP_IMG_YN LIKE 'N' OR
    REP_IMG_YN = null
);


-- 테이블 item_img 임시데이터 C:\Users\USER\Desktop\00_project\shoppingmall_project\src\main\resources\web\upload\item\
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url, rep_img_yn)
values ( 01 , 01, 'web_image01', 'image01', '/web/upload/item/1.png', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url)
values ( 02 , 01, 'web_image02','image02', '/web/upload/item/2.png');
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url)
values ( 03 , 01, 'web_image03','image03', '/web/upload/item/3.png');
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url)
values ( 04 , 01, 'web_image04','image04', '/web/upload/item/4.png');
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url)
values ( 05 , 01, 'web_image05','image05', '/web/upload/item/5.png');

commit;

insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url, rep_img_yn)
values ( 04 , 02, 'web_image04', 'image04', 'C:\Users\User\Documents\', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url)
values ( 05 , 02, 'web_image05','image05', 'C:\Users\User\Documents\');
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url)
values ( 06 , 02, 'web_image06','image06', 'C:\Users\User\Documents\');


insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url, rep_img_yn)
values ( 07 , 03, 'web_image07', 'image07', 'C:\Users\User\Documents\', 'Y');
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url)
values ( 08 , 03, 'web_image08','image08', 'C:\Users\User\Documents\');
insert into item_img(item_img_id, item_id, img_name, ori_img_name, img_url)
values ( 09 , 03, 'web_image09','image09', 'C:\Users\User\Documents\');

select item_img_id, item_id, img_name, ori_img_name, img_url, rep_img_yn from item_img;



truncate table item_img;



