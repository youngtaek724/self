package com.example.app.auth.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

import com.example.app.auth.dto.AuthSignVO;
import com.example.app.auth.mapper.AuthMapper;
import com.example.app.exception.SeskException;
import com.example.app.exception.enums.ExceptionCode;
import com.example.app.user.enums.UserStatus;
import com.example.app.user.enums.UserType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AuthMapper authMapper;

  /****************************************************************
   * 회원가입
   * 
   * @param signUpBody
   * @throws SeskException
   */
  @Transactional(rollbackFor = Exception.class)
  public boolean signUp(AuthSignVO signUpBody) throws SeskException {

    // 아이디 중복여부 확인
    if (checkId(signUpBody.getUserId())) {
      throw new SeskException(ExceptionCode.DUPLICATED_ID);
    }

    // 이메일 중복여부 확인
    if (checkEmail(signUpBody.getEmail())) {
      throw new SeskException(ExceptionCode.DUPLICATED_EMAIL);
    }

    // 핸드폰번호 인증 여부(TODO : 일단 생략)
    
    // 비밀번호 암호화처리
    signUpBody.setPassword(BCrypt.hashpw(signUpBody.getPassword(), BCrypt.gensalt()));

    signUpBody.setType(UserType.USER);
    signUpBody.setStatus(UserStatus.USING);
    signUpBody.setRankId(1);

    return authMapper.insertSignUp(signUpBody);
  }

  /****************************************************************
   * 이메일 중복체크
   *
   * @param email
   * @throws SeskException
   */
  @Transactional(readOnly = true)
  public boolean checkEmail(String email) throws SeskException {
    return authMapper.checkEmail(email);
  }

  /****************************************************************
   * 아이디 중복체크
   *
   * @param userId
   * @throws SeskException
   */
  @Transactional(readOnly = true)
  public boolean checkId(String userId) throws SeskException {
    Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,12}$");
    if (!pattern.matcher(userId).matches()) {
      return false;
    }
    return authMapper.checkId(userId);
  }
}
