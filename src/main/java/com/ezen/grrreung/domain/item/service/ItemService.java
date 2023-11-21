package com.ezen.grrreung.domain.item.service;

import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.dto.ItemImg;

import java.util.List;
import java.util.Map;

public interface ItemService {

    // item 등록
    public void registerItem(Item item);

    // item 전체 조회
    public List<Item> allItems();

    // 카테고리로 조회
    public List<Item> findByCate(String cateTop);

    // item 1개 조회
    public Item findByItemId(int itemId);

    // item 썸네일
    public String showThumbnail(int itemId);

    // 상품 이미지 전체 조회하기
    public  List<Map<String, Object>> showImageSlide(int itemId);




}


//    public void register(Member member);
//
//    public Member getMember(String memberId);
//
//    public List<Member> getMembers();
