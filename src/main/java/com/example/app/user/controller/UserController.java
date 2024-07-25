package com.example.app.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*") // USER 관련 화면
public class UserController {

    /************************************************************************
     * 로그인 페이지 (USER)
     */
    @GetMapping("/login")
    public void login(Model model) {

    }

    /************************************************************************
     * 회원가입 페이지 (USER)
     */
    @GetMapping("/register")
    public void register() {
    }

    /************************************************************************
     * 마이페이지 > 내 정보 (USER)
     */
    @GetMapping("/mypage/info")
    public void mypageInfo() {
    }

    /************************************************************************
     * 마이페이지 > 예약내역 (USER)
     */
    @GetMapping("/mypage/reserve")
    public void mypageReserve() {

    }

    /************************************************************************
     * 마이페이지 > 리뷰내역 (USER)
     */
    @GetMapping("/mypage/review")
    public void mypageReview(Model model) {

    }

    /************************************************************************
     * 마이페이지 > 위시리스트 (USER)
     */
    @GetMapping("/mypage/wish")
    public void mypageWish(Model model) {

    }

}
