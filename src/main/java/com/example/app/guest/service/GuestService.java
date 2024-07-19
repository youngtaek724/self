package com.example.app.guest.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.app.security.enums.RoleType;
import com.example.app.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuestService {
  private final JwtService jwtService;

  /************************************************************************
   * Guest 전용 토큰 생성
   * 
   * @return Token String
   */
  public String makeGuestToken() {
    String id = UUID.randomUUID().toString();
    String token = jwtService.generateToken(RoleType.GUEST, id);
    log.info("token : " + token);
    return token;
  }

}
