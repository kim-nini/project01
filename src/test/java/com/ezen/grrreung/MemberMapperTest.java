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
	void createTest() {
		Member createMember = new Member();
		createMember.setMemberId("ddalang5");
		createMember.setName("김딸랑");
		createMember.setPassword("3333");
		createMember.setEmail("ddalang2@gmail.com");
		createMember.setHp("010-1111-2222");
		createMember.setAddress("경기도 하남시");
		createMember.setAddress2("망원동");
		createMember.setAddress3("123");
		memberMapper.create(createMember);
		log.info("회원 등록 완료 : {}", createMember);
	}

	@Test
	void createTest2() {
		Member createMember = new Member();
		createMember.setMemberId("bangry1");
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
	void LoginTest1(){
		Member member = memberMapper.login("ehfpal02", "1234");
		log.info("로그인 정보 확인 : {}", member);
	}

	@Test
	void findByIdTest(){
		Member member = memberMapper.findById("ehfpal02");
		log.info("상세 정보 확인 : {}", member);
	}
}
