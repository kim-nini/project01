package com.ezen.grrreung.domain.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    private int cartId;
    private String memberId;
    private int itemId;
    private int cartAmount;
}
