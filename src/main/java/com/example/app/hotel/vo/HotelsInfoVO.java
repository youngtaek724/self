package com.example.app.hotel.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class HotelsInfoVO {
    private int id;
    private int hotelId;
    private String Name;
    private String description;
    private String type;
    private int maxOccupancy;
    private boolean smokingAllowed;
    private boolean wifiYn;
    private boolean tvYn;
    private boolean parkingYn;
    private boolean breakfastIncluded;
    private int bedCnt;
    private Date checkinTime;
    private Date checkoutTime;
    private int price;
}
