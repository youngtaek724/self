package com.example.app.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
@Component
@Data
@NoArgsConstructor
public class ContractInfoVO {

    private int id;               // 기본 키
    private int hotelId;          // HOTEL_MST 테이블 외래 키
    private int rankId;           // RANK_INFO 테이블 외래 키
    private Timestamp stDate;     // 계약 시작일
    private Timestamp edDate;     // 계약 종료일

    @Builder
    public ContractInfoVO(int id, int hotelId, int rankId, Timestamp stDate, Timestamp edDate) {
        this.id = id;
        this.hotelId = hotelId;
        this.rankId = rankId;
        this.stDate = stDate;
        this.edDate = edDate;
    }
}