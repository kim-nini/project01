package com.ezen.grrreung;

import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.dto.ItemImg;
import com.ezen.grrreung.domain.item.mapper.ItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


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
		log.info(thumbnail.toString());

	}





}
