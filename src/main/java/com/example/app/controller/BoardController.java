package com.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    /*테스트용 taek 코드입니다*/
    @GetMapping("/faq")
    public void faq(Model model){

    }

    @GetMapping("/notice")
    public void notice(Model model){

    }

    @GetMapping("/noticeDetail")
    public void noticeDetail(Model model){

    }

    @GetMapping("/qnaReg")
    public void qnaReg(Model model){

    }
}























