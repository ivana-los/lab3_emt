package emt.lab_2_final.model.exeptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User with username '%s' does not exist.".formatted(username));
    }
}

