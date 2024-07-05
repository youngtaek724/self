package com.example.app.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.auth.dto.SignUpBody;
import com.example.app.auth.mapper.AuthMapper;
import com.example.app.exception.SeskException;
import com.example.app.user.dto.UserInfoVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private AuthMapper authMapper;

  public void signUp(UserInfoVO userInfoVO) {
  }

  /****************************************************************
   * 회원가입
   * 
   * @param signUpBody
   * @throws TodayFishException
   */
  @Transactional(rollbackFor = Exception.class)
  public void signUp(SignUpBody signUpBody) throws SeskException {

  }

}

