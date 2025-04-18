package workshop.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.domain.Post;
import workshop.repository.PostRepository;
import workshop.servicesException.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private  PostRepository repo;

    public Post findById(String id){
        Post user = repo.findOne(id);
        if(user == null){
            throw new ObjectNotFoundException("Objeto nao encontrado");
        }
        return user;
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }
    
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
