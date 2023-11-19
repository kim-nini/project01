package com.ezen.grrreung.domain.member.mapper;

import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.dto.MemberSearchCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface MemberMapper {

    /**
     * 회원가입
     */
    public void creat(Member member);

    /**
    * 로그인
    */
    public Member login(String memberId,
                        String password);

    /**
     * 마이페이지
     */
    public Member findById(String memberId);


    /**
     * 마이페이지 수정
     */
    public void update(Member member);
}
