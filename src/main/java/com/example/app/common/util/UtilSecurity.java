package com.example.app.common.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.app.security.dto.CustomUserDetails;



public class UtilSecurity {
  public static CustomUserDetails getLoginSession() {
    if (SecurityContextHolder.getContext().getAuthentication() == null) {
      return null;
    }

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal.equals("anonymousUser")) {
      return null;
    }

    return (CustomUserDetails) principal;
  }
}
