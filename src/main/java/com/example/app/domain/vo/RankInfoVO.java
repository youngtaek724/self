package com.example.app.domain.vo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@NoArgsConstructor
public class RankInfoVO {

    private int id;                   // 기본 키
    private int commision;            // 계약 수수료
    private String rankType;          // 등급: BRONZE, SILVER, GOLD
    private String userType;          // 고객 구분: USER, HOTEL

    @Builder
    public RankInfoVO(int id, int commision, String rankType, String userType) {
        this.id = id;
        this.commision = commision;
        this.rankType = rankType;
        this.userType = userType;
    }
}