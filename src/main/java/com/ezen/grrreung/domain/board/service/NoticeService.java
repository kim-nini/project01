package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.web.common.RequestParams;

import java.util.List;


public interface NoticeService {

    // 공지사항 등록
    public void posting(Notice notice);

    // 공지사항 전체 + 검색 목록
    public List<Notice> postList(RequestParams params);
    
    // 공지사항 목록 행갯수
    public int postListCount(RequestParams params);

    // 공지사항 상세보기
    public Notice postInfo(int notiCode);

    // 공지사항 삭제
    public void deletePost(int notiCode);

    // 공지사항 수정
    public void updatePost(Notice Notice);


}
