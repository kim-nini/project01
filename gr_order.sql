-- CREATE ORDER ---------------------------------

CREATE TABLE order_gr (
    order_id        INT AUTO_INCREMENT NOT NULL,
    member_id       VARCHAR(30) NOT NULL,
    order_date      DATETIME DEFAULT CURRENT_TIMESTAMP,
    order_status    ENUM('주문완료', '주문취소') DEFAULT '주문완료',
    order_memo      VARCHAR(100) NULL,
    order_name      VARCHAR(30) NOT NULL,
    order_add       VARCHAR(255) NOT NULL,
    order_hp        VARCHAR(30) NOT NULL,
    order_price_all VARCHAR(50) NOT NULL,
    PRIMARY KEY (order_id)
)AUTO_INCREMENT=10000;

CREATE TABLE order_item (
    order_item_id INT AUTO_INCREMENT NOT NULL,
    order_id      INT NOT NULL,
    item_id       INT NOT NULL,
    order_price   INT NOT NULL,
    order_amount  INT NOT NULL,
    PRIMARY KEY (order_item_id),
    FOREIGN KEY (order_id) REFERENCES order_gr (order_id)
);