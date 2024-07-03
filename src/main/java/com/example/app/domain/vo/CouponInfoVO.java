package com.example.app.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@NoArgsConstructor
public class CouponInfoVO {

    private int id;                   // 기본 키
    private int userId;               // user_info 테이블
    private boolean useYn;            // 발급여부
    private Timestamp rgstDate;       // 발급일
    private Timestamp expireDate;     // 만료일
    private String status;            // 할인타입: PERCENT, KRW
    private boolean duplicate;        // 중복사용여부
    private int price;                // 할인가격
    private String systemName;        // 발급시스템명: HOTEL, ADMIN
    private int quantity;             // 발급수량

    @Builder
    public CouponInfoVO(int id, int userId, boolean useYn, Timestamp rgstDate, Timestamp expireDate,
                        String status, boolean duplicate, int price, String systemName, int quantity) {
        this.id = id;
        this.userId = userId;
        this.useYn = useYn;
        this.rgstDate = rgstDate;
        this.expireDate = expireDate;
        this.status = status;
        this.duplicate = duplicate;
        this.price = price;
        this.systemName = systemName;
        this.quantity = quantity;
    }
}