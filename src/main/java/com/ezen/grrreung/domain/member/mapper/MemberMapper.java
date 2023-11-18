package com.ezen.grrreung.domain.member.mapper;

import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.dto.MemberSearchCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface MemberMapper {

    /**
     * 신규회원 저장
     */
    public void create(Member member);

    /**
    * 로그인
    */
    public Member findById(@Param("memberId") String memberId,
                           @Param("password") String password);


}
