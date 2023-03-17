package com.jobis.refund.api.controller.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "AddUserRequest", description = "회원 등록 Request")
public class AddUserRequest {

    @NotBlank(message = "아이디를 입력해 주세요.")
    @Schema(title = "userId", description = "아이디", example = "programmer")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    @Schema(title = "password", description = "비밀번호", example = "123456")
    private String password;

    @NotBlank(message = "이름을 입력해 주세요.")
    @Schema(title = "name", description = "이름", example = "박연진")
    private String name;

    @NotBlank(message = "주민등록번호를 입력해 주세요.")
    @Schema(title = "regNo", description = "주민등록번호", example = "860824-1655068")
    private String regNo;
}
