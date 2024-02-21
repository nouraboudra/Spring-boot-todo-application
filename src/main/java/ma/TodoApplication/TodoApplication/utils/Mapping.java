package ma.TodoApplication.TodoApplication.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.TodoApplication.TodoApplication.entities.Task;
import ma.TodoApplication.TodoApplication.entities.User;
import ma.TodoApplication.TodoApplication.entities.dto.TaskRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.TaskResponseDto;
import ma.TodoApplication.TodoApplication.entities.dto.UserRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.UserResponseDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

@NoArgsConstructor
public class Mapping {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Task maptoTask(TaskRequestDto taskRequestDto) {
        return modelMapper.map(taskRequestDto, Task.class);
    }

    public static TaskResponseDto mapToTaskResponseDto(Task task) {
        return modelMapper.map(task, TaskResponseDto.class);

    }


    public static User mapToUserEntity(UserRequestDto userDto) {
        return modelMapper.map(userDto, User.class);
    }


    public static UserResponseDto mapToUserResponseDto(User user) {

        UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
        userResponseDto.setFullName(user.getFirstName() + " " + user.getLastName());

        return userResponseDto;
    }

}


