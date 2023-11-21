package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemRev;
import com.ezen.grrreung.domain.board.mapper.ItemRevMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemRevServiceImpl implements ItemRevService{

    private final ItemRevMapper itemRevMapper;
    public ItemRevServiceImpl(ItemRevMapper itemRevMapper) {
        this.itemRevMapper = itemRevMapper;
    }

    // 리뷰 작성
    @Override
    public void posting(ItemRev itemRev) { itemRevMapper.create(itemRev); }

    // 리뷰 전체 리스트
    @Override
    public List<ItemRev> postList() {
        return itemRevMapper.postList();
    }

    // 리뷰 검색 리스트
    @Override
    public List<ItemRev> searchList(String searchValue) { return itemRevMapper.searchList(searchValue); }

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
