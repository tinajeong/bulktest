package com.example.bulktest.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@SpringBootTest
@Transactional
@Slf4j
class BatchUserServiceIntegrationTest {

    int dataRowCount = 100_000;

    @Autowired
    SimpleUserService simpleUserService;
    @Autowired
    BatchUserService batchUserService;

    @Test
    public void 배치사이즈_100() {
        int batchSize = 100;
        log.info("insert {} {}", String.join("", Collections.nCopies(30, ">")),batchSize);
        batchUserService.setBatchSize(batchSize);
        long normalElapsedTime = simpleUserService.createUser(dataRowCount);
        long batchElapsedTime = batchUserService.createUser(dataRowCount);

        log.info(String.join("", Collections.nCopies(60, "-")));

        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Regular inserts", "|", dataRowCount, "|", normalElapsedTime, normalElapsedTime / 1000));
        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Batch inserts", "|", dataRowCount, "|", batchElapsedTime, batchElapsedTime / 1000));
    }

    @Test
    public void 배치사이즈_500() {
        int batchSize = 500;
        log.info("insert {} {}", String.join("", Collections.nCopies(30, ">")),batchSize);
        batchUserService.setBatchSize(batchSize);
        long normalElapsedTime = simpleUserService.createUser(dataRowCount);
        long batchElapsedTime = batchUserService.createUser(dataRowCount);

        log.info(String.join("", Collections.nCopies(60, "-")));

        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Regular inserts", "|", dataRowCount, "|", normalElapsedTime, normalElapsedTime / 1000));
        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Batch inserts", "|", dataRowCount, "|", batchElapsedTime, batchElapsedTime / 1000));
    }

    @Test
    public void 배치사이즈_1000() {
        int batchSize = 1000;
        log.info("insert {} {}", String.join("", Collections.nCopies(30, ">")),batchSize);
        batchUserService.setBatchSize(batchSize);
        long normalElapsedTime = simpleUserService.createUser(dataRowCount);
        long batchElapsedTime = batchUserService.createUser(dataRowCount);

        log.info(String.join("", Collections.nCopies(60, "-")));

        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Regular inserts", "|", dataRowCount, "|", normalElapsedTime, normalElapsedTime / 1000));
        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Batch inserts", "|", dataRowCount, "|", batchElapsedTime, batchElapsedTime / 1000));
    }

    @Test
    public void 배치사이즈_5000() {
        int batchSize = 5000;
        log.info("insert {} {}", String.join("", Collections.nCopies(30, ">")),batchSize);
        batchUserService.setBatchSize(batchSize);
        long normalElapsedTime = simpleUserService.createUser(dataRowCount);
        long batchElapsedTime = batchUserService.createUser(dataRowCount);

        log.info(String.join("", Collections.nCopies(60, "-")));

        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Regular inserts", "|", dataRowCount, "|", normalElapsedTime, normalElapsedTime / 1000));
        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Batch inserts", "|", dataRowCount, "|", batchElapsedTime, batchElapsedTime / 1000));
    }

    @Test
    public void 배치사이즈_10000() {
        int batchSize = 10000;
        log.info("insert {} {}", String.join("", Collections.nCopies(30, ">")),batchSize);
        batchUserService.setBatchSize(batchSize);
        long normalElapsedTime = simpleUserService.createUser(dataRowCount);
        long batchElapsedTime = batchUserService.createUser(dataRowCount);

        log.info(String.join("", Collections.nCopies(60, "-")));

        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Regular inserts", "|", dataRowCount, "|", normalElapsedTime, normalElapsedTime / 1000));
        log.info(String.format("%-20s%-5s%-10s%-5s%8sms (%s s)", "Batch inserts", "|", dataRowCount, "|", batchElapsedTime, batchElapsedTime / 1000));
    }
}