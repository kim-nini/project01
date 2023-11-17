package com.ezen.grrreung.domain.member.service;

import com.ezen.grrreung.domain.member.dto.Member;
import java.util.List;

public interface MemberService {
    public void register(Member member);

    public Member getMember(String memberId);

    public Member getMemberByEmail(String email);
}
