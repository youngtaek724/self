package com.example.app.user.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.exception.SeskException;
import com.example.app.exception.enums.ExceptionCode;
import com.example.app.security.enums.RoleType;
import com.example.app.security.jwt.JwtService;
import com.example.app.user.dto.UserInfoVO;
import com.example.app.user.enums.UserStatus;
import com.example.app.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserMapper userMapper;
  private final JwtService jwtService;

  /****************************************************************
   * 로그인
   *
   * @param userId
   * @param password
   * @throws SeskException
   */
  @Transactional(readOnly = true)
  public String login(String userId, String password) throws SeskException {
    UserInfoVO loginData = userMapper.loginInfo(userId);

    // 비밀번호 암호화 후 체크
    if (!BCrypt.checkpw(password, loginData.getPassword())) {
      throw new SeskException(ExceptionCode.LOGIN_FAIL);
    }

    // // 회원상태가 사용중지이거나 탈퇴일 경우 로그인 불가
    if (loginData.getStatus().equals(UserStatus.STOP) || loginData.getStatus().equals(UserStatus.WITHDRAW)) {
      throw new SeskException(ExceptionCode.USER_NOT_FOUND);
    }

    return jwtService.generateToken(RoleType.USER, loginData.getId());
  }

}
