package com.example.app.controller;

import com.example.app.hotel.service.HotelService;
import com.example.app.hotel.vo.Top10HotelsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainRestController {
    private final HotelService hotelService;
    @PostMapping("/home/{local}")
    public List<Top10HotelsVO> showTop10Hotels(@PathVariable String local){
        return hotelService.showTop10Hotels(local);
    }
}























