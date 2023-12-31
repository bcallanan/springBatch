/**
 * 
 */
package com.bcallanan.batch.processor;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

/**
 * @param <T>
 * 
 */
@Component
public class BatchItemProcessor implements ItemProcessor<Object, Object> {

    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public Integer process(Object item) throws Exception {
        return Integer.sum(10, (int) item);
    }
}
