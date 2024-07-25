package com.example.app.user.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.security.dto.CustomUserDetails;
import com.example.app.user.dto.UserInfoVO;

@Mapper
public interface UserMapper {
  // 로그인 정보
  UserInfoVO loginInfo(String userId);

  // 로그인 토큰 정보 가져오기
  CustomUserDetails getUserLoginData(String id);

  // 이메일 정보 가져오기
  String findUserEmail(String email, String userName);

  // 인증시간 가져오기
  String findAuthStore(String email, String status);

  // 인증 실패 처리
  void expired(String status, String email);

  // 인증번호 중복체크
  Optional<String> findAuthKey(String authNumber);

  // 인증번호 저장
  void insertAuth(String status, String email, String authNumber);
}
