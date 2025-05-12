package fpt.aptech.day2.models;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "tb_Manufacturer")
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categoryid")
    private List<Product> productList;

    public Manufacturer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
