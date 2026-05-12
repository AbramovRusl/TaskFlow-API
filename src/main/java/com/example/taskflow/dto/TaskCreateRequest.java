package com.example.taskflow.dto;

import com.example.taskflow.enums.TaskPriority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TaskCreateRequest {

    private String title;
    private String description;
    private TaskPriority priority;
    private LocalDateTime deadline;
}
