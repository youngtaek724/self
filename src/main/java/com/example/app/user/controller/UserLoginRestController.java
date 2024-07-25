package com.example.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.exception.SeskException;
import com.example.app.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
@Tag(name = "👨🏻‍💼 회원", description = "회원")
public class UserLoginRestController {

  @Autowired
  private UserService userService;

  /************************************************************************
   * 로그인
   * 
   * @param body
   * @throws SeskException
   */
  @PostMapping("/token")
  @Operation(summary = "로그인", description = "로그인")
  public ResponseEntity<String> signUp(@RequestParam("userId") String userId, @RequestParam("password") String password)
      throws SeskException {
    String result = userService.login(userId, password);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  /************************************************************************
   * 이메일 인증번호 요청 - 아이디찾기
   * 
   * @param email
   * @return
   * @throws SeskException
   */
  @PostMapping("/request/email")
  @PreAuthorize("@securityChecker.checkLevel('GUEST')")
  @Operation(summary = "이메일 인증번호 요청 - 아이디찾기", description = "이메일 인증번호 요청 - 아이디찾기")
  public Boolean requestEmail(@RequestParam @NotNull String email,
      @RequestParam @NotNull String userName) throws SeskException {
    return userService.requestEmail(email, userName);
  }

  /************************************************************************
   * 아이디 찾기 - 이메일 인증 검증 및 아이디 찾기
   * 
   * @param userId
   * @param emailAuthCode
   * @return
   * @throws SeskException
   */
  // @PostMapping("/find/id")
  // @Operation(summary = "아이디 찾기", description = "아이디 찾기")
  // @PreAuthorize("@securityChecker.checkLevel('GUEST')")
  // public String findId(@RequestParam String emailAuthCode, @RequestParam String
  // email) throws SeskException {
  // return userService.findId(emailAuthCode, email);
  // }

  // 비밀번호 재설정

  // 회원탈퇴

}
