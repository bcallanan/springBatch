/**
 * 
 */
package com.bcallanan.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Component
@Slf4j
public class ChunkExecutionListener implements ChunkListener {

    /**
     * Callback before the chunk is executed, but inside the transaction.
     * 
     * @param context The current {@link ChunkContext}
     */
    @Override
    public void beforeChunk(ChunkContext context) {
        System.out.println("before chunk at: ");
    }

    /**
     * Callback after the chunk is executed, outside the transaction.
     * 
     * @param context The current {@link ChunkContext}
     */
    @Override
    public void afterChunk(ChunkContext context) {
        System.out.println("After chunk at: ");
    }

    /**
     * Callback after a chunk has been marked for rollback. It is invoked after
     * transaction rollback. While the rollback will have occurred, transactional
     * resources might still be active and accessible. Due to this, data access code
     * within this callback still "participates" in the original transaction unless
     * it declares that it runs in its own transaction. <em>As a result, you should
     * use {@code PROPAGATION_REQUIRES_NEW} for any transactional operation that is
     * called from here.</em>
     * 
     * @param context the chunk context containing the exception that caused the
     *                underlying rollback.
     */
    @Override
    public void afterChunkError(ChunkContext context) {
    }
}