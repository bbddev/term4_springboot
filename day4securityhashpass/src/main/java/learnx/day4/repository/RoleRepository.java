package learnx.day4.repository;

import learnx.day4.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Roles findByName(String name);
}
