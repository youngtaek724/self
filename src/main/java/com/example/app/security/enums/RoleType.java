package com.example.app.security.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
  ADMIN(1, "ROLE_ADMIN"),
  USER(2, "ROLE_USER"),
  GUEST(3, "ROLE_GUEST"); 

  private int level;
  private String name;
}
