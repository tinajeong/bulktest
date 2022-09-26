package com.example.bulktest;

import com.example.bulktest.service.BatchUserService;
import com.example.bulktest.service.SimpleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
@Slf4j
public class BulkTestApplication implements CommandLineRunner {

    @Autowired
    private BatchUserService batchUserService;

    @Autowired
    private SimpleUserService simpleUserService;

    public static void main(String[] args) {
        SpringApplication.run(BulkTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int[] batchSizeArray = {1, 10, 100, 1_000, 10_000}; //1_000, 10_000, 100_000

        log.info("insert {}", String.join("", Collections.nCopies(50, ">")));
        for (int batchSize : batchSizeArray) {
            long normalElapsedTime = simpleUserService.createUser(batchSize);
            long batchElapsedTime = batchUserService.createUser(batchSize);

            log.info(String.join("", Collections.nCopies(60, "-")));

            log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Regular inserts", "|", batchSize, "|", normalElapsedTime, normalElapsedTime / 1000));
            log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Batch inserts", "|", batchSize, "|", batchElapsedTime, batchElapsedTime / 1000));
            log.info(String.format("Total gain: %d %s", calculateGainInPercent(normalElapsedTime, batchElapsedTime), "%"));
        }
    }

    int calculateGainInPercent(long before, long after) {
        return (int) Math.floor(100D * (before - after) / before);
    }
}
