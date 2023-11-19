package com.ezen.grrreung.domain.board.service;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.mapper.ItemQnaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemQnaServiceImpl implements ItemQnaService{

    private final ItemQnaMapper itemQnaMapper;

    public ItemQnaServiceImpl(ItemQnaMapper itemQnaMapper) {
        this.itemQnaMapper = itemQnaMapper;
    }

    @Override
    public void posting(ItemQna itemQna) {
        itemQnaMapper.create(itemQna);
    }

    @Override
    public List<ItemQna> postList() {
        return itemQnaMapper.postList();
    }

    @Override
    public List<ItemQna> searchList(String searchValue) {
        return itemQnaMapper.searchList(searchValue);
    }


    @Override
    public ItemQna postInfo(int qnaCode) {
        return null;
    }

    @Override
    public void deletePost(int qnaCode) {

    }

    @Override
    public void updatePost(ItemQna itemQna) {

    }
}
