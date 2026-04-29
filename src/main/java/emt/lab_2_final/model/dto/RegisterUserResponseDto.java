package emt.lab_2_final.model.dto;

import emt.lab_2_final.model.domain.User;
import emt.lab_2_final.model.enums.Role;

public record RegisterUserResponseDto(
        String username,
        String name,
        String surname,
        String email,
        Role role
) {
    public static RegisterUserResponseDto from(User user) {
        return new RegisterUserResponseDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getRole()
        );
    }
}

