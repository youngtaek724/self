package com.example.app.domain.vo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class WishListVO {

    private int id;         // 기본 키
    private int hotelId;    // hotel_mst 테이블 외래 키
    private int userId;     // user_info 테이블 외래 키

    @Builder
    public WishListVO(int id, int hotelId, int userId) {
        this.id = id;
        this.hotelId = hotelId;
        this.userId = userId;
    }
}