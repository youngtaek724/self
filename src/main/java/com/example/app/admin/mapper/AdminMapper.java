package com.example.app.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.admin.vo.AdminLoginVO;
import com.example.app.security.dto.CustomUserDetails;

@Mapper
public interface AdminMapper {

  public AdminLoginVO adminLogin(String adminId);

  public CustomUserDetails getAdminLoginData(String id);

}
