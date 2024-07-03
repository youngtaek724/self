package com.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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























