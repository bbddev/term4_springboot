package fpt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "login")
@Data
public class Login {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    @NotNull(message = "Password cannot be null")
    private String password;
    @Column(name = "role")
    @NotNull(message = "Role cannot be null")
    private String role;
}
