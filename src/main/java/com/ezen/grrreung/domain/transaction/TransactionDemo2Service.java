package com.ezen.grrreung.domain.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionDemo2Service {
	
	@Transactional
	public void someUpdate() {
		log.info("someUpdate() 호출됨...");
		printTransactionActived();
	}
	
	// 트랜잭션 적용 확인을 위한 헬퍼 메소드
	private void printTransactionActived() {
		boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션  활성화 상태 = {}", txActive);
	}
}




