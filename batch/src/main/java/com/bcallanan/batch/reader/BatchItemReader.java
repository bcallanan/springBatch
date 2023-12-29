/**
 * 
 */
package com.bcallanan.batch.reader;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;
import org.springframework.stereotype.Component;

/**
 * @param <T>
 * 
 */
@Component
public class BatchItemReader<T> extends AbstractItemStreamItemReader<T> {

    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        // TODO Auto-generated method stub
        return null;
    }

}
