package fpt.aptech.day2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_Products")
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "photo")
    private String photo;

    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    @ManyToOne
    private Manufacturer categoryid;

}
