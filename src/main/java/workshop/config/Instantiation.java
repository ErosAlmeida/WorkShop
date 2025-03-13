package workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import workshop.domain.User;
import workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User  maria = new User(null, "Maria Brown", "maria@gmail.com", null, null);
        User  alex = new User(null, "Alex Green", "alex@gmail.com", null, null); 
        User  bob = new User(null, "bob Green", "bob@gmail.com"); 

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        
    }
    
}
