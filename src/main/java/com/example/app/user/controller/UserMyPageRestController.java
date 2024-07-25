package com.example.app.user.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.exception.SeskException;
import com.example.app.user.dto.MyPageInfoData;
import com.example.app.user.service.MypageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
@Tag(name = "👨🏻‍💼 마이페이지", description = "마이페이지")
public class UserMyPageRestController {

  private final MypageService mypageService;

  /************************************************************************
   * 내 정보 가져오기(이름, 아이디, 번호, 이메일, 주소(기본, 상세, 우편번호), 가입일, 랭크
   * 
   * @param id
   * @return
   */
  @GetMapping("/info")
  @PreAuthorize("@securityChecker.checkLevel('USER')")
  @Operation(summary = "내 정보 가져오기", description = "내 정보 가져오기")
  public MyPageInfoData showUserInfo(Principal id) throws SeskException {
    String userId = id.getName();
    MyPageInfoData result = mypageService.showUserInfo(userId);
    return result;
  }

  // 예약 내역

  // 찜한 여행지

  // 리뷰 내역

}
