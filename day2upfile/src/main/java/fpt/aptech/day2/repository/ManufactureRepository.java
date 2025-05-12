package fpt.aptech.day2.repository;

import fpt.aptech.day2.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureRepository extends JpaRepository<Manufacturer,Integer> {
}
