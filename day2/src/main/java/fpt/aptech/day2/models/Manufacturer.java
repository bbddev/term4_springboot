package fpt.aptech.day2.models;

import jakarta.persistence.*;

import java.util.List;

import lombok.*;

@Table(name = "tb_Manafacturers")
@Entity
@Getter
@Setter
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categoryid")
    private List<Product> product;


}
