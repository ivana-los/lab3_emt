package emt.lab_2_final.model.dto;

import emt.lab_2_final.model.domain.User;

public record RegisterUserRequestDto(
        String name,
        String surname,
        String email,
        String username,
        String password
) {
    public User toUser() {
        return new User(name, surname, email, username, password);
    }
}
