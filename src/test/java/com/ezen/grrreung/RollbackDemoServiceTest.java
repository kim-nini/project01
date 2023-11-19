package com.ezen.grrreung;

import com.ezen.grrreung.domain.transaction.MyException;
import com.ezen.grrreung.domain.transaction.RollbackDemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RollbackDemoServiceTest {
	@Autowired
	private RollbackDemoService service;
	
	@Test
	void throwRuntimeException() {
		service.throwRuntimeException();
	}
	@Test
	void throwCompilecheckedException() throws MyException {
		service.throwCompilecheckedException();
	}
	@Test
	void throwCompilecheckedException2() throws MyException {
		service.throwCompilecheckedException2();
	}
}






