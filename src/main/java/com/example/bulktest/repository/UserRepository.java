package com.example.bulktest.repository;


import com.example.bulktest.data.User;

import java.util.List;

public interface UserRepository {
    void saveAll(List<User> userList);

    List<User> findAll();
}
