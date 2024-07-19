package com.example.app.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.auth.dto.AuthSignVO;

@Mapper
public interface AuthMapper {
    // 이메일 중복체크
    boolean checkEmail(String email);

    // 아이디 중복체크
    boolean checkId(String id);

    // 회원가입
    boolean insertSignUp(AuthSignVO signUpBody);

}
