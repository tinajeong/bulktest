package com.example.bulktest.service;

import com.example.bulktest.data.User;
import com.example.bulktest.repository.SimpleUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SimpleUserService {

    private SimpleUserRepository simpleUserRepository;

    private List<User> generateUserData(int count) {

        final List<User> userList = new ArrayList<>(count);

        for (int i = 1; i <= count; i++) {
            User user = new User(String.valueOf(i), "Tina", "tinajeong@gmail.com", "Yeongdeungpo-gu, Seoul");
            userList.add(user);
        }
        return userList;
    }


    @Transactional
    public long createUser(int count) {
        List<User> userList = generateUserData(count);
        long startTime = System.nanoTime();
        simpleUserRepository.saveAll(userList);
        return (System.nanoTime() - startTime) / 1_000_000;
    }

    @Transactional
    public long getUser() {
        long startTime = System.nanoTime();

        return (System.nanoTime() - startTime) / 1_000_000;
    }

    @Transactional
    public long getDeleteUser() {
        long startTime = System.nanoTime();

        return (System.nanoTime() - startTime) / 1_000_000;
    }
}
