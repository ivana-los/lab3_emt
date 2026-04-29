package emt.lab_2_final.service.application;

import emt.lab_2_final.model.dto.LoginUserRequestDto;
import emt.lab_2_final.model.dto.LoginUserResponseDto;
import emt.lab_2_final.model.dto.RegisterUserRequestDto;
import emt.lab_2_final.model.dto.RegisterUserResponseDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}

