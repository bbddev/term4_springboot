package fpt.aptech.day5client.repository;

import fpt.aptech.day5client.models.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<Marks, String> {

    @Query("SELECT m FROM Marks m WHERE m.studentcode = :code AND m.subject = :subject")
    Marks findSubjectByCode(@Param("code") String code,
                                      @Param("subject") String subject); //code cung la studentcode

    @Query("SELECT m FROM Marks m WHERE m.studentcode = :code")
    List<Marks> findAllSubjectsByCode(@Param("code") String code); //code cung la studentcode

    @Query("SELECT m FROM Marks m")
    List<Marks> findAllMark();


}
