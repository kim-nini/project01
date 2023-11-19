package com.ezen.grrreung.domain.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionDemoService {

	@Transactional
	public void applyTransction() {
		// 현재 비즈니스 메소드에 트랜잭션이 적용되어 있는지 확인
		// 트랜잭션 동기화 매니저를 통해 결과가 true면 트랜잭션이 적용됨을 의미한다.
		boolean txActive = false;
		txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션  활성화 상태 = {}", txActive);
	}
	
	public void nonApplyTransction() {
		boolean txActive = false;
		txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션  활성화 상태 = {}", txActive);
	}
	

}




