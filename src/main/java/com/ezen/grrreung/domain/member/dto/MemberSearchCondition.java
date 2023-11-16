package com.ezen.grrreung.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberSearchCondition {
    private String memberId;
    private String name;
    private String email;
}
