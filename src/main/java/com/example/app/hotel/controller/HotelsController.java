package com.example.app.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hotels/*")
public class HotelsController {

    private final HotelService hotelService;

    @GetMapping("/hotels")
    public void hotels(Model model) {

    }

    // 호텔리스트 보기(지도)
    @GetMapping("/place")
    public void place(Model model) {

    }

    @GetMapping("/room")
    public void room(Model model) {

    }
}
