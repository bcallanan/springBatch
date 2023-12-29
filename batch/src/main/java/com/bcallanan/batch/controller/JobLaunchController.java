/**
 * 
 */
package com.bcallanan.batch.controller;

import java.util.Properties;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcallanan.batch.entity.BatchJob;

/**
 * 
 */
@RestController
public class JobLaunchController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    private JobOperator jobOperator;
    @PostMapping(value = "/job")
    
    public void handle(@RequestBody BatchJob batchJob) throws Exception {

        String name = "Job_run:" + System.currentTimeMillis();
        Properties props = new Properties();
        props.put("jobName", name);
        jobOperator.start(batchJob.name(), props);
    }
}
