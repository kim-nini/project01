package com.ezen.grrreung.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {
  private int notiCode;
  private String notiTitle;
  private String notiCont;
  private String notiDate;
  private String notiAuth;

}
