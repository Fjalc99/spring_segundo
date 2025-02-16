package com.salesianostriana.dam.jwt.security.user.service;

import com.salesianostriana.dam.jwt.security.user.dto.CreateUserRequest;
import com.salesianostriana.dam.jwt.security.user.model.User;
import com.salesianostriana.dam.jwt.security.user.model.UserRole;
import com.salesianostriana.dam.jwt.security.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User createUser(CreateUserRequest createUserRequest) {
        User user = User.builder()
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .roles(Set.of(UserRole.USER))
                .email(createUserRequest.email())
                .enable(false)
                .build();

        return userRepository.save(user);
    }



    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

 
    public void save(User user) {
        userRepository.save(user);
    }
}
