package ma.TodoApplication.TodoApplication.services;

import ma.TodoApplication.TodoApplication.entities.User;
import ma.TodoApplication.TodoApplication.entities.dto.UserRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.UserResponseDto;
import ma.TodoApplication.TodoApplication.exceptions.EntityNotFoundException;

import java.util.List;

public interface UserService {

    public List<UserResponseDto> getAllUsers();
    public UserResponseDto createUser(UserRequestDto userDto);
    public UserResponseDto getUserById(Long id) throws EntityNotFoundException;
    public void deleteUserById(Long id);
    public UserResponseDto updateUser( UserRequestDto userDto) throws EntityNotFoundException;



}
