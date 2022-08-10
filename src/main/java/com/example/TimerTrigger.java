package com.example;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class TimerTrigger implements Function<Optional<Object>, Optional<Object>> {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    public Optional<Object> apply(Optional<Object> ebj) {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        try {
            jobLauncher.run(job, params);
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
//        context.getLogger().info("Java Timer trigger function executed at: " + LocalDateTime.now());
        return Optional.of(Object.class);
    }
}