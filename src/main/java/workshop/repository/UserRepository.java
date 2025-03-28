package workshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import workshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAll();

	User findOne(String id);
    
}