package com.ezen.grrreung.web.member.controller;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 가입 화면 요청
     */
    @GetMapping("/register")
    public String registerForm(){
        return "member/register";
    }

    /**
     * 회원 가입 처리 요청
     */
    @PostMapping("/register")
    public String register(@ModelAttribute("member") Member member){
        log.info("수신한 회원 정보 : {}", member.toString());
        memberService.register(member);
        return "redirect:/";
    }


}

