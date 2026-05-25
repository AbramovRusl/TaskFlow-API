package com.example.taskflow.mapper;

import com.example.taskflow.dto.UserCreateRequest;
import com.example.taskflow.dto.UserResponse;
import com.example.taskflow.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UserMapper {

    public UserResponse toResponse(UserEntity entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setEmail(entity.getEmail());
        response.setCreatedAt(entity.getCreatedAt());
        return response;
    }

    public UserEntity toEntity(UserCreateRequest user) {
        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setEmail(user.getEmail());
        entity.setCreatedAt(LocalDateTime.now());
        return entity;
    }
}
