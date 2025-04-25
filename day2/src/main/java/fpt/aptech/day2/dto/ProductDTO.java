package fpt.aptech.day2.dto;

import fpt.aptech.day2.models.Manufacturer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private MultipartFile photo;
    private Manufacturer categoryid;
}
