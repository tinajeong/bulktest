package com.example.bulktest.repository;

import com.example.bulktest.data.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Log
@Qualifier("simpleUserRepository")
public class SimpleUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public SimpleUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void saveAll(List<User> userList) {

        for (User user : userList) {
            jdbcTemplate.update("INSERT INTO TEST(NAME,EMAIL,ADDRESS) VALUES(?,?,?)",
                    user.getName(),
                    user.getEmail(),
                    user.getAddress());
        }

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
