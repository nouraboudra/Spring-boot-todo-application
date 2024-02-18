package ma.TodoApplication.TodoApplication.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UserResponseDto {

    private Long id;
    private String fullName;
    private String email;
}
