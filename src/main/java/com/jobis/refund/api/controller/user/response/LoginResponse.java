package com.jobis.refund.api.controller.user.response;

import com.jobis.refund.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private Long idx;

    private String userId;

    private String name;

    private String token;
}