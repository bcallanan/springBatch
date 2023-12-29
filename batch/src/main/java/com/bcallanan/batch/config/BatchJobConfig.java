package com.bcallanan.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.bcallanan.batch.listener.BatchJobExecutionListener;
import com.bcallanan.batch.listener.StepListener;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Component
@Slf4j
@EnableBatchProcessing
public class BatchJobConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private BatchJobExecutionListener batchJobExecutionListener;

    @Autowired
    private StepListener stepListener;

    @Bean("printJob")
    public Job printJob() {
        return new JobBuilder("printJob", jobRepository).listener(batchJobExecutionListener).start(easyStep())
                .next(nextStep()).build();
    }

    @Bean
    public Step easyStep() {
        return new StepBuilder("easy", jobRepository).listener(stepListener).tasklet(printTask(), transactionManager)
                .build();
    }

    private Tasklet printTask() {
        return new Tasklet() {

            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                System.out.println("First tasklet step");
                // TODO Auto-generated method stub
                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    public Step nextStep() {
        return new StepBuilder("next", jobRepository).listener(stepListener).tasklet(nextTask(), transactionManager)
                .build();
    }

    private Tasklet nextTask() {
        return new Tasklet() {

            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                System.out.println("First tasklet step");
                // TODO Auto-generated method stub
                return RepeatStatus.FINISHED;
            }
        };
    }
}
