package fpt.aptech.day1p2.service;

import fpt.aptech.day1p2.models.Student;
import fpt.aptech.day1p2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    //DI Constructor base
    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> filterByAge(int min, int max) {
        return studentRepository.findByAge(min, max);
    }

    @Override
    public void saveStudent(Student newStudent) {
        studentRepository.save(newStudent);
    }

    @Override
    public void updateStudent(Student editStudent) {
        Student student = studentRepository.findById(editStudent.getId()).get();
        student.setName(editStudent.getName());
        student.setAge(editStudent.getAge());
        student.setAddress(editStudent.getAddress());
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
