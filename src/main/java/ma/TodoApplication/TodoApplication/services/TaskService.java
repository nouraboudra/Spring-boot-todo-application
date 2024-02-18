package ma.TodoApplication.TodoApplication.services;

import ma.TodoApplication.TodoApplication.entities.dto.TaskRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.TaskResponseDto;
import ma.TodoApplication.TodoApplication.exceptions.TaskNotFoundException;

import java.util.List;

public interface TaskService {

    List<TaskResponseDto> getAllTasks();
    TaskResponseDto createTask(TaskRequestDto taskDto);
    TaskResponseDto getTaskById(Long id) throws TaskNotFoundException;
    TaskResponseDto updateTask (TaskRequestDto taskDto);
    void deleteTask(Long id) ;

}
