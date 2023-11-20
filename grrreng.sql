-- DROP TABLE ---------------------------------

DROP TABLE member;

DROP TABLE order_item;

DROP TABLE order_gr;

DROP TABLE item;

DROP TABLE item_img;

DROP TABLE cart;

DROP TABLE notice;

DROP TABLE item_qna;

DROP TABLE item_rev;

DROP TABLE item_qna_re;

DROP TABLE category;


-- CREATE ---------------------------------

CREATE TABLE order_gr (
    order_id     NUMBER(20) NOT NULL,
    member_id    VARCHAR2(30) NOT NULL,
    order_date   DATE  DEFAULT sysdate,
    order_status VARCHAR2(255) DEFAULT '주문완료',
    order_memo   VARCHAR2(100) NULL,
    order_name   VARCHAR2(30) NOT NULL,
    order_add    VARCHAR2(255) NOT NULL,
    order_hp     VARCHAR2(30) NOT NULL,
    order_price  VARCHAR2(50) NOT NULL
);

CREATE TABLE member (
    member_id VARCHAR2(30) NOT NULL,
    password  VARCHAR2(255) NOT NULL,
    name      VARCHAR2(30) NOT NULL,
    hp        VARCHAR2(255) NOT NULL,
    email     VARCHAR2(255) NULL,
    admin     VARCHAR2(255) DEFAULT 'N',
    address   VARCHAR2(255) NOT NULL
);

CREATE TABLE order_item (
    order_item_id NUMBER(20) NOT NULL,
    order_id      NUMBER(20) NOT NULL,
    item_id2      NUMBER(20) NOT NULL,
    order_price   NUMBER(20) NOT NULL,
    order_amount  NUMBER(20) NOT NULL
);

CREATE TABLE item (
    item_id          NUMBER(20) NOT NULL,
    cate_code        NUMBER(20) NOT NULL,
    item_name        VARCHAR2(50) NOT NULL,
    item_price       NUMBER(20) NOT NULL,
    item_amount      NUMBER(20) NOT NULL,
    item_detail      VARCHAR2(255) NOT NULL,
    item_sell_status VARCHAR2(200) DEFAULT 'SELL'
);

CREATE TABLE item_img (
    item_img_id  NUMBER(20) NOT NULL,
    item_id      NUMBER(20) NOT NULL,
    img_name     VARCHAR2(255) NOT NULL,
    ori_img_name VARCHAR2(255) NOT NULL,
    img_url      VARCHAR2(255) NOT NULL,
    rep_img_yn   VARCHAR2(255) DEFAULT 'N'
);

CREATE TABLE cart (
    cart_id     NUMBER(20) NOT NULL,
    member_id   VARCHAR2(30) NOT NULL,
    item_id     NUMBER(20) NOT NULL,
    cart_amount NUMBER(20) NOT NULL
);

CREATE TABLE notice (
    noti_code  NUMBER(20) NOT NULL,
    noti_title VARCHAR2(500) NOT NULL,
    noti_cont  VARCHAR2(500) NOT NULL,
    noti_date  DATE DEFAULT sysdate,
    noti_auth  VARCHAR2(30) DEFAULT 'grrreng'
);

CREATE TABLE item_qna (
    qna_code  NUMBER(20) NOT NULL,
    item_id   NUMBER(20) NOT NULL,
    qna_title VARCHAR2(100) NOT NULL,
    qna_cont  VARCHAR2(500) NOT NULL,
    qna_date  DATE DEFAULT sysdate,
    member_id VARCHAR2(30) NOT NULL
);

CREATE TABLE item_rev (
    rev_code  NUMBER(20) NOT NULL,
    item_id   NUMBER(20) NOT NULL,
    rev_title VARCHAR2(100) NOT NULL,
    rev_cont  VARCHAR2(500) NOT NULL,
    rev_date  DATE DEFAULT sysdate,
    member_id VARCHAR2(30) NOT NULL
);

CREATE TABLE item_qna_re (
    re_code  NUMBER(20) NOT NULL,
    qna_code NUMBER(20) NOT NULL,
    re_cont  VARCHAR2(500) NOT NULL,
    re_date  DATE DEFAULT sysdate
);

CREATE TABLE category (
    cate_code NUMBER(20) NOT NULL,
    cate_name VARCHAR2(30) NOT NULL,
    cate_top  NUMBER(20) NULL
);


-- ALTER ---------------------------------

ALTER TABLE order_gr ADD CONSTRAINT pk_order_gr PRIMARY KEY ( order_id );

ALTER TABLE member ADD CONSTRAINT pk_member PRIMARY KEY ( member_id );

ALTER TABLE order_item ADD CONSTRAINT pk_order_item PRIMARY KEY ( order_item_id,
                                                                  order_id );

ALTER TABLE item ADD CONSTRAINT pk_item PRIMARY KEY ( item_id );

ALTER TABLE item_img ADD CONSTRAINT pk_item_img PRIMARY KEY ( item_img_id );

ALTER TABLE cart ADD CONSTRAINT pk_cart PRIMARY KEY ( cart_id );

ALTER TABLE notice ADD CONSTRAINT pk_notice PRIMARY KEY ( noti_code );

ALTER TABLE item_qna ADD CONSTRAINT pk_item_qna PRIMARY KEY ( qna_code );

ALTER TABLE item_rev ADD CONSTRAINT pk_item_rev PRIMARY KEY ( rev_code );

ALTER TABLE item_qna_re ADD CONSTRAINT pk_item_qna_re PRIMARY KEY ( re_code );

ALTER TABLE category ADD CONSTRAINT pk_category PRIMARY KEY ( cate_code );

ALTER TABLE order_item
    ADD CONSTRAINT fk_order_gr_to_order_item_1 FOREIGN KEY ( order_id )
        REFERENCES order_gr ( order_id );


-- SEQUENCE DROP ---------------------------------

-- Drop sequence for notice
DROP SEQUENCE notice_seq;

-- Drop sequence for item_rev�� ������ ����
DROP SEQUENCE item_rev_seq;

-- Drop sequence for order_gr
DROP SEQUENCE order_gr_seq;

-- Drop sequence for item_qna
DROP SEQUENCE item_qna_seq;

-- Drop sequence for item_qna_re
DROP SEQUENCE item_qna_re_seq;

-- Drop sequence for category
DROP SEQUENCE category_seq;


-- SEQUENCE CREATE ---------------------------------

-- Sequence for notice
CREATE SEQUENCE notice_seq START WITH 1 INCREMENT BY 1; 

-- Sequence for item_rev
CREATE SEQUENCE item_rev_seq START WITH 1 INCREMENT BY 1; 

-- Sequence for order_gr
CREATE SEQUENCE order_gr_seq START WITH 10000 INCREMENT BY 1;

-- Sequence for item_qna
CREATE SEQUENCE item_qna_seq START WITH 1 INCREMENT BY 1;

-- Sequence for item_qna_re
CREATE SEQUENCE item_qna_re_seq START WITH 1 INCREMENT BY 1;

-- Sequence for category
CREATE SEQUENCE category_seq START WITH 100 INCREMENT BY 1;


-- TEST INSERT ---------------------------------

-- Insert data into member table
INSERT INTO member (
    member_id,
    password,
    name,
    hp,
    email,
    address
) VALUES (
    'member001',
    'password123',
    'John Doe',
    '555-1234',
    'john@example.com',
    '123 Main St'
);

-- Insert data into order_gr table
INSERT INTO order_gr (
    order_id,
    member_id,
    order_memo,
    order_name,
    order_add,
    order_hp,
    order_price
) VALUES (
    order_gr_seq.NEXTVAL,
    'member001',
    'Urgent order',
    'John Doe',
    '123 Main St',
    '555-1234',
    '100.00'
);

-- Insert data into order_item table
INSERT INTO order_item (
    order_item_id,
    order_id,
    item_id2,
    order_price,
    order_amount
) VALUES (
    1,
    10000,
    101,
    50.00,
    2
);

-- Insert data into item table
INSERT INTO item (
    item_id,
    cate_code,
    item_name,
    item_price,
    item_amount,
    item_detail
) VALUES (
    101,
    1,
    'Sample Item',
    25.00,
    50,
    'Description of the item'
);

-- Insert data into item_img table
INSERT INTO item_img (
    item_img_id,
    item_id,
    img_name,
    ori_img_name,
    img_url
) VALUES (
    1,
    101,
    'Image1',
    'OriginalImage1.jpg',
    'https://example.com/image1.jpg'
);

-- Insert data into cart table
INSERT INTO cart (
    cart_id,
    member_id,
    item_id,
    cart_amount
) VALUES (
    1,
    'member001',
    101,
    2
);


-- Insert data into notice table
INSERT INTO notice (
    noti_code,
    noti_title,
    noti_cont
) VALUES (
    notice_seq.NEXTVAL,
    'Important Notice',
    'This is an important notice.'
);

-- Insert data into item_qna table
INSERT INTO item_qna (
    qna_code,
    item_id,
    qna_title,
    qna_cont,
    member_id
) VALUES (
    item_qna_seq.NEXTVAL,
    101,
    'Question about the item',
    'What are the specifications of this item?',
    'member001'
);

-- Insert data into item_rev table
INSERT INTO item_rev (
    rev_code,
    item_id,
    rev_title,
    rev_cont,
    member_id
) VALUES (
    item_rev_seq.NEXTVAL,
    101,
    'Great product',
    '내용이 들어간당',
    'member001'
);

-- Insert data into item_qna_re table
INSERT INTO item_qna_re (
    re_code,
    qna_code,
    re_cont
) VALUES (
    item_qna_re_seq.NEXTVAL,
    1,
    'The specifications are...'
);

-- Insert data into category table
INSERT INTO category (
    cate_code,
    cate_name,
    cate_top
) VALUES (
    category_seq.NEXTVAL,
    'Electronics',
    NULL
);


-- SELECT ALL ---------------------------------

-- Select all from order_gr
SELECT
    *
FROM
    order_gr;

-- Select all from member
SELECT
    *
FROM
    member;

-- Select all from order_item
SELECT
    *
FROM
    order_item;

-- Select all from item
SELECT
    *
FROM
    item;

-- Select all from item_img
SELECT
    *
FROM
    item_img;

-- Select all from cart
SELECT
    *
FROM
    cart;

-- Select all from notice
SELECT
    *
FROM
    notice;

-- Select all from item_qna
SELECT
    *
FROM
    item_qna;

-- Select all from item_rev
SELECT
    *
FROM
    item_rev;

-- Select all from item_qna_re
SELECT
    *
FROM
    item_qna_re;

-- Select all from category
SELECT
    *
FROM
    category;

SELECT
    *
FROM
    item_rev;

SELECT
    *
FROM
    item_rev
ORDER BY
    rev_code DESC;

-------------------------------------------------------------------------------

SELECT
    *
FROM
    item_qna
WHERE
    qna_title LIKE '%1%'
    or member_id LIKE '%1%';

SELECT noti_code,
           noti_title,
           noti_cont,
           noti_auth,
           TO_CHAR(noti_date, 'yyyy-MM-DD HH24:MI:SS')  noti_date
        FROM notice
        WHERE noti_code = 1;
