package ma.TodoApplication.TodoApplication.services;

import lombok.AllArgsConstructor;
import ma.TodoApplication.TodoApplication.entities.Task;
import ma.TodoApplication.TodoApplication.entities.dto.TaskRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.TaskResponseDto;
import ma.TodoApplication.TodoApplication.exceptions.EntityNotFoundException;

import ma.TodoApplication.TodoApplication.repositories.TaskRepository;
import ma.TodoApplication.TodoApplication.utils.Mapping;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class TaskServiceImp implements TaskService{
    private final TaskRepository taskRepository;
    private final UserService userService;
    @Override
    public List<TaskResponseDto> getAllTasks() {
      return taskRepository
                .findAll()
                .stream()
                .map(Mapping::mapToTaskResponseDto).toList();
    }
    @Override
    public TaskResponseDto getTaskById(Long id) throws EntityNotFoundException {
        Task task = taskRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Task Not Found with the ID : "+id));
       return  Mapping.mapToTaskResponseDto(task);
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskDto) throws  EntityNotFoundException{
        Task task = Mapping.maptoTask(taskDto);
        userService.getUserById(task.getUser().getId());

        return Mapping.mapToTaskResponseDto(taskRepository.save(task));
    }

    @Override
    public TaskResponseDto updateTask(TaskRequestDto taskDto){
        Task task = Mapping.maptoTask(taskDto);
        return Mapping.mapToTaskResponseDto(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id)  {
        taskRepository.deleteById(id);
    }
}
