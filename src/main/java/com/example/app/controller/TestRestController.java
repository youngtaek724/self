package com.example.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/test/*")
public class TestRestController {
    
    @PostMapping("/new")
    @PreAuthorize("@securityChecker.checkLevel('GUEST')")
    public String write(){
        return "hi";
    }
}