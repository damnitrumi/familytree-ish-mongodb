package com.guilhermesoares.familytree.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guilhermesoares.familytree.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
