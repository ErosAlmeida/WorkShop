package workshop.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import workshop.domain.User;
import workshop.services.UserService;


@RestController
@RequestMapping(value = "/users")

public class UserResource {

   
    @SuppressWarnings("unused")
    @Autowired
    private UserService service;

  
    @SuppressWarnings("unchecked")
    @GetMapping
    public List<User> findAll() {
        List<User> list = findAll();
        
        return (List<User>) ResponseEntity.ok().body(list);
    }
}
