package com.ezen.grrreung.domain.board.mapper;

import com.ezen.grrreung.domain.board.dto.ItemRev;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemRevMapper {

    public void create(ItemRev itemRev);

    public List<ItemRev> postList();

    public ItemRev findByBno(int revCode);

    public void updateByRevCode(ItemRev itemRev);

    public void deletePost(int revCode);

    public void hitCountUpdate(int revCode);
}
