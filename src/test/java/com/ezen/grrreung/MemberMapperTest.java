package com.ezen.grrreung;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void findByAllTest() {
		List<Member> list = memberMapper.findByAll();
		for (Member member : list) {
			log.info(member.toString());
		}
	}
	
	@Test
	public void findByIdTest() {
		// given
		String memberId = "bangry";
		// when
		Member member = memberMapper.findById(memberId);
		// then
		assertThat(memberId)
			.isNotNull();
		log.info("회원정보 : {}", member.toString());
	}
	
	@Test
	void findByNameLikeTest() {
		String findName = "김";
		List<Member> list = memberMapper.findByNameLike(findName);
		log.info("이름 와일드카드 검색 : {}", list);
		for (Member member : list) {
			log.info(member.toString());
		}
	}
	
	@Test
	void createTest() {
		Member createMember = new Member();
		createMember.setMemberId("ddalang");
		createMember.setName("김딸랑");
		createMember.setPasswd("1111");
		createMember.setEmail("ddalang@gmail.com");
		memberMapper.create(createMember);
		log.info("회원 등록 완료 : {}", createMember);
	}

}
