package com.example.bulktest;

import com.example.bulktest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class BulkTestApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("batchUserService")
	private UserService batchUserService;

	@Autowired
	@Qualifier("simpleUserService")
	private UserService simpleUserService;

	public static void main(String[] args) {
		SpringApplication.run(BulkTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int[] batchSizeArray = {1,10,100,100,10_000,100_000,1_000_000};

		for (int batchSize : batchSizeArray) {
			long normalElapsedTime = simpleUserService.createUser(batchSize);
			long batchElapsedTime = batchUserService.createUser(batchSize);

			System.out.println(String.join("", Collections.nCopies(50,"-")));
			System.out.format("%-20s%-5s%-10s%-5s%8sms\n", "Regular inserts", "|", batchSize, "|", normalElapsedTime);
			System.out.format("%-20s%-5s%-10s%-5s%8sms\n", "Batch inserts", "|", batchSize, "|", batchElapsedTime);
			System.out.printf("Total gain: %d %s\n", calculateGainInPercent(normalElapsedTime, batchElapsedTime), "%");
		}
	}

	int calculateGainInPercent(long before, long after) {
		return (int) Math.floor(100D * (before - after) / before);
	}
}
