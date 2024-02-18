package ma.TodoApplication.TodoApplication.entities.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UserRequestDto {

    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
}

