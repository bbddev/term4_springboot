package fpt.aptech.day5client.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Students {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    @NotBlank(message = "Name is required...")
    private String name;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
    List<Marks> marksList = new ArrayList<Marks>();

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Marks> getMarksList() {
        return marksList;
    }
    public void setMarksList(List<Marks> marksList) {
        this.marksList = marksList;
    }
}
