package com.hiagodev.blogMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hiagodev.blogMongo.domain.Post;
import com.hiagodev.blogMongo.domain.User;
import com.hiagodev.blogMongo.dto.AuthorDTO;
import com.hiagodev.blogMongo.dto.CommentDTO;
import com.hiagodev.blogMongo.repository.PostRepository;
import com.hiagodev.blogMongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, sdf.parse("25/03/2018"), "partiu viagem!!", "vou viajar para SP.",
                new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("24/06/2018"), "Estou de volta!!", "voltei da viagem de SP.",
                new AuthorDTO(maria));
        Post p3 = new Post(null, sdf.parse("25/12/2018"), "feliz natal!", "bom natl para todos.", new AuthorDTO(bob));

        CommentDTO c1 = new CommentDTO("boa viagem mano", sdf.parse("25/03/2018"), new AuthorDTO(bob));
        CommentDTO c4 = new CommentDTO("boa viagem mari", sdf.parse("25/03/2018"), new AuthorDTO(alex));
        
        CommentDTO c2 = new CommentDTO("feliz natal tambem", sdf.parse("25/12/2018"), new AuthorDTO(maria));
        CommentDTO c3 = new CommentDTO("teve uma boa viagem?", sdf.parse("24/6/2018"), new AuthorDTO(alex));

        p1.getComments().addAll(Arrays.asList(c1,c4));
        p2.getComments().add(c3);
        p3.getComments().add(c2);

        postRepository.saveAll(Arrays.asList(p1, p2, p3));
        maria.getPosts().addAll(Arrays.asList(p1, p2));
        bob.getPosts().add(p3);
        userRepository.saveAll(Arrays.asList(maria, bob));

    }

}
