package com.ezen.grrreung;

import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.domain.board.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardTest {

    @Autowired
    private NoticeMapper noticeMapper;

    @Test
    public void createTest(){
        Notice notice = new Notice();
        notice.setNotiCont("dddd");
        notice.setNotiTitle("dddd");
        noticeMapper.create(notice);
        
    }


}
