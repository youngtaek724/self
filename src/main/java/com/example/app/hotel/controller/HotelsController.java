package com.example.app.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hotels/*")
public class HotelsController {

    @GetMapping("/hotels")
    public void hotels(Model model){

    }

    @GetMapping("/place")
    public void place(Model model){

    }

    @GetMapping("/room")
    public void room(Model model){

    }
}























