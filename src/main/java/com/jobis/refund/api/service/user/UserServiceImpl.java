package com.jobis.refund.api.service.user;

import com.jobis.refund.api.controller.user.request.AddUserRequest;
import com.jobis.refund.api.controller.user.request.LoginRequest;
import com.jobis.refund.api.controller.user.response.LoginResponse;
import com.jobis.refund.api.controller.user.response.UserInfoResponse;
import com.jobis.refund.api.repository.UserRepository;
import com.jobis.refund.api.service.user.mapper.UserMapper;
import com.jobis.refund.common.config.JwtProvider;
import com.jobis.refund.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    @Transactional
    @Override
    public Long addUser(AddUserRequest request) throws Exception {

        if (userRepository.findByUserId(request.getUserId()).isPresent()) {
            throw new Exception("이미 존재하는 아이디입니다.");
        }

        if (userRepository.findByRegNo(request.getRegNo()).isPresent()) {
            throw new Exception("이미 존재하는 주민등록번호입니다.");
        }

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        request.setRegNo(passwordEncoder.encode(request.getRegNo()));

        User user = UserMapper.INSTANCE.toEntity(request);

        userRepository.save(user);
        return user.getIdx();
    }

    @Transactional
    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUserId(request.getUserId()).orElseThrow(() ->
                new BadCredentialsException("가입되지 않은 회원입니다."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return LoginResponse.builder()
                .idx(user.getIdx())
                .userId(user.getUserId())
                .name(user.getName())
                .token(jwtProvider.createToken(user))
                .build();

    }

    @Transactional
    @Override
    public UserInfoResponse findUserInfo(Long userIdx) {
        User user = userRepository.findById(userIdx).orElseThrow(() ->
                new BadCredentialsException("가입되지 않은 회원입니다."));

        return UserInfoResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .regNo(user.getRegNo())
                .build();
    }
}


