package com.example.taskflow.dto;

import com.example.taskflow.enums.TaskPriority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TaskUpdateRequest {

    String title;
    String description;
    TaskPriority priority;
    LocalDateTime deadline;
}
