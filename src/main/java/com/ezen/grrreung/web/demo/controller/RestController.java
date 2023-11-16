package com.ezen.grrreung.web.demo.controller;

import com.ezen.grrreung.domain.item.dto.item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API 서비스 세부 컨트롤러
 */
@Controller
@Slf4j
public class RestController {

    @RequestMapping("/text")
    @ResponseBody
    public String plainTextService(@RequestBody String message){
        log.info("요청메시지 바디의 내용 : {}", message);
        return "일반적인 텍스트입니다...";
    }

    @PostMapping("/product")
    @ResponseBody
    public item jsonService(@RequestBody item item){
        log.info("상품정보 : {}", item.toString());
        // DB에 상품정보 등록 생략
        return item;
    }

    @GetMapping("/product")
    @ResponseBody
    public List<item>  products(){
        // DB에 상품목록 조회 생략
        List<item> list = new ArrayList<>();
        list.add(new item(1111, "상품이름1", 1000));
        list.add(new item(2222, "상품이름2", 1000));
        list.add(new item(3333, "상품이름3", 1000));
        list.add(new item(4444, "상품이름4", 1000));
        list.add(new item(4444, "상품이름5", 1000));
        return list;
    }

}
