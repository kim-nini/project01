package com.ezen.grrreung;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Disabled;
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
	@Disabled
	void createTest() {
		Member createMember = new Member();
		createMember.setMemberId("ddalang");
		createMember.setName("김딸랑");
		createMember.setPassword("1111");
		createMember.setEmail("ddalang@gmail.com");
		createMember.setHp("010-1111-2222");
		createMember.setAddress("경기도 하남시");
		createMember.setAddress2("망원동");
		createMember.setAddress3("123");
		memberMapper.create(createMember);
		log.info("회원 등록 완료 : {}", createMember);
	}
	@Test
	@Disabled
	void createTest2() {
		Member createMember = new Member();
		createMember.setMemberId("bangry");
		createMember.setName("김방글");
		createMember.setPassword("2222");
		createMember.setEmail("bangry@gmail.com");
		createMember.setHp("010-1234-2222");
		createMember.setAddress("경기도 하남시");
		createMember.setAddress2("망원동");
		createMember.setAddress3("789");
		memberMapper.create(createMember);
		log.info("회원 등록 완료 : {}", createMember);
	}

	@Test
	void findByIdTest1(){
		Member member = memberMapper.findById("bangry", "2222");
		log.info("로그인 정보 확인 : {}", member);
	}
}
