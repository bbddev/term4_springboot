package fpt.aptech.day2.dto;

import fpt.aptech.day2.models.Manufacturer;
import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private MultipartFile photo;
    private Manufacturer categoryid;

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

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public Manufacturer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Manufacturer categoryid) {
        this.categoryid = categoryid;
    }
}
