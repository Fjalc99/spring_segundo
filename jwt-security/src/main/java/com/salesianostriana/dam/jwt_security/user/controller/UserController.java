package com.salesianostriana.dam.jwt_security.user.controller;


import com.salesianostriana.dam.jwt_security.user.dto.CreateUserRequest;
import com.salesianostriana.dam.jwt_security.user.dto.LoginRequest;
import com.salesianostriana.dam.jwt_security.user.dto.UserResponse;
import com.salesianostriana.dam.jwt_security.user.model.User;
import com.salesianostriana.dam.jwt_security.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody CreateUserRequest createUserRequest){
        User user = userService.create(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.of(user));

    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest){

        Authentication authentication =


                SecurityContextHolder.

    }


}
