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

  /**
   * 관리자 로그인
   *
   * @param body 로그인 정보
   * @return Token String
   */
  public String login(AdminLoginVO body) throws SeskException {

    AdminLoginVO adminLoginData = adminMapper.adminLogin(body.getId());

    if (adminLoginData == null || !BCrypt.checkpw(body.getPassword(), adminLoginData.getPassword())) {
        throw new SeskException(ExceptionCode.LOGIN_FAIL);
    }

    return jwtService.generateToken(RoleType.ADMIN, adminLoginData.getId());
}
}