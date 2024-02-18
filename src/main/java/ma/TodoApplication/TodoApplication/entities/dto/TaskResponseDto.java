package ma.TodoApplication.TodoApplication.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.TodoApplication.TodoApplication.enums.Status;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class TaskResponseDto {

    private Long id;
    private String title;
    private String description;
    private Long userId;
    private Status status;
    private Date dueDate;
    private Date updatedAt;
}
