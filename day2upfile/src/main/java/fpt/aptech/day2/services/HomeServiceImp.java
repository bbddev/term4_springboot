package fpt.aptech.day2.services;

import fpt.aptech.day2.models.Manufacturer;
import fpt.aptech.day2.models.Product;
import fpt.aptech.day2.repository.ManufactureRepository;
import fpt.aptech.day2.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImp implements HomeService {
    //DI for contructer
    ManufactureRepository manufactureRepository;
    ProductRepository productRepository;

    @Autowired
    public HomeServiceImp(ManufactureRepository manufactureRepository, ProductRepository productRepository) {
        this.manufactureRepository = manufactureRepository;
        this.productRepository = productRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        return manufactureRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findByIdManufacture(Manufacturer categoryid) {
        return productRepository.findByIdManufacture(categoryid);
    }

    @Override
    public Manufacturer findManufacturerById(int id) {
        return manufactureRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public int deleteMProduct(List<Integer> codeList) {
        String sql = "DELETE FROM Product p WHERE p.id IN :codeList";
        return entityManager.createQuery(sql)
                .setParameter("codeList",codeList)
                .executeUpdate();
    }
}
