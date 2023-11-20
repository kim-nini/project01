package com.ezen.grrreung.web.member.controller;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/grrreung")
@RequiredArgsConstructor
@SessionAttributes
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /**
     * 로그인 화면 요청
     */
    @GetMapping("/login")
    public String loginForm() {
        return "grrreung/sub/login";
    }

    /**
     * 로그인 처리 요청
     */
    @PostMapping("/login")
    public String login(Member member, HttpServletRequest request,  Model model) {
        Member findMember = memberService.login(member.getMemberId(), member.getPassword());
        log.info("로그인 회원 아이디 : {}", findMember);
        HttpSession session = request.getSession();
        if(findMember != null){
            session.setAttribute("loginMember", findMember);
            return "redirect:/";
        }else{
            return "grrreung/sub/login";
        }
    }

    /**
     * 로그아웃 처리 요청
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
        
    

    /**
     * 회원 가입 화면 요청
     */
    @GetMapping("/register")
    public String registerForm() {
        return "/grrreung/sub/register";
    }

    /**
     * 회원 가입 처리 요청
     */
    @PostMapping("/register")
    public String register(@ModelAttribute("member") Member member) {
        log.info("수신한 회원 정보 : {}", member.toString());
        memberService.register(member);  // 디비연결
        return "redirect:/grrreung/result";
    }

    /**
     * 회원가입 결과 페이지
     */
    @GetMapping("/result")
    public String result(HttpServletRequest request) {
        return "/grrreung/sub/result";
    }


    /**
     * 회원가입 상세 정보
     */
    @RequestMapping ("/mypage/{memberId}")
    public String info(@PathVariable String memberId, Model model){
        System.out.println("전달 받은 아이디 : " + memberId);
        Member member = memberService.memberInfo(memberId);
        model.addAttribute("member", member);
        return "/grrreung/sub/mypage";
    }

    
    /**
     * 회원가입 수정 화면
     */
    @GetMapping("/update/{memberId}")
    public String update(@PathVariable String memberId, Model model){
        Member member = memberService.memberInfo(memberId);
        model.addAttribute("member", member);
        return "/grrreung/sub/update";
    }

    /**
     * 회원가입 수정 처리
     */
    @PostMapping("/update")
    public String update(@ModelAttribute("member") Member member) {
        memberService.updateInfo(member);
        return "redirect:/grrreung/mypage";
    }



}