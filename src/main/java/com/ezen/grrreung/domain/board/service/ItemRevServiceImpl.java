package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemRev;
import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.domain.board.mapper.ItemRevMapper;
import com.ezen.grrreung.web.common.RequestParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemRevServiceImpl implements ItemRevService{

    private final ItemRevMapper itemRevMapper;

    // 리뷰 작성
    @Override
    public void posting(ItemRev itemRev) { itemRevMapper.create(itemRev); }

    // 리뷰 전체 + 검색 리스트
    @Override
    public List<ItemRev> postList(RequestParams params) {
        return itemRevMapper.postList(params);
    }

    // 리뷰 리스트 행갯수
    @Override
    public int postListCount(RequestParams params) {
        return itemRevMapper.postListCount(params);
    }

    // 리뷰 상세 보기
    @Override
    public ItemRev postInfo(int revCode) { return itemRevMapper.findByBno(revCode); }

    // 리뷰 삭제
    @Override
    public void deletePost(int revCode) { itemRevMapper.deletePost(revCode);  }

    // 리뷰 수정
    @Override
    public void updatePost(ItemRev itemRev) { itemRevMapper.updateByBno(itemRev);  }

}
