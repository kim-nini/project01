
CREATE TABLE order_gr (
   order_id           NUMBER(20)       NOT NULL,
   member_id       VARCHAR2(30)       NOT NULL,
   order_date       DATE                   NOT NULL,
   order_status       VARCHAR2(255)   NOT NULL,
   order_memo     VARCHAR2(100)   NULL,
   order_name       VARCHAR2(30)       NOT NULL,
   order_add       VARCHAR2(255)   NOT NULL,
   order_hp           VARCHAR2(30)       NOT NULL,
   order_price       VARCHAR2(50)       NOT NULL
);

CREATE TABLE member (
   member_id       VARCHAR2(30)       NOT NULL,
   password       VARCHAR2(255)   NOT NULL,
   name               VARCHAR2(30)       NOT NULL,
   hp                   VARCHAR2(255)   NOT NULL,
   email               VARCHAR2(255)   NULL,
   admin           VARCHAR2(255)   DEFAULT 'N',
   address           VARCHAR2(255)   NOT NULL
);

CREATE TABLE order_item (
   order_item_id   NUMBER(20)   NOT NULL,
   order_id           NUMBER(20)   NOT NULL,
   item_id2           NUMBER(20)   NOT NULL,
   order_price       NUMBER(20)   NOT NULL,
   order_amount   NUMBER(20)   NOT NULL
);

CREATE TABLE item (
   item_id           NUMBER(20)       NOT NULL,
   cate_code       NUMBER(20)       NOT NULL,
   item_name       VARCHAR2(50)       NOT NULL,
   item_price       NUMBER(20)       NOT NULL,
   item_amount   NUMBER(20)       NOT NULL,
   item_detail       VARCHAR2(255)   NOT NULL,
   item_sell_status   VARCHAR2(200)   DEFAULT 'sell'
);

ALTER TABLE item DROP CONSTRAINT ITEM_SELL_STATUS_CHECK;
ALTER TABLE ITEM ADD CONSTRAINT ITEM_SELL_STATUS_CHECK CHECK(
    ITEM_SELL_STATUS LIKE 'sell' OR
    ITEM_SELL_STATUS LIKE 'sold_out' OR
    ITEM_SELL_STATUS = null
);

CREATE TABLE item_img (
   item_img_id       NUMBER(20)       NOT NULL,
   item_id           NUMBER(20)       NOT NULL,
   img_name       VARCHAR2(255)   NOT NULL,
   ori_img_name   VARCHAR2(255)   NOT NULL,
   img_url           VARCHAR2(255)   NOT NULL,
   rep_img_yn       VARCHAR2(255)   DEFAULT 'N'
);


CREATE TABLE cart (
   cart_id           NUMBER(20)   NOT NULL,
   member_id       VARCHAR2(30)   NOT NULL,
   item_id           NUMBER(20)   NOT NULL,
   cart_amount       NUMBER(20)   NULL
);

CREATE TABLE notice (
   noti_code   NUMBER(20)       NOT NULL,
   noti_title       VARCHAR2(500)   NOT NULL,
   noti_cont       VARCHAR2(500)   NOT NULL,
   noti_date       DATE                   DEFAULT sysdate,
   noti_auth       VARCHAR2(30)       DEFAULT 'grrreng'
);

CREATE TABLE item_qna (
   qna_code           NUMBER(20)       NOT NULL,
   item_id           NUMBER(20)       NOT NULL,
   qna_title           VARCHAR2(100)   NOT NULL,
   qna_cont           VARCHAR2(500)   NOT NULL,
   qna_date           DATE                   DEFAULT sysdate,
   member_id       VARCHAR2(30)       NOT NULL
);

CREATE TABLE item_rev (
   rev_code       NUMBER(20)       NOT NULL,
   item_id       NUMBER(20)       NOT NULL,
   rev_cont       VARCHAR2(500)   NOT NULL,
   rev_auth       VARCHAR2(30)       NOT NULL,
   rev_date       DATE                   DEFAULT sysdate,
   member_id   VARCHAR2(30)       NOT NULL
);

CREATE TABLE item_qna_re (
   re_code       NUMBER(20)       NOT NULL,
   qna_code       NUMBER(20)       NOT NULL,
   re_cont       VARCHAR2(500)   NOT NULL,
   re_date       DATE                  DEFAULT sysdate
);

CREATE TABLE category (
   cate_code   NUMBER(20)   NOT NULL,
   cate_name   VARCHAR2(30)   NOT NULL,
   cate_top       NUMBER(20)   NULL
);

ALTER TABLE order_gr ADD CONSTRAINT PK_ORDER_GR PRIMARY KEY ( 
    order_id
);

ALTER TABLE member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
   member_id
);

ALTER TABLE order_item ADD CONSTRAINT PK_ORDER_ITEM PRIMARY KEY (
   order_item_id,
   order_id
);

ALTER TABLE item ADD CONSTRAINT PK_ITEM PRIMARY KEY (
   item_id
);

ALTER TABLE item_img ADD CONSTRAINT PK_ITEM_IMG PRIMARY KEY (
   item_img_id
);

ALTER TABLE cart ADD CONSTRAINT PK_CART PRIMARY KEY (
   cart_id
);

ALTER TABLE notice ADD CONSTRAINT PK_NOTICE PRIMARY KEY (
   noti_code
);

ALTER TABLE item_qna ADD CONSTRAINT PK_ITEM_QNA PRIMARY KEY (
   qna_code
);

ALTER TABLE item_rev ADD CONSTRAINT PK_ITEM_REV PRIMARY KEY (
   rev_code
);

ALTER TABLE item_qna_re ADD CONSTRAINT PK_ITEM_QNA_RE PRIMARY KEY (
   re_code
);

ALTER TABLE category ADD CONSTRAINT PK_CATEGORY PRIMARY KEY (
   cate_code
);

ALTER TABLE order_item ADD CONSTRAINT FK_order_gr_TO_order_item_1 FOREIGN KEY (
   order_id
)
REFERENCES order_gr (
   order_id
);

commit;




