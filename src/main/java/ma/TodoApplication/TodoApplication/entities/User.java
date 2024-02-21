package ma.TodoApplication.TodoApplication.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message ="First name is null ")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message ="Last name is null" )
    @Column(name = "last_name")
    private String lastName;


    @Email(message = "Email not valid check your mail !!! ")
    @Column(name = "email",unique = true)
    private String email;

    //orphanRemoval = true :This ensures that if a Task is removed from the tasks list, it will be deleted from the database.
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}

