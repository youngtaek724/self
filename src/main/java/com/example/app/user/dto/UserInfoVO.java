package com.example.app.user.dto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.app.user.enums.UserStatus;
import com.example.app.user.enums.UserType;

import java.sql.Timestamp;

@Data
@Component
@NoArgsConstructor
public class UserInfoVO {

    private Integer id;                  // 기본 키
    private String userId;           // 아이디
    private String password;         // 비밀번호
    private String name;             // 회원명
    private String phone;            // 핸드폰번호
    private String defaultAddr;      // 기본주소
    private String detailAddr;       // 상세주소
    private String zipCode;          // 우편번호
    private String email;            // 이메일
    private UserType type;             // 타입: USER, HOTEL, ADMIN
    private Timestamp rgstDate;      // 가입일
    private Timestamp updateDate;    // 수정일(탈퇴일)
    private UserStatus status;           // 상태: USING, STOP, WITHDRAW
    private Integer rankId;              // rank_info 테이블의 외래 키

    @Builder
    public UserInfoVO(int id, String userId, String password, String name, String phone,
                    String defaultAddr, String detailAddr, String zipCode, String email,
                    UserType type, Timestamp rgstDate, Timestamp updateDate, UserStatus status, int rankId) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.defaultAddr = defaultAddr;
        this.detailAddr = detailAddr;
        this.zipCode = zipCode;
        this.email = email;
        this.type = type;
        this.rgstDate = rgstDate;
        this.updateDate = updateDate;
        this.status = status;
        this.rankId = rankId;
    }
}