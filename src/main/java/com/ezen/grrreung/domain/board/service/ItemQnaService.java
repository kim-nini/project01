package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemQna;

import java.util.List;


public interface ItemQnaService {

    // 게시글 등록
    public void posting(ItemQna itemQna);

    // 게시글목록
    public List<ItemQna> postList();

    // 게시글 검색 목록
    public List<ItemQna> searchList(String searchValue);

    // 게시글상세보기
    public ItemQna postInfo(int qnaCode);


    // 게시글 삭제
    public void deletePost(int qnaCode);

    // 게시글 수정
    public void updatePost(ItemQna itemQna);


}
