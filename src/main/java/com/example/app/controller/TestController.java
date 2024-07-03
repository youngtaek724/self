package com.example.app.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class TestController {

    @PostMapping("/test")
    @PreAuthorize("@securityChecker.checkLevel('GUEST')")
    public String test(Model model){
        return "hello";
    }

}























