package com.example.app.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@NoArgsConstructor
public class ReservationInfoVO {

    private int id;                 // 기본 키
    private int userId;             // user_info 테이블 외래 키
    private int roomId;             // room_info 테이블 외래 키
    private Timestamp checkIn;      // 체크인 시간
    private Timestamp checkOut;     // 체크아웃 시간
    private boolean payYn;          // 결제 완료 여부
    private Timestamp createdAt;    // 예약 신청 일자
    private Integer couponId;       // coupon 테이블 외래 키
    private Integer couponPrice;    // 쿠폰 적용 가격
    private int roomPrice;          // 객실 가격

    @Builder
    public ReservationInfoVO(int id, int userId, int roomId, Timestamp checkIn, Timestamp checkOut,
                             boolean payYn, Timestamp createdAt, Integer couponId, Integer couponPrice,
                             int roomPrice) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.payYn = payYn;
        this.createdAt = createdAt;
        this.couponId = couponId;
        this.couponPrice = couponPrice;
        this.roomPrice = roomPrice;
    }
}