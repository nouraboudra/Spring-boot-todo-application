package ma.TodoApplication.TodoApplication.entities.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ma.TodoApplication.TodoApplication.enums.Status;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TaskRequestDto {

    private Long id;
    private String title;
    private String description;
    private Long userId;
    private Status status;
    private Date dueDate;


}
