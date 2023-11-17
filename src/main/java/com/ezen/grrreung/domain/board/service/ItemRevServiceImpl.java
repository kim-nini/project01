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

    @Override
    public void posting(ItemRev itemRev) {

    }

    @Override
    public List<ItemRev> postList() {
        return itemRevMapper.postList();
    }

    @Override
    public ItemRev postInfo(int revCode) {
        return null;
    }

    @Override
    public void deletePost(int revCode) {

    }

    @Override
    public void updatePost(ItemRev itemRev) {

    }
}
