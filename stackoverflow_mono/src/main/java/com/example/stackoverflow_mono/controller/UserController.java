package com.example.stackoverflow_mono.controller;

import com.example.stackoverflow_mono.dto.user.*;
import com.example.stackoverflow_mono.service.user.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController extends ApiController<UserDetailsServiceImpl> {

    public UserController(UserDetailsServiceImpl service) {
        super(service);
    }

    @PostMapping(value = API + V1 +"/user/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(service.signIn(loginRequest));
    }

    @PostMapping(value = API + V1 +"/user/refreshtoken")
    public ResponseEntity<TokenRefreshResponse> refreshToken(@Valid @RequestBody TokenRefreshRequest request){
        return ResponseEntity.ok(service.refreshToken(request));
    }

    @PostMapping(value = API + V1 +"/user/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest request){
        service.create(request);
        return ResponseEntity.ok("User created successfully!");
    }



}
