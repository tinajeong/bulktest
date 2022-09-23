package com.example.bulktest.repository;

import com.example.bulktest.data.User;
import lombok.extern.java.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@Log
public class BatchUserRepositry implements UserRepository {
    private JdbcTemplate jdbcTemplate;
    int batchSize = 100;

    public BatchUserRepositry(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void saveAll(List<User> userList) {

        jdbcTemplate.batchUpdate("INSERT INTO TEST(ID,NAME,EMAIL,ADDRESS) VALUES(?,?,?,?)",
                userList,
                batchSize,
                (PreparedStatement ps, User user) -> {
                    ps.setString(1, user.getId());
                    ps.setString(2, user.getName());
                    ps.setString(3, user.getEmail());
                    ps.setString(4, user.getAddress());
                }
        );

    }
}
