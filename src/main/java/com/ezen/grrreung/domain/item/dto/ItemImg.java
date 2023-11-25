package com.ezen.grrreung.domain.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemImg {
    private int itemImgId;
    private int itemId;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYN;

    public ItemImg (int itemId,  String imgName, String oriImgName, String repImgYN) {
        this.itemId = itemId;
        this.imgName = imgName;
        this.oriImgName = oriImgName;
        this.repImgYN = null;
    }


}

