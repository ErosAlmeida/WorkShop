package workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import workshop.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    Post findOne(String id);

    

    
}
