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
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.bcallanan.batch.listener.BatchJobExecutionListener;
import com.bcallanan.batch.listener.ChunkExecutionListener;
import com.bcallanan.batch.processor.BatchItemProcessor;
import com.bcallanan.batch.reader.BatchItemReader;
import com.bcallanan.batch.writer.BatchItemWriter;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Component
@Slf4j
@EnableBatchProcessing
public class ChunkJobConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private BatchJobExecutionListener batchJobExecutionListener;

    @Autowired
    private ChunkExecutionListener chunkListener;

    @Autowired
    private BatchItemReader<?> itemReader;

    @Autowired
    private BatchItemProcessor itemProcessor;

    @Autowired
    private BatchItemWriter itemWriter;

    @Bean
    public Job chunkJob() {
        return new JobBuilder("chunkJob", jobRepository).listener(batchJobExecutionListener).start(easyChunk()).build();
    }

    @Bean
    public Step easyChunk() {
        return new StepBuilder("easyChunk", jobRepository)
                .chunk(1, transactionManager)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .listener(chunkListener)
                .build();
    }

    private Tasklet printTask() {
        return new Tasklet() {

            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                log.info("First tasklet step");
                // TODO Auto-generated method stub
                return RepeatStatus.FINISHED;
            }
        };
    }
}
