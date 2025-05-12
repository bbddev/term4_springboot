package fpt.aptech.day2.models;

import jakarta.persistence.*;

@Table(name = "tb_Product")
@Entity
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

    @JoinColumn(name = "categoryid",referencedColumnName = "id")
    @ManyToOne
    private Manufacturer categoryid;

    public Product() {}

    public Product(String name, double price, int quantity, String photo, Manufacturer categoryid) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.photo = photo;
        this.categoryid = categoryid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Manufacturer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Manufacturer categoryid) {
        this.categoryid = categoryid;
    }
}
