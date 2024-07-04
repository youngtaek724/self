package com.example.app.admin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminLoginVO {

  @NotBlank
  @Schema(description = "아이디 (영문, 숫자를 포함한 4~20자리)", example = "admin")
  private String id;

  @NotBlank
  @Schema(description = "비밀번호 (영문, 숫자를 포함한 8~20자리)", example = "qwer1234")
  private String password;

}
