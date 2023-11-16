package com.ezen.grrreung.domain.member.mapper;

import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.dto.MemberSearchCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface MemberMapper {
    public List<Member> findByAll();
    public Member findById(String id);
    //public List<Member> findByAgeRange(@Param("begin") int begin, @Param("end") int end);
    public List<Member> findByNameLike(String name);
    public void create(Member member);
    public void update(Member member);
    // 검색 타입별 회원 검색
    public List<Member> findBySearchType(@Param("type") String type, @Param("value") String value);
    // 통합 검색
    public List<Member> findBySearchAll(String value);
    // 통합 검색
    public List<Member> findBySearchAllOption(MemberSearchCondition searchCondition);

}
