package com.example.stackoverflow_mono.service.user;

import com.example.stackoverflow_mono.domains.RefreshToken;
import com.example.stackoverflow_mono.domains.Role;
import com.example.stackoverflow_mono.domains.User;
import com.example.stackoverflow_mono.dto.user.*;
import com.example.stackoverflow_mono.enums.ERole;
import com.example.stackoverflow_mono.exception.GenericNotFoundException;
import com.example.stackoverflow_mono.exception.GenericRunTimeException;
import com.example.stackoverflow_mono.exception.TokenRefreshException;
import com.example.stackoverflow_mono.mapper.AuthUserMapper;
import com.example.stackoverflow_mono.repository.RoleRepository;
import com.example.stackoverflow_mono.repository.UserRepository;
import com.example.stackoverflow_mono.security.SessionUser;
import com.example.stackoverflow_mono.security.UserDetailsImpl;
import com.example.stackoverflow_mono.security.jwt.JwtUtils;
import com.example.stackoverflow_mono.service.AbstractService;
import com.example.stackoverflow_mono.service.GenericCrudService;
import com.example.stackoverflow_mono.utils.BaseUtils;
import lombok.NonNull;
import lombok.Singular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



@Service
public class UserDetailsServiceImpl extends AbstractService<UserRepository, AuthUserMapper>
        implements GenericCrudService<Long, AuthUserDto, SignUpRequest, AuthUserUpdateDto>, UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionUser sessionUser;
    @Autowired
    @Lazy
    AuthenticationManager authenticationManager;


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    @Lazy
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    RefreshTokenService refreshTokenService;


    public UserDetailsServiceImpl(UserRepository repository, AuthUserMapper mapper, BaseUtils utils) {
        super(repository, mapper, utils);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }


    @Override
    public Long create(@NonNull SignUpRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            throw new GenericRunTimeException("Error: Username is already taken!", HttpStatus.BAD_REQUEST.value());
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new GenericRunTimeException("Error: Email is already in use!", HttpStatus.BAD_REQUEST.value());
        }

        User user = User.builder()
                .email(signupRequest.getEmail())
                .fullName(signupRequest.getFullName())
                .image_url(signupRequest.getImage_url())
                .password(encoder.encode(signupRequest.getPassword()))
                .displayName(signupRequest.getDisplayName())
                .username(signupRequest.getUsername())
                .build();

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new GenericNotFoundException("Error: Role is not found.", HttpStatus.NOT_FOUND.value()));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new GenericNotFoundException("Error: Role is not found.", HttpStatus.NOT_FOUND.value()));
                        roles.add(adminRole);
                        break;
                    case "employer":
                        Role empRole = roleRepository.findByName(ERole.ROLE_EMPLOYER)
                                .orElseThrow(() -> new GenericNotFoundException("Error: Role is not found.", HttpStatus.NOT_FOUND.value()));
                        roles.add(empRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new GenericNotFoundException("Error: Role is not found.", HttpStatus.NOT_FOUND.value()));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return user.getId();
    }

    @Override
    public void delete(@NonNull Long aLong) {

    }

    @Override
    public void update(@NonNull AuthUserUpdateDto dto) {

    }

    @Override
    public List<AuthUserDto> getAll() {
        return null;
    }

    @Override
    public AuthUserDto get(@NonNull Long aLong) {
        return null;
    }

    public JwtResponse signIn(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

        return new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
                userDetails.getUsername(), userDetails.getEmail(), roles);
    }

    public TokenRefreshResponse refreshToken(TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(token1 -> refreshTokenService.verifyExpiration(token1))
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return new TokenRefreshResponse(token, requestRefreshToken);
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }
}
