package fpt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    private String name;
    @Column(name = "email")
    @NotNull(message = "Email cannot be null")
    private String email;
    @Column(name = "phone")
    @NotNull(message = "Phone cannot be null")
    private String phone;
    @Column(name = "address")
    @NotNull(message = "Address cannot be null")
    private String address;
}
