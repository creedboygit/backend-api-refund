package com.jobis.refund.api.controller.user;

import com.jobis.refund.api.controller.user.request.AddUserRequest;
import com.jobis.refund.api.controller.user.request.LoginRequest;
import com.jobis.refund.api.controller.user.response.LoginResponse;
import com.jobis.refund.api.controller.user.response.UserInfoResponse;
import com.jobis.refund.api.service.user.UserService;
import com.jobis.refund.common.util.SecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/szs", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "회원 등록1", description = "",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = Long.class)))})
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public Long addUser(@RequestBody @Valid AddUserRequest request) throws Exception {
        return userService.addUser(request);
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest request) throws Exception {
        return userService.login(request);
    }

    @GetMapping(value = "/me")
    @ResponseStatus(HttpStatus.OK)
//    public UserInfoResponse findUserInfo() throws Exception {
    public UserInfoResponse findUserInfo() throws Exception {
        return userService.findUserInfo(SecurityUtil.getCurrentMemberId());
    }
}
