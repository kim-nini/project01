package com.ezen.grrreung.web.demo.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@Slf4j
public class MessageController {

    @RequestMapping("/message")
    public void message(@RequestParam("message") String message, HttpServletResponse response){
        response.setContentType("text/plain; charset=utf-8");
        log.info("수신한 메시지 : {}", message);
        try {
            PrintWriter out  = response.getWriter();
            // 메시지 에코
            out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/json")
    public void message2(HttpServletResponse response){
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out  = response.getWriter();
            // json 출력
            String json = "{\"id\" : \"bangry\", \"name\" : \"김기정\"}";
            out.println(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
