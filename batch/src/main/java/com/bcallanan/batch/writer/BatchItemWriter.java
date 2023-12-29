/**
 * 
 */
package com.bcallanan.batch.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.stereotype.Component;

/**
 * @param <T>
 * 
 */
@Component
public class BatchItemWriter<T> extends AbstractItemStreamItemWriter<T> {

    /**
     * Process the supplied data element. Will not be called with any null items in
     * normal operation.
     * 
     * @param chunk of items to be written. Must not be {@code null}.
     * @throws Exception if there are errors. The framework will catch the exception
     *                   and convert or rethrow it as appropriate.
     */
    @Override
    public void write(Chunk<? extends T> chunk) throws Exception {

        chunk.forEach(System.out::println);

        System.out.println("write each chunk******");
    }
}
