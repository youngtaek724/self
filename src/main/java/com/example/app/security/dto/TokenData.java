package com.example.app.security.dto;


import com.example.app.security.enums.RoleType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenData {
  private String id;
  private RoleType role;

}
