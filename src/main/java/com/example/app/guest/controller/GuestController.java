package com.example.app.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.guest.service.GuestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/guest")
@Tag(name = "👨🏻‍💼 손님(방문자) API", description = "로그인 하기 전 손님(방문자) 전용")
public class GuestController {

  @Autowired
  private GuestService guestService;

  /**
   * Guest 전용 토큰 생성
   * 
   * @return Token String
   */
  @PostMapping("/token")
  @Operation(summary = "01. 게스트 로그인", description = "게스트 로그인")
  public String makeGuestToken() {
    return guestService.makeGuestToken();
  }

}
