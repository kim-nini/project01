package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemRev;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemRevService {

    // 게시글 등록
    public void posting(ItemRev itemRev);

    // 게시글목록
    public List<ItemRev> postList();

    // 게시글상세보기
    public ItemRev postInfo(int revCode);


    // 게시글 삭제
    public void deletePost(int revCode);

    // 게시글 수정
    public void updatePost(ItemRev itemRev);

    // 게시글 검색 목록

}
