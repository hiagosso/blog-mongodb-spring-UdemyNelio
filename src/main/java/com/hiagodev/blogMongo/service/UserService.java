package com.hiagodev.blogMongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiagodev.blogMongo.domain.User;
import com.hiagodev.blogMongo.repository.UserRepository;
import com.hiagodev.blogMongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
       return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
