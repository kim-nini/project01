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

    // 회원 등록
    @Override
    public void register(Member member) {
        memberMapper.create(member);
    }

    // 아이디 중복 검사
    @Override
    public Member getMember(String memberId) {
        return memberMapper.findById(memberId);
    }

    // 로그인
    @Override
    public Member login(String memberId, String password) {
       return memberMapper.login(memberId, password);
    }

    // 아이디로 마이페이지 정보 가져오기
    @Override
    public Member memberInfo(String memberId) {
        return memberMapper.findById(memberId);
    }

    // 마이페이지 정보 수정
    @Override
    public void updateInfo(Member member) {
        memberMapper.update(member);
    }

    // 회원 탈퇴
    @Override
    public void deleteUser(String memberId) {
        memberMapper.delete(memberId);
    }

}
