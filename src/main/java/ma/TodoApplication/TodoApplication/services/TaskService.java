package ma.TodoApplication.TodoApplication.services;

import ma.TodoApplication.TodoApplication.entities.dto.TaskRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.TaskResponseDto;
import ma.TodoApplication.TodoApplication.exceptions.EntityNotFoundException;


import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface TaskService {

    List<TaskResponseDto> getAllTasks();
    TaskResponseDto createTask(TaskRequestDto taskDto)throws EntityNotFoundException;
    TaskResponseDto getTaskById(Long id) throws EntityNotFoundException;
    TaskResponseDto updateTask (TaskRequestDto taskDto);
    void deleteTask(Long id) ;

}
