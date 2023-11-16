package com.ezen.grrreung.domain.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RollbackDemoService {
	
	@Transactional
	public void throwRuntimeException() {
		// 롤백 테스트를 위한 RuntimeException 예외 발생
		log.info("throwRuntimeException() 메서드 호출됨...");
		throw new RuntimeException("런타임 예외 발생");
	}
	
	@Transactional
	public void throwCompilecheckedException() throws MyException {
		// 롤백 테스트를 위한 Exception 예외 발생
		log.info("throwCompilecheckedException() 메서드 호출됨...");
		throw new MyException("컴파일 체크드 예외 발생");
	}
	
	// rollbackFor 속성 설정 테스트
	@Transactional(rollbackFor = MyException.class)
	public void throwCompilecheckedException2() throws MyException {
		log.info("throwCompilecheckedException2() 메서드 호출됨...");
		throw new MyException();
	}
}




