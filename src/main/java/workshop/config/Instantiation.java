package workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import workshop.domain.Post;
import workshop.domain.User;
import workshop.dto.CommentsDTO;
import workshop.dto.authorDTO;
import workshop.repository.PostRepository;
import workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        // Apaga todos os dados do banco para evitar duplicação
        postRepository.deleteAll();
        userRepository.deleteAll();

        // Criando usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com", null, null);
        User alex = new User(null, "Alex Green", "alex@gmail.com", null, null);
        User bob = new User(null, "Bob Green", "bob@gmail.com", null, null);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Itália, abraços!",new authorDTO(maria));
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei muito feliz!", new authorDTO(maria));
        
        CommentsDTO c1 = new CommentsDTO("Tenha uma viagem excelente", sdf.parse("(15/03/2025)"), new authorDTO(alex));
        CommentsDTO c2 = new CommentsDTO("Se divirta", sdf.parse("(20/03/2025)"), new authorDTO(bob));
        CommentsDTO c3 = new CommentsDTO("Tenha um excelente dia", sdf.parse("(10/03/2025)"), new authorDTO(alex));
        
        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));


        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}

