package com.ezen.grrreung.domain.board.dto;

import com.ezen.grrreung.domain.item.dto.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemRev {
  private int revCode;
  private int itemId;
  private String memberId;
  private String revTitle;
  private String revCont;
  private String revDate;
  
  // 파일 경로 추가
  private String imagePath;

  private Item item;
}
