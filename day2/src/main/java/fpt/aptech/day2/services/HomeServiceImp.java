package fpt.aptech.day2.services;

import fpt.aptech.day2.models.Manufacturer;
import fpt.aptech.day2.models.Product;
import fpt.aptech.day2.repository.ManufactureRepository;
import fpt.aptech.day2.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomeServiceImp implements HomeService {
    ManufactureRepository manufacturerRepository;
    ProductRepository productRepository;

    @Autowired
    public HomeServiceImp(ManufactureRepository manufacturerRepository, ProductRepository productRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findByIdManufacturer(Manufacturer categoryid) {
        return productRepository.findByIdManufacture(categoryid);
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findManufacturerById(int id) {
        return manufacturerRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public int deleteMProduct(List<Integer> productIdList) {
        String sql = "DELETE FROM Product p where p.id IN :codeList";
        return entityManager.createQuery(sql).setParameter("codeList", productIdList).executeUpdate();

    }

}
