package org.fury.advent.processor.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class LocationItemWriter implements ItemWriter<Integer> {

    @Override
    public void write(Chunk<? extends Integer> chunk) {
        chunk.getItems().forEach(item -> log.info("Writer writes: [{}]", item));
    }
}
