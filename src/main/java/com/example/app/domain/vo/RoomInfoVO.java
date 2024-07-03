package com.example.app.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@NoArgsConstructor
public class RoomInfoVO {

    private int id;                 // 기본 키
    private int hotelId;            // hotel_mst 테이블 외래 키
    private String name;            // 방 이름
    private int price;              // 가격
    private String description;     // 설명
    private String type;            // 타입: SINGLE, DOUBLE, SUITE
    private int maxOccupancy;       // 최대 인원 수
    private boolean smokingAllowed; // 흡연 가능 여부
    private boolean wifiYn;         // 와이파이 여부
    private boolean tvYn;           // 티비 여부
    private boolean parkingYn;      // 주차 가능 여부
    private boolean breakfastIncluded; // 조식 포함 여부
    private int bedCnt;             // 침대 수

    @Builder
    public RoomInfoVO(int id, int hotelId, String name, int price, String description, String type,
                      int maxOccupancy, boolean smokingAllowed, boolean wifiYn, boolean tvYn,
                      boolean parkingYn, boolean breakfastIncluded, int bedCnt) {
        this.id = id;
        this.hotelId = hotelId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
        this.maxOccupancy = maxOccupancy;
        this.smokingAllowed = smokingAllowed;
        this.wifiYn = wifiYn;
        this.tvYn = tvYn;
        this.parkingYn = parkingYn;
        this.breakfastIncluded = breakfastIncluded;
        this.bedCnt = bedCnt;
    }
}