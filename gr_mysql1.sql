create database grrreung;
use grrreung;
-- ALTER DATABASE grrreung DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
SHOW DATABASES;
SELECT user, host FROM mysql.user;

-- DROP TABLE ---------------------------------
DROP TABLE IF EXISTS member;

DROP TABLE IF EXISTS order_item;

DROP TABLE IF EXISTS order_gr;

DROP TABLE IF EXISTS item;

DROP TABLE IF EXISTS item_img;

DROP TABLE IF EXISTS cart;

DROP TABLE IF EXISTS notice;

DROP TABLE IF EXISTS item_qna;

DROP TABLE IF EXISTS item_rev;

DROP TABLE IF EXISTS item_qna_re;

DROP TABLE IF EXISTS category;