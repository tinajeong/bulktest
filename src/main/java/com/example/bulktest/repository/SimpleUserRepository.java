package com.example.bulktest.repository;

import com.example.bulktest.data.User;
import lombok.extern.java.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Log
public class SimpleUserRepository implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public SimpleUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void saveAll(List<User> userList) {

        for (User user : userList) {
            jdbcTemplate.update("INSERT INTO TEST(ID,NAME,EMAIL,ADDRESS) VALUES(?,?,?,?)",
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAddress());
        }

    }
}
