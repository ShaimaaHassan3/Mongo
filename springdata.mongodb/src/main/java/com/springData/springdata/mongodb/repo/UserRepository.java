package com.springData.springdata.mongodb.repo;

import com.springData.springdata.mongodb.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User saveUser(User user) {
        mongoTemplate.save(user);
        return user;
    }

    public User findUserById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, User.class);
    }

    public List<User> findAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    // Custom query example
    public List<User> findUsersByAgeGreaterThan(int age) {
        Query query = new Query(Criteria.where("age").gt(age));
        return mongoTemplate.find(query, User.class);
    }

    public void deleteUser(User user) {
        mongoTemplate.remove(user);
    }
}
