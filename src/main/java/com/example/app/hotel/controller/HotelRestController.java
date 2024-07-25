package com.example.app.hotel.controller;

import com.example.app.common.util.RequestAPI;
import com.example.app.controller.ApiController;
import com.example.app.guest.service.GuestService;
import com.example.app.hotel.service.HotelService;
import com.example.app.hotel.vo.HotelsInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/hotels")
@Tag(name = "호텔 API", description = "호텔 API")
public class HotelRestController {
    @Autowired
    private HotelService hotelService;
    @PostMapping("/{hotelId}")
    public String abc(
            @PathVariable int hotelId,
            @RequestParam(required = false, defaultValue = "2") int adultCnt,
            @RequestParam(required = false, defaultValue = "0") int childAges,
            @RequestParam("checkIn") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut
    ) throws IOException {
        log.info("hotelId:{}", hotelId);
        log.info("checkIn:{}", checkIn);
        log.info("checkOut:{}", checkOut);
        log.info("adultCnt:{}", adultCnt);
        log.info("childAges:{}", childAges);
        hotelService.hotelsInfo(hotelId, adultCnt, childAges, checkIn, checkOut);
       return "success";
    }

}
