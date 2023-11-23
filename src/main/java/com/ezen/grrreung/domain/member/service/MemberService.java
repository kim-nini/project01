package com.ezen.grrreung.domain.member.service;

import com.ezen.grrreung.domain.member.dto.Member;
import java.util.List;

public interface MemberService {

    // 로그인
    public Member login(String memberId, String password);

    // 회원가입
    public void register(Member member);

    // 회원가입 아이디 중복 검사
    public Member getMember(String memberId);

    // 마이페이지 상세정보
    public Member memberInfo(String memberId);

    // 마이페이지 수정
    public void updateInfo(Member member);

    // 회원 탈퇴
    public void deleteUser(String memberId);
}
