package com.example.app.admin.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.app.admin.mapper.AdminMapper;
import com.example.app.admin.vo.AdminLoginVO;
import com.example.app.exception.SeskException;
import com.example.app.exception.enums.ExceptionCode;
import com.example.app.security.enums.RoleType;
import com.example.app.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

  private final JwtService jwtService;
  private final AdminMapper adminMapper;

  /****************************************************************
   * 관리자 로그인
   *
   * @param body 로그인 정보
   * @return Token String;
   */
  public String login(AdminLoginVO body) throws SeskException {
    // 1. 관리자 ID 체크
    AdminLoginVO adminLoginData = adminMapper.adminLogin(body.getId());

    // 2. 관리자 계정 유무와 비밀번호 일치 여부 체크
    if (adminLoginData == null || !BCrypt.checkpw(body.getPassword(), adminLoginData.getPassword())) {
        throw new SeskException(ExceptionCode.LOGIN_FAIL);
    }
    // 3. 토큰 생성
    return jwtService.generateToken(RoleType.ADMIN, adminLoginData.getId());
  }
}