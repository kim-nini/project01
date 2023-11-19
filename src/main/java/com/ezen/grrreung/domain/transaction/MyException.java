package com.ezen.grrreung.domain.transaction;

// 사용자 정의 예외 클래스
public class MyException extends Exception{
	public MyException() {
		super("예기치 않은 오류가 발생하였습니다.");
	}
	public MyException(String message) {
		super(message);
	}
}

