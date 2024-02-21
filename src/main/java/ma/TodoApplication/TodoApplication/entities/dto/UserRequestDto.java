package ma.TodoApplication.TodoApplication.entities.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
    private String email;
}

