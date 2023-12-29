/**
 * 
 */
package com.bcallanan.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Component
@Slf4j
public class StepListener implements StepExecutionListener {

    /**
     * Initialize the state of the listener with the {@link StepExecution} from the
     * current scope.
     * 
     * @param stepExecution instance of {@link StepExecution}.
     */
    @Override
    public void beforeStep(StepExecution stepExecution) {

        System.out.println("before starting step: " + stepExecution.getJobExecution().getExecutionContext().toString());
        System.out.println(
                "before starting step: " + stepExecution.getJobExecution().getExecutionContext().get("myName"));

        System.out.println("before starting step: " + stepExecution.getJobExecution().getJobParameters());

    }

    /**
     * Give a listener a chance to modify the exit status from a step. The value
     * returned is combined with the normal exit status by using
     * {@link ExitStatus#and(ExitStatus)}.
     * <p>
     * Called after execution of the step's processing logic (whether successful or
     * failed). Throwing an exception in this method has no effect, as it is only
     * logged.
     * 
     * @param stepExecution a {@link StepExecution} instance.
     * @return an {@link ExitStatus} to combine with the normal value. Return
     *         {@code null} (the default) to leave the old value unchanged.
     */
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("after step: " + stepExecution.getJobExecution().getExecutionContext().toString());
        return null;
    }
}