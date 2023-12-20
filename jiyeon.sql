
-- 장바구니에서 선택된 상품만 주문서로 넘기기

        SELECT i.item_name, i.item_detail, i.item_price,
               c.member_id, c.item_id,
               SUM(c.cart_amount) AS cart_amount,
               m.img_name AS item_img
        FROM
            cart c
                INNER JOIN item i ON c.item_id = i.item_id
                INNER JOIN item_img m ON i.item_id = m.item_id
        WHERE
            c.member_id = 'customer1'
          AND m.rep_img_yn='Y'
          AND c.item_id IN (
              11, 12

              )
        GROUP BY
            i.item_name, i.item_detail, i.item_price,
            c.member_id, c.item_id,
            m.img_name
        ORDER BY
            item_id DESC
            
            
          