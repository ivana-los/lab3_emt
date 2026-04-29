package emt.lab_2_final.service.application.impl;

import emt.lab_2_final.model.domain.User;
import emt.lab_2_final.model.exeptions.IncorrectPasswordException;
import emt.lab_2_final.model.exeptions.UserNotFoundException;
import emt.lab_2_final.model.exeptions.UsernameAlreadyExistsException;
import emt.lab_2_final.repository.UserRepository;
import emt.lab_2_final.service.domain.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User register(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            throw new UsernameAlreadyExistsException(user.getUsername());
        return userRepository.save(new User(
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getUsername(),
                passwordEncoder.encode(user.getPassword())
        ));
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new IncorrectPasswordException();
        return user;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}