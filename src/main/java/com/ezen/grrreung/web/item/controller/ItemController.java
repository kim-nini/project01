package com.ezen.grrreung.web.item.controller;

import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.dto.ItemImg;
import com.ezen.grrreung.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/grrreung")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @RequestMapping("/")
    public String homeItemList(Model model){
        List<Item> list = itemService.allItems();
        model.addAttribute("item", list);
        return "/grrreung/index";
    }

    @RequestMapping("/shop")
    public String allItemsList(Model model){
        List<Item> list = itemService.allItems();
        model.addAttribute("item", list);

        // 썸네일 url 불러오기 **** 임시로 1 지정 ***************************************************************************************
        ItemImg image=null;
        String thumbnail="";

        for(Item i : list) {
            image = itemService.showThumbnail(i.getItemId());
            thumbnail = image.getImgUrl();
        }

        model.addAttribute("thumbnail", thumbnail);

        return "/grrreung/sub/shop";
    }

    // 아이템 아이디로 상품 한개 상세정보
    @GetMapping("/shop/item/{itemId}")
    public String itemInfo(@PathVariable("itemId")int itemId, Model model){
        Item item = itemService.findByItemId(itemId);
        model.addAttribute("item", item);
        return "/grrreung/sub/item";
    }

    // 카테고리별 상품 출력
    @GetMapping("/shop/{cateTop}")
    public String itemCate(@PathVariable("cateTop")String cateTop, Model model) {
        List<Item> item = itemService.findByCate(cateTop);
        model.addAttribute("item", item);
        return "/grrreung/sub/shop";
    }




}
