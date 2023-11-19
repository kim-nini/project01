package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.domain.board.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public void posting(Notice notice) {

    }

    @Override
    public List<Notice> postList() {
        return noticeMapper.postList();
    }

    @Override
    public Notice postInfo(int notiCode) {
        return null;
    }

    @Override
    public void deletePost(int notiCode) {

    }

    @Override
    public void updatePost(Notice notice) {

    }
}
