package aptech.dm6.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name is required")
    @Size(min = 3, max = 20,message = "name must be between 3-20 characters")
    private String name;
    @Email(message = "email is invalid")
    private String email;
    @Min(value = 18,message = "age must be greater than or equal 18 years old")
    @Max(value = 40,message = "age must be less than or equal 40 years old")
    private int age;
    @Past(message = "dob is in the past")
    private Date dob;
    @OneToMany(mappedBy = "author", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    private List<Book> books;
}
