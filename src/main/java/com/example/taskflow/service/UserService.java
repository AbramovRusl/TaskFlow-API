package com.example.taskflow.service;

import com.example.taskflow.dto.UserCreateRequest;
import com.example.taskflow.dto.UserResponse;
import com.example.taskflow.entity.UserEntity;
import com.example.taskflow.mapper.UserMapper;
import com.example.taskflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createNewUser(UserCreateRequest request){
        UserEntity userEntity = userRepository.save(userMapper.toEntity(request));
        return userMapper.toResponse(userEntity);
    }
}
