package com.ezen.grrreung;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@SpringBootTest
@Slf4j
public class SpringAOPTest {
	
	@Autowired
	private MemberService memberService;

	@Test
	public void getMembersTest() {
		List<Member> list = memberService.getMembers();
		log.info("회원 전체 목록 : {}", list);
	}

	@Test
	public void getMemberTest() {
		Member member = memberService.getMember("bangry");
		log.info("회원 상세 : {}", member);
	}
}
