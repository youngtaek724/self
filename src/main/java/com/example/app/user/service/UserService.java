package com.example.app.user.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.auth.enums.AuthStoreStatus;
import com.example.app.common.util.MailUtil;
import com.example.app.common.util.RandomUtil;
import com.example.app.exception.SeskException;
import com.example.app.exception.enums.ExceptionCode;
import com.example.app.security.enums.RoleType;
import com.example.app.security.jwt.JwtService;
import com.example.app.user.dto.UserInfoVO;
import com.example.app.user.enums.UserStatus;
import com.example.app.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserMapper userMapper;
  private final JwtService jwtService;
  private final MailUtil mailUtil;

  /****************************************************************
   * 로그인
   *
   * @param userId
   * @param password
   * @throws SeskException
   */
  @Transactional(readOnly = true)
  public String login(String userId, String password) throws SeskException {
    UserInfoVO loginData = userMapper.loginInfo(userId);

    // 비밀번호 암호화 후 체크
    if (!BCrypt.checkpw(password, loginData.getPassword())) {
      throw new SeskException(ExceptionCode.LOGIN_FAIL);
    }

    // // 회원상태가 사용중지이거나 탈퇴일 경우 로그인 불가
    if (loginData.getStatus().equals(UserStatus.STOP) || loginData.getStatus().equals(UserStatus.WITHDRAW)) {
      throw new SeskException(ExceptionCode.USER_NOT_FOUND);
    }

    return jwtService.generateToken(RoleType.USER, loginData.getId());
  }

  /****************************************************************
   * 이메일 인증번호 요청 - 아이디찾기
   */
  @Transactional(rollbackFor = Exception.class)
  public Boolean requestEmail(String email, String userName) throws SeskException {

    // 0-1. 해당 이름과 이메일이 일치하는 데이터가 존재하는지 확인
    String userEmail = userMapper.findUserEmail(email, userName);
    if (!email.equals(userEmail)) {
      throw new SeskException(ExceptionCode.NOT_FOUND);
    }

    // 1. 이메일로 1분내에 발송한 데이터가 있는지 확인
    String requestTime = userMapper.findAuthStore(email, AuthStoreStatus.UNAUTHENTICATED.toString()); // requestTime
    if (requestTime != null) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSX");
      LocalDateTime dateTime = LocalDateTime.parse(requestTime, formatter);
      LocalDateTime oneMinuteAgo = LocalDateTime.now().minusMinutes(1);
      if (dateTime.isAfter(oneMinuteAgo)) {
        throw new SeskException(ExceptionCode.ERROR_TRY_AGAIN);
      }
    }

    // 2. 이전에 발송한 정보를 전부 인증 실패로 처리
    userMapper.expired(AuthStoreStatus.EXPIRED.toString(), email); // update

    // 3. 인증 번호 생성
    String authNumber = RandomUtil.makeRandomNumber(6);

    // 4. 인증번호 중복체크
    Optional<String> check = userMapper.findAuthKey(authNumber);
    boolean exists = check.isPresent();
    if (exists) {
      throw new SeskException(ExceptionCode.ERROR_DUPLICATION_AUTH_NUMBER);
    }

    // 5. 인증 번호 발송
    mailUtil.sendAuthMail(email, authNumber);

    // 6. 인증번호 저장소 등록
    userMapper.insertAuth(AuthStoreStatus.UNAUTHENTICATED.toString(), email, authNumber);

    return true;
  }

  // /****************************************************************
  // * 아이디 찾기 - 이메일 인증 검증 및 아이디 찾기
  // *
  // * @param emailAuthCode
  // * @param email
  // * @return
  // * @throws SeskException
  // */
  // @Transactional(readOnly = true)
  // public String findId(String emailAuthCode, String email) throws
  // SeskException {
  // // 1. 이메일 인증 검증
  // Optional<AuthStore> emailAuthStore =
  // authStoreRepository.findByAuthKeyAndStatus(
  // emailAuthCode, AuthStoreStatus.AUTHENTICATED);

  // if (!emailAuthStore.isPresent()) {
  // throw new SeskException(ExceptionCode.ERROR_AUTH_EMAIL);
  // }

  // // 2. 이메일로 아이디 조회
  // Optional<User> user = userRepository.findByEmail(email);

  // return user.get().getUserId();
  // }
}
