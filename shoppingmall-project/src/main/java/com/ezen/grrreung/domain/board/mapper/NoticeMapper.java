package com.ezen.grrreung.domain.board.mapper;


import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.web.common.RequestParams;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    // 공지사항 작성하기
    public void create(Notice notice);

    // 공지사항 전체 + 검색 리스트
    public List<Notice> postList(RequestParams params);

    // 공지사항 리스트 행갯수
    public int postListCount(RequestParams params);

    // 공지사항 상세보기
    public Notice findByBno(int notiCode);

    // 공지사항 수정하기
    public void updateByBno(Notice notice);

    // 삭제
    public void deletePost(int notiCode);

    // 조회수
    public void hitCountUpdate(int notiCode);
}
