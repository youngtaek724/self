package com.example.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.app.admin.mapper.AdminMapper;
import com.example.app.security.dto.CustomUserDetails;
import com.example.app.security.enums.RoleType;
import com.example.app.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

  @Autowired
  private AdminMapper adminMapper;

  @Autowired
  private UserMapper userMapper;

  // admin

  // user
  @Override
  public CustomUserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    String findRole = id.split(":")[0];
    String findId = id.split(":")[1];

    log.info("findRole : " + findRole);
    log.info("findId : " + findId);

    CustomUserDetails userDetails = null;

    if (findRole.equals("GUEST")) {
      userDetails = new CustomUserDetails(findId, findId);
      userDetails.setRoleType(RoleType.GUEST);
    } else if (findRole.equals("ADMIN")) {
      try {
        userDetails = adminMapper.getAdminLoginData(findId);
        if (userDetails == null) {
          throw new UsernameNotFoundException(id);
        }
        userDetails.setRoleType(RoleType.ADMIN);
      } catch (NumberFormatException e) {
        throw new UsernameNotFoundException("Invalid ID format: " + id, e);
      }
    } else if (findRole.equals("USER")) {
      try {
        userDetails = userMapper.getUserLoginData(findId);
        if (userDetails == null) {
          throw new UsernameNotFoundException(id);
        }
        userDetails.setRoleType(RoleType.USER);
      } catch (NumberFormatException e) {
        throw new UsernameNotFoundException("Invalid ID format: " + id, e);
      }

    } else {
      throw new UsernameNotFoundException("Role not found for ID: " + id);
    }

    return userDetails;
  }
}
