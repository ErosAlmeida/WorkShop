package workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.config.Instantiation;
import workshop.domain.User;
import workshop.dto.UserDTO;
import workshop.repository.UserRepository;
import workshop.resourceException.ResourceExceptionHandler;
import workshop.servicesException.ObjectNotFoundException;

@Service
public class UserService {

    @SuppressWarnings("unused")
    private final ResourceExceptionHandler resourceExceptionHandler;

    @SuppressWarnings("unused")
    private final Instantiation instantiation;
    
    @Autowired
    private  UserRepository repo;

    UserService(Instantiation instantiation, ResourceExceptionHandler resourceExceptionHandler) {
        this.instantiation = instantiation;
        this.resourceExceptionHandler = resourceExceptionHandler;
    }

    public List<User>findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        User user = repo.findOne(id);
        if(user == null){
            throw new ObjectNotFoundException("Objeto nao encontrado");
        }
        return user;
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }
    public User update(User obj){
        User newObj = repo.findOne(obj.getId());
        updateData(newObj, obj);
                return repo.save(newObj);
            }
        
            private void updateData(User newObj, User obj) {
                newObj.setName(obj.getName());
                newObj.setId(obj.getId());
                newObj.setEmail(obj.getEmail());
              
        }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
