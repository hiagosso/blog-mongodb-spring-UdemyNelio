package com.hiagodev.blogMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hiagodev.blogMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
