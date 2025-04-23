package BV.notifyservice.repositories;

import BV.notifyservice.models.Notify;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyRepository extends
        MongoRepository<Notify, String> {
    List<Notify> findByUserId(Long userId);
}