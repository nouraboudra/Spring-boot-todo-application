package ma.TodoApplication.TodoApplication.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.TodoApplication.TodoApplication.entities.User;
import ma.TodoApplication.TodoApplication.entities.dto.UserRequestDto;
import ma.TodoApplication.TodoApplication.entities.dto.UserResponseDto;
import ma.TodoApplication.TodoApplication.exceptions.EntityNotFoundException;
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
                .toList();
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userDto) {
        User user = Mapping.mapToUserEntity(userDto);
        return Mapping.mapToUserResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto getUserById(Long id) throws EntityNotFoundException{
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return Mapping.mapToUserResponseDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userDto) throws EntityNotFoundException{
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userDto.getId()));

        // Update user fields
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(user);
        return Mapping.mapToUserResponseDto(updatedUser);
    }
}