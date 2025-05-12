package fpt.aptech.day5client.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "marks")
@Data
public class Marks {
    @Id
    @Column(name = "studentcode")
    private String studentcode;
    @Column(name = "subject")
    @NotBlank(message = "Subject is required...")
    private String subject;

    @Column(name = "mark")
    @Min(value = 0, message = "Mark must be >= 0...")
    @Max(value = 100, message = "Mark must be <= 100...")
    private double mark;

    @ManyToOne
    @JoinColumn(name = "studentcode", referencedColumnName = "code", insertable = false, updatable = false)
    private Students students;

    public String getStudentcode() {
        return studentcode;
    }
    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
    public Students getStudents() {
        return students;
    }
    public void setStudents(Students students) {
        this.students = students;
    }
}
