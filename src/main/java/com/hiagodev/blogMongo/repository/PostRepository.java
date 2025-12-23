package com.hiagodev.blogMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hiagodev.blogMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
