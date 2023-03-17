package com.jobis.refund.api.service.user;

import com.jobis.refund.api.controller.user.request.AddUserRequest;
import com.jobis.refund.api.controller.user.request.LoginRequest;
import com.jobis.refund.api.controller.user.response.LoginResponse;
import com.jobis.refund.api.controller.user.response.UserInfoResponse;

public interface UserService {

    Long addUser(AddUserRequest request) throws Exception;

    LoginResponse login(LoginRequest request) throws Exception;

    UserInfoResponse findUserInfo(Long currentMemberId) throws Exception;
}
