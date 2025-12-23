package com.hiagodev.blogMongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodev.blogMongo.domain.User;
import com.hiagodev.blogMongo.dto.UserDTO;
import com.hiagodev.blogMongo.service.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok(new UserDTO(obj));
    }
    
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO userdto) {
        User obj = userService.fromDto(userdto);
        obj = userService.insert(obj);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

     @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO userdto,@PathVariable String id) {
        User obj = userService.fromDto(userdto);
        obj.setId(id);
        obj = userService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
