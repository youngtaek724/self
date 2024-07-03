package com.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

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























