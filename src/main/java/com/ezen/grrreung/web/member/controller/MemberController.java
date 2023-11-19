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
//    @PostMapping("/register")
//    public String register(@ModelAttribute("member") Member member,
//                           HttpServletRequest request,  Model model){
//        log.info("수신한 회원 정보 : {}", member.toString());
//        memberService.register(member);
//        request.getSession().setAttribute("member", member);
//        return "redirect:/member/result";
//    }

    @PostMapping("/register")
    @ResponseBody
    public boolean register(@RequestBody Member member){
        log.info("수신한 회원 정보 : {}", member.toString());
        try {
            memberService.register(member);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @GetMapping("/idcheck")
    @ResponseBody
    public boolean idCheck(@RequestParam("id") String id){
        log.info("수신한 아이디 : {}", id);
        Member member = memberService.getMember(id);
        if(member != null){
            return true;
        }
        return false;
    }

    /**
     * 회원 가입 결과 요청
     */
    @RequestMapping("/result")
    public String result(HttpServletRequest request){
        return "member/result";
    }

    /**
     * 회원 상세 정보 요청
     */
    @RequestMapping("/{memberId}")
    public String view(@PathVariable("memberId") String id, Model model){
        System.out.println("전달 받은 아이디 : " + id);
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "member/view";
    }

    /**
     * 전체 회원 목록 조회 요청
     */
    @GetMapping()
    public String list(Model model){
        List<Member> list = memberService.getMembers();
        model.addAttribute("list", list);
        return "member/list";
    }
}

