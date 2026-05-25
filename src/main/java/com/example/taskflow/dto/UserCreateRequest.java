package com.example.taskflow.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequest {

    private String firstName;
    private String lastName;
    private String email;
}
