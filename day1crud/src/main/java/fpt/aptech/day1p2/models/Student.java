package fpt.aptech.day1p2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

@Table(name = "student")
@Entity
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "Name is required...")
    @Size(min = 2, max = 100, message = "Name from 2 to 100 char")
    @Column(name = "name")
    private String name;
    @NotNull(message = "Age is required...")
    @Range(min = 15, max = 80, message = "Age is over 15 and above 80")
    @Column(name = "age")
    private int age;
    @NotEmpty(message = "Address is required...")
    @Size(min = 2, max = 100, message = "Address from 2 to 100 char")
    @Column(name = "address")
    private String address;
}