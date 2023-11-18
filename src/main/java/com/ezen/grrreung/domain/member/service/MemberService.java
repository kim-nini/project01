package com.ezen.grrreung.domain.member.service;

import com.ezen.grrreung.domain.member.dto.Member;
import java.util.List;

public interface MemberService {
    public void register(Member member);
    public void login(Member member);

    // 회원가입 유효성 검사
    public Member getMember(String memberId);
    public Member getMemberByEmail(String email);

    // 로그인
    public Member getMemberByPw(String password);
}
