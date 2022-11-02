package com.example.stackoverflow_mono.mapper;

import com.example.stackoverflow_mono.domains.User;
import com.example.stackoverflow_mono.dto.user.AuthUserDto;
import com.example.stackoverflow_mono.dto.user.AuthUserUpdateDto;
import com.example.stackoverflow_mono.dto.user.LoginRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<User, AuthUserDto, LoginRequest, AuthUserUpdateDto>{

}
