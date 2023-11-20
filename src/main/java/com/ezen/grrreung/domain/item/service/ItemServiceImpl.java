package com.ezen.grrreung.domain.item.service;

import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.dto.ItemImg;
import com.ezen.grrreung.domain.item.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }


    @Override
    public void registerItem(Item item) {
        itemMapper.createItem(item);
    }

    @Override
    public List<Item> allItems() {
        return itemMapper.findAllItems();
    }

    @Override
    public List<Item> findByCate(String cateTop) {
        return itemMapper.findByCategory(cateTop);
    }


    @Override
    public Item findByItemId(int itemId) {
        return itemMapper.findByItemId(itemId);
    }

    @Override
    public String showThumbnail(int itemId) {
        return itemMapper. findThumbnail(itemId);
    }

    @Override
    public List<ItemImg> showImageSlide(int itemId) {
        return itemMapper.findItemImages(itemId);
    }
}
//    private final MemberMapper memberMapper;
//
//    @Autowired
//    public ItemServiceImpl(MemberMapper memberMapper) {
//        this.memberMapper = memberMapper;
//    }
//
//    @Override
//    public void register(Member member) {
//        memberMapper.create(member);
//    }
//
//    @Override
//    public Member getMember(String memberId) {
//        return memberMapper.findById(memberId);
//    }
//
//    @Override
//    public List<Member> getMembers() {
//        return memberMapper.findByAll();
//    }