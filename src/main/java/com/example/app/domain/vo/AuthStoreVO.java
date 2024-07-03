package com.example.app.domain.vo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@NoArgsConstructor
public class AuthStoreVO {

    private int id;                   // 기본 키
    private String status;            // 인증상태: UNAUTHENTICATED, EXPIRED, AUTHENTICATED
    private String targetKey;         // 인증 대상
    private String authKey;           // 인증 번호
    private Timestamp requestTime;    // 요청시간
    private Timestamp expireTime;     // 만료시간
    private Timestamp validatedTime;  // 인증시간


    @Builder
    public AuthStoreVO(int id, String status, String targetKey, String authKey,
                       Timestamp requestTime, Timestamp expireTime, Timestamp validatedTime) {
        this.id = id;
        this.status = status;
        this.targetKey = targetKey;
        this.authKey = authKey;
        this.requestTime = requestTime;
        this.expireTime = expireTime;
        this.validatedTime = validatedTime;
    }
}