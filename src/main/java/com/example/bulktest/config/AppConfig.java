package com.example.bulktest.config;


import com.example.bulktest.repository.BatchUserRepositry;
import com.example.bulktest.repository.SimpleUserRepository;
import com.example.bulktest.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("simpleUserService")
    public UserService simpleUserService(SimpleUserRepository simpleUserRepository) {
        return new UserService(simpleUserRepository);
    }

    @Bean
    @Qualifier("batchUserService")
    public UserService batchUserService(BatchUserRepositry batchUserRepositry) {
        return new UserService(batchUserRepositry);
    }
}
