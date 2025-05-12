package fpt.aptech.day2.services;

import fpt.aptech.day2.models.Manufacturer;
import fpt.aptech.day2.models.Product;

import java.util.List;

public interface HomeService {
    List<Product> getProducts();
    List<Manufacturer> getManufacturers();
    Product getProduct(int id);
    List<Product> findByIdManufacture(Manufacturer categoryid);
    Manufacturer findManufacturerById(int id);
    Product save(Product product);
    int deleteMProduct(List<Integer> codeList);
}
