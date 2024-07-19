package com.example.app.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.user.dto.UserInfoVO;

@Mapper
public interface UserMapper {
  // 로그인 정보
  UserInfoVO loginInfo(String userId);
}
