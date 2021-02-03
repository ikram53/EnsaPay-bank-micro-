package com.ensa.bank.Controller;

import com.ensa.bank.Config.TaskletStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Scanner;

@RestController
@EnableScheduling
public class JobLauncherController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Autowired
    TaskletStep taskletStep;

    Boolean a=true;

    JobParameters jobParameters =null;

    @RequestMapping("/launchjob")
    public String handle() throws Exception {

        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
           /*JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();*/

System.out.println(taskletStep.getCsvFilename());
            File file = new File(taskletStep.getCsvFilename());
            System.out.println(file.exists());

                jobParameters = new JobParametersBuilder()
                        //.addString("JobID", String.valueOf(System.currentTimeMillis()))
                        .addLong("time", System.currentTimeMillis())
                        .addString("fileName", taskletStep.getCsvFilename())
                        .toJobParameters();
                this.a=false;


            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return "Done!";
    }

    @Scheduled(cron ="0 0/1 * * * *")
    public  void storeInDb() throws Exception {

        this.handle() ;
    }
}