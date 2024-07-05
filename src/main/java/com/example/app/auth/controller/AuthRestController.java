package com.example.app.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.auth.dto.SignUpBody;
import com.example.app.auth.service.AuthService;
import com.example.app.exception.SeskException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Valid
@RestController
@RequestMapping("/auth")
@Tag(name = "👨🏻‍💼 회원가입", description = "회원가입")
public class AuthRestController {

  @Autowired
  private AuthService authService;

  /************************************************************************
   * 회원가입
   * 
   * @param body
   * @throws TodayFishException
   */
  @PostMapping("/join")
  @PreAuthorize("@securityChecker.checkLevel('GUEST')")
  @Operation(summary = "회원가입", description = "회원가입")
  public ResponseEntity<Void> signUp(@ModelAttribute @Valid SignUpBody body) throws SeskException {
    authService.signUp(body);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  
}