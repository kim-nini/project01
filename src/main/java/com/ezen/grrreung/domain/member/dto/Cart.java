package com.ezen.grrreung.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    private String cartId;
    private String memberId;
    private String itemId;
    private String cartAmount;
}
