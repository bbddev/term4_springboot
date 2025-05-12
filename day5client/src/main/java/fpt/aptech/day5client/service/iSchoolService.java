package fpt.aptech.day5client.service;

import fpt.aptech.day5client.models.Marks;

import java.util.List;

public interface iSchoolService {
    List<Marks> findAllMarks();

    Marks findSubjectByCode(String code, String subject);

    List<Marks> findAllSubjectsByCode(String code); //code cung la studentcode

    void saveMarks(Marks marks);

    void updateMarks(Marks marks);

    void deleteMarks(String code, String subject); //code cung la studentcode
}
