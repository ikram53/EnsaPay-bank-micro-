package com.ensa.bank;


import com.ensa.bank.Controller.JobLauncherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
public class BankApplication implements CommandLineRunner {
@Autowired


    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }

}
