package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.ItemQnaRe;
import com.ezen.grrreung.web.common.RequestParams;

import java.util.List;


public interface ItemQnaService {

    // 상품 문의 등록
    public void posting(ItemQna itemQna);

    // 상품 문의 목록
    public List<ItemQna> postList(RequestParams params);

    // 상품 문의 목록 행갯수
    public int postListCount(RequestParams params);

    // 상품 문의상세보기
    public ItemQna postInfo(int qnaCode);

    // 상품 문의 수정
    public void updatePost(ItemQna itemQna);

    // 상품 문의 삭제
    public void deletePost(int qnaCode);

    // qnaCode로 답변 리스트 가져오기
    public List<ItemQnaRe> getListByQnaCode(int qnaCode);

    // 상품 문의 답변 등록
    public int postRe(ItemQnaRe itemQnaRe);

    // 생성된 reCode로 등록된 답변 가져오기
    public ItemQnaRe getReByReCode(int reCode);

    // 답변 수정 하기
    public void updateQnaRe(ItemQnaRe itemQnaRe);

    // 답변 삭제 하기
    public  void  deleteQnaRe(int reCode);


    // 상품 상세페이지 내 상품문의목록
    // 아이템 상세페이지 상품문의목록 조회 - 아이템id
    public List<ItemQna> itemQna(RequestParams params);

    // 아이템별 (전체 회원) 상품문의 개수 조회
    public int itemQnaPostCount(int itemId);

    // 아이템 상세보기 페이지에서 보여줄 문의목록 조회
    public List<ItemQna> itemQnaAll(int itemId);

}
