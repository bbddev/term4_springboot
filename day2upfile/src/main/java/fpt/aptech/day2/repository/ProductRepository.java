package fpt.aptech.day2.repository;

import fpt.aptech.day2.models.Manufacturer;
import fpt.aptech.day2.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
   @Query("select p from Product p where p.categoryid= :categoryid")
    List<Product> findByIdManufacture(@Param("categoryid") Manufacturer categoryid);
}
