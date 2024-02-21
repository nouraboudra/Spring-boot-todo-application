package ma.TodoApplication.TodoApplication.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.TodoApplication.TodoApplication.entities.dto.TaskRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.TaskResponseDto;
import ma.TodoApplication.TodoApplication.exceptions.EntityNotFoundException;
import ma.TodoApplication.TodoApplication.services.TaskService;
import ma.TodoApplication.TodoApplication.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;


    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<TaskResponseDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
    // Patch method that changes only the status and ...
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) throws EntityNotFoundException {
            TaskResponseDto task = taskService.getTaskById(id);
            return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<?> createTask(@RequestBody TaskRequestDto taskDto) throws EntityNotFoundException {
        TaskResponseDto createdTask = taskService.createTask(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("")
    public ResponseEntity<TaskResponseDto> updateTask(@RequestBody TaskRequestDto taskDto) {
            TaskResponseDto updatedTask = taskService.updateTask(taskDto);
            return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
    }
}