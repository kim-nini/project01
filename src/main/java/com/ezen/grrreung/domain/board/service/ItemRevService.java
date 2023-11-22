package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemRev;
import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.web.common.RequestParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemRevService {

    // 리뷰 등록
    public void posting(ItemRev itemRev);

    // 리뷰 전체 + 검색 목록
    public List<ItemRev> postList(RequestParams params);

    // 리뷰 목록 행갯수
    public int postListCount(RequestParams params);

    // 리뷰 상세보기
    public ItemRev postInfo(int revCode);

    // 리뷰 삭제
    public void deletePost(int revCode);

    // 리뷰 수정
    public void updatePost(ItemRev itemRev);



}
