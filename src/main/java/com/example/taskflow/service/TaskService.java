package com.example.taskflow.service;

import com.example.taskflow.dto.TaskCreateRequest;
import com.example.taskflow.dto.TaskResponse;
import com.example.taskflow.dto.TaskUpdateRequest;
import com.example.taskflow.entity.TaskEntity;
import com.example.taskflow.enums.TaskPriority;
import com.example.taskflow.mapper.TaskMapper;
import com.example.taskflow.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    public List<TaskResponse> getAllTasks() {
        List<TaskEntity> entities = taskRepository.findAll();
        List<TaskResponse> responses = new ArrayList<>();
        for (TaskEntity taskEntity :entities) {
            responses.add(taskMapper.toResponse(taskEntity));
        }
        return responses;
    }

    public TaskResponse updateTask(UUID id, TaskUpdateRequest request) {
        Optional<TaskEntity> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            TaskEntity entity = optional.get();
            entity.setTitle(request.getTitle());
            entity.setDescription(request.getDescription());
            entity.setPriority(request.getPriority());
            entity.setDeadline(request.getDeadline());
            entity.setUpdatedAt(LocalDateTime.now());

            TaskEntity savedEntity = taskRepository.save(entity);

            return taskMapper.toResponse(savedEntity);
        } else {
            throw new RuntimeException("Task not found");
        }
    }
}
