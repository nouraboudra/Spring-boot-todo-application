package ma.TodoApplication.TodoApplication.services;

import ma.TodoApplication.TodoApplication.entities.User;
import ma.TodoApplication.TodoApplication.entities.dto.UserRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    public List<UserResponseDto> getAllUsers();
    public UserResponseDto createUser(UserRequestDto userDto);
    public UserResponseDto getUserById(Long id)  ;
    public void deleteUserById(Long id);
    public UserResponseDto updateUser( UserRequestDto userDto) ;



}
