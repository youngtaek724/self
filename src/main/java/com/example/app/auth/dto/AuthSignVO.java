package com.example.app.auth.dto;

import com.example.app.user.enums.UserStatus;
import com.example.app.user.enums.UserType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthSignVO {

  // 회원가입
  private Integer id;
  private String userId; // 아이디
  private String password; // 비밀번호
  private String name; // 회원명
  private String phone; // 핸드폰번호
  private String defaultAddr; // 기본주소
  private String detailAddr; // 상세주소
  private String zipCode; // 우편번호
  private String email; // 이메일
  private UserType type; // 타입: USER, HOTEL, ADMIN
  private UserStatus status; // 상태: USING, STOP, WITHDRAW
  private Integer rankId; // rank_info 테이블의 외래 키

}
