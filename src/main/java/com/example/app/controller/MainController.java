package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    private final HotelService hotelService;

    @GetMapping("/home")
    public void home(Model model) {
        model.addAttribute("top10Hotels", hotelService.showTop10Hotels("서울"));
    }
}
