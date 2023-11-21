package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.Notice;

import java.util.List;


public interface NoticeService {

    // 게시글 등록
    public void posting(Notice notice);

    // 게시글목록
    public List<Notice> postList();

    // 게시글 검색 목록
    public List<Notice> searchList(String searchValue);

    // 게시글상세보기
    public Notice postInfo(int notiCode);

    // 게시글 삭제
    public void deletePost(int notiCode);

    // 게시글 수정
    public void updatePost(Notice Notice);


}
