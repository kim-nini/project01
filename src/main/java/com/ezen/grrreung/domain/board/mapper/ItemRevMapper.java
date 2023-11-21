package com.ezen.grrreung.domain.board.mapper;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.ItemRev;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemRevMapper {

    // 리뷰 작성하기
    public void create(ItemRev itemRev);

    // 리뷰 전체 리스트
    public List<ItemRev> postList();

    // 리뷰 검색 리스트
    public List<ItemRev> searchList(String searchValue);

    // 리뷰 상세보기
    public ItemRev findByBno(int revCode);

    // 수정
    public void updateByBno(ItemRev itemRev);

    // 삭제
    public void deletePost(int revCode);

    // 조회수
    public void hitCountUpdate(int revCode);
}
