
-- CREATE MEMBER,CART ---------------------------------

CREATE TABLE member (
    member_id VARCHAR(30) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    name      VARCHAR(30) NOT NULL,
    hp        VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NULL,
    admin     ENUM('N', 'Y') DEFAULT 'N',
    address   VARCHAR(255) NOT NULL,
    address2  VARCHAR(255),
    address3  VARCHAR(255),
    address4  VARCHAR(255),
    PRIMARY KEY (member_id)
);

update member set name = '관리자' where member_id = 'admin';

CREATE TABLE cart (
    cart_id     INT AUTO_INCREMENT NOT NULL,
    member_id   VARCHAR(30) NOT NULL,
    item_id     INT NOT NULL,
    cart_amount INT NOT NULL,
    PRIMARY KEY (cart_id)
);

