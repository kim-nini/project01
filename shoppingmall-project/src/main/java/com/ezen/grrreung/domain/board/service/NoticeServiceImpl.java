package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.domain.board.mapper.ItemRevMapper;
import com.ezen.grrreung.domain.board.mapper.NoticeMapper;
import com.ezen.grrreung.web.common.RequestParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }

    // 공지사항 작성
    @Override
    public void posting(Notice notice) { noticeMapper.create(notice);  }

    // 공지사항 전체 + 검색 리스트
    @Override
    public List<Notice> postList(RequestParams params) {
        return noticeMapper.postList(params);
    }

    // 공지사항 리스트 행갯수
    @Override
    public int postListCount(RequestParams params) {
        return noticeMapper.postListCount(params);
    }

    // 공지사항 상세보기
    @Override
    public Notice postInfo(int notiCode) {
        return noticeMapper.findByBno(notiCode);
    }

    // 공지사항 삭제
    @Override
    public void deletePost(int notiCode) { noticeMapper.deletePost(notiCode); }

    // 공지사항 수정
    @Override
    public void updatePost(Notice notice) { noticeMapper.updateByBno(notice); }

}
