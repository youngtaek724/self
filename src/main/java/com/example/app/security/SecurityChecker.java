package com.example.app.security;

import org.springframework.stereotype.Component;

import com.example.app.common.util.UtilSecurity;
import com.example.app.security.dto.CustomUserDetails;
import com.example.app.security.enums.RoleType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityChecker {

  /******************************************************************
   * 권한 레벨 체크
   * 
   * @param roleType
   * @return true: 권한 레벨이 같거나 높음, false: 권한 레벨이 낮음
   */
  public boolean checkLevel(RoleType roleType) {
    CustomUserDetails loginSession = UtilSecurity.getLoginSession();
    if (loginSession == null)
      return false;

    log.info("레벨 확인 session : " + loginSession.getRoleType().getLevel()); // guest _ 3
    log.info("레벨 확인 role : " + roleType.getLevel()); // admin _ 1
 
    // 로그인한 사용자의 권한 레벨이 낮으면 false
    if (loginSession.getRoleType().getLevel() > roleType.getLevel()) {
      return false;
    }


    return true;
  } 
}
