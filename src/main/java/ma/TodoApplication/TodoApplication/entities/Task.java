package ma.TodoApplication.TodoApplication.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.TodoApplication.TodoApplication.enums.Status;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank(message = "Title is null")
    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "description")
    private String description;


    @NotNull(message = "Status is null")
    @Enumerated(EnumType.STRING)
    private Status status;


    @Future
    @NotNull(message = "due Date is null")
    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dueDate;


    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;


    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
