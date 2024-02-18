package ma.TodoApplication.TodoApplication.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.TodoApplication.TodoApplication.entities.User;
import ma.TodoApplication.TodoApplication.entities.dto.UserRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.UserResponseDto;
import ma.TodoApplication.TodoApplication.repositories.UserRepository;
import ma.TodoApplication.TodoApplication.utils.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(Mapping::mapToUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userDto) {
        User user = Mapping.mapToUserEntity(userDto);
        User savedUser = userRepository.save(user);
        return Mapping.mapToUserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return Mapping.mapToUserResponseDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDto.getId()));

        // Update user fields
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(user);
        return Mapping.mapToUserResponseDto(updatedUser);
    }
}