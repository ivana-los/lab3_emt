package emt.lab_2_final.service.application.impl;

import emt.lab_2_final.helper.JwtHelper;
import emt.lab_2_final.model.domain.User;
import emt.lab_2_final.model.dto.LoginUserRequestDto;
import emt.lab_2_final.model.dto.LoginUserResponseDto;
import emt.lab_2_final.model.dto.RegisterUserRequestDto;
import emt.lab_2_final.model.dto.RegisterUserResponseDto;
import emt.lab_2_final.service.application.UserApplicationService;
import emt.lab_2_final.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto) {
        User user = userService.register(registerUserRequestDto.toUser());
        RegisterUserResponseDto displayUserDto = RegisterUserResponseDto.from(user);
        return Optional.of(displayUserDto);
    }

    @Override
    public Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto) {
        User user = userService.login(loginUserRequestDto.username(), loginUserRequestDto.password());

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginUserResponseDto(token));
    }

    @Override
    public Optional<RegisterUserResponseDto> findByUsername(String username) {
        return userService
                .findByUsername(username)
                .map(RegisterUserResponseDto::from);
    }
}

