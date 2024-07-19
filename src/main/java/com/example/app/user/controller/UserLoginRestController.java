package com.example.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.exception.SeskException;
import com.example.app.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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

}
