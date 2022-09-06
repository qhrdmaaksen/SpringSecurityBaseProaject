package com.example.SpringSecurityBaseProject.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller //@ 주로 view 를 반환하기 위해서 사용
public class MainController {

    @GetMapping("/")
    //principal 클래스: 모든 보안 주체에 공통되는 계정 데이터 및 작업을 캡슐화, 모든 보안 주체가 파생되는 추상 기본 클래스
    public String index (Model model, Principal principal){//principal에 담긴 사용자 정보 id출력
        //index 에 message key value 에 들어갈 내용
        //로그인했을 경우에는 로그인한 방문자의 이름을 따로 출력하게만들자
        if ( principal == null ){
            model.addAttribute("message","방문자님 안녕하세요. vitamin7777777 의 메인 화면입니다.");
        }else {
            model.addAttribute("message", principal.getName() + "님 안녕하세요 , vitamin7777777 의 메인 화면입니다.");
        }
        return "index";
    }
    @GetMapping("/info")
    public String info (Model model){
        //index 에 massage key value 에 들어갈
        model.addAttribute("message","안녕하세요. 사이트 정보 화면입니다.");
        return "info" ;
    }
    @GetMapping("/dashboard")
    public String dashboard (Model model, Principal principal){
        //index 에 massage key value 에 들어갈
        model.addAttribute("message","안녕하세요." + principal.getName() + " 님 게시물 화면입니다.");//principal에 담긴 사용자 정보 id출력
        //AccountContext.setAccount(accountRepository.findByUsername(principal.getName()));//사용자 정보를 가져와서 스레드로컬에 넣어주기
        return "dashboard" ;
    }
    @GetMapping("/admin")
    public String admin (Model model, Principal principal){
        //index 에 massage key value 에 들어갈
        model.addAttribute("message","안녕하세요." + principal.getName() + " 님 관리자 화면입니다.");
        return "admin" ;
    }
}
