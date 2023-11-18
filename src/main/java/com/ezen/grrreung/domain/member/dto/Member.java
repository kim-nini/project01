package com.ezen.grrreung.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
    private String memberId;
    private String password;
    private String name;
    private String hp;
    private String email;
    private String admin;
    private String address;
    private String address2;
    private String address3;
}
