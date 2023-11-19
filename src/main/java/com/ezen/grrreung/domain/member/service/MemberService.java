package com.ezen.grrreung.domain.member.service;

import com.ezen.grrreung.domain.member.dto.Member;
import java.util.List;

public interface MemberService {

    // 회원가입
    public void register(Member member);

    // 로그인
    public Member login(String memberId, String password);

    // 회원가입 유효성 검사
    public Member getMember(String memberId);
    public Member getMemberByEmail(String email);

}
