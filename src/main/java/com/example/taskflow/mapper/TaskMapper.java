package com.example.taskflow.mapper;

import com.example.taskflow.dto.TaskCreateRequest;
import com.example.taskflow.dto.TaskResponse;
import com.example.taskflow.entity.TaskEntity;
import com.example.taskflow.enums.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;


@Component
public class TaskMapper {

    public TaskResponse toResponse(TaskEntity entity){
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(entity.getId());
        taskResponse.setTitle(entity.getTitle());
        taskResponse.setStatus(entity.getStatus());
        taskResponse.setDescription(entity.getDescription());
        taskResponse.setPriority(entity.getPriority());
        taskResponse.setDeadline(entity.getDeadline());
        taskResponse.setCreatedAt(entity.getCreatedAt());
        taskResponse.setUpdatedAt(entity.getUpdatedAt());
        return taskResponse;
    }

    public TaskEntity toEntity(TaskCreateRequest request){
        LocalDateTime timeNow = LocalDateTime.now();
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(UUID.randomUUID());
        taskEntity.setTitle(request.getTitle());
        taskEntity.setDescription(request.getDescription());
        taskEntity.setStatus(TaskStatus.NEW);
        taskEntity.setPriority(request.getPriority());
        taskEntity.setDeadline(request.getDeadline());
        taskEntity.setCreatedAt(timeNow);
        taskEntity.setUpdatedAt(timeNow);
        return taskEntity;
    }

}
