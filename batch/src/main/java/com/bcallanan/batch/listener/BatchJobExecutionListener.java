/**
 * 
 */
package com.bcallanan.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Component
@Slf4j
public class BatchJobExecutionListener implements JobExecutionListener {

    /**
     * Callback before a job executes.
     * 
     * @param jobExecution the current {@link JobExecution}
     */
    @Override
    public void beforeJob(JobExecution jobExecution) {

        System.out.println("Job started at: " + jobExecution.getStartTime());
        System.out.println("Job exec context: " + jobExecution.getExecutionContext().toString());
        System.out.println("Job name: " + jobExecution.getJobInstance().getJobName());

        jobExecution.getExecutionContext().put("myName", "Brian Callanan");
    }

    /**
     * Callback after completion of a job. Called after both successful and failed
     * executions. To perform logic on a particular status, use
     * {@code if (jobExecution.getStatus() == BatchStatus.X)}.
     * 
     * @param jobExecution the current {@link JobExecution}
     */
    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("After job Job exec context: " + jobExecution.getExecutionContext().toString());
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Job execution completed successfully");
        } else {
            log.error("Job Execution Failed");
        }
    }
}
