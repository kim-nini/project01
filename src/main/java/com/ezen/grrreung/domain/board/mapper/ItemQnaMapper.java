package com.ezen.grrreung.domain.board.mapper;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.ItemQnaRe;
import com.ezen.grrreung.web.common.RequestParams;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemQnaMapper {
    
    // QNA 문의하기
    public void create(ItemQna itemQna);

    // QNA 전체 + 검색 리스트
    public List<ItemQna> postList(RequestParams params);

    // 문의 리스트 행갯수
    public int postListCount(RequestParams params);

    // QNA 상세보기
    public ItemQna findByBno(int qnaCode);

    // 수정
    public void updateByBno(ItemQna itemQna);

    // 삭제
    public void deletePost(int qnaCode);

    // 조회수
//    public void hitCountUpdate(int qnaCode);

    // qnaCode로 답변리스트 가져오기
    public List<ItemQnaRe> qnaReByQnaCode(int qnaCode);
    
    // 문의답변등록
    public void createRe(ItemQnaRe itemQnaRe);

    // reCode로 답변 1개 가져오기
    public ItemQnaRe getQnaRe(int reCode);

    // 답변 수정하기
    public void updateQnaRe(ItemQnaRe itemQnaRe);

    // 답변 삭제하기
    public void deleteQnaRe(int reCode);

    // 아이템 상세페이지 문의목록 조회 - 아이템id
    public List<ItemQna> itemQnaList(RequestParams params);

    // 아이템별 (전체 회원) 문의 개수 조회
    public int itemQnaPostCount(int itemId);

    // 아이템 상세보기 페이지에서 보여줄 문의목록 조회
    public List<ItemQna> itemQnaAll(int ItemId);

}
