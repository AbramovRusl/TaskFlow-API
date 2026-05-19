package com.example.taskflow.service;

import com.example.taskflow.dto.TaskCreateRequest;
import com.example.taskflow.dto.TaskResponse;
import com.example.taskflow.entity.TaskEntity;
import com.example.taskflow.mapper.TaskMapper;
import com.example.taskflow.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskResponse createTask(TaskCreateRequest request) {

        TaskEntity taskEntity = taskMapper.toEntity(request);
        TaskResponse response = taskMapper.toResponse(taskRepository.save(taskEntity));

        return response;
    }

    public TaskResponse getTask(UUID id) {
        Optional<TaskEntity> optional = taskRepository.findById(id);

        if (optional.isPresent()) {
            TaskEntity entity = optional.get();
            return taskMapper.toResponse(entity);
        } else {
            throw new RuntimeException("Task not found");
        }
    }
}
