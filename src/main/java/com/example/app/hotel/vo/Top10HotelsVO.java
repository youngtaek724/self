package com.example.app.hotel.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Top10HotelsVO {
    private int ranking;
    private String hotelName;
    private int cnt;
    private int lowPrice;
    private int starRating;
}
