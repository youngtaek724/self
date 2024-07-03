package com.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {

    @GetMapping("/mypageInfo")
    public void mypageInfo(Model model){

    }

    @GetMapping("/mypageReserve")
    public void mypageReserve(Model model){

    }

    @GetMapping("/mypageReview")
    public void mypageReview(Model model){

    }

    @GetMapping("/mypageWish")
    public void mypageWish(Model model){

    }
}






















