package fpt.aptech.day1p2.repository;

import fpt.aptech.day1p2.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.age> :min and s.age < :max")
    public List<Student> findByAge(@Param("min") Integer min, @Param("max") Integer max);
}