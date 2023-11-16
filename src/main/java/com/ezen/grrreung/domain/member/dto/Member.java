package com.ezen.grrreung.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
    private String memberId;
    private String passwd;
    private String name;
    private String email;
    private String regdate;
    private String num;
}
