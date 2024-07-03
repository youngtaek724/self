package com.example.app.security.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.app.security.enums.RoleType;

import lombok.Getter;

@Getter
public class CustomUserDetails implements UserDetails {
  private static final long serialVersionUID = 1L;
  private final String username;
  private final String password;
  private RoleType roleType;

  public CustomUserDetails(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public CustomUserDetails(Integer username, String password) {
    this.username = String.valueOf(username);
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(roleType.toString()));
    return authorities;
  }

  public RoleType getRoleType() {
    return roleType;
  }

  public void setRoleType(RoleType roleType) {
    this.roleType = roleType;
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(0, authority);

  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
