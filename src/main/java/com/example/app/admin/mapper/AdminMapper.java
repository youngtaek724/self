package com.example.app.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.admin.vo.AdminLoginVO;
import com.example.app.security.dto.CustomUserDetails;

@Mapper
public interface AdminMapper {

  // 관리자 로그인
  public AdminLoginVO adminLogin(String adminId);

  // 관리자 로그인시 토큰 데이터 확인용
  public CustomUserDetails getAdminLoginData(String id);

}
