package com.ezen.grrreung.domain.member.service;

import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService {

    private final MemberMapper memberMapper;

    @Override
    public void register(Member member) {
        memberMapper.register(member);
    }

    @Override
    public Member login(String memberId, String password) {
       return memberMapper.login(memberId, password);
    }

    @Override
    public Member getMember(String memberId) {
        return null;
    }

    @Override
    public Member getMemberByEmail(String email) {
        return null;
    }

}
