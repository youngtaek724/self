package com.example.app.domain.vo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
@Component
@Data
@NoArgsConstructor
public class UserCouponVO {

    private int id;             // SEQ(AUTO)
    private int userId;         // user_info 테이블
    private int couponId;       // coupon_info 테이블
    private Timestamp useDate;  // 사용날짜
    private boolean useYn;      // 사용여부

    @Builder
    public UserCouponVO(int id, int userId, int couponId, Timestamp useDate, boolean useYn) {
        this.id = id;
        this.userId = userId;
        this.couponId = couponId;
        this.useDate = useDate;
        this.useYn = useYn;
    }
}