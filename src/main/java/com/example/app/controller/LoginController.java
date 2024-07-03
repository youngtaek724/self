package com.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {

    @GetMapping("/login")
    public void login(Model model){

    }

    @GetMapping("/register")
    public void register(Model model){

    }
}























