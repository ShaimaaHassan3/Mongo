package com.springData.springdata.mongodb.repo;

import com.springData.springdata.mongodb.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<User, String> {
    List<User> findByAgeGreaterThan(int age);

    void deleteByName(String firstName);

    public long count();
}
