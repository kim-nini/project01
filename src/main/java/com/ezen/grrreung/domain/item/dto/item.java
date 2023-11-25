package com.ezen.grrreung.domain.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class item {
    private int productId;
    private String name;
    private long price;
}
