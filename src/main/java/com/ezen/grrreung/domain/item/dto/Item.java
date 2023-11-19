package com.ezen.grrreung.domain.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private int itemId;
    private int cateCode;
    private String itemName;
    private int itemPrice;
    private int itemAmount;
    private String itemDetail;
    private String itemSellStatus; // 'sell' , 'sold_out'
}
