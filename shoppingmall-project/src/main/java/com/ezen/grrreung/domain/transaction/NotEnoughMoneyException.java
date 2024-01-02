package com.ezen.grrreung.domain.transaction;

// 사용자 정의 컴파일 체크 예외 (비즈니스 예외)
public class NotEnoughMoneyException extends Exception{
	
	public NotEnoughMoneyException() {
		super("예기치 않은 오류가 발생하였습니다.");
	}
	
	public NotEnoughMoneyException(String message) {
		super(message);
	}
}

