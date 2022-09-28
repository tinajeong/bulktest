package com.example.bulktest.repository;

import com.example.bulktest.data.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@Log
@Qualifier("batchUserRepository")
public class BatchUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    int batchSize = 1000;

    public BatchUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void saveAll(List<User> userList) {
        jdbcTemplate.batchUpdate("INSERT INTO USER(NAME,EMAIL,ADDRESS) VALUES(?,?,?)",
                userList,
                batchSize,
                (PreparedStatement ps, User user) -> {
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getEmail());
                    ps.setString(3, user.getAddress());
                }
        );

    }

    @Override
    public List<User> findAll() {
        return null;
    }


    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
}
