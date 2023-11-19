package com.ezen.grrreung.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemQna {
  private int qnaCode;
  private int itemId;
  private String qnaTitle;
  private String qnaCont;
  private Date qnaDate;
  private String memberId;

}
