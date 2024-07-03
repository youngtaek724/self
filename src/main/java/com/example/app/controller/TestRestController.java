package com.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/test/*")
public class TestRestController {
    @PostMapping("/new")
    public String write(){
        return "hi";
    }
}