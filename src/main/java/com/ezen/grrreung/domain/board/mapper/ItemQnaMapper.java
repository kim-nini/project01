package com.ezen.grrreung.domain.board.mapper;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemQnaMapper {
    
    // QNA 문의하기
    public void create(ItemQna itemQna);

    // QNA 전체리스트
    public List<ItemQna> postList();

    // QNA 검색 리스트
    public List<ItemQna> searchList(String searchValue);

    // QNA 상세보기
    public ItemQna findByBno(int qnaCode);

    // 수정
    public void updateByBno(ItemQna itemQna);

    // 삭제
    public void deletePost(int qnaCode);

    // 조회수
    public void hitCountUpdate(int qnaCode);
}
