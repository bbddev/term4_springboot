package fpt.repository;

import fpt.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    @Query("SELECT l FROM Login l WHERE l.username = ?1 AND l.password = ?2")
    public Login findByUsernameAndPassword(String username, String password);
}
