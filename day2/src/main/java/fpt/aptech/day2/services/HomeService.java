package fpt.aptech.day2.services;

import fpt.aptech.day2.models.Manufacturer;
import fpt.aptech.day2.models.Product;

import java.util.List;

public interface HomeService {
    List<Product> getProducts();


    Product getProductById(int id);

    List<Product> findByIdManufacturer(Manufacturer categoryid);
    List<Manufacturer> getManufacturers();


    Manufacturer findManufacturerById(int id);

    Product save(Product product);

    int deleteMProduct(List<Integer> productIdList);
}
