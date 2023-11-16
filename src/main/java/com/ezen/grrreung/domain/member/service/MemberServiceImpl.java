package com.ezen.grrreung.domain.member.service;

import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberServiceImpl implements  MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void register(Member member) {
        memberMapper.create(member);
    }

    @Override
    public Member getMember(String memberId) {
        return memberMapper.findById(memberId);
    }

    @Override
    public List<Member> getMembers() {
        return memberMapper.findByAll();
    }
}
