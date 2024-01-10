package com.ezen.grrreung.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemQna {
  private int qnaCode;
  private int itemId;
  private String qnaTitle;
  private String qnaCont;
  private String qnaDate;
  private String memberId;

  // 답변이 달렸는지 여부를 확인하는 필드
  private boolean hasRe;

}
