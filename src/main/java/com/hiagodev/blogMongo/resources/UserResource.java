package com.hiagodev.blogMongo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodev.blogMongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User user = new User("1","maria","marial@gmail.com");
        User user2 = new User("1","mario","mara@gmail.com");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        
        return ResponseEntity.ok(list);
    }
}
