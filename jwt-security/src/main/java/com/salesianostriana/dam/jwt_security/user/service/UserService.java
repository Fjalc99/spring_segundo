package com.salesianostriana.dam.jwt_security.user.service;

import com.salesianostriana.dam.jwt_security.user.dto.CreateUserRequest;
import com.salesianostriana.dam.jwt_security.user.model.User;
import com.salesianostriana.dam.jwt_security.user.model.UserRole;
import com.salesianostriana.dam.jwt_security.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User create(CreateUserRequest createUserRequest){
        User user = User.builder()
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .roles(Set.of(UserRole.USER))
                .build();

                return userRepository.save(user);
    }

}
