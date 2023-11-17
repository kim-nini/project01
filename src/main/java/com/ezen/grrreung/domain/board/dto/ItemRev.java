package com.ezen.grrreung.domain.board.dto;

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
  private String revAuth;
  private String revDate;

}
