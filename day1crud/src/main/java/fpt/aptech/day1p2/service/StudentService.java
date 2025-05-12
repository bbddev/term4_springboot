package fpt.aptech.day1p2.service;

import fpt.aptech.day1p2.models.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();
    public Student getStudent(int id);
    public List<Student> filterByAge(int min, int max);
    public void saveStudent(Student newStudent);
    public void updateStudent(Student editStudent);
    public void deleteStudent(int id);
}