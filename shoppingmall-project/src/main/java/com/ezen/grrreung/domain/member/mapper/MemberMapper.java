package com.ezen.grrreung.domain.member.mapper;

import com.ezen.grrreung.domain.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    /**
     * 회원가입
     */
    public void create(Member member);

    /**
    * 로그인
    */
    public Member login(@Param("memberId") String memberId,
                        @Param("password") String password);


    /**
     * 마이페이지
     */
    public Member findById(String memberId);


    /**
     * 마이페이지 수정
     */
    public void update(Member member);


    /**
    * 회원 탈퇴
    */
    public void delete(String memberId);



}
