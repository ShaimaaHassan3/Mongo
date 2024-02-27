package com.springData.springdata.mongodb;

import com.springData.springdata.mongodb.entities.User;
import com.springData.springdata.mongodb.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application implements CommandLineRunner {

//	@Autowired
//	ItemRepository groceryItemRepo;

    private MongoTemplate mongoTemplate;

    public Application(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder().age(12).name("Mony").gender("Female")
                .id(1).build();
        this.mongoTemplate.save(user);

    }
}
