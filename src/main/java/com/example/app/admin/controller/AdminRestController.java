package com.example.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.admin.service.AdminService;
import com.example.app.admin.vo.AdminLoginVO;
import com.example.app.exception.SeskException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Valid
@RestController
@RequestMapping("/admin")
@Tag(name = "👨🏻‍💼 관리자", description = "관리자")
public class AdminRestController {

  @Autowired
  private AdminService adminService;

  /************************************************************************
   * 관리자 로그인
   * 
   * @param body 로그인 정보
   * @return Token String
   * @throws SeskException
   */
  @PostMapping("/token")
  @Operation(summary = "01. 관리자 로그인", description = "관리자 로그인")
  public String login(@RequestBody @Valid AdminLoginVO body) throws SeskException {
    // 변경점 확인
    return adminService.login(body);
  }
  
}
