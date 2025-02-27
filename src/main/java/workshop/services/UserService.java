package workshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import workshop.domain.User;
import workshop.repository.UserRepository;

@Service
public class UserService {
    
    private  UserRepository repo;
    public List<User>findAll(){
        return repo.findAll();

    }
}
