package fpt.aptech.day5client.service;

import fpt.aptech.day5client.models.Marks;
import fpt.aptech.day5client.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements iSchoolService {
    @Autowired
    SchoolRepository repository;


    public List<Marks> findAllMarks() {
        return repository.findAll();
    }

    public Marks findSubjectByCode(String code, String subject) {
        return repository.findSubjectByCode(code, subject);
    }

    public List<Marks> findAllSubjectsByCode(String code) {
        return repository.findAllSubjectsByCode(code);
    }


    public void saveMarks(Marks marks) {
        repository.save(marks);

    }

    public void updateMarks(Marks marks) {
        repository.save(marks);

    }

    public void deleteMarks(String code, String subject) {
        Marks marks = repository.findSubjectByCode(code, subject);
        if (marks != null) {
            repository.delete(marks);
        }

    }
}