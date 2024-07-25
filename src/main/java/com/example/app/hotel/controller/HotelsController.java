package com.example.app.hotel.controller;

import com.example.app.common.util.RequestAPI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/hotels/*")
public class HotelsController {
    private final RequestAPI requestAPI;
    @GetMapping("/hotels")
    public void hotels(Model model){

    }
    @GetMapping("/hotels/{hotelId}")
    public void hotels(
            @PathVariable("hotelId") int hotelId,
            @RequestParam(value = "adultCnt", defaultValue = "2") int adultCnt,
            @RequestParam(value="childAges", required = false) String childAges,
            @RequestParam("checkIn") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut){
            String year = checkIn.getYear()+"";
            String month = checkIn.getMonthValue()+"";

    }
    @GetMapping("/place")
    public void place(Model model){

    }

    @GetMapping("/room")
    public void room(Model model){

    }
}























