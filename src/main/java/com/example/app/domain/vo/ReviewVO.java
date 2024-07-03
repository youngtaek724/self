package com.example.app.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@NoArgsConstructor
public class ReviewVO {

    private int id;             // 기본 키
    private int userId;         // user_info 테이블 외래 키
    private String content;     // 내용
    private int rsvtId;         // reservation_info 테이블 외래 키
    private int star;           // 별점

    @Builder
    public ReviewVO(int id, int userId, String content, int rsvtId, int star) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.rsvtId = rsvtId;
        this.star = star;
    }
}