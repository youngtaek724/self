package com.example.app.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.app.auth.dto.AuthSignVO;
import com.example.app.auth.service.AuthService;
import com.example.app.exception.SeskException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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
   * @throws SeskException
   */
  @PostMapping("/join")
  // @PreAuthorize("@securityChecker.checkLevel('GUEST')")
  @Operation(summary = "회원가입", description = "회원가입")
  public ResponseEntity<Boolean> signUp(@RequestBody AuthSignVO body) throws SeskException {
    boolean result = authService.signUp(body);
    return new ResponseEntity<>(result, HttpStatus.OK);

  }

  /************************************************************************
   * 이메일 중복체크
   *
   * @param email
   * @throws SeskException
   */
  @GetMapping("/check/email")
  // @PreAuthorize("@securityChecker.checkLevel('GUEST')")
  @Operation(summary = "이메일 중복체크", description = "이메일 중복체크")
  public ResponseEntity<Boolean> checkEmail(@RequestParam("email") String email) throws SeskException {
    boolean check = authService.checkEmail(email);
    return new ResponseEntity<>(check, HttpStatus.OK);
  }

  /************************************************************************
   * 아이디 중복체크
   *
   * @param 아이디
   * @throws SeskException
   */
  @GetMapping("/check/id")
  // @PreAuthorize("@securityChecker.checkLevel('GUEST')")
  @Operation(summary = "아이디 중복체크", description = "아이디 중복체크")
  public ResponseEntity<Boolean> isDuplicatedId(@RequestParam("userId") String userId) throws SeskException {
    boolean check = authService.checkId(userId);
    return new ResponseEntity<>(check, HttpStatus.OK);
  }

}
