package com.ezen.grrreung;

import com.ezen.grrreung.domain.item.dto.Category;
import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.dto.ItemImg;
import com.ezen.grrreung.domain.item.mapper.ItemMapper;
import com.ezen.grrreung.web.common.page.Pagination;
import com.ezen.grrreung.web.common.page.RequestParams;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;


@SpringBootTest
@Slf4j
public class GrrItemTest {

	@Autowired
	private ItemMapper itemMapper;

	@Test
	public void findAllItemsTest() {
		List<Item> list = itemMapper.findAllItems();
		for (Item item: list) {
			log.info(item.toString());
		}
	}

	@Test
	public void findByItemIdTest() {
		int itemId = 1;
		Item item = itemMapper.findByItemId(itemId);
		log.info(item.toString());
	}

	@Test
	public void findByCateTest() {
		String cateTop = "living";
		List<Item> item = itemMapper.findByCategory(cateTop);
		log.info(item.toString());
	}

	@Test
	public void createItemTest() {
		Item item = new Item();
		item.setItemId(14);
		item.setCateCode(1005);
		item.setItemName("상품14");
		item.setItemPrice(10000);
		item.setItemAmount(58);
		item.setItemDetail("상품설명14");
		itemMapper.createItem(item);
		log.info(item.toString());
	}


	@Test
	public void findByCategoryTest() {
		List<Item> list = itemMapper.findByCategory("living");
		for(Item item: list) {
			log.info(item.toString());
		}

	}


	@Test
	public void  findItemImageTest() {
//		ItemImg thumbnail = itemMapper.findThumbnail(1);
		String thumbnail = itemMapper.findThumbnail(1);
		log.info(thumbnail);
	}

	@Test
	public void findItemImages() {
		List<Map<String, Object>> images = itemMapper.findItemImages(1);
		for(Map<String, Object>  map : images) {
			String imageName = (String)map.get("IMG_NAME");
			log.info("이미지 파일명 : {}", imageName);
		}

	}


	@Test
	public void findCateAll() {
		List<Category> cateList = itemMapper.findCateAll();
		for (Category category: cateList) {
			log.info("카테고리명 : {} {}",category.getCateTop(), category.getCateName());
		}
	}


	@Test
	public void findCateNameTest() {
		String cateTop = "living";
		List<Category> list = itemMapper.findCateName(cateTop);
		for (Category cate : list) {
			log.info("상세 카테고리명 : {}", cate.getCateName() );
		}
	}


	@Test
	public void findDescriptionImagesTest() {
		List<Map<String, Object>> list = itemMapper.findDescriptionImages(11);

		for(Map<String, Object> map : list) {
			log.info("{}",map.get("IMG_NAME"));
		}
	}




	@Test
	public void findByParamsTest() {

		RequestParams params = new RequestParams();
		params.setRequestPage(1);
		params.setElementSize(8);
		params.setSearch("상품");

		List<Item> list = itemMapper.findByParams(params);
		for (Item item : list) {
			log.info("검색 목록 : {}", item);
		}

		int count = itemMapper.countByParams(params);
		log.info("조회된 상품 개수 : {}", count);
		Pagination pg = new Pagination(params, count);
		log.info("페이지네이션 : {}", pg.toString());

	}


	@Test
	public void registerItemTest() {
		Item item = new Item(13, 1003, "상품13", 32000, 100, "상품설명13" );
		itemMapper.createItem(item);
	}



}
