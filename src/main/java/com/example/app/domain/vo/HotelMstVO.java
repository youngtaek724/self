package com.example.app.domain.vo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@NoArgsConstructor
public class HotelMstVO {

    private int id;                   // 기본 키
    private String name;              // 호텔명
    private String tel;               // 전화번호
    private String defaultAddr;       // 기본 주소
    private String detailAddr;        // 상세 주소
    private String city;              // 지역
    private String state;             // 상태: 1, 2, 3
    private String zipCode;           // 우편번호
    private String country;           // 나라
    private String category;          // 카테고리

    @Builder
    public HotelMstVO(int id, String name, String tel, String defaultAddr, String detailAddr,
                      String city, String state, String zipCode, String country, String category) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.defaultAddr = defaultAddr;
        this.detailAddr = detailAddr;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.category = category;
    }
}