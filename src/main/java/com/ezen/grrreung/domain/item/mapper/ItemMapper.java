package com.ezen.grrreung.domain.item.mapper;

import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.dto.ItemImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {

    /*
    * item 전체 목록 조회
    *
    * */
    public List<Item> findAllItems();

    // item_id로 1개 item 조회
    public Item findByItemId(int itemId);

    // 카테고리로 상품 조회
    public List<Item> findByCategory(String cateTop);

    // item 등록
    public void createItem(Item item);


    // 검색 타입별 item 검색
    public List<Item> findBySearchType(@Param("type") String type, @Param("value") String value);

   // 통합 검색
    public List<Item> findBySearchAll(String value);

    // 통합 검색
    public List<Item> findBySearchAllOption();


    // item 이미지 불러오기
    public ItemImg findThumbnail(int itemId);


}
