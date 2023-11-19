package com.ezen.grrreung.domain.board.mapper;


import com.ezen.grrreung.domain.board.dto.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    public void create(Notice notice);

    public List<Notice> postList();

    public Notice findByBno(int notiCode);

    public void updateByNotiCode(Notice notice);

    public void deletePost(int notiCode);

    public void hitCountUpdate(int notiCode);
}
