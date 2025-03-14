package workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workshop.domain.Post;
import workshop.services.PostService;


@RestController
@RequestMapping(value = "/users")
public class PostResource {

    @Autowired
    private PostService service;


    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body((obj)); 
    }

}

